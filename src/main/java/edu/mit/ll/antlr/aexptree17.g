tree grammar aexptree17;

options {
output=AST;
ASTLabelType=CommonTree;
tokenVocab = aexp17;
}

tokens {
ALL='ALL';
AND='&';
OR= '|';
NOT='!';
}

@header{
package edu.mit.ll.antlr;
import java.io.File;
import java.util.HashMap;
import edu.mit.ll.aexp.*;
import edu.mit.ll.aexpression.*;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import org.antlr.runtime.tree.CommonTree;

}

@members{
CommonTree t = null;
boolean debug = false;
DimensionSets allDimensionSets = new DimensionSets();
Dimensions allDimensions = new Dimensions();
TagSchemes allTagSchemes = new TagSchemes();
Fields allFields = new Fields();
Tables allTables = new Tables();
VirtualDimensions allVirtualDimensions = new VirtualDimensions();
public static String folderlocation = null;
boolean caseInsensitive = false;
String expression = "";
public void setExpression(String expression){
  this.expression = expression;
}
public void setFolderLocation(String folder)
{
  File dot = new File(".").getAbsoluteFile();
  String s = dot.getAbsolutePath();
  s=s.substring(0,s.length()-1);
  this.folderlocation = s+folder;
}
public void enableCaseInsensitive(boolean caseInsensitive) {
this.caseInsensitive = caseInsensitive;    
}
public void setTree(CommonTree t){
this.t = t;
}

public void enableDebug(boolean value)
{ 
this.debug = value;
}

public void preconfigure(){
    RegistryOperators.debug = this.debug;
    String T2FMapFileName = folderlocation+"Table2FieldMap.json";
    String F2DMapFileName = folderlocation+"Field2DimensionMap.json";
    String Tag2FieldMapFileName = folderlocation+"Tag2FieldMap.json";
    String Ds2DMapFileName = folderlocation+"DimensionSet2DimensionMap.json";
    String Ts2TMapFileName = folderlocation+"TagScheme2TagMap.json";
    String VirtualDimensionMapFileName = folderlocation+"VirtualDimensionsMap.json";
    PreProcessMaps ffs = new PreProcessMaps();
    
    ffs.setT2FMapFileName(T2FMapFileName);
    ffs.setF2DMapFileName(F2DMapFileName);
    ffs.setTag2FieldMapFileName(Tag2FieldMapFileName);
    ffs.setDs2DMapFileName(Ds2DMapFileName);
    ffs.setTs2TMapFileName(Ts2TMapFileName);
    ffs.setVirtualDimensionMapFileName(VirtualDimensionMapFileName);
    RegistryOperators ro = new RegistryOperators(); 
    
    try{
    //For testing operators like ?
        //ffs.setOperator2DimensionSetMapFileName(folderlocation+"Operator2DimensionSetMap1.json");
      }
      catch (Exception e){
        //No operators set...
        
      }
      

    ffs.init();
    
    allVirtualDimensions = ffs.getVirtualDimensions();
    allTables = ffs.getTables();
    allDimensionSets = ffs.getDs2dmap();
    allDimensions = ffs.getDimensions();
    allTagSchemes = ffs.getTs2tmap();
    allFields = ffs.getFields();
    
    ProvenanceDataStructure.setFolderlocation(ffs);
}
}

start returns [Result r]
  @init 
  {
    preconfigure();
  }
	: 
	a=r_exp  
	{ 
	  if(this.debug) 
	  System.out.println("Evaluating rexp");
	  $r = $a.r; 
	}
	;
r_exp returns [Result r]
  @init
  {
    $r = new Result();
    $r.provenance.setData($r, ProvenanceDataStructure.TYPE.REXP);
    $r.provenance.setTree(t);
    $r.provenance.setExpression(expression);
  }
  @after
  {
    if(this.debug)
    System.out.println("Returning result:"+$r);
  }
  :
  (
  (a=period_exp)
  {
    $r.provenance.join($a.pr.provenance);
	  if(this.debug)
	    System.out.println("Lonely period_exp in r_exp");
    //Check if we have tags and convert those to fields
    if($a.pr.getIntermediate_atom()!=null && $a.pr.getIntermediate_atom().getAtomType().equals(Atom.Type.TAGSET)){
      List<Tag> taglist = new LinkedList<>();
      for(Tag t: $a.pr.getIntermediate_atom().getTagSet()){
        taglist.add(t);
      }
      List<Field> intermediate_fields = RegistryOperators.matchFieldsTagsFields(allFields.getAllFieldsList(),taglist );
      $a.pr.setIntermediate(intermediate_fields);
    }
    if($a.pr.getIntermediate_fields()!=null)
    { 
      Set<Field> ifset = new HashSet<>();
      for(Field f : $a.pr.getIntermediate_fields())
        ifset.add(f);
      $r.setResult(ifset);
    }
    else{
      Set<Table> ifset = new HashSet<>();
      for(Table f : $a.pr.getIntermediate_tables())
        ifset.add(f);
      $r.setResult(ifset);
    }
  }
  |
  ^(b=(AND|OR) d=r_exp e=period_exp)//If a not is put in period_exp it will not get parsed
  {
    $r.provenance.join($d.r.provenance);
    $r.provenance.join($e.pr.provenance);
    Result temp = new Result();
    //Convert E to result
    if(this.debug)
    System.out.println("Lonely period_exp in r_exp");
    if($e.pr.getIntermediate_fields()!=null)
    { 
      Set<Field> ifset = new HashSet<>();
      for(Field f : $e.pr.getIntermediate_fields())
        ifset.add(f);
      temp.setResult(ifset);
    }
    else{
      Set<Table> ifset = new HashSet<>();
      for(Table f : $e.pr.getIntermediate_tables())
        ifset.add(f);
      temp.setResult(ifset);
    }
    //Perform operation for fields or tables
    //And
    if($b.text.equals("&")){
    if(this.debug)
      System.out.println("AND");
      if($d.r.getResultFields()!=null)
	    {
	      //AND with fields
	      if(this.debug)
	      System.out.println("And with fields");
	      //Convert d to list
	      Set<Field> intermediateresult1 = $d.r.getResultFields();
	      List<Field> intermediateresultlist1 = new LinkedList<>();
	      for(Field f : intermediateresult1)
	        intermediateresultlist1.add(f);
	      //Convert temp to list
	      Set<Field> intermediateresult2 = temp.getResultFields();
	      //We may have tags that were converted to tables... 
	      if(intermediateresult2==null)
	      {
	        //Check and see if there are tables and convert them to fields
	        try{
	        List<Table> temptables = new LinkedList<>();
	        for(Table t: temp.getResultTables())
	          temptables.add(t);
	        List<Field> result = RegistryOperators.getTablesFields(temptables);
	        intermediateresult2 = new HashSet<>();
	        for(Field f : result)
	          intermediateresult2.add(f);
	        }
	        catch(Exception exc){
	          throw new NullPointerException("Problem getting result, no field or tables");
	        } 
	      }
        List<Field> intermediateresultlist2 = new LinkedList<>();
        for(Field f : intermediateresult2)
          intermediateresultlist2.add(f);
	      Set<Field> result = RegistryOperators.intersectionFields(intermediateresultlist1,intermediateresultlist2);
	      if(result==null){
	         $r.setResult(new HashSet<>());
        }
        else
           $r.setResult(result);
	     
	    }
	    else{
	      //AND with tables
	      if(this.debug)
        System.out.println("And with tables");
        //Convert d to list
        Set<Table> intermediateresult1 = $d.r.getResultTables();
        List<Table> intermediateresultlist1 = new LinkedList<>();
        for(Table f : intermediateresult1)
          intermediateresultlist1.add(f);
        //Convert temp to list
        Set<Table> intermediateresult2 = temp.getResultTables();
        List<Table> intermediateresultlist2 = new LinkedList<>();
        for(Table f : intermediateresult2)
          intermediateresultlist2.add(f);
        Set<Table> result = RegistryOperators.intersectionTables(intermediateresultlist1,intermediateresultlist2);
        $r.setResult(result);
	    }
      
    }
    //Or
    else{
    if(this.debug)
      System.out.println("OR");
      if($d.r.getResultFields()!=null)
      {
        //AND with fields
        if(this.debug)
        System.out.println("And with fields");
        //Convert d to list
        Set<Field> intermediateresult1 = $d.r.getResultFields();
        List<Field> intermediateresultlist1 = new LinkedList<>();
        for(Field f : intermediateresult1)
          intermediateresultlist1.add(f);
        //Convert temp to list
        Set<Field> intermediateresult2 = temp.getResultFields();
        List<Field> intermediateresultlist2 = new LinkedList<>();
        for(Field f : intermediateresult2)
          intermediateresultlist2.add(f);
        Set<Field> result = RegistryOperators.unionFields(intermediateresultlist1,intermediateresultlist2);
        $r.setResult(result);
      }
      else{
        //AND with tables
        if(this.debug)
        System.out.println("And with tables");
        //Convert d to list
        Set<Table> intermediateresult1 = $d.r.getResultTables();
        List<Table> intermediateresultlist1 = new LinkedList<>();
        for(Table f : intermediateresult1)
          intermediateresultlist1.add(f);
        //Convert temp to list
        Set<Table> intermediateresult2 = temp.getResultTables();
        List<Table> intermediateresultlist2 = new LinkedList<>();
        for(Table f : intermediateresult2)
          intermediateresultlist2.add(f);
        Set<Table> result = RegistryOperators.intersectionTables(intermediateresultlist1,intermediateresultlist2);
        $r.setResult(result);
      }
    }
  }
  )
  |
  ^(NOT c=r_exp) 
  {
    $r.provenance.join($c.r.provenance);
    //Handle cases for fields and tables
    if($c.r.getResultFields()!=null)
    {
      //Minus with fields
      if(this.debug)
      System.out.println("Minus with fields");
      Set<Field> intermediateresult = $c.r.getResultFields();
      List<Field> intermediateresultlist = new LinkedList<>();
      for(Field f : intermediateresult)
      intermediateresultlist.add(f);
      Set<Field> result = RegistryOperators.minusFields(intermediateresultlist,allFields.getAllFieldsList());
      $r.setResult(result);
    }
    else{
      //Minus with tables
      if(this.debug)
      System.out.println("Minus with tables");
      Set<Table> intermediateresult = $c.r.getResultTables();
      List<Table> intermediateresultlist = new LinkedList<>();
      for(Table f : intermediateresult)
      intermediateresultlist.add(f);
      Set<Table> result = RegistryOperators.minusTables(intermediateresultlist,allTables.getTables());
      $r.setResult(result);
    }
  }
  ;
  
period_exp returns[IntermediateResult pr]
  @init
  {
    $pr = new IntermediateResult();
    $pr.provenance.setData($pr,ProvenanceDataStructure.TYPE.PERIODEXPRESSION);
  }
  @after
  {
	  if(this.debug)
	    System.out.println("Returning intermediate result from period:"+$pr);
  }
  : 
  (a=star_exp)
  {
	  if(this.debug)
	    System.out.println("Lonely star in period_exp");
	  ProvenanceDataStructure period = $pr.provenance, star = $a.starr.provenance;
    $pr = $a.starr;
    $pr.provenance = period;
    $pr.provenance.join(star);
  }
//  |
//  ^('#' period_exp star_exp)
//  {
//	  if(this.debug){
//	    System.out.println("hashtag period_exp in period_exp");
//	    System.err.println("Unsupported operation, # is not yet defined");
//	  }
//  }
  ;
  
star_exp returns[IntermediateResult starr]
  @init
  {
    $starr = new IntermediateResult();
    $starr.provenance.setData($starr,ProvenanceDataStructure.TYPE.STAREXPRESSION);
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning intermediate result from star:"+$starr);
  }
  :
  (a=slash_exp)
  {
    //Float it up
    if(this.debug)
      System.out.println("Lonely slash in star_exp");
      //star espression provenance
    ProvenanceDataStructure stare = $starr.provenance, slashe = $a.sr.provenance;
    
    $starr = $a.sr;
    //reset the toplevel to star
    $starr.provenance = stare;
    //set lower level to slash
    $starr.provenance.join(slashe);
  }
  |
  ^('*' b=star_exp c=slash_exp)
  {
    //C will have dimensions or tags 
    //B will have tables or fields
    
    //B has tables
    if($b.starr.getIntermediate_tables()!=null)
    {
      //C should have dimensions
      List<String> tempdimlist = new LinkedList<String>();
      for(Dimension d: $c.sr.getIntermediate_set_of_dims()){
        tempdimlist.add(d.getName());
      }
      List<Field> result = RegistryOperators.matchTablesDimensionsFields($b.starr.getIntermediate_tables(),tempdimlist);
      $starr.setIntermediate(result);
    }
    //B has fields
    else
    {
        List<Field> result = null;
        if($c.sr.getIntermediate_tags()!=null){
        //Set of tags
          List<Field> inputfields = null;
          if($b.starr.getFields(allFields.getAllFieldsList())!=null)
            inputfields = $b.starr.getFields(allFields.getAllFieldsList());
          else
            inputfields = RegistryOperators.getTablesFields($b.starr.getIntermediate_tables());
          List<Tag> targettags = $c.sr.getIntermediate_tags();
          result = RegistryOperators.matchFieldsTagsFields(inputfields, targettags);
        }
        else{
        //Dimensions
          List<Field> inputfields = null;
          if($b.starr.getFields(allFields.getAllFieldsList())!=null)
            inputfields = $b.starr.getFields(allFields.getAllFieldsList());
          else
            inputfields = RegistryOperators.getTablesFields($b.starr.getIntermediate_tables());
          Set<Dimension> inputdimensions = $c.sr.getIntermediate_set_of_dims();
          //We may have the result of a sub expression so change it to set of dimensions if its tables or fields
          if(inputdimensions == null)
          {
            inputdimensions = new HashSet<>();
            if($c.sr.getIntermediate_atom().getAtomType().equals(Atom.Type.RESULT))
            {
              Result r = $c.sr.getIntermediate_atom().getResult();
              if(r.getResultTables()!=null)
              {
                //convert tables to set of dimensions
                List<Table> ttablelist = new LinkedList<>();
                for(Table t: r.getResultTables())
                  ttablelist.add(t);
                List<Field> tfieldlist = RegistryOperators.getTablesFields(ttablelist);
                for(Field f:tfieldlist)
                  inputdimensions.add(f.getDimension());
              }
              else
              {
                //convert fields to set of dimensions
                List<Field> ttablelist = new LinkedList<>();
                for(Field t: r.getResultFields())
                  ttablelist.add(t);
                for(Field t:ttablelist)
                  inputdimensions.add(t.getDimension());
              }
            }
          }
          result = RegistryOperators.matchFieldsDimensionsFields(inputfields, inputdimensions);
        }
        if(result == null)
          throw new NullPointerException("Could not get results in star expression");
        $starr.setIntermediate(result);
    }
    $starr.provenance.setData($starr,ProvenanceDataStructure.TYPE.STAREXPRESSION);
    //b star c slash
    ProvenanceDataStructure operation = new ProvenanceDataStructure("*",ProvenanceDataStructure.TYPE.OPERATION);
    $starr.provenance.join(operation);
    $starr.provenance.join($b.starr.provenance);
    $starr.provenance.join($c.sr.provenance);
    
  }
  ;
  
slash_exp returns[IntermediateResult sr]
  @init
  {
    $sr = new IntermediateResult();
    $sr.setAlltables(allTables);
    //Set the toplevel provenance as being a slash expression
    //The upper level before this will have the result sr
    $sr.provenance.setData($sr,ProvenanceDataStructure.TYPE.SLASHEXPRESSION);
    
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning intermediate result from slash:"+$sr);
  }
  :
  (^('/' f=slash_exp b=atom2))//PROBLEM HERE WITH ? TO VALIDATE (ALL/(EXPR?)) IT HAS TO BE ATOM, BUT THAT CONFLICTS WITH THE NORMAL ALL/SOMEHTING EXPRESSION
  {
	  if(this.debug){
	    System.out.println("/ atom2 in slash_exp");
	    System.out.println("Here i should evaluate slash operator and return tables");
    }
    //A will be an atom behaving as an atom 2
    //B will be an atom 2
    //slash expression will have dimension set or set of dimensions.
    //slash exp has to be translated to tables
    //atom2 will have set of dimensions
    DimensionSet inputds = new DimensionSet("DimSet");
    for(Dimension s:$b.a2.getDimSet()){
      inputds.addDimension(s);
    }
    
    List<Table> resultlist = RegistryOperators.matchTablesDimensionSetTables(allTables.getTables(),inputds);
    
    $sr = new IntermediateResult();
    //Set up the top level
    $sr.setIntermediate(resultlist);
    $sr.provenance.setData($sr,ProvenanceDataStructure.TYPE.SLASHEXPRESSION);
//    $sr.provenance.setData("Finding the tables that contain the following dimensions( in a dimensionset)"+inputds.getDimSet()+" result:"+resultlist);
    //Set up the 2 sublevels
    ProvenanceDataStructure operation = new ProvenanceDataStructure("/",ProvenanceDataStructure.TYPE.OPERATION);
    $sr.provenance.join(operation);
    $sr.provenance.join($b.a2.provenance);
    $sr.provenance.join($f.sr.provenance);
  }
  |
  (^('?' e=slash_exp))
  {
  if(this.debug)
    System.out.println("? in slash_exp");
    //Here the slash_exp result will behave as an atom2
    PreProcessMaps ppm = new PreProcessMaps();
    $sr = new IntermediateResult();
    List<DimensionSet> res = new LinkedList<DimensionSet>();
    res.addAll(ppm.reachDimensionSetDimensionSets($e.sr.getIntermediate_dimset()));
    $sr.setIntermediate(res);
    $sr.provenance.join($e.sr.provenance);
    ProvenanceDataStructure operation = new ProvenanceDataStructure("?",ProvenanceDataStructure.TYPE.OPERATION);
    $sr.provenance.join(operation);
    
  }
  |
  (
  (a=atom)
  {
  if(this.debug)
    System.out.println("Lonely atom in slash_exp");
    $sr.setIntermediate($a.atomicExp);
    $sr.provenance.join($a.atomicExp.provenance);
  }
  |
  ^('.' c=slash_exp d=durations)
  {
    //c will be an atom in which we have to perform the same operations as an atom2
    List<Field> allf = new LinkedList<Field>();
    for(Field fieldinset:allFields.getFields()){
      allf.add(fieldinset);
    }
    List<Field> flist= $c.sr.getFields(allf);
    List<Period> appliedDurations = $d.durationList;
    List<Field> result = RegistryOperators.matchFieldsPeriodsFields(flist,appliedDurations);
    $sr = new IntermediateResult();
    $sr.setIntermediate(result);
    //Join with sublevel
        ProvenanceDataStructure operation = new ProvenanceDataStructure(".",ProvenanceDataStructure.TYPE.OPERATION);
    $sr.provenance.join(operation);
    $sr.provenance.join($c.sr.provenance);
    $sr.provenance.join(new ProvenanceDataStructure($d.durationList,ProvenanceDataStructure.TYPE.DURATIONSET));
//    $sr.provenance.setData("Matching all fields with specified periods:"+appliedDurations +"result:"+result.toString(), ProvenanceDataStructure.TYPE.FIELDSET);
  }
  )
  ;
atom2 returns[Atom2 a2]
  @init
  {
    $a2 = new Atom2();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning atom2:"+$a2);
  }
  :
  (
  (
  a=set_of_dims//MULTIPLE SPECIFIC DIMENSIONS
  {
    $a2.setDimSet($a.dim_set);
    $a2.setAtomType(Atom2.Type.SETOFDIMS);
    //Set the atom2
    $a2.provenance.setData($a2,ProvenanceDataStructure.TYPE.ATOM2);
    //Set the lower level
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($a.dim_set,ProvenanceDataStructure.TYPE.SETOFDIMS);
    $a2.provenance.join(element);
    
  }
  |
  b=dimSet//ONE OR ALL
  {
    $a2.setDimensions($b.dimensionSet);
    $a2.setAtomType(Atom2.Type.DIMSET);
    //Set the atom 2
    $a2.provenance.setData($a2,ProvenanceDataStructure.TYPE.ATOM);
    //Set the lower level
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($b.dimensionSet,ProvenanceDataStructure.TYPE.DIMENSIONSET);
    $a2.provenance.join(element);
    
  }
  )
  |
  ^('.' c=atom2 d=durations)
  {
  
    //The atom2 here can have any sort of durations, and the same dimension set
    //we just need to add the new durations
    for(Period p:$d.durationList)
    {
      $c.a2.addPeriod(p);
    }
    //Now replace the result with the new atom2
    $a2.setDimSet($c.a2.getDimSet());
    $a2.setPeriodsApplied($c.a2.getPeriodsApplied());
    $a2.setAtomType(Atom2.Type.RESULT);
    
    //Begin provenance
    //Fill up the periods
    List<ProvenanceDataStructure> provenanceList = new LinkedList<>();
    for(Period p:$d.durationList)
    {
      ProvenanceDataStructure element = new ProvenanceDataStructure();
      element.setData(p,ProvenanceDataStructure.TYPE.PERIOD);
      provenanceList.add(element);
    }
    //Fill up the dimensionsets
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($b.dimensionSet,ProvenanceDataStructure.TYPE.DIMENSIONSET);
    provenanceList.add(element);
    //Join them under atom 2
    ProvenanceDataStructure atom2provenance = new ProvenanceDataStructure();
    atom2provenance.setData($c.a2,ProvenanceDataStructure.TYPE.ATOM2);
    for(ProvenanceDataStructure pds : provenanceList){
      atom2provenance.join(pds);
    }
    atom2provenance.join(element);
    //Reset provenance
    $a2.provenance = atom2provenance;
  }
  )
  ;
//One of the basic structures
//This should return a set of fields, but it can also return a set of dimensions/tags
//For later evaluation
atom returns [Atom atomicExp]  
  @init
  {
  if(this.debug)
    System.out.println("Evaluating atom");
    $atomicExp = new Atom();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning atom:"+$atomicExp);
  }
  :
  a=dims
  {
    $atomicExp.setDimSet($a.dimSet);
    $atomicExp.setAtomType(Atom.Type.DIMSET);
    
    //Top level is atom
    $atomicExp.provenance.setData($atomicExp,ProvenanceDataStructure.TYPE.ATOM);
    
    //Below that is an element
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($a.dimSet,ProvenanceDataStructure.TYPE.DIMENSIONSET);
    $atomicExp.provenance.join(element);
  }
  |
  b=tags 
  {
    $atomicExp.setTagSet($b.tagSet);
    $atomicExp.setAtomType(Atom.Type.TAGSET);
    //Set atom
    $atomicExp.provenance.setData($atomicExp,ProvenanceDataStructure.TYPE.ATOM);
    //Set lower lev
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($b.tagSet,ProvenanceDataStructure.TYPE.TAGSET);
    $atomicExp.provenance.join(element);
  }
  |
  '(' (
  c=r_exp
  {
  if(this.debug)
    System.out.println("Evaluated expression in parenthesis");
    $atomicExp.setResult($c.r);
    $atomicExp.setAtomType(Atom.Type.RESULT);
    //Classify as atom
    $atomicExp.provenance.setData($atomicExp,ProvenanceDataStructure.TYPE.ATOM);
    //Join with provenance of other r-exp
    $atomicExp.provenance.join($c.r.provenance);
    
  }
  )* ')'
  |
  '[' 
  (
  d=dimSet
  {
    $atomicExp.setDimensions($d.dimensionSet);
    $atomicExp.setAtomType(Atom.Type.DIMSET);
    if(this.debug){
      System.out.println("Matching []");
    }
    //Set the top level atom
    $atomicExp.provenance.setData($atomicExp,ProvenanceDataStructure.TYPE.ATOM);
    //Set the lower layer and join
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($d.dimensionSet,ProvenanceDataStructure.TYPE.DIMENSIONSET);
    $atomicExp.provenance.join(element);
  }
  |
  e=set_of_dimSets
  {
    //Fill the atom
    $atomicExp.setDimensions($e.dimset_set);
    $atomicExp.setAtomType(Atom.Type.DIMSET);
    
    if(this.debug){
      System.out.println("Matching []");
    }
    //Set the atom type
    $atomicExp.provenance.setData($atomicExp,ProvenanceDataStructure.TYPE.ATOM);
    //Set the sublevel
    ProvenanceDataStructure element = new ProvenanceDataStructure();
    element.setData($e.dimset_set,ProvenanceDataStructure.TYPE.DIMENSIONSETSET);
    $atomicExp.provenance.join(element);

  }
  ) ']' 
  ;

//Returns A dimension set
//The returned set can have ALL, one, or more than one specified dimensions.
dims returns [Set<Dimension> dimSet]
  @init
  {
    $dimSet = new HashSet<>();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning dimensionlist:"+$dimSet);
  }
  :
  ALL 
  {
  if(this.debug)
    System.out.println("Evaluating ALL");
    for(Dimension d: allDimensions.getDimensions()){
      $dimSet.add(d);
    }
  } 
  |
  a=dim
  {
  if(this.debug)
    System.out.println("Evaluating DIM");
    $dimSet.add($a.d);
  }
  |
  b=set_of_dims 
  {
  if(this.debug)
    System.out.println("Evaluating set of dims");
    for(Dimension d: $b.dim_set){
      $dimSet.add(d);
    }
  }
  ;
//Set of specified dimensions.
set_of_dims returns [Set<Dimension> dim_set]
  @init
  {
    $dim_set = new HashSet<>();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning set of dims:"+$dim_set);
  }
  :
  '{' 
  a=dim
  {
      $dim_set.add($a.d);
  } 
  '}' 
  |
  '{'^(','(a=dim{$dim_set.add($a.d);})+)'}'
//  |
//  virtual_dim
  ;
//To be implemented
virtual_dim returns[List<Dimension> virtual_dim]
  :
  '\'{'^(','(a=dim{$virtual_dim.add($a.d);})+)'}\''
  ;
  
//Returns a set of dimension sets.  Similar to the normal dimSet but different
//In the sense that here we can specify more than one dimensionSet
//In the regular dimSet we can get 1 or ALL
set_of_dimSets returns [Set<DimensionSet> dimset_set]
  @init
  {
  if(this.debug)
    System.out.println("initializing set of dimsets");
    $dimset_set = new HashSet<>();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning set of dimsets:"+$dimset_set);
  }
  : 
  '{' 
  a=dimSet
  {
    for(DimensionSet ds:$a.dimensionSet)
      $dimset_set.add(ds);
  } 
  '}'
  |
  '{'
  ^(','
  (a=dimSet
  {for(DimensionSet ds:$a.dimensionSet)
      $dimset_set.add(ds);
  }
  )+
  )
  '}'
  ;
  
//Returns a dimension with name ID
dim returns [Dimension d] 
  @init
  {
  if(this.debug)
    System.out.println("In dim");
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning dimension:"+$d);
  }
  : 
  ID
  {
  if(this.debug)
    System.out.println("Evaluating dimid");
    Dimension ret = null;
    ret = allDimensions.getDimension($ID.text);
    if(ret == null){
    if(this.debug)
      System.out.println("Could not find dimension:"+$ID.text);
    }
    else
      $d = ret;
  }
  ; 
//Returns a set of tags.  It is a set so the already existing algorithms
//Work appropriately.
tags  returns [Set<Tag> tagSet]
  @init
  {
    $tagSet = new HashSet<>();
    if(this.debug)
    System.out.println("Initializing tagset");
  }
  @after
  {
  if(this.debug)
     System.out.println("Tagset:"+$tagSet);
  }
  :
  '{' a=tag{$tagSet.add($a.tag);} '}'
  |
  '{'^(','(a=tag{$tagSet.add($a.tag);})+)'}'
  |
  c=tag
  {
    $tagSet.add($c.tag);
  }
  //unnamed tag set
  ;
//Returns a tag object based on the tagscheme and id specified or NPE if not found
tag returns [Tag tag]
  @init
  {
  if(this.debug)
    System.out.println("Initializing tag");
    $tag = new Tag();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning Tag:"+$tag);
    if($tag.getName()==null||$tag.getTs()==null){
    if(this.debug)
      System.out.println("Not enough info for tag");
    }
  }
  :
  (
  tagScheme 
  {
    $tag.setTs($tagScheme.targetTagScheme);
  }
  |
  '_'
  {
    $tag.setTs(allTagSchemes.getTagScheme("_"));
  }
  )
  ':' ID 
  {
    $tag.setName($ID.text); 
  }
  ;
//Returns a tag scheme that has the name ID
tagScheme returns [TagScheme targetTagScheme]
  : 
  ID 
  {
    TagScheme target = allTagSchemes.getTagScheme($ID.text);
    if(this.debug)
    System.out.println("Finding"+$ID.text);
    if(target == null){
    if(this.debug)
      System.out.println("TagScheme not found:"+$ID.text);
      throw new NullPointerException("TagScheme not found"+$ID.text);
    }
    else{
    if(this.debug)
      System.out.println("TagScheme found");
      $targetTagScheme = target;
    }
  }
  //UNNAMED TAG SCHEMES Can be done, but are not in specification.
  //What come close to this is the default tag scheme.
  ;

//Returns a set of dimensionset because that way we can work with 
//Whatever is inside whether its one or all of the dimensionsets
dimSet returns [Set<DimensionSet> dimensionSet]
  @init
  {
  if(this.debug)
    System.out.println("Finding dimSet");
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning dimSet:"+$dimensionSet);
  }
  : 
  ALL 
  {
  if(this.debug)
    System.out.println("Dimensionset all");
    $dimensionSet = new HashSet<>(allDimensionSets.getDimensionSets());
  }
  |
  ID 
  {
    DimensionSet target = allDimensionSets.getDimensionSet($ID.text);
    if(this.debug)
    System.out.println("Finding"+$ID.text);
    Set<DimensionSet> result = new HashSet<>();
    if(target == null){
    if(this.debug)
      System.out.println("Dimensionset not found");
      throw new NullPointerException("Could not find dimension set:"+$ID.text);
    }
    else{
    if(this.debug)
      System.out.println("Dimensionset found");
      //Possibly handle unnamed dimset
      result.add(target);
      $dimensionSet = result;
    } 
  }
  ;

//Returns a list of durations as that is what we need here
durations returns[List<Period> durationList]
  @init
  {
    $durationList = new LinkedList<>();
  }
  @after
  {
  if(this.debug)
    System.out.println("Returning duration list:"+$durationList);
  }
  :
  '{'^(';' (b=duration{$durationList.add($b.duration);})+)'}'
  ;
//Returns a duration object
duration returns[Period duration]
  @after
  {
//    System.out.println("Returning duration"+$duration.toString());
  }
  :
  starttime=start_time ',' endtime=end_time
  {
//    System.out.println("Duration found");
    $duration = new Period($starttime.value,$endtime.value);
  }
  ;
//Most basic part of duration
start_time returns [String value]
  :
  INT
  {  
    $value = $INT.text;
  }
  ;
//Another basic part of a duration
end_time returns [String value]
  :
  INT
  {  
    $value = $INT.text;
  }
  ;