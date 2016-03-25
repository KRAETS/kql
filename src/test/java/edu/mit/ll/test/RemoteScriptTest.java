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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.CannotProceedException;

import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import unity.parser.ParseException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.mit.ll.aexp.AExpProcessor;
import edu.mit.ll.aexp.Result;
import edu.mit.ll.datastoreutils.Parser;
import edu.mit.ll.execution.QueryExecutor;
import edu.mit.ll.php.JavaPhpSqlWrapper;


public class RemoteScriptTest {

    static String testName = "APITest";    
    static Logger log = Logger.getLogger(Test1.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void fileSetUp() throws Exception {
    	
    }
    
    @Test
    public void test() throws IOException {
    	StringBuilder output2 = new StringBuilder();
//		Process p = Runtime.getRuntime().exec(new String[]{"php5", finalScriptName, param});
//		
//		StringBuilder result = new StringBuilder();
    	String urlstring = "http://192.168.0.114:8080/sqlparser/examples/simplerexample.php"+"?kqlq="+"SELECT hola FROM 'filebeat-*'";
	      URL url = new URL(urlstring);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      
	      conn.setRequestMethod("GET");
	      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      String line;
	      while ((line = rd.readLine()) != null) {
	         output2.append(line);
	      }
	      rd.close();
	      System.out.println(output2.toString());
    }

}