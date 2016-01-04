package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.binary.StringUtils;

import edu.mit.ll.aexpression.Dimension;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.PreProcessMaps;
import edu.mit.ll.aexpression.RegistryOperators;

public class ProvenanceDataStructure {
	public boolean fullPrint = false;
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
		String text = "";
		text+=this.rootNode.getType();
		if(fullPrint){
			text+="{"+this.rootNode.data.toString()+"}";
		}
		text+="\n";
		text+=toStringHelper(rootNode, 1);
		
		//Clean up empty space
		String newString = "";
		for(String line : text.split("\n")){
			if(!line.matches("(----)+>(\\\\s+$|$)")){
				//Here
				newString+=line+"\n";
			}
		}
		
		//Organize levels
		String newString2  = "";
		int previousIndentation = 0, currentIndentation = 0;
		for(String line : newString.split("\n")){
			currentIndentation = (line.length()-line.replace("-", "").length())/4;
			//There should be at most 1 level of indentation from the previous to current level
			if(currentIndentation - previousIndentation >1){
				//If there is more than one level
				int decreaseLevel = currentIndentation - previousIndentation - 1;
				for(int i = 0; i<decreaseLevel;i++){
					line=line.replaceFirst("----", "");
				}
			}
			newString2+=line+"\n";
			previousIndentation = currentIndentation;
		}
		return text;
	}
	public ProvenanceDataStructure(Object data, TYPE type){
		this.setData(data,type);
	}
	public ProvenanceDataStructure(){
	}
	private static int count = 0;
	public String toStringHelper(Node current, int level){
	
		String levelString ="";
//		if(count == 0){
//			count++;
//			levelString+=toStringHelper(current.getChildren().get(0), 1);
//		}
		for(Node child:current.getChildren()){
			//Add the level
			for(int i = 0; i<level;i++){
				levelString+="----";
			}
			levelString+=">";
			//Add the content
			switch ( child.getType() ) {
			case SLASHEXPRESSION:
				
				//Check if operation present in child
				boolean flag = false;
				for(Node children : child.getChildren()){
					if(children.getType().equals(TYPE.OPERATION))
						flag = true;
				}
				//present results if so
				//ifnot then ignore
				if(flag){
					levelString+="SLASHEXP:"+child.getData();
				}
				break;
			case STAREXPRESSION:
				//Check if operation present in child

				boolean flag1 = false;
				for(Node children : child.getChildren()){
					if(children.getType().equals(TYPE.OPERATION))
						flag1 = true;
				}
				//present results if so
				//ifnot then ignore
				if(flag1){
					levelString+="STAREXP:"+child.getData();
				}
				
				break;
			case DIMENSIONSET:
				Set<Dimension> allDim = new HashSet<>(); 
				for(Dimension d:((Set<Dimension>)child.getData())){
					allDim.add(d);
				}
				List<Field> matchedFields = RegistryOperators.matchFieldsDimensionsFields(folderlocation.getFields().getAllFieldsList(), allDim);
				levelString+="{Fields:[";
				for(Field f : matchedFields){
					levelString+="{"+f.getName()+",table:"+f.getTable().getName()+"}";
				}
				levelString+="]}";
				break;
			case OPERATION:
				levelString+=child.getData();
				break;
			case PERIODEXPRESSION:
				//nothing
				break;
			case ATOM:
				levelString+="atom";
				break;
			default:
				levelString+=""+child.getType();
				if(fullPrint){
					levelString+="["+child.getData()+"]";
				}
				break;
			}
				
//			
//			if(fullPrint)
//				levelString+="{"+child.getData().toString()+"}";
			levelString+="\n";
			//Check the children;
			levelString+=toStringHelper(child, level+1);
		}
		return levelString;
	}
	public static PreProcessMaps getFolderlocation() {
		return folderlocation;
	}
	public static void setFolderlocation(PreProcessMaps folderlocation) {
		ProvenanceDataStructure.folderlocation = folderlocation;
	}
}
