grammar aexp17;
//Simplified

options {
output=AST;
ASTLabelType=CommonTree;
}

tokens {
ALL='ALL';
AND='&';
OR= '|';
NOT='!';
}

@lexer::header{
package edu.mit.ll.antlr;
}

@parser::header{
package edu.mit.ll.antlr;
}

@members{
boolean debug = false;
public void enableDebug(boolean value){
this.debug = value;
}
public boolean caseInsensitive = false;
public void enableCaseInsensitive(boolean caseInsensitive) {
this.caseInsensitive = caseInsensitive;    
}

}
start
  :
  r_exp 
  {
  if(this.debug)
    System.out.println($r_exp.tree==null?"null":$r_exp.tree.toStringTree());
  }
  ;

r_exp 
  :
  period_exp ((AND^|OR^) period_exp)*
  |
  NOT r_exp ->^(NOT r_exp)
  ;

period_exp  
  : 
  star_exp  ('#'^ star_exp)*
  ;

star_exp
  :
  slash_exp ('*'^ slash_exp)*
  ;
slash_exp
  :
  atom2 ('/'^ atom2)+
  |
  atom2 ('?'^)+
  |
  atom ('.'^ durations)*
  ;
atom2 
  :
  set_of_dims ('.'^ durations)*
  | 
  dimSet ('.'^ durations)*
  ;

atom  
  :
  dims
  |
  tags
  |
  '(' r_exp* ')'
  {
  if(this.debug)
  System.out.println("Encountered rexp in parenthesis");
  }
  |
  '[' (dimSet|set_of_dimSets) ']'
  ;

dims  
  :
  ALL 
  |
  dim
  |
  set_of_dims
  ;

set_of_dims
  : 
  '{' dim '}' -> '{' dim '}'
  |
  '{' dim (',' dim)+ '}'  -> '{'^(','dim+)'}'
  ;
  
set_of_dimSets
  :
  '{' dimSet '}' -> '{' dimSet '}'
  |
  '{' dimSet (',' dimSet)+ '}'  -> '{'^(',' dimSet+)'}'
  ;
dim 
  :
  ID
  ;
tags  
  :
  '{' tag '}' -> '{' tag '}'
  |
  '{' tag (',' tag)+ '}' -> '{'^(',' tag+)'}'
  |
  tag
  ;

tag 
  :
  (tagScheme|'_') ':' ID
  ;

tagScheme
  :
  ID
  ;

dimSet  
  : 
  ALL
  |
  ID
  ;

durations
  :   
  '{' duration (';' duration)* '}' -> '{'^(';'duration+)'}'
  ;

duration:
  start_time ',' end_time
  ;
start_time
  : 
  INT -> INT
  ;
end_time
  : 
  INT -> INT 
  ;

INT : '0'..'9' ('0'..'9')*
  ;
ID  : ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    |   '/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}
    ;

/*
WS  :   ( ' '
        | '\t'
        | '\r'
        ) {$channel=HIDDEN;}
    ;
*/
WS  :   (' '|'\t')+ {skip();} ;

NEWLINE:'\r'? '\n' ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
