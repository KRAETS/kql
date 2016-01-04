package edu.mit.ll.test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
import edu.mit.ll.execution.QueryExecutor;
import edu.mit.ll.php.JavaPhpSqlWrapper;
import edu.mit.ll.sqlutils.Parser;


public class ApitTest5 {

    static String testName = "APITest2";    
    static Logger log = Logger.getLogger(Test1.class);

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void fileSetUp() throws Exception {
    	
    }
    
    @Test
    public void test() throws SQLException, RecognitionException, ParseException, IOException {
    	//messages.find({"$or":[{"subFolder":"sent"},{"subFolder":"sent_items"}]}).distinct("headers.From")
    	QueryExecutor ex = new QueryExecutor("select \\ALL*_:email_message|ALL*email_address\\ FROM \\ALL/{folder}/_:email_message\\ WHERE ( \\ALL*folder*_:email_message\\ = 'sent_items' OR \\ALL*folder*_:email_message\\= 'sent') AND ( \\ALL*email_address*_:sender\\='susan.scott@enron.com' )", 100);
    	ex.enableDebug(true);
    	ResultSet res  = ex.executeQuery();
    }
}
