package edu.mit.ll.aexp;

import java.util.HashSet;
import java.util.Set;


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
