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

import java.io.IOException;
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

import edu.mit.ll.aexp.AExpExtractor;
import edu.mit.ll.aexp.AExpProcessor;
import edu.mit.ll.aexp.Result;
import edu.mit.ll.execution.QueryExecutor;
import edu.mit.ll.php.JavaPhpSqlWrapper;


public class APITest3 {

    static String testName = "APITest2";    
    static Logger log = Logger.getLogger(Test1.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void fileSetUp() throws Exception {
    	
    }
    
    @Test
    public void test() throws SQLException, RecognitionException, ParseException, IOException, CannotProceedException {
    	QueryExecutor ex = new QueryExecutor("SELECT \\ALL*_:email_message\\ FROM \\ALL/{folder}\\ WHERE ( \\ALL*folder*_:email_message\\ = 'sent_items' OR \\ALL*folder*_:email_message\\ = 'sent') AND ( \\ALL*datetime*_:recipient\\ >= Date('1 Jan 2001 0:00:00 -0700 (PDT)'))  AND ( \\ALL*datetime*_:recipient\\ < Date('1 Jan 2002 0:00:00 -0700 (PDT)'))  ", 100);
    	ex.enableDebug(true);

    	ResultSet res  = ex.executeQuery();
    }

}
