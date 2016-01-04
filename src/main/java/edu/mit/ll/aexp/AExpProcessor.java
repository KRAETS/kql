package edu.mit.ll.aexp;

import java.util.LinkedList;
import java.util.List;

import edu.mit.ll.antlr.*;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
public class AExpProcessor {

	private String folderlocation = "src/main/resources/jsonemail/";

	private List<Result> storedOperationResults = new LinkedList<>();

	private boolean debug = false;

	private boolean caseInsensitive;;

	public Result process(String input, boolean save) throws RecognitionException {
		//Stream in the input
		ANTLRStringStream in = new ANTLRStringStream(input);
		//Initialize the lexer
		aexp17Lexer lexer = new aexp17Lexer(in);
		//Tokenize the input
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		//Parse the tokens
		aexp17Parser parser = new aexp17Parser(tokens);
		parser.enableDebug(this.debug);
		aexp17Parser.start_return r = parser.start();
		//Generate the AST
		CommonTree t = (CommonTree)r.getTree();
		if(this.debug){
			System.out.println("Printing tree");
			System.out.println(t.toStringTree());
		}
		//Initialize the node streamer
		CommonTreeNodeStream nodes = new CommonTreeNodeStream(t);
		//Initialize the tree walker
		aexptree17 walker = new aexptree17(nodes);
		walker.enableCaseInsensitive(true);
		walker.setFolderLocation(folderlocation);
		walker.enableDebug(debug);
		if(this.debug)
			System.out.println("Interpreting Expression");
		//Walk the tree to get a result
		Result s = walker.start().r;
		//Save the result
		if(save){
			this.saveAExpResult(s);
		}
		return s;
	}

	public void saveAExpResult(Result op){
		this.storedOperationResults.add(op);
	}

	public List<Result> getStoredOperationResults() {
		return storedOperationResults;
	}

	public String getFolderlocation() {
		return folderlocation;
	}

	public void setFolderlocation(String folderlocation) {
		this.folderlocation = folderlocation;
	}

	public void enableDebug(boolean debug) {
		this.debug = debug;
	}

	public void enableCaseInsensitive(boolean caseInsensitive) {
		// TODO Auto-generated method stub
		this.caseInsensitive = caseInsensitive;
	}
}
