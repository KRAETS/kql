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
import org.antlr.runtime.RecognitionException;
import org.apache.log4j.Logger;
import org.junit.*;
import org.junit.rules.ExpectedException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import edu.mit.ll.aexp.AExpProcessor;
import edu.mit.ll.aexp.ProvenanceDataStructure;
import edu.mit.ll.aexp.Result;
import edu.mit.ll.aexp.ProvenanceDataStructure.TYPE;
import edu.mit.ll.php.JavaPhpSqlWrapper;
import edu.mit.ll.sqlutils.Parser;



public class ProvenanceDSTest {
	

    static String testName = "Test1";    
    static Logger log = Logger.getLogger(ProvenanceDSTest.class);


    
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @BeforeClass
    static public void fileSetUp() throws Exception {
    	
    }
    
    @Test
    public void test() {
    	ProvenanceDataStructure ds1 = new ProvenanceDataStructure();
    	ds1.setData("Hola", TYPE.DIMENSIONSET);
    	ProvenanceDataStructure ds2 = new ProvenanceDataStructure();
    	ds2.setData("Hola", TYPE.DIMENSION);
    	ProvenanceDataStructure ds21 = new ProvenanceDataStructure();
    	ds21.setData("Hola", TYPE.ATOM);
    	ds2.join(ds21);
    	ProvenanceDataStructure ds3 = new ProvenanceDataStructure();
    	ds3.setData("Hola", TYPE.DIMENSION);
    	ds1.join(ds2);
    	ds1.join(ds3);
    	System.out.println(ds1);

    }


}
