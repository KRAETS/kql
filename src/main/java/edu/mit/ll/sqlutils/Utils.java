package edu.mit.ll.sqlutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import edu.mit.ll.aexpression.Dimension;
import edu.mit.ll.aexpression.DimensionSet;
import edu.mit.ll.aexpression.DimensionSets;
import edu.mit.ll.aexpression.Dimensions;
import edu.mit.ll.aexpression.Field;
import edu.mit.ll.aexpression.Fields;
import edu.mit.ll.aexpression.PreProcessMaps;
import edu.mit.ll.aexpression.RegistryOperators;
import edu.mit.ll.aexpression.Table;
import edu.mit.ll.aexpression.Tables;
import edu.mit.ll.aexpression.Tag;
import edu.mit.ll.aexpression.TagSchemes;
import edu.mit.ll.aexpression.VirtualDimensions;
import edu.mit.ll.antlr.aexptree17;

public class Utils {
	/**
     * Helper method to print out the resultSet.
     * 
     * @param rst the resultSet returned from the query execution.
     * @return the number of tuples returned
     * @throws SQLException
     *             if a database error occurs
     */
    public static int printResults(ResultSet rst) throws SQLException
    {
//    	if(!rst.isBeforeFirst()){
//    		throw new SQLException("Result set not before first");
//    	}
        // Print out your results
        ResultSetMetaData meta = rst.getMetaData();
        int numColumns = meta.getColumnCount();
        System.out.print(meta.getColumnName(1));
        for (int j = 2; j <= meta.getColumnCount(); j++)
            System.out.print(", " + meta.getColumnName(j));
        System.out.println();

        int count = 0;
        while (rst.next())
        {
            System.out.print(rst.getObject(1));
            for (int j = 2; j <= numColumns; j++)
                System.out.print(", " + rst.getObject(j));
            System.out.println();
            count++;
        }
        return count;
    }
    public static int printResultsToFile(ResultSet rst, File outFile) throws SQLException, FileNotFoundException
    {
//    	if(!rst.isBeforeFirst()){
//    		throw new SQLException("Result set not before first");
//    	}
        PrintWriter fileprinter = new PrintWriter(outFile);
        // Print out your results
        ResultSetMetaData meta = rst.getMetaData();
        int numColumns = meta.getColumnCount();
        fileprinter.print(meta.getColumnName(1));
        for (int j = 2; j <= meta.getColumnCount(); j++)
        	fileprinter.print(", " + meta.getColumnName(j));
        fileprinter.println();
        int count = 0;
        while (rst.next())
        {
        	fileprinter.print(rst.getObject(1));
            for (int j = 2; j <= numColumns; j++)
            	fileprinter.print(", " + rst.getObject(j));
            fileprinter.println();
            count++;
        }
        fileprinter.close();
        return count;
    }
	public static int printResultToJson(ResultSet s, File outFile) throws SQLException{
		//Do something
		JsonObject object = new JsonObject();
		JsonArray resultsarray = new JsonArray();
		ResultSetMetaData meta = s.getMetaData();
		
		//Print additional information
		String folderlocation = aexptree17.folderlocation;
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
	    

	      

	    ffs.init();
	    
	    VirtualDimensions allVirtualDimensions = ffs.getVirtualDimensions();
	    Tables allTables = ffs.getTables();
	    DimensionSets allDimensionSets = ffs.getDs2dmap();
	    Dimensions allDimensions = ffs.getDimensions();
	    TagSchemes allTagSchemes = ffs.getTs2tmap();
	    Fields allFields = ffs.getFields();
	    
		JsonObject additionalInformationObject = new JsonObject();
		for(int i =1; i<=meta.getColumnCount();i++){
			JsonObject fieldinfoobject = new JsonObject();
			Field target = null;
			for(Field d:allFields.getAllFieldsList()){
				if(d.getName().equals(meta.getColumnName(i))){
					target =d;
					break;
				}
			}
			if(target==null){
				System.err.println("Field not found"+meta.getColumnName(i));
				continue;
			}
			//Dimension Expansion
			JsonArray dimensions = new JsonArray();
			dimensions.add(new JsonPrimitive(target.getDimension().getName()));

			//Table Expansion
			JsonArray tables = new JsonArray();
			for(Table t:allTables.getTables()){
				for(Field f:t.getFields()){
					if(f.getName().equals(target.getName())){
						tables.add(new JsonPrimitive(t.getName()));
					}
				}
			}
			
			
			//Tag expansion
			JsonArray tags = new JsonArray();
			for(Tag t:target.getTags()){
				if(t!=null)
				tags.add(new JsonPrimitive(t.getName()));
			}
			//Dimensionset expansion
			JsonArray dimensionsets = new JsonArray();
			for(DimensionSet dss:allDimensionSets.getDimensionSets()){
				for(Dimension d:dss.getDimensions()){
					if(target.getDimension().getName().equals(d.getName())){
						dimensionsets.add(new JsonPrimitive(dss.getName()));
					}
				}
			}
		    fieldinfoobject.add("dimensionexpansion", dimensions);
		    fieldinfoobject.add("tableexpansion", tables);
		    fieldinfoobject.add("tagexpansion", tags);
		    fieldinfoobject.add("dimensionsetexpansion", dimensionsets);
			
			
			additionalInformationObject.add(meta.getColumnName(i), fieldinfoobject);
		}
		object.add("additionalinfo",additionalInformationObject);
		//End
		
        int numColumns = meta.getColumnCount();
        int count = 0;
		while(s.next()){
			//Instantiate row object
			JsonObject result = new JsonObject();
			//Fill it up
			for(int i = 1; i<=numColumns;i++){
				Object obj = s.getObject(i);
				try{
					JsonPrimitive prim = new JsonPrimitive(obj.toString());
					result.add(meta.getColumnName(i),prim);

				}
				catch(Exception e){
					JsonNull nullobj = new JsonNull();
					result.add(meta.getColumnName(i), nullobj);
				}
			}
			//Add it to results array
			resultsarray.add(result);
			count++;
		}
		//load array in result object
		object.add("results", resultsarray);
		
		try {
			PrintWriter pw = new PrintWriter(outFile);
			pw.println(object.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Could not open file");
		}
		return count;
	}
}
