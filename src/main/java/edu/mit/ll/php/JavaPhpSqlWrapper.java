//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mit.ll.php;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class JavaPhpSqlWrapper {
    private String query;
    private String defaultScript = "src/main/java/edu/mit/ll/php/sqlparser/examples/simplerexample.php";

    public String execPHP(String scriptName, String param) {
        if(scriptName == null) {
        	if(debug)
        		System.out.println("No script specified, using default:" + this.defaultScript);
        	//Add full path
        	File dot = new File(".").getAbsoluteFile();
        	String s = dot.getAbsolutePath();
        	s=s.substring(0,s.length()-1);
            scriptName = s+this.defaultScript;
        }

        StringBuilder output = null;

        try {
            output = new StringBuilder();
            (new StringBuilder("php ")).append(scriptName).append(" ").append(param).toString();
            Process p = Runtime.getRuntime().exec(new String[]{"php", scriptName, param});
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String err;
            while((err = input.readLine()) != null) {
                output.append(err);
            }

            input.close();
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        return output.toString();
    }

    public JavaPhpSqlWrapper(String query) {
        this.query = query;
    }

    public JavaPhpSqlWrapper() {
    }

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

	public void enableDebug(boolean debug) {
		// TODO Auto-generated method stub
		this.debug = debug;
	}
	private boolean debug = false;
}
