package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


import edu.mit.ll.aexp.ProvenanceDataStructure.TYPE;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.Table;

public class Result {
	public ProvenanceDataStructure provenance = new ProvenanceDataStructure();
	
	private Set<Table> resultTables = null;
	private Set<Field> resultFields = null;
	public Set<Field> getResultFields() {
		return resultFields;
	}
	public void setResult(Set<?> result) {
		try{
			this.resultFields = (Set<Field>) result;
			for(Field f: resultFields){
//				System.out.println(f);
			}
		}
		catch(ClassCastException e){
			this.resultFields = null;
		}
		try{
			this.resultTables = (Set<Table>) result;
			for(Table f: resultTables){
//				System.out.println(f);
			}

		}
		catch(ClassCastException e){
			this.resultTables = null;
		}
		if(resultFields==null && resultTables==null){
			throw new NullPointerException("Problem assigning result");
		}
		return;
	}
	public Set<Table> getResultTables() {
		return resultTables;
	}
	public String toJsonString(){
		JsonObject result = new JsonObject();
		
		List<String> tables = new LinkedList<>();
				
		if(this.getResultTables()!=null)
			for(Table t:this.getResultTables())
				tables.add(t.getName());
		
		List<String> fields = new LinkedList<>();
		
		if(this.getResultFields()!=null){
			for(Field f: this.getResultFields()){
				fields.add(f.getName());
			}
		}
	    Gson gson = new Gson();
	    JsonElement tablesJson = gson.toJsonTree(tables);
		result.add("tables", tablesJson);
		JsonElement fieldsJson = gson.toJsonTree(fields);
		result.add("fields", fieldsJson);
		
		return result.toString();
	
	}
	
	@Override 
	public String toString(){
		String returnstring = "{Tables:";
		
		if(this.getResultTables()!=null)
			returnstring +=this.getResultTables();
		else
			returnstring+="null";
		
		returnstring+=" Fields:";
		
		if(this.getResultFields()!=null){
			int length = 0;
			for(Field f: this.getResultFields()){
				returnstring+=f.getTable().getName()+":"+f.getName()+",";
				length++;
			}
			if(length>0)
				returnstring = returnstring.substring(0,returnstring.length()-2);
		}
		else
			returnstring+="null";
		
		
		returnstring+="}";
		return returnstring;
	}
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return this.getResultFields()==null&&this.getResultTables()==null;
	}
}
