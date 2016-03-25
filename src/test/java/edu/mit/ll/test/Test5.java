/*******************************************************************************
 * Copyright (c) 2013 Massachusetts Institute of Technology
 * 
 * Not with standing any copyright notice, U.S. Government rights in this work
 * are defined by DFARS 252.227-7013 or DFARS 252.227-7014 as detailed below.
 * Use of this work other than as specifically authorized by the U.S.
 * Government may violate any copyrights that exist in this work.
 * 
 * UNLIMITED RIGHTS
 * DFARS Clause reference: 252.227-7013 (a)(16) and 252.227-7014 (a)(16)
 * Unlimited Rights. The Government has the right to use, modify, reproduce, perform,
 * display, release or disclose this (technical data or computer software) in whole or in part, in
 * any manner, and for any purpose whatsoever, and to have or authorize others to do so.
 * 
 * THE SOFTWARE IS PROVIDED TO YOU ON AN "AS IS" BASIS.
 ******************************************************************************/
package edu.mit.ll.test;

import java.util.List;

import javax.naming.CannotProceedException;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.ExpectedException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import edu.mit.ll.aexp.AExpProcessor;
import edu.mit.ll.datastoreutils.Parser;
import edu.mit.ll.php.JavaPhpSqlWrapper;



public class Test5 {
	

    static String testName = "Test1";    
    static Logger log = Logger.getLogger(Test5.class);


    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void fileSetUp() throws Exception {
    	

    }
    
    @Test
    public void test() throws JsonSyntaxException, CannotProceedException {
    	String query = "SELECT \\ALL/DimensionSet2*Dimension1\\";
    	Parser p = new Parser();
        List<String> aexpqueries = p.stringExtractor("\\\\",query,"POTATO");
        JavaPhpSqlWrapper sqlprocessor = new JavaPhpSqlWrapper(aexpqueries.get(aexpqueries.size()-1));
        JsonParser parser = new JsonParser();
        JsonObject result = (JsonObject)parser.parse(sqlprocessor.execPHP(null,sqlprocessor.getQuery()));
        for(int i=0; i<aexpqueries.size()-1;i++){
            try {
            	AExpProcessor processor = new AExpProcessor();
            	processor.setFolderlocation("src/main/resources/json/");
            	processor.enableDebug(true);
            	String r1 = processor.process(aexpqueries.get(i),true).toString();
                Assert.assertEquals("{resultTables:null resultFields:[Field3]}", r1);
            } catch (RecognitionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }


}
