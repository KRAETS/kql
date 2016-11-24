// $ANTLR 3.5.2 /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g 2016-03-13 07:51:50

package edu.mit.ll.antlr;
import java.io.File;
import java.util.HashMap;
import edu.mit.ll.aexp.*;
import edu.mit.ll.aexpression.*;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import org.antlr.runtime.tree.CommonTree;



import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import javax.naming.CannotProceedException;


@SuppressWarnings("all")
public class aexptree17 extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "COMMENT", "ESC_SEQ", 
		"HEX_DIGIT", "ID", "INT", "NEWLINE", "NOT", "OCTAL_ESC", "OR", "STRING", 
		"UNICODE_ESC", "WS", "'#'", "'('", "')'", "'*'", "','", "'.'", "'/'", 
		"':'", "';'", "'?'", "'['", "']'", "'_'", "'{'", "'}'", "'\\'{'", "'}\\''"
	};
	public static final int EOF=-1;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int ALL=4;
	public static final int AND=5;
	public static final int COMMENT=6;
	public static final int ESC_SEQ=7;
	public static final int HEX_DIGIT=8;
	public static final int ID=9;
	public static final int INT=10;
	public static final int NEWLINE=11;
	public static final int NOT=12;
	public static final int OCTAL_ESC=13;
	public static final int OR=14;
	public static final int STRING=15;
	public static final int UNICODE_ESC=16;
	public static final int WS=17;
	public static final int T__33=33;
	public static final int T__34=34;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public aexptree17(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public aexptree17(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return aexptree17.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g"; }


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

	public void preconfigure() throws CannotProceedException{
		
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


	public static class start_return extends TreeRuleReturnScope {
		public Result r;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "start"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:104:1: start returns [Result r] : a= r_exp ;
	public final aexptree17.start_return start() throws RecognitionException, CannotProceedException {
		aexptree17.start_return retval = new aexptree17.start_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope a =null;



		    preconfigure();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:109:2: (a= r_exp )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:110:2: a= r_exp
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_r_exp_in_start89);
			a=r_exp();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			 
				  if(this.debug) 
				  System.out.println("Evaluating rexp");
				  retval.r = (a!=null?((aexptree17.r_exp_return)a).r:null); 
				
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start"


	public static class r_exp_return extends TreeRuleReturnScope {
		public Result r;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "r_exp"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:117:1: r_exp returns [Result r] : ( ( (a= period_exp ) | ^(b= ( AND | OR ) d= r_exp e= period_exp ) ) | ^( NOT c= r_exp ) );
	public final aexptree17.r_exp_return r_exp() throws RecognitionException {
		aexptree17.r_exp_return retval = new aexptree17.r_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree b=null;
		CommonTree NOT1=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope d =null;
		TreeRuleReturnScope e =null;
		TreeRuleReturnScope c =null;

		CommonTree b_tree=null;
		CommonTree NOT1_tree=null;


		    retval.r = new Result();
		    retval.r.provenance.setData(retval.r, ProvenanceDataStructure.TYPE.REXP);
		    retval.r.provenance.setTree(t);
		    retval.r.provenance.setExpression(expression);
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:130:3: ( ( (a= period_exp ) | ^(b= ( AND | OR ) d= r_exp e= period_exp ) ) | ^( NOT c= r_exp ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= ALL && LA2_0 <= AND)||LA2_0==ID||LA2_0==OR||LA2_0==19||LA2_0==21||(LA2_0 >= 23 && LA2_0 <= 24)||(LA2_0 >= 27 && LA2_0 <= 28)||(LA2_0 >= 30 && LA2_0 <= 31)) ) {
				alt2=1;
			}
			else if ( (LA2_0==NOT) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:131:3: ( (a= period_exp ) | ^(b= ( AND | OR ) d= r_exp e= period_exp ) )
					{
					root_0 = (CommonTree)adaptor.nil();


					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:131:3: ( (a= period_exp ) | ^(b= ( AND | OR ) d= r_exp e= period_exp ) )
					int alt1=2;
					int LA1_0 = input.LA(1);
					if ( (LA1_0==ALL||LA1_0==ID||LA1_0==19||LA1_0==21||(LA1_0 >= 23 && LA1_0 <= 24)||(LA1_0 >= 27 && LA1_0 <= 28)||(LA1_0 >= 30 && LA1_0 <= 31)) ) {
						alt1=1;
					}
					else if ( (LA1_0==AND||LA1_0==OR) ) {
						alt1=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 1, 0, input);
						throw nvae;
					}

					switch (alt1) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:132:3: (a= period_exp )
							{
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:132:3: (a= period_exp )
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:132:4: a= period_exp
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_period_exp_in_r_exp136);
							a=period_exp();
							state._fsp--;

							adaptor.addChild(root_0, a.getTree());

							}


							    retval.r.provenance.join((a!=null?((aexptree17.period_exp_return)a).pr:null).provenance);
								  if(this.debug)
								    System.out.println("Lonely period_exp in r_exp");
							    //Check if we have tags and convert those to fields
							    if((a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_atom()!=null && (a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_atom().getAtomType().equals(Atom.Type.TAGSET)){
							      List<Tag> taglist = new LinkedList<>();
							      for(Tag t: (a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_atom().getTagSet()){
							        taglist.add(t);
							      }
							      List<Field> intermediate_fields = RegistryOperators.matchFieldsTagsFields(allFields.getAllFieldsList(),taglist );
							      (a!=null?((aexptree17.period_exp_return)a).pr:null).setIntermediate(intermediate_fields);
							    }
							    if((a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_fields()!=null)
							    { 
							      Set<Field> ifset = new HashSet<>();
							      for(Field f : (a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_fields())
							        ifset.add(f);
							      retval.r.setResult(ifset);
							    }
							    else{
							      Set<Table> ifset = new HashSet<>();
							      for(Table f : (a!=null?((aexptree17.period_exp_return)a).pr:null).getIntermediate_tables())
							        ifset.add(f);
							      retval.r.setResult(ifset);
							    }
							  
							}
							break;
						case 2 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:161:3: ^(b= ( AND | OR ) d= r_exp e= period_exp )
							{
							_last = (CommonTree)input.LT(1);
							{
							CommonTree _save_last_1 = _last;
							CommonTree _first_1 = null;
							CommonTree root_1 = (CommonTree)adaptor.nil();
							b=(CommonTree)input.LT(1);
							if ( input.LA(1)==AND||input.LA(1)==OR ) {
								input.consume();
								b_tree = (CommonTree)adaptor.dupNode(b);


								root_1 = (CommonTree)adaptor.becomeRoot(b_tree, root_1);

								state.errorRecovery=false;
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								throw mse;
							}

							match(input, Token.DOWN, null); 
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_r_exp_in_r_exp160);
							d=r_exp();
							state._fsp--;

							adaptor.addChild(root_1, d.getTree());

							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_period_exp_in_r_exp164);
							e=period_exp();
							state._fsp--;

							adaptor.addChild(root_1, e.getTree());

							match(input, Token.UP, null); 
							adaptor.addChild(root_0, root_1);
							_last = _save_last_1;
							}



							    retval.r.provenance.join((d!=null?((aexptree17.r_exp_return)d).r:null).provenance);
							    retval.r.provenance.join((e!=null?((aexptree17.period_exp_return)e).pr:null).provenance);
							    Result temp = new Result();
							    //Convert E to result
							    if(this.debug)
							    System.out.println("Lonely period_exp in r_exp");
							    if((e!=null?((aexptree17.period_exp_return)e).pr:null).getIntermediate_fields()!=null)
							    { 
							      Set<Field> ifset = new HashSet<>();
							      for(Field f : (e!=null?((aexptree17.period_exp_return)e).pr:null).getIntermediate_fields())
							        ifset.add(f);
							      temp.setResult(ifset);
							    }
							    else{
							      Set<Table> ifset = new HashSet<>();
							      for(Table f : (e!=null?((aexptree17.period_exp_return)e).pr:null).getIntermediate_tables())
							        ifset.add(f);
							      temp.setResult(ifset);
							    }
							    //Perform operation for fields or tables
							    //And
							    if((b!=null?b.getText():null).equals("&")){
							    if(this.debug)
							      System.out.println("AND");
							      if((d!=null?((aexptree17.r_exp_return)d).r:null).getResultFields()!=null)
								    {
								      //AND with fields
								      if(this.debug)
								      System.out.println("And with fields");
								      //Convert d to list
								      Set<Field> intermediateresult1 = (d!=null?((aexptree17.r_exp_return)d).r:null).getResultFields();
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
								         retval.r.setResult(new HashSet<>());
							        }
							        else
							           retval.r.setResult(result);
								     
								    }
								    else{
								      //AND with tables
								      if(this.debug)
							        System.out.println("And with tables");
							        //Convert d to list
							        Set<Table> intermediateresult1 = (d!=null?((aexptree17.r_exp_return)d).r:null).getResultTables();
							        List<Table> intermediateresultlist1 = new LinkedList<>();
							        for(Table f : intermediateresult1)
							          intermediateresultlist1.add(f);
							        //Convert temp to list
							        Set<Table> intermediateresult2 = temp.getResultTables();
							        List<Table> intermediateresultlist2 = new LinkedList<>();
							        for(Table f : intermediateresult2)
							          intermediateresultlist2.add(f);
							        Set<Table> result = RegistryOperators.intersectionTables(intermediateresultlist1,intermediateresultlist2);
							        retval.r.setResult(result);
								    }
							      
							    }
							    //Or
							    else{
							    if(this.debug)
							      System.out.println("OR");
							      if((d!=null?((aexptree17.r_exp_return)d).r:null).getResultFields()!=null)
							      {
							        //AND with fields
							        if(this.debug)
							        System.out.println("And with fields");
							        //Convert d to list
							        Set<Field> intermediateresult1 = (d!=null?((aexptree17.r_exp_return)d).r:null).getResultFields();
							        List<Field> intermediateresultlist1 = new LinkedList<>();
							        for(Field f : intermediateresult1)
							          intermediateresultlist1.add(f);
							        //Convert temp to list
							        Set<Field> intermediateresult2 = temp.getResultFields();
							        List<Field> intermediateresultlist2 = new LinkedList<>();
							        for(Field f : intermediateresult2)
							          intermediateresultlist2.add(f);
							        Set<Field> result = RegistryOperators.unionFields(intermediateresultlist1,intermediateresultlist2);
							        retval.r.setResult(result);
							      }
							      else{
							        //AND with tables
							        if(this.debug)
							        System.out.println("And with tables");
							        //Convert d to list
							        Set<Table> intermediateresult1 = (d!=null?((aexptree17.r_exp_return)d).r:null).getResultTables();
							        List<Table> intermediateresultlist1 = new LinkedList<>();
							        for(Table f : intermediateresult1)
							          intermediateresultlist1.add(f);
							        //Convert temp to list
							        Set<Table> intermediateresult2 = temp.getResultTables();
							        List<Table> intermediateresultlist2 = new LinkedList<>();
							        for(Table f : intermediateresult2)
							          intermediateresultlist2.add(f);
							        Set<Table> result = RegistryOperators.intersectionTables(intermediateresultlist1,intermediateresultlist2);
							        retval.r.setResult(result);
							      }
							    }
							  
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:289:3: ^( NOT c= r_exp )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					NOT1=(CommonTree)match(input,NOT,FOLLOW_NOT_in_r_exp182); 
					NOT1_tree = (CommonTree)adaptor.dupNode(NOT1);


					root_1 = (CommonTree)adaptor.becomeRoot(NOT1_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_r_exp_in_r_exp186);
					c=r_exp();
					state._fsp--;

					adaptor.addChild(root_1, c.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					    retval.r.provenance.join((c!=null?((aexptree17.r_exp_return)c).r:null).provenance);
					    //Handle cases for fields and tables
					    if((c!=null?((aexptree17.r_exp_return)c).r:null).getResultFields()!=null)
					    {
					      //Minus with fields
					      if(this.debug)
					      System.out.println("Minus with fields");
					      Set<Field> intermediateresult = (c!=null?((aexptree17.r_exp_return)c).r:null).getResultFields();
					      List<Field> intermediateresultlist = new LinkedList<>();
					      for(Field f : intermediateresult)
					      intermediateresultlist.add(f);
					      Set<Field> result = RegistryOperators.minusFields(intermediateresultlist,allFields.getAllFieldsList());
					      retval.r.setResult(result);
					    }
					    else{
					      //Minus with tables
					      if(this.debug)
					      System.out.println("Minus with tables");
					      Set<Table> intermediateresult = (c!=null?((aexptree17.r_exp_return)c).r:null).getResultTables();
					      List<Table> intermediateresultlist = new LinkedList<>();
					      for(Table f : intermediateresult)
					      intermediateresultlist.add(f);
					      Set<Table> result = RegistryOperators.minusTables(intermediateresultlist,allTables.getTables());
					      retval.r.setResult(result);
					    }
					  
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			    if(this.debug)
			    System.out.println("Returning result:"+retval.r);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "r_exp"


	public static class period_exp_return extends TreeRuleReturnScope {
		public IntermediateResult pr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "period_exp"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:319:1: period_exp returns [IntermediateResult pr] : (a= star_exp ) ;
	public final aexptree17.period_exp_return period_exp() throws RecognitionException {
		aexptree17.period_exp_return retval = new aexptree17.period_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		TreeRuleReturnScope a =null;



		    retval.pr = new IntermediateResult();
		    retval.pr.provenance.setData(retval.pr,ProvenanceDataStructure.TYPE.PERIODEXPRESSION);
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:330:3: ( (a= star_exp ) )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:331:3: (a= star_exp )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:331:3: (a= star_exp )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:331:4: a= star_exp
			{
			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_star_exp_in_period_exp234);
			a=star_exp();
			state._fsp--;

			adaptor.addChild(root_0, a.getTree());

			}


				  if(this.debug)
				    System.out.println("Lonely star in period_exp");
				  ProvenanceDataStructure period = retval.pr.provenance, star = (a!=null?((aexptree17.star_exp_return)a).starr:null).provenance;
			    retval.pr = (a!=null?((aexptree17.star_exp_return)a).starr:null);
			    retval.pr.provenance = period;
			    retval.pr.provenance.join(star);
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


				  if(this.debug)
				    System.out.println("Returning intermediate result from period:"+retval.pr);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "period_exp"


	public static class star_exp_return extends TreeRuleReturnScope {
		public IntermediateResult starr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "star_exp"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:350:1: star_exp returns [IntermediateResult starr] : ( (a= slash_exp ) | ^( '*' b= star_exp c= slash_exp ) );
	public final aexptree17.star_exp_return star_exp() throws RecognitionException {
		aexptree17.star_exp_return retval = new aexptree17.star_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal2=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope c =null;

		CommonTree char_literal2_tree=null;


		    retval.starr = new IntermediateResult();
		    retval.starr.provenance.setData(retval.starr,ProvenanceDataStructure.TYPE.STAREXPRESSION);
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:361:3: ( (a= slash_exp ) | ^( '*' b= star_exp c= slash_exp ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ALL||LA3_0==ID||LA3_0==19||(LA3_0 >= 23 && LA3_0 <= 24)||(LA3_0 >= 27 && LA3_0 <= 28)||(LA3_0 >= 30 && LA3_0 <= 31)) ) {
				alt3=1;
			}
			else if ( (LA3_0==21) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:362:3: (a= slash_exp )
					{
					root_0 = (CommonTree)adaptor.nil();


					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:362:3: (a= slash_exp )
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:362:4: a= slash_exp
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_slash_exp_in_star_exp288);
					a=slash_exp();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());

					}


					    //Float it up
					    if(this.debug)
					      System.out.println("Lonely slash in star_exp");
					      //star espression provenance
					    ProvenanceDataStructure stare = retval.starr.provenance, slashe = (a!=null?((aexptree17.slash_exp_return)a).sr:null).provenance;
					    
					    retval.starr = (a!=null?((aexptree17.slash_exp_return)a).sr:null);
					    //reset the toplevel to star
					    retval.starr.provenance = stare;
					    //set lower level to slash
					    retval.starr.provenance.join(slashe);
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:377:3: ^( '*' b= star_exp c= slash_exp )
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal2=(CommonTree)match(input,21,FOLLOW_21_in_star_exp302); 
					char_literal2_tree = (CommonTree)adaptor.dupNode(char_literal2);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal2_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_star_exp_in_star_exp306);
					b=star_exp();
					state._fsp--;

					adaptor.addChild(root_1, b.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_slash_exp_in_star_exp310);
					c=slash_exp();
					state._fsp--;

					adaptor.addChild(root_1, c.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					    //C will have dimensions or tags 
					    //B will have tables or fields
					    
					    //B has tables
					    if((b!=null?((aexptree17.star_exp_return)b).starr:null).getIntermediate_tables()!=null)
					    {
					      //C should have dimensions
					      List<String> tempdimlist = new LinkedList<String>();
					      for(Dimension d: (c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_set_of_dims()){
					        tempdimlist.add(d.getName());
					      }
					      List<Field> result = RegistryOperators.matchTablesDimensionsFields((b!=null?((aexptree17.star_exp_return)b).starr:null).getIntermediate_tables(),tempdimlist);
					      retval.starr.setIntermediate(result);
					    }
					    //B has fields
					    else
					    {
					        List<Field> result = null;
					        if((c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_tags()!=null){
					        //Set of tags
					          List<Field> inputfields = null;
					          if((b!=null?((aexptree17.star_exp_return)b).starr:null).getFields(allFields.getAllFieldsList())!=null)
					            inputfields = (b!=null?((aexptree17.star_exp_return)b).starr:null).getFields(allFields.getAllFieldsList());
					          else
					            inputfields = RegistryOperators.getTablesFields((b!=null?((aexptree17.star_exp_return)b).starr:null).getIntermediate_tables());
					          List<Tag> targettags = (c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_tags();
					          result = RegistryOperators.matchFieldsTagsFields(inputfields, targettags);
					        }
					        else{
					        //Dimensions
					          List<Field> inputfields = null;
					          if((b!=null?((aexptree17.star_exp_return)b).starr:null).getFields(allFields.getAllFieldsList())!=null)
					            inputfields = (b!=null?((aexptree17.star_exp_return)b).starr:null).getFields(allFields.getAllFieldsList());
					          else
					            inputfields = RegistryOperators.getTablesFields((b!=null?((aexptree17.star_exp_return)b).starr:null).getIntermediate_tables());
					          Set<Dimension> inputdimensions = (c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_set_of_dims();
					          //We may have the result of a sub expression so change it to set of dimensions if its tables or fields
					          if(inputdimensions == null)
					          {
					            inputdimensions = new HashSet<>();
					            if((c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_atom().getAtomType().equals(Atom.Type.RESULT))
					            {
					              Result r = (c!=null?((aexptree17.slash_exp_return)c).sr:null).getIntermediate_atom().getResult();
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
					        retval.starr.setIntermediate(result);
					    }
					    retval.starr.provenance.setData(retval.starr,ProvenanceDataStructure.TYPE.STAREXPRESSION);
					    //b star c slash
					    ProvenanceDataStructure operation = new ProvenanceDataStructure("*",ProvenanceDataStructure.TYPE.OPERATION);
					    retval.starr.provenance.join(operation);
					    retval.starr.provenance.join((b!=null?((aexptree17.star_exp_return)b).starr:null).provenance);
					    retval.starr.provenance.join((c!=null?((aexptree17.slash_exp_return)c).sr:null).provenance);
					    
					  
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning intermediate result from star:"+retval.starr);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "star_exp"


	public static class slash_exp_return extends TreeRuleReturnScope {
		public IntermediateResult sr;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "slash_exp"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:459:1: slash_exp returns [IntermediateResult sr] : ( ( ^( '/' f= slash_exp b= atom2 ) ) | ( ^( '?' e= slash_exp ) ) | ( (a= atom ) | ^( '.' c= slash_exp d= durations ) ) );
	public final aexptree17.slash_exp_return slash_exp() throws RecognitionException {
		aexptree17.slash_exp_return retval = new aexptree17.slash_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal3=null;
		CommonTree char_literal4=null;
		CommonTree char_literal5=null;
		TreeRuleReturnScope f =null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope e =null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope c =null;
		TreeRuleReturnScope d =null;

		CommonTree char_literal3_tree=null;
		CommonTree char_literal4_tree=null;
		CommonTree char_literal5_tree=null;


		    retval.sr = new IntermediateResult();
		    retval.sr.setAlltables(allTables);
		    //Set the toplevel provenance as being a slash expression
		    //The upper level before this will have the result sr
		    retval.sr.provenance.setData(retval.sr,ProvenanceDataStructure.TYPE.SLASHEXPRESSION);
		    
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:474:3: ( ( ^( '/' f= slash_exp b= atom2 ) ) | ( ^( '?' e= slash_exp ) ) | ( (a= atom ) | ^( '.' c= slash_exp d= durations ) ) )
			int alt5=3;
			switch ( input.LA(1) ) {
			case 24:
				{
				alt5=1;
				}
				break;
			case 27:
				{
				alt5=2;
				}
				break;
			case ALL:
			case ID:
			case 19:
			case 23:
			case 28:
			case 30:
			case 31:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:475:3: ( ^( '/' f= slash_exp b= atom2 ) )
					{
					root_0 = (CommonTree)adaptor.nil();


					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:475:3: ( ^( '/' f= slash_exp b= atom2 ) )
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:475:4: ^( '/' f= slash_exp b= atom2 )
					{
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal3=(CommonTree)match(input,24,FOLLOW_24_in_slash_exp355); 
					char_literal3_tree = (CommonTree)adaptor.dupNode(char_literal3);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal3_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_slash_exp_in_slash_exp359);
					f=slash_exp();
					state._fsp--;

					adaptor.addChild(root_1, f.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_atom2_in_slash_exp363);
					b=atom2();
					state._fsp--;

					adaptor.addChild(root_1, b.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}


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
					    for(Dimension s:(b!=null?((aexptree17.atom2_return)b).a2:null).getDimSet()){
					      inputds.addDimension(s);
					    }
					    
					    List<Table> resultlist = RegistryOperators.matchTablesDimensionSetTables(allTables.getTables(),inputds);
					    
					    retval.sr = new IntermediateResult();
					    //Set up the top level
					    retval.sr.setIntermediate(resultlist);
					    retval.sr.provenance.setData(retval.sr,ProvenanceDataStructure.TYPE.SLASHEXPRESSION);
					//    retval.sr.provenance.setData("Finding the tables that contain the following dimensions( in a dimensionset)"+inputds.getDimSet()+" result:"+resultlist);
					    //Set up the 2 sublevels
					    ProvenanceDataStructure operation = new ProvenanceDataStructure("/",ProvenanceDataStructure.TYPE.OPERATION);
					    retval.sr.provenance.join(operation);
					    retval.sr.provenance.join((b!=null?((aexptree17.atom2_return)b).a2:null).provenance);
					    retval.sr.provenance.join((f!=null?((aexptree17.slash_exp_return)f).sr:null).provenance);
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:505:3: ( ^( '?' e= slash_exp ) )
					{
					root_0 = (CommonTree)adaptor.nil();


					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:505:3: ( ^( '?' e= slash_exp ) )
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:505:4: ^( '?' e= slash_exp )
					{
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal4=(CommonTree)match(input,27,FOLLOW_27_in_slash_exp379); 
					char_literal4_tree = (CommonTree)adaptor.dupNode(char_literal4);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal4_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_slash_exp_in_slash_exp383);
					e=slash_exp();
					state._fsp--;

					adaptor.addChild(root_1, e.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					}


					  if(this.debug)
					    System.out.println("? in slash_exp");
					    //Here the slash_exp result will behave as an atom2
					    PreProcessMaps ppm = new PreProcessMaps();
					    retval.sr = new IntermediateResult();
					    List<DimensionSet> res = new LinkedList<DimensionSet>();
					    res.addAll(ppm.reachDimensionSetDimensionSets((e!=null?((aexptree17.slash_exp_return)e).sr:null).getIntermediate_dimset()));
					    retval.sr.setIntermediate(res);
					    retval.sr.provenance.join((e!=null?((aexptree17.slash_exp_return)e).sr:null).provenance);
					    ProvenanceDataStructure operation = new ProvenanceDataStructure("?",ProvenanceDataStructure.TYPE.OPERATION);
					    retval.sr.provenance.join(operation);
					    
					  
					}
					break;
				case 3 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:521:3: ( (a= atom ) | ^( '.' c= slash_exp d= durations ) )
					{
					root_0 = (CommonTree)adaptor.nil();


					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:521:3: ( (a= atom ) | ^( '.' c= slash_exp d= durations ) )
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0==ALL||LA4_0==ID||LA4_0==19||LA4_0==28||(LA4_0 >= 30 && LA4_0 <= 31)) ) {
						alt4=1;
					}
					else if ( (LA4_0==23) ) {
						alt4=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 4, 0, input);
						throw nvae;
					}

					switch (alt4) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:522:3: (a= atom )
							{
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:522:3: (a= atom )
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:522:4: a= atom
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_atom_in_slash_exp404);
							a=atom();
							state._fsp--;

							adaptor.addChild(root_0, a.getTree());

							}


							  if(this.debug)
							    System.out.println("Lonely atom in slash_exp");
							    retval.sr.setIntermediate((a!=null?((aexptree17.atom_return)a).atomicExp:null));
							    retval.sr.provenance.join((a!=null?((aexptree17.atom_return)a).atomicExp:null).provenance);
							  
							}
							break;
						case 2 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:530:3: ^( '.' c= slash_exp d= durations )
							{
							_last = (CommonTree)input.LT(1);
							{
							CommonTree _save_last_1 = _last;
							CommonTree _first_1 = null;
							CommonTree root_1 = (CommonTree)adaptor.nil();
							_last = (CommonTree)input.LT(1);
							char_literal5=(CommonTree)match(input,23,FOLLOW_23_in_slash_exp418); 
							char_literal5_tree = (CommonTree)adaptor.dupNode(char_literal5);


							root_1 = (CommonTree)adaptor.becomeRoot(char_literal5_tree, root_1);

							match(input, Token.DOWN, null); 
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_slash_exp_in_slash_exp422);
							c=slash_exp();
							state._fsp--;

							adaptor.addChild(root_1, c.getTree());

							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_durations_in_slash_exp426);
							d=durations();
							state._fsp--;

							adaptor.addChild(root_1, d.getTree());

							match(input, Token.UP, null); 
							adaptor.addChild(root_0, root_1);
							_last = _save_last_1;
							}



							    //c will be an atom in which we have to perform the same operations as an atom2
							    List<Field> allf = new LinkedList<Field>();
							    for(Field fieldinset:allFields.getFields()){
							      allf.add(fieldinset);
							    }
							    List<Field> flist= (c!=null?((aexptree17.slash_exp_return)c).sr:null).getFields(allf);
							    List<Period> appliedDurations = (d!=null?((aexptree17.durations_return)d).durationList:null);
							    List<Field> result = RegistryOperators.matchFieldsPeriodsFields(flist,appliedDurations);
							    retval.sr = new IntermediateResult();
							    retval.sr.setIntermediate(result);
							    //Join with sublevel
							        ProvenanceDataStructure operation = new ProvenanceDataStructure(".",ProvenanceDataStructure.TYPE.OPERATION);
							    retval.sr.provenance.join(operation);
							    retval.sr.provenance.join((c!=null?((aexptree17.slash_exp_return)c).sr:null).provenance);
							    retval.sr.provenance.join(new ProvenanceDataStructure((d!=null?((aexptree17.durations_return)d).durationList:null),ProvenanceDataStructure.TYPE.DURATIONSET));
							//    retval.sr.provenance.setData("Matching all fields with specified periods:"+appliedDurations +"result:"+result.toString(), ProvenanceDataStructure.TYPE.FIELDSET);
							  
							}
							break;

					}

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning intermediate result from slash:"+retval.sr);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "slash_exp"


	public static class atom2_return extends TreeRuleReturnScope {
		public Atom2 a2;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom2"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:551:1: atom2 returns [Atom2 a2] : ( (a= set_of_dims |b= dimSet ) | ^( '.' c= atom2 d= durations ) ) ;
	public final aexptree17.atom2_return atom2() throws RecognitionException {
		aexptree17.atom2_return retval = new aexptree17.atom2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal6=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope c =null;
		TreeRuleReturnScope d =null;

		CommonTree char_literal6_tree=null;


		    retval.a2 = new Atom2();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:561:3: ( ( (a= set_of_dims |b= dimSet ) | ^( '.' c= atom2 d= durations ) ) )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:562:3: ( (a= set_of_dims |b= dimSet ) | ^( '.' c= atom2 d= durations ) )
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:562:3: ( (a= set_of_dims |b= dimSet ) | ^( '.' c= atom2 d= durations ) )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ALL||LA7_0==ID||LA7_0==31) ) {
				alt7=1;
			}
			else if ( (LA7_0==23) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:563:3: (a= set_of_dims |b= dimSet )
					{
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:563:3: (a= set_of_dims |b= dimSet )
					int alt6=2;
					int LA6_0 = input.LA(1);
					if ( (LA6_0==31) ) {
						alt6=1;
					}
					else if ( (LA6_0==ALL||LA6_0==ID) ) {
						alt6=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 6, 0, input);
						throw nvae;
					}

					switch (alt6) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:564:3: a= set_of_dims
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_set_of_dims_in_atom2480);
							a=set_of_dims();
							state._fsp--;

							adaptor.addChild(root_0, a.getTree());


							    retval.a2.setDimSet((a!=null?((aexptree17.set_of_dims_return)a).dim_set:null));
							    retval.a2.setAtomType(Atom2.Type.SETOFDIMS);
							    //Set the atom2
							    retval.a2.provenance.setData(retval.a2,ProvenanceDataStructure.TYPE.ATOM2);
							    //Set the lower level
							    ProvenanceDataStructure element = new ProvenanceDataStructure();
							    element.setData((a!=null?((aexptree17.set_of_dims_return)a).dim_set:null),ProvenanceDataStructure.TYPE.SETOFDIMS);
							    retval.a2.provenance.join(element);
							    
							  
							}
							break;
						case 2 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:577:3: b= dimSet
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_dimSet_in_atom2494);
							b=dimSet();
							state._fsp--;

							adaptor.addChild(root_0, b.getTree());


							    retval.a2.setDimensions((b!=null?((aexptree17.dimSet_return)b).dimensionSet:null));
							    retval.a2.setAtomType(Atom2.Type.DIMSET);
							    //Set the atom 2
							    retval.a2.provenance.setData(retval.a2,ProvenanceDataStructure.TYPE.ATOM);
							    //Set the lower level
							    ProvenanceDataStructure element = new ProvenanceDataStructure();
							    element.setData((b!=null?((aexptree17.dimSet_return)b).dimensionSet:null),ProvenanceDataStructure.TYPE.DIMENSIONSET);
							    retval.a2.provenance.join(element);
							    
							  
							}
							break;

					}

					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:591:3: ^( '.' c= atom2 d= durations )
					{
					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal6=(CommonTree)match(input,23,FOLLOW_23_in_atom2511); 
					char_literal6_tree = (CommonTree)adaptor.dupNode(char_literal6);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal6_tree, root_1);

					match(input, Token.DOWN, null); 
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_atom2_in_atom2515);
					c=atom2();
					state._fsp--;

					adaptor.addChild(root_1, c.getTree());

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_durations_in_atom2519);
					d=durations();
					state._fsp--;

					adaptor.addChild(root_1, d.getTree());

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}



					  
					    //The atom2 here can have any sort of durations, and the same dimension set
					    //we just need to add the new durations
					    for(Period p:(d!=null?((aexptree17.durations_return)d).durationList:null))
					    {
					      (c!=null?((aexptree17.atom2_return)c).a2:null).addPeriod(p);
					    }
					    //Now replace the result with the new atom2
					    retval.a2.setDimSet((c!=null?((aexptree17.atom2_return)c).a2:null).getDimSet());
					    retval.a2.setPeriodsApplied((c!=null?((aexptree17.atom2_return)c).a2:null).getPeriodsApplied());
					    retval.a2.setAtomType(Atom2.Type.RESULT);
					    
					    //Begin provenance
					    //Fill up the periods
					    List<ProvenanceDataStructure> provenanceList = new LinkedList<>();
					    for(Period p:(d!=null?((aexptree17.durations_return)d).durationList:null))
					    {
					      ProvenanceDataStructure element = new ProvenanceDataStructure();
					      element.setData(p,ProvenanceDataStructure.TYPE.PERIOD);
					      provenanceList.add(element);
					    }
					    //Fill up the dimensionsets
					    ProvenanceDataStructure element = new ProvenanceDataStructure();
					    element.setData((b!=null?((aexptree17.dimSet_return)b).dimensionSet:null),ProvenanceDataStructure.TYPE.DIMENSIONSET);
					    provenanceList.add(element);
					    //Join them under atom 2
					    ProvenanceDataStructure atom2provenance = new ProvenanceDataStructure();
					    atom2provenance.setData((c!=null?((aexptree17.atom2_return)c).a2:null),ProvenanceDataStructure.TYPE.ATOM2);
					    for(ProvenanceDataStructure pds : provenanceList){
					      atom2provenance.join(pds);
					    }
					    atom2provenance.join(element);
					    //Reset provenance
					    retval.a2.provenance = atom2provenance;
					  
					}
					break;

			}

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning atom2:"+retval.a2);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom2"


	public static class atom_return extends TreeRuleReturnScope {
		public Atom atomicExp;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:633:1: atom returns [Atom atomicExp] : (a= dims |b= tags | '(' (c= r_exp )* ')' | '[' (d= dimSet |e= set_of_dimSets ) ']' );
	public final aexptree17.atom_return atom() throws RecognitionException {
		aexptree17.atom_return retval = new aexptree17.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal7=null;
		CommonTree char_literal8=null;
		CommonTree char_literal9=null;
		CommonTree char_literal10=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope b =null;
		TreeRuleReturnScope c =null;
		TreeRuleReturnScope d =null;
		TreeRuleReturnScope e =null;

		CommonTree char_literal7_tree=null;
		CommonTree char_literal8_tree=null;
		CommonTree char_literal9_tree=null;
		CommonTree char_literal10_tree=null;


		  if(this.debug)
		    System.out.println("Evaluating atom");
		    retval.atomicExp = new Atom();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:645:3: (a= dims |b= tags | '(' (c= r_exp )* ')' | '[' (d= dimSet |e= set_of_dimSets ) ']' )
			int alt10=4;
			switch ( input.LA(1) ) {
			case ALL:
				{
				alt10=1;
				}
				break;
			case ID:
				{
				int LA10_2 = input.LA(2);
				if ( (LA10_2==EOF||(LA10_2 >= UP && LA10_2 <= AND)||LA10_2==ID||LA10_2==NOT||LA10_2==OR||(LA10_2 >= 19 && LA10_2 <= 21)||(LA10_2 >= 23 && LA10_2 <= 24)||(LA10_2 >= 27 && LA10_2 <= 28)||(LA10_2 >= 30 && LA10_2 <= 31)) ) {
					alt10=1;
				}
				else if ( (LA10_2==25) ) {
					alt10=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 31:
				{
				switch ( input.LA(2) ) {
				case 22:
					{
					int LA10_7 = input.LA(3);
					if ( (LA10_7==DOWN) ) {
						int LA10_9 = input.LA(4);
						if ( (LA10_9==ID) ) {
							int LA10_10 = input.LA(5);
							if ( (LA10_10==UP||LA10_10==ID) ) {
								alt10=1;
							}
							else if ( (LA10_10==25) ) {
								alt10=2;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 10, 10, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}
						else if ( (LA10_9==30) ) {
							alt10=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 10, 9, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case ID:
					{
					int LA10_8 = input.LA(3);
					if ( (LA10_8==32) ) {
						alt10=1;
					}
					else if ( (LA10_8==25) ) {
						alt10=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 10, 8, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

					}
					break;
				case 30:
					{
					alt10=2;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
				}
				break;
			case 30:
				{
				alt10=2;
				}
				break;
			case 19:
				{
				alt10=3;
				}
				break;
			case 28:
				{
				alt10=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}
			switch (alt10) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:646:3: a= dims
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dims_in_atom571);
					a=dims();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());


					    retval.atomicExp.setDimSet((a!=null?((aexptree17.dims_return)a).dimSet:null));
					    retval.atomicExp.setAtomType(Atom.Type.DIMSET);
					    
					    //Top level is atom
					    retval.atomicExp.provenance.setData(retval.atomicExp,ProvenanceDataStructure.TYPE.ATOM);
					    
					    //Below that is an element
					    ProvenanceDataStructure element = new ProvenanceDataStructure();
					    element.setData((a!=null?((aexptree17.dims_return)a).dimSet:null),ProvenanceDataStructure.TYPE.DIMENSIONSET);
					    retval.atomicExp.provenance.join(element);
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:660:3: b= tags
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tags_in_atom585);
					b=tags();
					state._fsp--;

					adaptor.addChild(root_0, b.getTree());


					    retval.atomicExp.setTagSet((b!=null?((aexptree17.tags_return)b).tagSet:null));
					    retval.atomicExp.setAtomType(Atom.Type.TAGSET);
					    //Set atom
					    retval.atomicExp.provenance.setData(retval.atomicExp,ProvenanceDataStructure.TYPE.ATOM);
					    //Set lower lev
					    ProvenanceDataStructure element = new ProvenanceDataStructure();
					    element.setData((b!=null?((aexptree17.tags_return)b).tagSet:null),ProvenanceDataStructure.TYPE.TAGSET);
					    retval.atomicExp.provenance.join(element);
					  
					}
					break;
				case 3 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:672:3: '(' (c= r_exp )* ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal7=(CommonTree)match(input,19,FOLLOW_19_in_atom598); 
					char_literal7_tree = (CommonTree)adaptor.dupNode(char_literal7);


					adaptor.addChild(root_0, char_literal7_tree);

					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:672:7: (c= r_exp )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( ((LA8_0 >= ALL && LA8_0 <= AND)||LA8_0==ID||LA8_0==NOT||LA8_0==OR||LA8_0==19||LA8_0==21||(LA8_0 >= 23 && LA8_0 <= 24)||(LA8_0 >= 27 && LA8_0 <= 28)||(LA8_0 >= 30 && LA8_0 <= 31)) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:673:3: c= r_exp
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_r_exp_in_atom606);
							c=r_exp();
							state._fsp--;

							adaptor.addChild(root_0, c.getTree());


							  if(this.debug)
							    System.out.println("Evaluated expression in parenthesis");
							    retval.atomicExp.setResult((c!=null?((aexptree17.r_exp_return)c).r:null));
							    retval.atomicExp.setAtomType(Atom.Type.RESULT);
							    //Classify as atom
							    retval.atomicExp.provenance.setData(retval.atomicExp,ProvenanceDataStructure.TYPE.ATOM);
							    //Join with provenance of other r-exp
							    retval.atomicExp.provenance.join((c!=null?((aexptree17.r_exp_return)c).r:null).provenance);
							    
							  
							}
							break;

						default :
							break loop8;
						}
					}

					_last = (CommonTree)input.LT(1);
					char_literal8=(CommonTree)match(input,20,FOLLOW_20_in_atom617); 
					char_literal8_tree = (CommonTree)adaptor.dupNode(char_literal8);


					adaptor.addChild(root_0, char_literal8_tree);

					}
					break;
				case 4 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:687:3: '[' (d= dimSet |e= set_of_dimSets ) ']'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal9=(CommonTree)match(input,28,FOLLOW_28_in_atom625); 
					char_literal9_tree = (CommonTree)adaptor.dupNode(char_literal9);


					adaptor.addChild(root_0, char_literal9_tree);

					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:688:3: (d= dimSet |e= set_of_dimSets )
					int alt9=2;
					int LA9_0 = input.LA(1);
					if ( (LA9_0==ALL||LA9_0==ID) ) {
						alt9=1;
					}
					else if ( (LA9_0==31) ) {
						alt9=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 9, 0, input);
						throw nvae;
					}

					switch (alt9) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:689:3: d= dimSet
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_dimSet_in_atom636);
							d=dimSet();
							state._fsp--;

							adaptor.addChild(root_0, d.getTree());


							    retval.atomicExp.setDimensions((d!=null?((aexptree17.dimSet_return)d).dimensionSet:null));
							    retval.atomicExp.setAtomType(Atom.Type.DIMSET);
							    if(this.debug){
							      System.out.println("Matching []");
							    }
							    //Set the top level atom
							    retval.atomicExp.provenance.setData(retval.atomicExp,ProvenanceDataStructure.TYPE.ATOM);
							    //Set the lower layer and join
							    ProvenanceDataStructure element = new ProvenanceDataStructure();
							    element.setData((d!=null?((aexptree17.dimSet_return)d).dimensionSet:null),ProvenanceDataStructure.TYPE.DIMENSIONSET);
							    retval.atomicExp.provenance.join(element);
							  
							}
							break;
						case 2 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:704:3: e= set_of_dimSets
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_set_of_dimSets_in_atom650);
							e=set_of_dimSets();
							state._fsp--;

							adaptor.addChild(root_0, e.getTree());


							    //Fill the atom
							    retval.atomicExp.setDimensions((e!=null?((aexptree17.set_of_dimSets_return)e).dimset_set:null));
							    retval.atomicExp.setAtomType(Atom.Type.DIMSET);
							    
							    if(this.debug){
							      System.out.println("Matching []");
							    }
							    //Set the atom type
							    retval.atomicExp.provenance.setData(retval.atomicExp,ProvenanceDataStructure.TYPE.ATOM);
							    //Set the sublevel
							    ProvenanceDataStructure element = new ProvenanceDataStructure();
							    element.setData((e!=null?((aexptree17.set_of_dimSets_return)e).dimset_set:null),ProvenanceDataStructure.TYPE.DIMENSIONSETSET);
							    retval.atomicExp.provenance.join(element);

							  
							}
							break;

					}

					_last = (CommonTree)input.LT(1);
					char_literal10=(CommonTree)match(input,29,FOLLOW_29_in_atom660); 
					char_literal10_tree = (CommonTree)adaptor.dupNode(char_literal10);


					adaptor.addChild(root_0, char_literal10_tree);

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning atom:"+retval.atomicExp);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class dims_return extends TreeRuleReturnScope {
		public Set<Dimension> dimSet;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dims"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:726:1: dims returns [Set<Dimension> dimSet] : ( ALL |a= dim |b= set_of_dims );
	public final aexptree17.dims_return dims() throws RecognitionException {
		aexptree17.dims_return retval = new aexptree17.dims_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ALL11=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope b =null;

		CommonTree ALL11_tree=null;


		    retval.dimSet = new HashSet<>();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:736:3: ( ALL |a= dim |b= set_of_dims )
			int alt11=3;
			switch ( input.LA(1) ) {
			case ALL:
				{
				alt11=1;
				}
				break;
			case ID:
				{
				alt11=2;
				}
				break;
			case 31:
				{
				alt11=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}
			switch (alt11) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:737:3: ALL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ALL11=(CommonTree)match(input,ALL,FOLLOW_ALL_in_dims700); 
					ALL11_tree = (CommonTree)adaptor.dupNode(ALL11);


					adaptor.addChild(root_0, ALL11_tree);


					  if(this.debug)
					    System.out.println("Evaluating ALL");
					    for(Dimension d: allDimensions.getDimensions()){
					      retval.dimSet.add(d);
					    }
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:746:3: a= dim
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dim_in_dims716);
					a=dim();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());


					  if(this.debug)
					    System.out.println("Evaluating DIM");
					    retval.dimSet.add((a!=null?((aexptree17.dim_return)a).d:null));
					  
					}
					break;
				case 3 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:753:3: b= set_of_dims
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_set_of_dims_in_dims730);
					b=set_of_dims();
					state._fsp--;

					adaptor.addChild(root_0, b.getTree());


					  if(this.debug)
					    System.out.println("Evaluating set of dims");
					    for(Dimension d: (b!=null?((aexptree17.set_of_dims_return)b).dim_set:null)){
					      retval.dimSet.add(d);
					    }
					  
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning dimensionlist:"+retval.dimSet);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dims"


	public static class set_of_dims_return extends TreeRuleReturnScope {
		public Set<Dimension> dim_set;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_of_dims"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:763:1: set_of_dims returns [Set<Dimension> dim_set] : ( '{' a= dim '}' | '{' ^( ',' (a= dim )+ ) '}' );
	public final aexptree17.set_of_dims_return set_of_dims() throws RecognitionException {
		aexptree17.set_of_dims_return retval = new aexptree17.set_of_dims_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal12=null;
		CommonTree char_literal13=null;
		CommonTree char_literal14=null;
		CommonTree char_literal15=null;
		CommonTree char_literal16=null;
		TreeRuleReturnScope a =null;

		CommonTree char_literal12_tree=null;
		CommonTree char_literal13_tree=null;
		CommonTree char_literal14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal16_tree=null;


		    retval.dim_set = new HashSet<>();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:773:3: ( '{' a= dim '}' | '{' ^( ',' (a= dim )+ ) '}' )
			int alt13=2;
			int LA13_0 = input.LA(1);
			if ( (LA13_0==31) ) {
				int LA13_1 = input.LA(2);
				if ( (LA13_1==22) ) {
					alt13=2;
				}
				else if ( (LA13_1==ID) ) {
					alt13=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 13, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 13, 0, input);
				throw nvae;
			}

			switch (alt13) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:774:3: '{' a= dim '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal12=(CommonTree)match(input,31,FOLLOW_31_in_set_of_dims772); 
					char_literal12_tree = (CommonTree)adaptor.dupNode(char_literal12);


					adaptor.addChild(root_0, char_literal12_tree);

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dim_in_set_of_dims779);
					a=dim();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());


					      retval.dim_set.add((a!=null?((aexptree17.dim_return)a).d:null));
					  
					_last = (CommonTree)input.LT(1);
					char_literal13=(CommonTree)match(input,32,FOLLOW_32_in_set_of_dims788); 
					char_literal13_tree = (CommonTree)adaptor.dupNode(char_literal13);


					adaptor.addChild(root_0, char_literal13_tree);

					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:781:3: '{' ^( ',' (a= dim )+ ) '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal14=(CommonTree)match(input,31,FOLLOW_31_in_set_of_dims797); 
					char_literal14_tree = (CommonTree)adaptor.dupNode(char_literal14);


					adaptor.addChild(root_0, char_literal14_tree);

					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal15=(CommonTree)match(input,22,FOLLOW_22_in_set_of_dims799); 
					char_literal15_tree = (CommonTree)adaptor.dupNode(char_literal15);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal15_tree, root_1);

					match(input, Token.DOWN, null); 
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:781:11: (a= dim )+
					int cnt12=0;
					loop12:
					while (true) {
						int alt12=2;
						int LA12_0 = input.LA(1);
						if ( (LA12_0==ID) ) {
							alt12=1;
						}

						switch (alt12) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:781:12: a= dim
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_dim_in_set_of_dims803);
							a=dim();
							state._fsp--;

							adaptor.addChild(root_1, a.getTree());

							retval.dim_set.add((a!=null?((aexptree17.dim_return)a).d:null));
							}
							break;

						default :
							if ( cnt12 >= 1 ) break loop12;
							EarlyExitException eee = new EarlyExitException(12, input);
							throw eee;
						}
						cnt12++;
					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					_last = (CommonTree)input.LT(1);
					char_literal16=(CommonTree)match(input,32,FOLLOW_32_in_set_of_dims808); 
					char_literal16_tree = (CommonTree)adaptor.dupNode(char_literal16);


					adaptor.addChild(root_0, char_literal16_tree);

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning set of dims:"+retval.dim_set);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "set_of_dims"


	public static class virtual_dim_return extends TreeRuleReturnScope {
		public List<Dimension> virtual_dim;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "virtual_dim"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:786:1: virtual_dim returns [List<Dimension> virtual_dim] : '\\'{' ^( ',' (a= dim )+ ) '}\\'' ;
	public final aexptree17.virtual_dim_return virtual_dim() throws RecognitionException {
		aexptree17.virtual_dim_return retval = new aexptree17.virtual_dim_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree string_literal17=null;
		CommonTree char_literal18=null;
		CommonTree string_literal19=null;
		TreeRuleReturnScope a =null;

		CommonTree string_literal17_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree string_literal19_tree=null;

		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:787:3: ( '\\'{' ^( ',' (a= dim )+ ) '}\\'' )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:788:3: '\\'{' ^( ',' (a= dim )+ ) '}\\''
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			string_literal17=(CommonTree)match(input,33,FOLLOW_33_in_virtual_dim828); 
			string_literal17_tree = (CommonTree)adaptor.dupNode(string_literal17);


			adaptor.addChild(root_0, string_literal17_tree);

			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			char_literal18=(CommonTree)match(input,22,FOLLOW_22_in_virtual_dim830); 
			char_literal18_tree = (CommonTree)adaptor.dupNode(char_literal18);


			root_1 = (CommonTree)adaptor.becomeRoot(char_literal18_tree, root_1);

			match(input, Token.DOWN, null); 
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:788:13: (a= dim )+
			int cnt14=0;
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==ID) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:788:14: a= dim
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dim_in_virtual_dim834);
					a=dim();
					state._fsp--;

					adaptor.addChild(root_1, a.getTree());

					retval.virtual_dim.add((a!=null?((aexptree17.dim_return)a).d:null));
					}
					break;

				default :
					if ( cnt14 >= 1 ) break loop14;
					EarlyExitException eee = new EarlyExitException(14, input);
					throw eee;
				}
				cnt14++;
			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			_last = (CommonTree)input.LT(1);
			string_literal19=(CommonTree)match(input,34,FOLLOW_34_in_virtual_dim839); 
			string_literal19_tree = (CommonTree)adaptor.dupNode(string_literal19);


			adaptor.addChild(root_0, string_literal19_tree);

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "virtual_dim"


	public static class set_of_dimSets_return extends TreeRuleReturnScope {
		public Set<DimensionSet> dimset_set;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_of_dimSets"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:794:1: set_of_dimSets returns [Set<DimensionSet> dimset_set] : ( '{' a= dimSet '}' | '{' ^( ',' (a= dimSet )+ ) '}' );
	public final aexptree17.set_of_dimSets_return set_of_dimSets() throws RecognitionException {
		aexptree17.set_of_dimSets_return retval = new aexptree17.set_of_dimSets_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal20=null;
		CommonTree char_literal21=null;
		CommonTree char_literal22=null;
		CommonTree char_literal23=null;
		CommonTree char_literal24=null;
		TreeRuleReturnScope a =null;

		CommonTree char_literal20_tree=null;
		CommonTree char_literal21_tree=null;
		CommonTree char_literal22_tree=null;
		CommonTree char_literal23_tree=null;
		CommonTree char_literal24_tree=null;


		  if(this.debug)
		    System.out.println("initializing set of dimsets");
		    retval.dimset_set = new HashSet<>();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:806:3: ( '{' a= dimSet '}' | '{' ^( ',' (a= dimSet )+ ) '}' )
			int alt16=2;
			int LA16_0 = input.LA(1);
			if ( (LA16_0==31) ) {
				int LA16_1 = input.LA(2);
				if ( (LA16_1==22) ) {
					alt16=2;
				}
				else if ( (LA16_1==ALL||LA16_1==ID) ) {
					alt16=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 16, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}

			switch (alt16) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:807:3: '{' a= dimSet '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal20=(CommonTree)match(input,31,FOLLOW_31_in_set_of_dimSets882); 
					char_literal20_tree = (CommonTree)adaptor.dupNode(char_literal20);


					adaptor.addChild(root_0, char_literal20_tree);

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_dimSet_in_set_of_dimSets889);
					a=dimSet();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());


					    for(DimensionSet ds:(a!=null?((aexptree17.dimSet_return)a).dimensionSet:null))
					      retval.dimset_set.add(ds);
					  
					_last = (CommonTree)input.LT(1);
					char_literal21=(CommonTree)match(input,32,FOLLOW_32_in_set_of_dimSets898); 
					char_literal21_tree = (CommonTree)adaptor.dupNode(char_literal21);


					adaptor.addChild(root_0, char_literal21_tree);

					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:815:3: '{' ^( ',' (a= dimSet )+ ) '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal22=(CommonTree)match(input,31,FOLLOW_31_in_set_of_dimSets906); 
					char_literal22_tree = (CommonTree)adaptor.dupNode(char_literal22);


					adaptor.addChild(root_0, char_literal22_tree);

					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal23=(CommonTree)match(input,22,FOLLOW_22_in_set_of_dimSets911); 
					char_literal23_tree = (CommonTree)adaptor.dupNode(char_literal23);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal23_tree, root_1);

					match(input, Token.DOWN, null); 
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:817:3: (a= dimSet )+
					int cnt15=0;
					loop15:
					while (true) {
						int alt15=2;
						int LA15_0 = input.LA(1);
						if ( (LA15_0==ALL||LA15_0==ID) ) {
							alt15=1;
						}

						switch (alt15) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:817:4: a= dimSet
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_dimSet_in_set_of_dimSets918);
							a=dimSet();
							state._fsp--;

							adaptor.addChild(root_1, a.getTree());

							for(DimensionSet ds:(a!=null?((aexptree17.dimSet_return)a).dimensionSet:null))
							      retval.dimset_set.add(ds);
							  
							}
							break;

						default :
							if ( cnt15 >= 1 ) break loop15;
							EarlyExitException eee = new EarlyExitException(15, input);
							throw eee;
						}
						cnt15++;
					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					_last = (CommonTree)input.LT(1);
					char_literal24=(CommonTree)match(input,32,FOLLOW_32_in_set_of_dimSets935); 
					char_literal24_tree = (CommonTree)adaptor.dupNode(char_literal24);


					adaptor.addChild(root_0, char_literal24_tree);

					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning set of dimsets:"+retval.dimset_set);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "set_of_dimSets"


	public static class dim_return extends TreeRuleReturnScope {
		public Dimension d;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dim"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:827:1: dim returns [Dimension d] : ID ;
	public final aexptree17.dim_return dim() throws RecognitionException {
		aexptree17.dim_return retval = new aexptree17.dim_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ID25=null;

		CommonTree ID25_tree=null;


		  if(this.debug)
		    System.out.println("In dim");
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:838:3: ( ID )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:839:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			ID25=(CommonTree)match(input,ID,FOLLOW_ID_in_dim977); 
			ID25_tree = (CommonTree)adaptor.dupNode(ID25);


			adaptor.addChild(root_0, ID25_tree);


			  if(this.debug)
			    System.out.println("Evaluating dimid");
			    Dimension ret = null;
			    ret = allDimensions.getDimension((ID25!=null?ID25.getText():null));
			    if(ret == null){
			    if(this.debug)
			      System.out.println("Could not find dimension:"+(ID25!=null?ID25.getText():null));
			    }
			    else
			      retval.d = ret;
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning dimension:"+retval.d);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dim"


	public static class tags_return extends TreeRuleReturnScope {
		public Set<Tag> tagSet;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tags"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:855:1: tags returns [Set<Tag> tagSet] : ( '{' a= tag '}' | '{' ^( ',' (a= tag )+ ) '}' |c= tag );
	public final aexptree17.tags_return tags() throws RecognitionException {
		aexptree17.tags_return retval = new aexptree17.tags_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal26=null;
		CommonTree char_literal27=null;
		CommonTree char_literal28=null;
		CommonTree char_literal29=null;
		CommonTree char_literal30=null;
		TreeRuleReturnScope a =null;
		TreeRuleReturnScope c =null;

		CommonTree char_literal26_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree char_literal29_tree=null;
		CommonTree char_literal30_tree=null;


		    retval.tagSet = new HashSet<>();
		    if(this.debug)
		    System.out.println("Initializing tagset");
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:867:3: ( '{' a= tag '}' | '{' ^( ',' (a= tag )+ ) '}' |c= tag )
			int alt18=3;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==31) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==22) ) {
					alt18=2;
				}
				else if ( (LA18_1==ID||LA18_1==30) ) {
					alt18=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA18_0==ID||LA18_0==30) ) {
				alt18=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:868:3: '{' a= tag '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal26=(CommonTree)match(input,31,FOLLOW_31_in_tags1021); 
					char_literal26_tree = (CommonTree)adaptor.dupNode(char_literal26);


					adaptor.addChild(root_0, char_literal26_tree);

					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tag_in_tags1025);
					a=tag();
					state._fsp--;

					adaptor.addChild(root_0, a.getTree());

					retval.tagSet.add((a!=null?((aexptree17.tag_return)a).tag:null));
					_last = (CommonTree)input.LT(1);
					char_literal27=(CommonTree)match(input,32,FOLLOW_32_in_tags1028); 
					char_literal27_tree = (CommonTree)adaptor.dupNode(char_literal27);


					adaptor.addChild(root_0, char_literal27_tree);

					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:870:3: '{' ^( ',' (a= tag )+ ) '}'
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					char_literal28=(CommonTree)match(input,31,FOLLOW_31_in_tags1036); 
					char_literal28_tree = (CommonTree)adaptor.dupNode(char_literal28);


					adaptor.addChild(root_0, char_literal28_tree);

					_last = (CommonTree)input.LT(1);
					{
					CommonTree _save_last_1 = _last;
					CommonTree _first_1 = null;
					CommonTree root_1 = (CommonTree)adaptor.nil();
					_last = (CommonTree)input.LT(1);
					char_literal29=(CommonTree)match(input,22,FOLLOW_22_in_tags1038); 
					char_literal29_tree = (CommonTree)adaptor.dupNode(char_literal29);


					root_1 = (CommonTree)adaptor.becomeRoot(char_literal29_tree, root_1);

					match(input, Token.DOWN, null); 
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:870:11: (a= tag )+
					int cnt17=0;
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==ID||LA17_0==30) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:870:12: a= tag
							{
							_last = (CommonTree)input.LT(1);
							pushFollow(FOLLOW_tag_in_tags1042);
							a=tag();
							state._fsp--;

							adaptor.addChild(root_1, a.getTree());

							retval.tagSet.add((a!=null?((aexptree17.tag_return)a).tag:null));
							}
							break;

						default :
							if ( cnt17 >= 1 ) break loop17;
							EarlyExitException eee = new EarlyExitException(17, input);
							throw eee;
						}
						cnt17++;
					}

					match(input, Token.UP, null); 
					adaptor.addChild(root_0, root_1);
					_last = _save_last_1;
					}


					_last = (CommonTree)input.LT(1);
					char_literal30=(CommonTree)match(input,32,FOLLOW_32_in_tags1047); 
					char_literal30_tree = (CommonTree)adaptor.dupNode(char_literal30);


					adaptor.addChild(root_0, char_literal30_tree);

					}
					break;
				case 3 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:872:3: c= tag
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tag_in_tags1057);
					c=tag();
					state._fsp--;

					adaptor.addChild(root_0, c.getTree());


					    retval.tagSet.add((c!=null?((aexptree17.tag_return)c).tag:null));
					  
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			     System.out.println("Tagset:"+retval.tagSet);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tags"


	public static class tag_return extends TreeRuleReturnScope {
		public Tag tag;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tag"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:879:1: tag returns [Tag tag] : ( tagScheme | '_' ) ':' ID ;
	public final aexptree17.tag_return tag() throws RecognitionException {
		aexptree17.tag_return retval = new aexptree17.tag_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal32=null;
		CommonTree char_literal33=null;
		CommonTree ID34=null;
		TreeRuleReturnScope tagScheme31 =null;

		CommonTree char_literal32_tree=null;
		CommonTree char_literal33_tree=null;
		CommonTree ID34_tree=null;


		  if(this.debug)
		    System.out.println("Initializing tag");
		    retval.tag = new Tag();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:895:3: ( ( tagScheme | '_' ) ':' ID )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:896:3: ( tagScheme | '_' ) ':' ID
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:896:3: ( tagScheme | '_' )
			int alt19=2;
			int LA19_0 = input.LA(1);
			if ( (LA19_0==ID) ) {
				alt19=1;
			}
			else if ( (LA19_0==30) ) {
				alt19=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 19, 0, input);
				throw nvae;
			}

			switch (alt19) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:897:3: tagScheme
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_tagScheme_in_tag1105);
					tagScheme31=tagScheme();
					state._fsp--;

					adaptor.addChild(root_0, tagScheme31.getTree());


					    retval.tag.setTs((tagScheme31!=null?((aexptree17.tagScheme_return)tagScheme31).targetTagScheme:null));
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:902:3: '_'
					{
					_last = (CommonTree)input.LT(1);
					char_literal32=(CommonTree)match(input,30,FOLLOW_30_in_tag1118); 
					char_literal32_tree = (CommonTree)adaptor.dupNode(char_literal32);


					adaptor.addChild(root_0, char_literal32_tree);


					    retval.tag.setTs(allTagSchemes.getTagScheme("_"));
					  
					}
					break;

			}

			_last = (CommonTree)input.LT(1);
			char_literal33=(CommonTree)match(input,25,FOLLOW_25_in_tag1130); 
			char_literal33_tree = (CommonTree)adaptor.dupNode(char_literal33);


			adaptor.addChild(root_0, char_literal33_tree);

			_last = (CommonTree)input.LT(1);
			ID34=(CommonTree)match(input,ID,FOLLOW_ID_in_tag1132); 
			ID34_tree = (CommonTree)adaptor.dupNode(ID34);


			adaptor.addChild(root_0, ID34_tree);


			    retval.tag.setName((ID34!=null?ID34.getText():null)); 
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning Tag:"+retval.tag);
			    if(retval.tag.getName()==null||retval.tag.getTs()==null){
			    if(this.debug)
			      System.out.println("Not enough info for tag");
			    }
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tag"


	public static class tagScheme_return extends TreeRuleReturnScope {
		public TagScheme targetTagScheme;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tagScheme"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:913:1: tagScheme returns [TagScheme targetTagScheme] : ID ;
	public final aexptree17.tagScheme_return tagScheme() throws RecognitionException {
		aexptree17.tagScheme_return retval = new aexptree17.tagScheme_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ID35=null;

		CommonTree ID35_tree=null;

		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:914:3: ( ID )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:915:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			ID35=(CommonTree)match(input,ID,FOLLOW_ID_in_tagScheme1157); 
			ID35_tree = (CommonTree)adaptor.dupNode(ID35);


			adaptor.addChild(root_0, ID35_tree);


			    TagScheme target = allTagSchemes.getTagScheme((ID35!=null?ID35.getText():null));
			    if(this.debug)
			    System.out.println("Finding"+(ID35!=null?ID35.getText():null));
			    if(target == null){
			    if(this.debug)
			      System.out.println("TagScheme not found:"+(ID35!=null?ID35.getText():null));
			      throw new NullPointerException("TagScheme not found"+(ID35!=null?ID35.getText():null));
			    }
			    else{
			    if(this.debug)
			      System.out.println("TagScheme found");
			      retval.targetTagScheme = target;
			    }
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tagScheme"


	public static class dimSet_return extends TreeRuleReturnScope {
		public Set<DimensionSet> dimensionSet;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dimSet"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:937:1: dimSet returns [Set<DimensionSet> dimensionSet] : ( ALL | ID );
	public final aexptree17.dimSet_return dimSet() throws RecognitionException {
		aexptree17.dimSet_return retval = new aexptree17.dimSet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree ALL36=null;
		CommonTree ID37=null;

		CommonTree ALL36_tree=null;
		CommonTree ID37_tree=null;


		  if(this.debug)
		    System.out.println("Finding dimSet");
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:948:3: ( ALL | ID )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==ALL) ) {
				alt20=1;
			}
			else if ( (LA20_0==ID) ) {
				alt20=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:949:3: ALL
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ALL36=(CommonTree)match(input,ALL,FOLLOW_ALL_in_dimSet1208); 
					ALL36_tree = (CommonTree)adaptor.dupNode(ALL36);


					adaptor.addChild(root_0, ALL36_tree);


					  if(this.debug)
					    System.out.println("Dimensionset all");
					    retval.dimensionSet = new HashSet<>(allDimensionSets.getDimensionSets());
					  
					}
					break;
				case 2 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:956:3: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					_last = (CommonTree)input.LT(1);
					ID37=(CommonTree)match(input,ID,FOLLOW_ID_in_dimSet1221); 
					ID37_tree = (CommonTree)adaptor.dupNode(ID37);


					adaptor.addChild(root_0, ID37_tree);


					    DimensionSet target = allDimensionSets.getDimensionSet((ID37!=null?ID37.getText():null));
					    if(this.debug)
					    System.out.println("Finding"+(ID37!=null?ID37.getText():null));
					    Set<DimensionSet> result = new HashSet<>();
					    if(target == null){
					    if(this.debug)
					      System.out.println("Dimensionset not found");
					      throw new NullPointerException("Could not find dimension set:"+(ID37!=null?ID37.getText():null));
					    }
					    else{
					    if(this.debug)
					      System.out.println("Dimensionset found");
					      //Possibly handle unnamed dimset
					      result.add(target);
					      retval.dimensionSet = result;
					    } 
					  
					}
					break;

			}
			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning dimSet:"+retval.dimensionSet);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dimSet"


	public static class durations_return extends TreeRuleReturnScope {
		public List<Period> durationList;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "durations"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:978:1: durations returns [List<Period> durationList] : '{' ^( ';' (b= duration )+ ) '}' ;
	public final aexptree17.durations_return durations() throws RecognitionException {
		aexptree17.durations_return retval = new aexptree17.durations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal38=null;
		CommonTree char_literal39=null;
		CommonTree char_literal40=null;
		TreeRuleReturnScope b =null;

		CommonTree char_literal38_tree=null;
		CommonTree char_literal39_tree=null;
		CommonTree char_literal40_tree=null;


		    retval.durationList = new LinkedList<>();
		  
		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:988:3: ( '{' ^( ';' (b= duration )+ ) '}' )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:989:3: '{' ^( ';' (b= duration )+ ) '}'
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			char_literal38=(CommonTree)match(input,31,FOLLOW_31_in_durations1263); 
			char_literal38_tree = (CommonTree)adaptor.dupNode(char_literal38);


			adaptor.addChild(root_0, char_literal38_tree);

			_last = (CommonTree)input.LT(1);
			{
			CommonTree _save_last_1 = _last;
			CommonTree _first_1 = null;
			CommonTree root_1 = (CommonTree)adaptor.nil();
			_last = (CommonTree)input.LT(1);
			char_literal39=(CommonTree)match(input,26,FOLLOW_26_in_durations1265); 
			char_literal39_tree = (CommonTree)adaptor.dupNode(char_literal39);


			root_1 = (CommonTree)adaptor.becomeRoot(char_literal39_tree, root_1);

			match(input, Token.DOWN, null); 
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:989:12: (b= duration )+
			int cnt21=0;
			loop21:
			while (true) {
				int alt21=2;
				int LA21_0 = input.LA(1);
				if ( (LA21_0==INT) ) {
					alt21=1;
				}

				switch (alt21) {
				case 1 :
					// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:989:13: b= duration
					{
					_last = (CommonTree)input.LT(1);
					pushFollow(FOLLOW_duration_in_durations1270);
					b=duration();
					state._fsp--;

					adaptor.addChild(root_1, b.getTree());

					retval.durationList.add((b!=null?((aexptree17.duration_return)b).duration:null));
					}
					break;

				default :
					if ( cnt21 >= 1 ) break loop21;
					EarlyExitException eee = new EarlyExitException(21, input);
					throw eee;
				}
				cnt21++;
			}

			match(input, Token.UP, null); 
			adaptor.addChild(root_0, root_1);
			_last = _save_last_1;
			}


			_last = (CommonTree)input.LT(1);
			char_literal40=(CommonTree)match(input,32,FOLLOW_32_in_durations1275); 
			char_literal40_tree = (CommonTree)adaptor.dupNode(char_literal40);


			adaptor.addChild(root_0, char_literal40_tree);

			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			  if(this.debug)
			    System.out.println("Returning duration list:"+retval.durationList);
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "durations"


	public static class duration_return extends TreeRuleReturnScope {
		public Period duration;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "duration"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:992:1: duration returns [Period duration] : starttime= start_time ',' endtime= end_time ;
	public final aexptree17.duration_return duration() throws RecognitionException {
		aexptree17.duration_return retval = new aexptree17.duration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree char_literal41=null;
		TreeRuleReturnScope starttime =null;
		TreeRuleReturnScope endtime =null;

		CommonTree char_literal41_tree=null;

		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:997:3: (starttime= start_time ',' endtime= end_time )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:998:3: starttime= start_time ',' endtime= end_time
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_start_time_in_duration1304);
			starttime=start_time();
			state._fsp--;

			adaptor.addChild(root_0, starttime.getTree());

			_last = (CommonTree)input.LT(1);
			char_literal41=(CommonTree)match(input,22,FOLLOW_22_in_duration1306); 
			char_literal41_tree = (CommonTree)adaptor.dupNode(char_literal41);


			adaptor.addChild(root_0, char_literal41_tree);

			_last = (CommonTree)input.LT(1);
			pushFollow(FOLLOW_end_time_in_duration1310);
			endtime=end_time();
			state._fsp--;

			adaptor.addChild(root_0, endtime.getTree());


			//    System.out.println("Duration found");
			    retval.duration = new Period((starttime!=null?((aexptree17.start_time_return)starttime).value:null),(endtime!=null?((aexptree17.end_time_return)endtime).value:null));
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);


			//    System.out.println("Returning duration"+retval.duration.toString());
			  
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "duration"


	public static class start_time_return extends TreeRuleReturnScope {
		public String value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "start_time"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1005:1: start_time returns [String value] : INT ;
	public final aexptree17.start_time_return start_time() throws RecognitionException {
		aexptree17.start_time_return retval = new aexptree17.start_time_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree INT42=null;

		CommonTree INT42_tree=null;

		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1006:3: ( INT )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1007:3: INT
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			INT42=(CommonTree)match(input,INT,FOLLOW_INT_in_start_time1333); 
			INT42_tree = (CommonTree)adaptor.dupNode(INT42);


			adaptor.addChild(root_0, INT42_tree);

			  
			    retval.value = (INT42!=null?INT42.getText():null);
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start_time"


	public static class end_time_return extends TreeRuleReturnScope {
		public String value;
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "end_time"
	// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1013:1: end_time returns [String value] : INT ;
	public final aexptree17.end_time_return end_time() throws RecognitionException {
		aexptree17.end_time_return retval = new aexptree17.end_time_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		CommonTree _first_0 = null;
		CommonTree _last = null;


		CommonTree INT43=null;

		CommonTree INT43_tree=null;

		try {
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1014:3: ( INT )
			// /Users/pedro/Documents/git/kraets/KRAETS/kql/src/main/java/edu/mit/ll/antlr/aexptree17.g:1015:3: INT
			{
			root_0 = (CommonTree)adaptor.nil();


			_last = (CommonTree)input.LT(1);
			INT43=(CommonTree)match(input,INT,FOLLOW_INT_in_end_time1356); 
			INT43_tree = (CommonTree)adaptor.dupNode(INT43);


			adaptor.addChild(root_0, INT43_tree);

			  
			    retval.value = (INT43!=null?INT43.getText():null);
			  
			}

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "end_time"

	// Delegated rules



	public static final BitSet FOLLOW_r_exp_in_start89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_period_exp_in_r_exp136 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_in_r_exp152 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_r_exp_in_r_exp160 = new BitSet(new long[]{0x00000000D9A80210L});
	public static final BitSet FOLLOW_period_exp_in_r_exp164 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_r_exp182 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_r_exp_in_r_exp186 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_star_exp_in_period_exp234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_slash_exp_in_star_exp288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_21_in_star_exp302 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_star_exp_in_star_exp306 = new BitSet(new long[]{0x00000000D9880210L});
	public static final BitSet FOLLOW_slash_exp_in_star_exp310 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_24_in_slash_exp355 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_slash_exp_in_slash_exp359 = new BitSet(new long[]{0x0000000080800210L});
	public static final BitSet FOLLOW_atom2_in_slash_exp363 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_27_in_slash_exp379 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_slash_exp_in_slash_exp383 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_atom_in_slash_exp404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_slash_exp418 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_slash_exp_in_slash_exp422 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_durations_in_slash_exp426 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_set_of_dims_in_atom2480 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dimSet_in_atom2494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_23_in_atom2511 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_atom2_in_atom2515 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_durations_in_atom2519 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_dims_in_atom571 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tags_in_atom585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_atom598 = new BitSet(new long[]{0x00000000D9B85230L});
	public static final BitSet FOLLOW_r_exp_in_atom606 = new BitSet(new long[]{0x00000000D9B85230L});
	public static final BitSet FOLLOW_20_in_atom617 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_atom625 = new BitSet(new long[]{0x0000000080000210L});
	public static final BitSet FOLLOW_dimSet_in_atom636 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_set_of_dimSets_in_atom650 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_atom660 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_dims700 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dim_in_dims716 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_of_dims_in_dims730 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dims772 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_dim_in_set_of_dims779 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_set_of_dims788 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dims797 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_set_of_dims799 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_dim_in_set_of_dims803 = new BitSet(new long[]{0x0000000000000208L});
	public static final BitSet FOLLOW_32_in_set_of_dims808 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_33_in_virtual_dim828 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_virtual_dim830 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_dim_in_virtual_dim834 = new BitSet(new long[]{0x0000000000000208L});
	public static final BitSet FOLLOW_34_in_virtual_dim839 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dimSets882 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_dimSet_in_set_of_dimSets889 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_set_of_dimSets898 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dimSets906 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_set_of_dimSets911 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_dimSet_in_set_of_dimSets918 = new BitSet(new long[]{0x0000000000000218L});
	public static final BitSet FOLLOW_32_in_set_of_dimSets935 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_dim977 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_tags1021 = new BitSet(new long[]{0x0000000040000200L});
	public static final BitSet FOLLOW_tag_in_tags1025 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_tags1028 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_tags1036 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_tags1038 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_tag_in_tags1042 = new BitSet(new long[]{0x0000000040000208L});
	public static final BitSet FOLLOW_32_in_tags1047 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tag_in_tags1057 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tagScheme_in_tag1105 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_30_in_tag1118 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_tag1130 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_tag1132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_tagScheme1157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_dimSet1208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_dimSet1221 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_durations1263 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_26_in_durations1265 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_duration_in_durations1270 = new BitSet(new long[]{0x0000000000000408L});
	public static final BitSet FOLLOW_32_in_durations1275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_start_time_in_duration1304 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_duration1306 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_end_time_in_duration1310 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_start_time1333 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_end_time1356 = new BitSet(new long[]{0x0000000000000002L});
}
