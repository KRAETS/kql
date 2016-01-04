// $ANTLR 3.5.2 /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g 2015-12-17 08:35:22

package edu.mit.ll.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class aexp17Lexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int T__29=29;
	public static final int T__30=30;
	public static final int T__31=31;
	public static final int T__32=32;
	public static final int ALL=4;
	public static final int AND=5;
	public static final int COMMENT=6;
	public static final int ESC_SEQ=7;
	public static final int HEX_DIGIT=8;
	public static final int ID=9;
	public static final int INT=10;
	public static final int NEWLINE=11;
	public static final int NOT=12;
	public static final int OCTAL_ESC=13;
	public static final int OR=14;
	public static final int STRING=15;
	public static final int UNICODE_ESC=16;
	public static final int WS=17;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public aexp17Lexer() {} 
	public aexp17Lexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public aexp17Lexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "/Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g"; }

	// $ANTLR start "ALL"
	public final void mALL() throws RecognitionException {
		try {
			int _type = ALL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:6:5: ( 'ALL' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:6:7: 'ALL'
			{
			match("ALL"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ALL"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:7:5: ( '&' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:7:7: '&'
			{
			match('&'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:8:5: ( '!' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:8:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:9:4: ( '|' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:9:6: '|'
			{
			match('|'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:10:7: ( '#' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:10:9: '#'
			{
			match('#'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:11:7: ( '(' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:11:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:12:7: ( ')' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:12:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:13:7: ( '*' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:13:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:14:7: ( ',' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:14:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:15:7: ( '.' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:15:9: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:16:7: ( '/' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:16:9: '/'
			{
			match('/'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "T__25"
	public final void mT__25() throws RecognitionException {
		try {
			int _type = T__25;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:17:7: ( ':' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:17:9: ':'
			{
			match(':'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__25"

	// $ANTLR start "T__26"
	public final void mT__26() throws RecognitionException {
		try {
			int _type = T__26;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:18:7: ( ';' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:18:9: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__26"

	// $ANTLR start "T__27"
	public final void mT__27() throws RecognitionException {
		try {
			int _type = T__27;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:19:7: ( '?' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:19:9: '?'
			{
			match('?'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__27"

	// $ANTLR start "T__28"
	public final void mT__28() throws RecognitionException {
		try {
			int _type = T__28;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:20:7: ( '[' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:20:9: '['
			{
			match('['); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__28"

	// $ANTLR start "T__29"
	public final void mT__29() throws RecognitionException {
		try {
			int _type = T__29;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:21:7: ( ']' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:21:9: ']'
			{
			match(']'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__29"

	// $ANTLR start "T__30"
	public final void mT__30() throws RecognitionException {
		try {
			int _type = T__30;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:22:7: ( '_' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:22:9: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__30"

	// $ANTLR start "T__31"
	public final void mT__31() throws RecognitionException {
		try {
			int _type = T__31;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:23:7: ( '{' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:23:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__31"

	// $ANTLR start "T__32"
	public final void mT__32() throws RecognitionException {
		try {
			int _type = T__32;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:24:7: ( '}' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:24:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__32"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:159:5: ( '0' .. '9' ( '0' .. '9' )* )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:159:7: '0' .. '9' ( '0' .. '9' )*
			{
			matchRange('0','9'); 
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:159:16: ( '0' .. '9' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:161:5: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:161:7: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:161:31: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:165:5: ( '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n' | '/*' ( options {greedy=false; } : . )* '*/' )
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( (LA6_0=='/') ) {
				int LA6_1 = input.LA(2);
				if ( (LA6_1=='/') ) {
					alt6=1;
				}
				else if ( (LA6_1=='*') ) {
					alt6=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 6, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 6, 0, input);
				throw nvae;
			}

			switch (alt6) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:165:9: '//' (~ ( '\\n' | '\\r' ) )* ( '\\r' )? '\\n'
					{
					match("//"); 

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:165:14: (~ ( '\\n' | '\\r' ) )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
							{
							if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
								input.consume();
							}
							else {
								MismatchedSetException mse = new MismatchedSetException(null,input);
								recover(mse);
								throw mse;
							}
							}
							break;

						default :
							break loop3;
						}
					}

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:165:28: ( '\\r' )?
					int alt4=2;
					int LA4_0 = input.LA(1);
					if ( (LA4_0=='\r') ) {
						alt4=1;
					}
					switch (alt4) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:165:28: '\\r'
							{
							match('\r'); 
							}
							break;

					}

					match('\n'); 
					_channel=HIDDEN;
					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:166:9: '/*' ( options {greedy=false; } : . )* '*/'
					{
					match("/*"); 

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:166:14: ( options {greedy=false; } : . )*
					loop5:
					while (true) {
						int alt5=2;
						int LA5_0 = input.LA(1);
						if ( (LA5_0=='*') ) {
							int LA5_1 = input.LA(2);
							if ( (LA5_1=='/') ) {
								alt5=2;
							}
							else if ( ((LA5_1 >= '\u0000' && LA5_1 <= '.')||(LA5_1 >= '0' && LA5_1 <= '\uFFFF')) ) {
								alt5=1;
							}

						}
						else if ( ((LA5_0 >= '\u0000' && LA5_0 <= ')')||(LA5_0 >= '+' && LA5_0 <= '\uFFFF')) ) {
							alt5=1;
						}

						switch (alt5) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:166:42: .
							{
							matchAny(); 
							}
							break;

						default :
							break loop5;
						}
					}

					match("*/"); 

					_channel=HIDDEN;
					}
					break;

			}
			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:176:5: ( ( ' ' | '\\t' )+ )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:176:9: ( ' ' | '\\t' )+
			{
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:176:9: ( ' ' | '\\t' )+
			int cnt7=0;
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0=='\t'||LA7_0==' ') ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt7 >= 1 ) break loop7;
					EarlyExitException eee = new EarlyExitException(7, input);
					throw eee;
				}
				cnt7++;
			}

			skip();
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:178:8: ( ( '\\r' )? '\\n' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:178:9: ( '\\r' )? '\\n'
			{
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:178:9: ( '\\r' )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0=='\r') ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:178:9: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "STRING"
	public final void mSTRING() throws RecognitionException {
		try {
			int _type = STRING;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:181:5: ( '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:181:8: '\"' ( ESC_SEQ |~ ( '\\\\' | '\"' ) )* '\"'
			{
			match('\"'); 
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:181:12: ( ESC_SEQ |~ ( '\\\\' | '\"' ) )*
			loop9:
			while (true) {
				int alt9=3;
				int LA9_0 = input.LA(1);
				if ( (LA9_0=='\\') ) {
					alt9=1;
				}
				else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '[')||(LA9_0 >= ']' && LA9_0 <= '\uFFFF')) ) {
					alt9=2;
				}

				switch (alt9) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:181:14: ESC_SEQ
					{
					mESC_SEQ(); 

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:181:24: ~ ( '\\\\' | '\"' )
					{
					if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '[')||(input.LA(1) >= ']' && input.LA(1) <= '\uFFFF') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop9;
				}
			}

			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING"

	// $ANTLR start "HEX_DIGIT"
	public final void mHEX_DIGIT() throws RecognitionException {
		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:186:11: ( ( '0' .. '9' | 'a' .. 'f' | 'A' .. 'F' ) )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'F')||(input.LA(1) >= 'a' && input.LA(1) <= 'f') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "HEX_DIGIT"

	// $ANTLR start "ESC_SEQ"
	public final void mESC_SEQ() throws RecognitionException {
		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:190:5: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' ) | UNICODE_ESC | OCTAL_ESC )
			int alt10=3;
			int LA10_0 = input.LA(1);
			if ( (LA10_0=='\\') ) {
				switch ( input.LA(2) ) {
				case '\"':
				case '\'':
				case '\\':
				case 'b':
				case 'f':
				case 'n':
				case 'r':
				case 't':
					{
					alt10=1;
					}
					break;
				case 'u':
					{
					alt10=2;
					}
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
					{
					alt10=3;
					}
					break;
				default:
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 10, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:190:9: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\\\"' | '\\'' | '\\\\' )
					{
					match('\\'); 
					if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:191:9: UNICODE_ESC
					{
					mUNICODE_ESC(); 

					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:192:9: OCTAL_ESC
					{
					mOCTAL_ESC(); 

					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ESC_SEQ"

	// $ANTLR start "OCTAL_ESC"
	public final void mOCTAL_ESC() throws RecognitionException {
		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:197:5: ( '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) ( '0' .. '7' ) | '\\\\' ( '0' .. '7' ) )
			int alt11=3;
			int LA11_0 = input.LA(1);
			if ( (LA11_0=='\\') ) {
				int LA11_1 = input.LA(2);
				if ( ((LA11_1 >= '0' && LA11_1 <= '3')) ) {
					int LA11_2 = input.LA(3);
					if ( ((LA11_2 >= '0' && LA11_2 <= '7')) ) {
						int LA11_4 = input.LA(4);
						if ( ((LA11_4 >= '0' && LA11_4 <= '7')) ) {
							alt11=1;
						}

						else {
							alt11=2;
						}

					}

					else {
						alt11=3;
					}

				}
				else if ( ((LA11_1 >= '4' && LA11_1 <= '7')) ) {
					int LA11_3 = input.LA(3);
					if ( ((LA11_3 >= '0' && LA11_3 <= '7')) ) {
						alt11=2;
					}

					else {
						alt11=3;
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 11, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:197:9: '\\\\' ( '0' .. '3' ) ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '3') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:198:9: '\\\\' ( '0' .. '7' ) ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:199:9: '\\\\' ( '0' .. '7' )
					{
					match('\\'); 
					if ( (input.LA(1) >= '0' && input.LA(1) <= '7') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

			}
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OCTAL_ESC"

	// $ANTLR start "UNICODE_ESC"
	public final void mUNICODE_ESC() throws RecognitionException {
		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:204:5: ( '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:204:9: '\\\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
			{
			match('\\'); 
			match('u'); 
			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			mHEX_DIGIT(); 

			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UNICODE_ESC"

	@Override
	public void mTokens() throws RecognitionException {
		// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:8: ( ALL | AND | NOT | OR | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | INT | ID | COMMENT | WS | NEWLINE | STRING )
		int alt12=25;
		switch ( input.LA(1) ) {
		case 'A':
			{
			int LA12_1 = input.LA(2);
			if ( (LA12_1=='L') ) {
				int LA12_25 = input.LA(3);
				if ( (LA12_25=='L') ) {
					int LA12_29 = input.LA(4);
					if ( ((LA12_29 >= '0' && LA12_29 <= '9')||(LA12_29 >= 'A' && LA12_29 <= 'Z')||LA12_29=='_'||(LA12_29 >= 'a' && LA12_29 <= 'z')) ) {
						alt12=21;
					}

					else {
						alt12=1;
					}

				}

				else {
					alt12=21;
				}

			}

			else {
				alt12=21;
			}

			}
			break;
		case '&':
			{
			alt12=2;
			}
			break;
		case '!':
			{
			alt12=3;
			}
			break;
		case '|':
			{
			alt12=4;
			}
			break;
		case '#':
			{
			alt12=5;
			}
			break;
		case '(':
			{
			alt12=6;
			}
			break;
		case ')':
			{
			alt12=7;
			}
			break;
		case '*':
			{
			alt12=8;
			}
			break;
		case ',':
			{
			alt12=9;
			}
			break;
		case '.':
			{
			alt12=10;
			}
			break;
		case '/':
			{
			int LA12_11 = input.LA(2);
			if ( (LA12_11=='*'||LA12_11=='/') ) {
				alt12=22;
			}

			else {
				alt12=11;
			}

			}
			break;
		case ':':
			{
			alt12=12;
			}
			break;
		case ';':
			{
			alt12=13;
			}
			break;
		case '?':
			{
			alt12=14;
			}
			break;
		case '[':
			{
			alt12=15;
			}
			break;
		case ']':
			{
			alt12=16;
			}
			break;
		case '_':
			{
			int LA12_17 = input.LA(2);
			if ( ((LA12_17 >= '0' && LA12_17 <= '9')||(LA12_17 >= 'A' && LA12_17 <= 'Z')||LA12_17=='_'||(LA12_17 >= 'a' && LA12_17 <= 'z')) ) {
				alt12=21;
			}

			else {
				alt12=17;
			}

			}
			break;
		case '{':
			{
			alt12=18;
			}
			break;
		case '}':
			{
			alt12=19;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
			{
			alt12=20;
			}
			break;
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt12=21;
			}
			break;
		case '\t':
		case ' ':
			{
			alt12=23;
			}
			break;
		case '\n':
		case '\r':
			{
			alt12=24;
			}
			break;
		case '\"':
			{
			alt12=25;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 12, 0, input);
			throw nvae;
		}
		switch (alt12) {
			case 1 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:10: ALL
				{
				mALL(); 

				}
				break;
			case 2 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:14: AND
				{
				mAND(); 

				}
				break;
			case 3 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:18: NOT
				{
				mNOT(); 

				}
				break;
			case 4 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:22: OR
				{
				mOR(); 

				}
				break;
			case 5 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:25: T__18
				{
				mT__18(); 

				}
				break;
			case 6 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:31: T__19
				{
				mT__19(); 

				}
				break;
			case 7 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:37: T__20
				{
				mT__20(); 

				}
				break;
			case 8 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:43: T__21
				{
				mT__21(); 

				}
				break;
			case 9 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:49: T__22
				{
				mT__22(); 

				}
				break;
			case 10 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:55: T__23
				{
				mT__23(); 

				}
				break;
			case 11 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:61: T__24
				{
				mT__24(); 

				}
				break;
			case 12 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:67: T__25
				{
				mT__25(); 

				}
				break;
			case 13 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:73: T__26
				{
				mT__26(); 

				}
				break;
			case 14 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:79: T__27
				{
				mT__27(); 

				}
				break;
			case 15 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:85: T__28
				{
				mT__28(); 

				}
				break;
			case 16 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:91: T__29
				{
				mT__29(); 

				}
				break;
			case 17 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:97: T__30
				{
				mT__30(); 

				}
				break;
			case 18 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:103: T__31
				{
				mT__31(); 

				}
				break;
			case 19 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:109: T__32
				{
				mT__32(); 

				}
				break;
			case 20 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:115: INT
				{
				mINT(); 

				}
				break;
			case 21 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:119: ID
				{
				mID(); 

				}
				break;
			case 22 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:122: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 23 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:130: WS
				{
				mWS(); 

				}
				break;
			case 24 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:133: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 25 :
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:1:141: STRING
				{
				mSTRING(); 

				}
				break;

		}
	}



}
