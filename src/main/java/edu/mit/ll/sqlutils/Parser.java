package edu.mit.ll.sqlutils;

import java.util.IllegalFormatException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Parser() {
    }
    public String lastResult(){
    	return this.lastResult;
    }
    private String lastResult = null;
    public List<String> stringExtractor(String delimiter, String target, String replacement) throws IllegalFormatException {
        LinkedList extractedStrings = new LinkedList();
        Pattern pattern = Pattern.compile(delimiter);
        Matcher matcher = pattern.matcher(target);
        target.trim();

        int ammount;
        for(ammount = 0; matcher.find(); ++ammount) {
            ;
        }

        matcher = pattern.matcher(target);
        if(ammount % 2 == 0 && ammount != 0) {
            for(int i = 0; i < ammount / 2; ++i) {
                if(replacement != null) {
                    matcher = pattern.matcher(target);
                }

                matcher.find();
                int firstmatchstart = matcher.start();
                int firstmatchfinish = matcher.end();
                boolean secondmatchstart = false;
                boolean secondmatchfinish = false;
                matcher.find();
                int var14 = matcher.end();
                int var13 = matcher.start();
                extractedStrings.add(target.substring(firstmatchfinish, var13));
                if(replacement != null) {
                    target = target.substring(0, firstmatchstart - 1) + " " + replacement + target.substring(var14, target.length());
                }
            }
            

            extractedStrings.add(target);
            this.lastResult=target;
            return extractedStrings;
        } else {
            throw new MissingFormatArgumentException("Missing escape character:" + delimiter);
        }
    }

}