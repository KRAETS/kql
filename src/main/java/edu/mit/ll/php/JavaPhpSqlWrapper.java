//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package edu.mit.ll.php;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.concurrent.ExecutionException;

import javax.naming.CannotProceedException;

public class JavaPhpSqlWrapper {
	private String query;
	private String defaultScript = "plugins/sql/src/main/java/edu/mit/ll/php/sqlparser/examples/simplerexample.php";
	private String remoteScript = "http://10.211.55.3:8001/sqlparser/examples/simplerexample.php";
//	private String remoteScript2 = "http://localhost:8080/sqlparser/examples/simplerexample.php";

	public String execPHP(String scriptName, final String param) throws CannotProceedException {
		if(scriptName == null) {
			if(debug)
				System.out.println("No script specified, using default:" + this.defaultScript);
			//Add full path
			File dot = new File(".").getAbsoluteFile();
			String s = dot.getAbsolutePath();
			s=s.substring(0,s.length()-1);
			scriptName = s+this.defaultScript;
		}
		final String finalScriptName = scriptName;

//		StringBuilder output = null;
//
//		try {
//			output = new StringBuilder();
//			(new StringBuilder("php ")).append(scriptName).append(" ").append(param).toString();





//			Process p = Runtime.getRuntime().exec(new String[]{"php", scriptName, param});


			try {
//				String result = AccessController.doPrivileged(
//						new PrivilegedExceptionAction<String>() {
//							public String run() throws Exception {
								StringBuilder output2 = new StringBuilder();
//								Process p = Runtime.getRuntime().exec(new String[]{"php5", finalScriptName, param});
//								
//								StringBuilder result = new StringBuilder();
							      URL url = new URL(remoteScript+"?kqlq="+param);
							      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
							      
							      conn.setRequestMethod("GET");
							      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
							      String line;
							      while ((line = rd.readLine()) != null) {
							         output2.append(line);
							      }
							      rd.close();
//							      return result.toString();
								
//								Process p = Runtime.getRuntime().exec(finalScriptName);
//
//								BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
//								String err;
//								while((err = input.readLine()) != null) {
//									output2.append(err);
//								}
//								
//								input.close();
								
								
//								return output2.toString();
//							}
//						});
				return output2.toString();
			} catch (Exception e) {
				// e.getException() should be an instance of FileNotFoundException,
				// as only "checked" exceptions will be "wrapped" in a
				// PrivilegedActionException.
//				throw (Exception) e.getException();
				throw new CannotProceedException("En el php"+e.toString()+"Query:"+param);
			}




//		} catch (Exception var8) {
//			var8.printStackTrace();
//			throw new CannotProceedException(var8.toString());
//		}

//		return output.toString();
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
