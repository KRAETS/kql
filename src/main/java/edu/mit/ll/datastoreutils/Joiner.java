package edu.mit.ll.datastoreutils;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import unity.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import edu.mit.ll.aexp.Result;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.Table;

public class Joiner {
	
	private int replacement = 0;
	
	public String join(List<Result> aexpresults, String replacedString, String replacementtext, JsonObject sql) throws ParseException{
		//Traverse the top level of the SQL in JSON:
		String sqlExpression = "";
//		System.out.println("Working with: "+replacedString);
		
		Set<Entry<String, JsonElement>> object = sql.entrySet();
		for (Map.Entry<String,JsonElement> entry : sql.entrySet()) {
			int size = sql.entrySet().size();
			//All entries are arrays on the top level
			//They are select... from... where... etc.
//			System.out.println("Printing:"+entry.getKey());
			if(entry.getValue().isJsonArray()){
				JsonArray arr = entry.getValue().getAsJsonArray();
				sqlExpression+=" "+entry.getKey()+" ";
				for(int i=0; i<arr.size();i++){
					//Get json element
					JsonElement currentElement = arr.get(i);
					//Convert to json object
					JsonObject currentElementobject = null;
					//System.out.println("Printing element:"+i+" It is:"+currentElement.toString());

					if(currentElement.isJsonObject()){
						currentElementobject = currentElement.getAsJsonObject();
						//Get the sub tree and process it
						JsonElement sub_tree = currentElementobject.get("sub_tree");
						JsonObject sub_tree_object = null;
						if(!sub_tree.isJsonPrimitive()){
							sqlExpression += " (";
							if(sub_tree.isJsonObject()){
								 sub_tree_object = sub_tree.getAsJsonObject();
							}
							else{
								JsonArray sub_tree_array = sub_tree.getAsJsonArray();
								sub_tree_object = new JsonObject();
								sub_tree_object.add("",sub_tree_array);
								
							}
							String newExpression = currentElementobject.get("base_expr").getAsString();
							sqlExpression +=join(aexpresults,newExpression,replacementtext,sub_tree_object);
							sqlExpression+= ") ";
							try{
							if(!currentElementobject.get("alias").isJsonPrimitive()){
								String alias = ((JsonObject)currentElementobject.get("alias")).get("base_expr").getAsString();
								sqlExpression += " "+alias+" ";
							}
							}
							catch(Exception e){
								//
							}
							
							
						}

						//If not then just process the current expression.
						else{
							String basexp = currentElementobject.get("base_expr").getAsString();
							while(basexp.contains(replacementtext)){
								String replacementstring = "";
								if(aexpresults.get(replacement).getResultFields()!=null){
									for(Field f:aexpresults.get(replacement).getResultFields()){
										replacementstring+=f.getName()+",";
									}
									replacementstring=replacementstring.substring(0,replacementstring.length()-1);
									
								}
								else{
									for(Table f:aexpresults.get(replacement).getResultTables()){
										replacementstring+=f.getName()+",";
									}
									replacementstring=replacementstring.substring(0,replacementstring.length()-1);
								}
								basexp = basexp.replaceFirst(replacementtext, replacementstring);
								replacement++;
							}
							sqlExpression+=" "+basexp+" ";
						}
						
					}
					else{
						throw new ClassCastException("Could not cast as json object");
					}
				}

			}
			else{
				throw new ParseException("Could not identify entry type");
			}

		}
//		System.out.println("Returning:"+sqlExpression);
		return sqlExpression;
	}
}
