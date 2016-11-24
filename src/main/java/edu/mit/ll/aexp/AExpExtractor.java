package edu.mit.ll.aexp;

import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that takes a KQL query and extracts the A-Expressions from it
 * @author pedro
 *
 */
public class AExpExtractor {

    public String lastResult(){
    	return this.lastResult;
    }
    private String lastResult = null;
    
    /**
     * Method to perform the address expression extraction.  Returns a list of the a-expressions
     * @param delimiter Delimiter that we want to find to replace
     * @param target String that we want analyzed
     * @param replacement String that we will put where delimiter was
     * @return List of the extracted a-expressions
     * @throws IllegalFormatException
     */
    public List<String> stringExtractor(String delimiter, String target, String replacement) throws IllegalFormatException {
        //List that will contain a-expressions
    	LinkedList<String> extractedStrings = new LinkedList<String>();
    	//Regular expression to find the delimiter we passed in
        Pattern pattern = Pattern.compile(delimiter);
        Matcher matcher = pattern.matcher(target);
        //Remove extra white space
        target.trim();
        //Find the amount of delimiters we have
        int ammount = 0;
        for(ammount = 0; matcher.find(); ++ammount);
        //Reset the index
        matcher = pattern.matcher(target);
        //Checks whether we have an event amount of delimiters or not.  If the amount
        //is not even, there is a missing delimiter
        if(ammount % 2 == 0 && ammount != 0) {
        	//Go to extract each a-expression
            for(int i = 0; i < ammount / 2; ++i) {
            	//See if we want to replace with some place holder and reset the index to replace successfully
                if(replacement != null) {
                    matcher = pattern.matcher(target);
                }
                //Find the location of the delimiters to replace
                matcher.find();
                int firstmatchstart = matcher.start();
                int firstmatchfinish = matcher.end();
                matcher.find();
                int var14 = matcher.end();
                int var13 = matcher.start();
                //Extract the strings
                extractedStrings.add(target.substring(firstmatchfinish, var13));
                //Insert the replacement in the target string
                if(replacement != null) {
                    target = target.substring(0, firstmatchstart - 1) + " " + replacement + target.substring(var14, target.length());
                }
            }
            //Add the target string entirely as a result
            extractedStrings.add(target);
            //Set the last result to be accessible
            this.lastResult=target;
            return extractedStrings;
        } else {
            throw new MissingFormatArgumentException("Missing escape character:" + delimiter);
        }
    }

}