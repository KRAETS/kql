package edu.mit.ll.aexp;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.codec.binary.StringUtils;

import sun.misc.Regexp;

import edu.mit.ll.aexpression.Dimension;
import edu.mit.ll.aexpression.DimensionSet;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.PreProcessMaps;
import edu.mit.ll.aexpression.RegistryOperators;
import edu.mit.ll.aexpression.Table;

public class ProvenanceDataStructure {
	public boolean fullPrint = false;		
	private CommonTree tree;
	private String expression;

	private class Node{
		private Object data;
		private TYPE type;
		private TYPE2 type2;
		public Node(){
			type = TYPE.NULL;
			data = null;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public TYPE getType() {
			return type;
		}
		public void setType(TYPE type) {
			this.type = type;
		}
		private List<Node> children = new LinkedList<>();
		public List<Node> getChildren(){
			return children;
		}
		public void addChild(Node child){
			children.add(child);
		}
		public void setType2(TYPE2 type2) {
			// TODO Auto-generated method stub
			this.type2 = type2;
		}

	}
	public CommonTree getTree() {
		return tree;
	}
	public void setTree(CommonTree tree) {
		this.tree = tree;
	}
	private Node rootNode = new Node();
	private static PreProcessMaps folderlocation = null;

	public enum TYPE {
		ATOM,ATOM2,DIMENSION,DIMENSIONSET,DIMENSIONSETSET,SETOFDIMS,FIELD,FIELDSET,TAG,TAGSET,TABLE,TABLESET,NULL, OPERATION,PERIOD,MULTIPLE,SLASHEXPRESSION,STAREXPRESSION,PERIODEXPRESSION,REXP,DURATIONSET
	};
	public enum TYPE2{
		FIELD,TABLE,OPERATION, STAR, SLASH
	}
	public void setData(Object data, TYPE type){
		this.rootNode.setData(data);
		this.rootNode.setType(type);
	}
	public void setData(Object data, TYPE2 type){
		this.rootNode.setData(data);
		this.rootNode.setType2(type);
	}
	public Object getData(){
		return rootNode.getData();
	}
	public Object getType(){
		return rootNode.getType();
	}
	public void setType(TYPE type){
		this.rootNode.setType(type);
	}
	public void setType2(TYPE2 type){
		this.rootNode.setType2(type);
	}
	public void setData(Object data){
		this.rootNode.setData(data);
	}
	public void join(ProvenanceDataStructure newChild){
		this.rootNode.addChild(newChild.rootNode);
	}
	@Override
	public String toString(){
		String text = "{\n"+"A-Expression: "+this.getExpression()+"\n\n";
		
		if(!fullPrint){
			//partial print just fields and tables
			text+="Table : Fields\n";
			
			if((rootNode.getData())!=null){
				
				Map<String,List<Field>> tableFieldMap = new HashMap<>();
				if(((Result)rootNode.getData()).getResultFields()!=null){
					//Just contains fields
					//Map the table and their fields
					for(Field f:((Result)rootNode.getData()).getResultFields()){

						if(!tableFieldMap.containsKey(f.getTable().getName())){
							//Create the table entry
							tableFieldMap.put(f.getTable().getName(), new LinkedList<Field>());
						}
						tableFieldMap.get(f.getTable().getName()).add(f);
					}
					//Print it out
					for(String table:tableFieldMap.keySet()){
						text+="<"+table+">"+":<";
						for(Field f:tableFieldMap.get(table)){
							text+=f.getName()+" ";
						}
						text+=">\n";
					}
					
				}
				else{
					//Just tables
					//Print out the table and its fields
					if(((Result)rootNode.getData()).getResultTables()!=null){
						for(Table t:((Result)rootNode.getData()).getResultTables()){
							text+="<"+t.getName()+">"+":<";
							for(Field field: t.getFields()){
								text+=field.getName();
							}
							text+=">\n";
						}
					}
				}
			}
			else{
				text+="Error, no data";
			}

		}
		else{
			//full print dimensionsets/tables
			//First print out the result:
			List<String> clauses = getClauses(this.getTree());
			List<Map<String, List<Field>>> results = getResults(this.rootNode);
			Collections.reverse(clauses);
//			Collections.reverse(results);
			if(results.size()!=clauses.size()){
				System.err.println("Problem providing provenance, results dont match clauses");
				return "Problem providing provenance, results dont match clauses";
			}
			for(int i = 0; i<results.size();i++){
				text+="Clause: "+clauses.get(i)+"\n";
				text+="Table : Fields\n";
				for(String table:results.get(i).keySet()){
					text+="<"+table+">"+":<";
					for(Field f:results.get(i).get(table)){
						text+=f.getName()+" ";
					}
					text+=">";
				}
				text+="\n\n";
			}
			
		}
		text+="}";
		return text;
	}
	List<Map<String,List<Field>>> resultList = new LinkedList<>();
	private List<Map<String,List<Field>>> getResults(Node node) {
		// TODO Auto-generated method stub
		for(Node child:node.getChildren()){
			if(child.getType().equals(TYPE.OPERATION)){
				//We have reached a node that contains the result of the operation
				//Add the operation
				if(((IntermediateResult)node.getData()).getIntermediate_fields()!=null){
					//Add the tables first then the fields
					resultList.add(getMapOfTablesAndFields(((IntermediateResult)node.getData()).getIntermediate_fields()));
				}
				else if (((IntermediateResult)node.getData()).getIntermediate_tables()!=null){
					resultList.add(getMapOfTablesAndFields2(((IntermediateResult)node.getData()).getIntermediate_tables()));
				}
				else{
					System.out.println("No fields or tables??");
				}
//				System.out.println(node);
			}
			else{
				getResults(child);
			}
		}
		return resultList;
	}
	private Map<String, List<Field>> getMapOfTablesAndFields2(List<Table>tList) {
		Map<String, List<Field>> tableFieldMap = new HashMap<>();
		for(Table t:tList){
			if(!tableFieldMap.keySet().contains(t.getName())){
				tableFieldMap.put(t.getName(), t.getFields());
			}
		}
		return tableFieldMap;
	}
	private Map<String, List<Field>> getMapOfTablesAndFields(List<Field> fieldList) {
		Map<String, List<Field>> tableFieldMap = new HashMap<>();
		for(Field f:fieldList){

			if(!tableFieldMap.containsKey(f.getTable().getName())){
				//Create the table entry
				tableFieldMap.put(f.getTable().getName(), new LinkedList<Field>());
			}
			tableFieldMap.get(f.getTable().getName()).add(f);
		}
		return tableFieldMap;
	}
	private List<String> clauses = new LinkedList<>();
	public List<String> getClauses(Tree tree2){
//		System.out.println(tree2);
		String clause = "("+tree2.toString()+" ";
		for(int i =0; i<tree2.getChildCount();i++){
//			System.out.println("Printing child" + tree2.getChild(i));
			if(tree2.getChild(i).toString().equals("*")||tree2.getChild(i).toString().equals("/")){
				clause+="priorclause ";
			}
			else
				clause+=tree2.getChild(i)+" ";
			if(tree2.getChild(i).getChildCount()>0)
				clauseHelper(tree2.getChild(i));
		}
		clause+=")";
		clauses.add(clause);
		return clauses;
	}
	private void clauseHelper(Tree tree2){
		String clause = "("+tree2.toString()+" ";
		for(int i =0; i<tree2.getChildCount();i++){
//			System.out.println(tree2.getChild(i));
//			clause+=tree2.getChild(i).toString()+" ";
			if(tree2.getChild(i).getChildCount()>0){
				clause+="priorclause ";

				clauseHelper(tree2.getChild(i));
			}
			else{
				clause+=tree2.getChild(i).toString()+" ";

			}
		}
		clause+=")";
		clauses.add(clause);
		
	}
	public ProvenanceDataStructure(Object data, TYPE type){
		this.setData(data,type);
	}
	public ProvenanceDataStructure(){
	}
	private static int count = 0;
	//	public String toStringHelper(Node current, int level){
	//	
	//		String levelString ="";
	////		if(count == 0){
	////			count++;
	////			levelString+=toStringHelper(current.getChildren().get(0), 1);
	////		}
	//		for(Node child:current.getChildren()){
	//			//Add the level
	//			for(int i = 0; i<level;i++){
	//				levelString+="----";
	//			}
	//			levelString+=">";
	//			//Add the content
	//			switch ( child.getType() ) {
	//			case SLASHEXPRESSION:
	//				
	//				//Check if operation present in child
	//				boolean flag = false;
	//				for(Node children : child.getChildren()){
	//					if(children.getType().equals(TYPE.OPERATION))
	//						flag = true;
	//				}
	//				//present results if so
	//				//ifnot then ignore
	//				if(flag){
	//					levelString+="SLASHEXP:"+child.getData();
	//				}
	//				break;
	//			case STAREXPRESSION:
	//				//Check if operation present in child
	//
	//				boolean flag1 = false;
	//				for(Node children : child.getChildren()){
	//					if(children.getType().equals(TYPE.OPERATION))
	//						flag1 = true;
	//				}
	//				//present results if so
	//				//ifnot then ignore
	//				if(flag1){
	//					levelString+="STAREXP:"+child.getData();
	//				}
	//				
	//				break;
	//			case DIMENSIONSET:
	//				Set<Dimension> allDim = new HashSet<>(); 
	//				for(Object d:((Set<Dimension>)child.getData())){
	//					if(d instanceof Dimension)
	//					allDim.add((Dimension)d);
	//					else{
	//						for(Dimension d1:((DimensionSet)d).getDimensions())
	//						allDim.add(d1);
	//					}
	//				}
	//				List<Field> matchedFields = RegistryOperators.matchFieldsDimensionsFields(folderlocation.getFields().getAllFieldsList(), allDim);
	//				levelString+="{Fields:[";
	//				for(Field f : matchedFields){
	//					levelString+="{"+f.getName()+",table:"+f.getTable().getName()+"}";
	//				}
	//				levelString+="]}";
	//				break;
	//			case OPERATION:
	//				levelString+=child.getData();
	//				break;
	//			case PERIODEXPRESSION:
	//				//nothing
	//				break;
	//			case ATOM:
	//				levelString+="atom";
	//				break;
	//			default:
	//				levelString+=""+child.getType();
	//				if(fullPrint){
	//					levelString+="["+child.getData()+"]";
	//				}
	//				break;
	//			}
	//				
	////			
	////			if(fullPrint)
	////				levelString+="{"+child.getData().toString()+"}";
	//			levelString+="\n";
	//			//Check the children;
	//			levelString+=toStringHelper(child, level+1);
	//		}
	//		return levelString;
	//	}
	public String newToStringHelper(Node current, String additional, String original){

		String levelString ="";
		String operationString = "";

		if(current.getData().toString().equals("IntermediateResult:")){

			return newToStringHelper(current.getChildren().get(0), "", "");
		}
		if((current.getData().toString().contains("DIMSET")||current.getData().toString().contains("TAGSET")) && current.getData() instanceof IntermediateResult)
		{
			levelString+="<"+current.getData()+","+additional+">";
			return levelString;
		}
		//		System.out.println("Printing "+current.getData()+" Additional = "+additional);
		if(current.getData().toString().equals("*")){
			additional = "*";
		}
		if(current.getChildren().size()>0){
			if(current.toString().equals("IntermediateResult: ")){
				//Check the lower level
//				System.out.println(current.getChildren().get(0).toString());
			}
			else{
				if(current.getType().equals(TYPE.STAREXPRESSION)){
					for(Node cn :current.getChildren()){
						if(cn.getType().equals(TYPE.OPERATION))
							continue;
						else{
							levelString+=newToStringHelper(cn, "*",levelString);
						}
					}
				}
			}


			//			for(Node n:current.getChildren()){
			//				String resu = newToStringHelper(n, additional,"");
			//				System.out.println
			//				if(resu.equals("*")){
			//					additional = "*";
			//				}
			//			}
		}

		//		String t = ("Evaluating "+current.getData()+" Additional = "+additional);
		//		System.out.println(t);
		return levelString;

	}
	public static PreProcessMaps getFolderlocation() {
		return folderlocation;
	}
	public static void setFolderlocation(PreProcessMaps folderlocation) {
		ProvenanceDataStructure.folderlocation = folderlocation;
	}
	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
}
