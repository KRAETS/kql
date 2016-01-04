// $ANTLR 3.5.2 /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g 2015-12-17 08:35:21

package edu.mit.ll.antlr;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class aexp17Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALL", "AND", "COMMENT", "ESC_SEQ", 
		"HEX_DIGIT", "ID", "INT", "NEWLINE", "NOT", "OCTAL_ESC", "OR", "STRING", 
		"UNICODE_ESC", "WS", "'#'", "'('", "')'", "'*'", "','", "'.'", "'/'", 
		"':'", "';'", "'?'", "'['", "']'", "'_'", "'{'", "'}'"
	};
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public aexp17Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public aexp17Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return aexp17Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "/Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g"; }


	boolean debug = false;
	public void enableDebug(boolean value){
	this.debug = value;
	}
	public boolean caseInsensitive = false;
	public void enableCaseInsensitive(boolean caseInsensitive) {
	this.caseInsensitive = caseInsensitive;    
	}



	public static class start_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "start"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:35:1: start : r_exp ;
	public final aexp17Parser.start_return start() throws RecognitionException {
		aexp17Parser.start_return retval = new aexp17Parser.start_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope r_exp1 =null;


		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:36:3: ( r_exp )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:37:3: r_exp
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_r_exp_in_start76);
			r_exp1=r_exp();
			state._fsp--;

			adaptor.addChild(root_0, r_exp1.getTree());


			  if(this.debug)
			    System.out.println((r_exp1!=null?((CommonTree)r_exp1.getTree()):null)==null?"null":(r_exp1!=null?((CommonTree)r_exp1.getTree()):null).toStringTree());
			  
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start"


	public static class r_exp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "r_exp"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:44:1: r_exp : ( period_exp ( ( AND ^| OR ^) period_exp )* | NOT r_exp -> ^( NOT r_exp ) );
	public final aexp17Parser.r_exp_return r_exp() throws RecognitionException {
		aexp17Parser.r_exp_return retval = new aexp17Parser.r_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND3=null;
		Token OR4=null;
		Token NOT6=null;
		ParserRuleReturnScope period_exp2 =null;
		ParserRuleReturnScope period_exp5 =null;
		ParserRuleReturnScope r_exp7 =null;

		CommonTree AND3_tree=null;
		CommonTree OR4_tree=null;
		CommonTree NOT6_tree=null;
		RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
		RewriteRuleSubtreeStream stream_r_exp=new RewriteRuleSubtreeStream(adaptor,"rule r_exp");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:45:3: ( period_exp ( ( AND ^| OR ^) period_exp )* | NOT r_exp -> ^( NOT r_exp ) )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ALL||LA3_0==ID||LA3_0==19||LA3_0==28||(LA3_0 >= 30 && LA3_0 <= 31)) ) {
				alt3=1;
			}
			else if ( (LA3_0==NOT) ) {
				alt3=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:3: period_exp ( ( AND ^| OR ^) period_exp )*
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_period_exp_in_r_exp97);
					period_exp2=period_exp();
					state._fsp--;

					adaptor.addChild(root_0, period_exp2.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:14: ( ( AND ^| OR ^) period_exp )*
					loop2:
					while (true) {
						int alt2=2;
						int LA2_0 = input.LA(1);
						if ( (LA2_0==AND||LA2_0==OR) ) {
							alt2=1;
						}

						switch (alt2) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:15: ( AND ^| OR ^) period_exp
							{
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:15: ( AND ^| OR ^)
							int alt1=2;
							int LA1_0 = input.LA(1);
							if ( (LA1_0==AND) ) {
								alt1=1;
							}
							else if ( (LA1_0==OR) ) {
								alt1=2;
							}

							else {
								NoViableAltException nvae =
									new NoViableAltException("", 1, 0, input);
								throw nvae;
							}

							switch (alt1) {
								case 1 :
									// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:16: AND ^
									{
									AND3=(Token)match(input,AND,FOLLOW_AND_in_r_exp101); 
									AND3_tree = (CommonTree)adaptor.create(AND3);
									root_0 = (CommonTree)adaptor.becomeRoot(AND3_tree, root_0);

									}
									break;
								case 2 :
									// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:46:21: OR ^
									{
									OR4=(Token)match(input,OR,FOLLOW_OR_in_r_exp104); 
									OR4_tree = (CommonTree)adaptor.create(OR4);
									root_0 = (CommonTree)adaptor.becomeRoot(OR4_tree, root_0);

									}
									break;

							}

							pushFollow(FOLLOW_period_exp_in_r_exp108);
							period_exp5=period_exp();
							state._fsp--;

							adaptor.addChild(root_0, period_exp5.getTree());

							}
							break;

						default :
							break loop2;
						}
					}

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:48:3: NOT r_exp
					{
					NOT6=(Token)match(input,NOT,FOLLOW_NOT_in_r_exp118);  
					stream_NOT.add(NOT6);

					pushFollow(FOLLOW_r_exp_in_r_exp120);
					r_exp7=r_exp();
					state._fsp--;

					stream_r_exp.add(r_exp7.getTree());
					// AST REWRITE
					// elements: r_exp, NOT
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 48:13: -> ^( NOT r_exp )
					{
						// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:48:15: ^( NOT r_exp )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);
						adaptor.addChild(root_1, stream_r_exp.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "r_exp"


	public static class period_exp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "period_exp"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:51:1: period_exp : star_exp ( '#' ^ star_exp )* ;
	public final aexp17Parser.period_exp_return period_exp() throws RecognitionException {
		aexp17Parser.period_exp_return retval = new aexp17Parser.period_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal9=null;
		ParserRuleReturnScope star_exp8 =null;
		ParserRuleReturnScope star_exp10 =null;

		CommonTree char_literal9_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:52:3: ( star_exp ( '#' ^ star_exp )* )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:53:3: star_exp ( '#' ^ star_exp )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_star_exp_in_period_exp145);
			star_exp8=star_exp();
			state._fsp--;

			adaptor.addChild(root_0, star_exp8.getTree());

			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:53:13: ( '#' ^ star_exp )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==18) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:53:14: '#' ^ star_exp
					{
					char_literal9=(Token)match(input,18,FOLLOW_18_in_period_exp149); 
					char_literal9_tree = (CommonTree)adaptor.create(char_literal9);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal9_tree, root_0);

					pushFollow(FOLLOW_star_exp_in_period_exp152);
					star_exp10=star_exp();
					state._fsp--;

					adaptor.addChild(root_0, star_exp10.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "period_exp"


	public static class star_exp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "star_exp"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:56:1: star_exp : slash_exp ( '*' ^ slash_exp )* ;
	public final aexp17Parser.star_exp_return star_exp() throws RecognitionException {
		aexp17Parser.star_exp_return retval = new aexp17Parser.star_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal12=null;
		ParserRuleReturnScope slash_exp11 =null;
		ParserRuleReturnScope slash_exp13 =null;

		CommonTree char_literal12_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:57:3: ( slash_exp ( '*' ^ slash_exp )* )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:58:3: slash_exp ( '*' ^ slash_exp )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_slash_exp_in_star_exp169);
			slash_exp11=slash_exp();
			state._fsp--;

			adaptor.addChild(root_0, slash_exp11.getTree());

			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:58:13: ( '*' ^ slash_exp )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==21) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:58:14: '*' ^ slash_exp
					{
					char_literal12=(Token)match(input,21,FOLLOW_21_in_star_exp172); 
					char_literal12_tree = (CommonTree)adaptor.create(char_literal12);
					root_0 = (CommonTree)adaptor.becomeRoot(char_literal12_tree, root_0);

					pushFollow(FOLLOW_slash_exp_in_star_exp175);
					slash_exp13=slash_exp();
					state._fsp--;

					adaptor.addChild(root_0, slash_exp13.getTree());

					}
					break;

				default :
					break loop5;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "star_exp"


	public static class slash_exp_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "slash_exp"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:60:1: slash_exp : ( atom2 ( '/' ^ atom2 )+ | atom2 ( '?' ^)+ | atom ( '.' ^ durations )* );
	public final aexp17Parser.slash_exp_return slash_exp() throws RecognitionException {
		aexp17Parser.slash_exp_return retval = new aexp17Parser.slash_exp_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal15=null;
		Token char_literal18=null;
		Token char_literal20=null;
		ParserRuleReturnScope atom214 =null;
		ParserRuleReturnScope atom216 =null;
		ParserRuleReturnScope atom217 =null;
		ParserRuleReturnScope atom19 =null;
		ParserRuleReturnScope durations21 =null;

		CommonTree char_literal15_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree char_literal20_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:61:3: ( atom2 ( '/' ^ atom2 )+ | atom2 ( '?' ^)+ | atom ( '.' ^ durations )* )
			int alt9=3;
			alt9 = dfa9.predict(input);
			switch (alt9) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:62:3: atom2 ( '/' ^ atom2 )+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom2_in_slash_exp191);
					atom214=atom2();
					state._fsp--;

					adaptor.addChild(root_0, atom214.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:62:9: ( '/' ^ atom2 )+
					int cnt6=0;
					loop6:
					while (true) {
						int alt6=2;
						int LA6_0 = input.LA(1);
						if ( (LA6_0==24) ) {
							alt6=1;
						}

						switch (alt6) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:62:10: '/' ^ atom2
							{
							char_literal15=(Token)match(input,24,FOLLOW_24_in_slash_exp194); 
							char_literal15_tree = (CommonTree)adaptor.create(char_literal15);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal15_tree, root_0);

							pushFollow(FOLLOW_atom2_in_slash_exp197);
							atom216=atom2();
							state._fsp--;

							adaptor.addChild(root_0, atom216.getTree());

							}
							break;

						default :
							if ( cnt6 >= 1 ) break loop6;
							EarlyExitException eee = new EarlyExitException(6, input);
							throw eee;
						}
						cnt6++;
					}

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:64:3: atom2 ( '?' ^)+
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom2_in_slash_exp207);
					atom217=atom2();
					state._fsp--;

					adaptor.addChild(root_0, atom217.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:64:9: ( '?' ^)+
					int cnt7=0;
					loop7:
					while (true) {
						int alt7=2;
						int LA7_0 = input.LA(1);
						if ( (LA7_0==27) ) {
							alt7=1;
						}

						switch (alt7) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:64:10: '?' ^
							{
							char_literal18=(Token)match(input,27,FOLLOW_27_in_slash_exp210); 
							char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal18_tree, root_0);

							}
							break;

						default :
							if ( cnt7 >= 1 ) break loop7;
							EarlyExitException eee = new EarlyExitException(7, input);
							throw eee;
						}
						cnt7++;
					}

					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:66:3: atom ( '.' ^ durations )*
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_atom_in_slash_exp221);
					atom19=atom();
					state._fsp--;

					adaptor.addChild(root_0, atom19.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:66:8: ( '.' ^ durations )*
					loop8:
					while (true) {
						int alt8=2;
						int LA8_0 = input.LA(1);
						if ( (LA8_0==23) ) {
							alt8=1;
						}

						switch (alt8) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:66:9: '.' ^ durations
							{
							char_literal20=(Token)match(input,23,FOLLOW_23_in_slash_exp224); 
							char_literal20_tree = (CommonTree)adaptor.create(char_literal20);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal20_tree, root_0);

							pushFollow(FOLLOW_durations_in_slash_exp227);
							durations21=durations();
							state._fsp--;

							adaptor.addChild(root_0, durations21.getTree());

							}
							break;

						default :
							break loop8;
						}
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "slash_exp"


	public static class atom2_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom2"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:68:1: atom2 : ( set_of_dims ( '.' ^ durations )* | dimSet ( '.' ^ durations )* );
	public final aexp17Parser.atom2_return atom2() throws RecognitionException {
		aexp17Parser.atom2_return retval = new aexp17Parser.atom2_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal23=null;
		Token char_literal26=null;
		ParserRuleReturnScope set_of_dims22 =null;
		ParserRuleReturnScope durations24 =null;
		ParserRuleReturnScope dimSet25 =null;
		ParserRuleReturnScope durations27 =null;

		CommonTree char_literal23_tree=null;
		CommonTree char_literal26_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:69:3: ( set_of_dims ( '.' ^ durations )* | dimSet ( '.' ^ durations )* )
			int alt12=2;
			int LA12_0 = input.LA(1);
			if ( (LA12_0==31) ) {
				alt12=1;
			}
			else if ( (LA12_0==ALL||LA12_0==ID) ) {
				alt12=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 12, 0, input);
				throw nvae;
			}

			switch (alt12) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:70:3: set_of_dims ( '.' ^ durations )*
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_of_dims_in_atom2244);
					set_of_dims22=set_of_dims();
					state._fsp--;

					adaptor.addChild(root_0, set_of_dims22.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:70:15: ( '.' ^ durations )*
					loop10:
					while (true) {
						int alt10=2;
						int LA10_0 = input.LA(1);
						if ( (LA10_0==23) ) {
							alt10=1;
						}

						switch (alt10) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:70:16: '.' ^ durations
							{
							char_literal23=(Token)match(input,23,FOLLOW_23_in_atom2247); 
							char_literal23_tree = (CommonTree)adaptor.create(char_literal23);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal23_tree, root_0);

							pushFollow(FOLLOW_durations_in_atom2250);
							durations24=durations();
							state._fsp--;

							adaptor.addChild(root_0, durations24.getTree());

							}
							break;

						default :
							break loop10;
						}
					}

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:72:3: dimSet ( '.' ^ durations )*
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dimSet_in_atom2261);
					dimSet25=dimSet();
					state._fsp--;

					adaptor.addChild(root_0, dimSet25.getTree());

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:72:10: ( '.' ^ durations )*
					loop11:
					while (true) {
						int alt11=2;
						int LA11_0 = input.LA(1);
						if ( (LA11_0==23) ) {
							alt11=1;
						}

						switch (alt11) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:72:11: '.' ^ durations
							{
							char_literal26=(Token)match(input,23,FOLLOW_23_in_atom2264); 
							char_literal26_tree = (CommonTree)adaptor.create(char_literal26);
							root_0 = (CommonTree)adaptor.becomeRoot(char_literal26_tree, root_0);

							pushFollow(FOLLOW_durations_in_atom2267);
							durations27=durations();
							state._fsp--;

							adaptor.addChild(root_0, durations27.getTree());

							}
							break;

						default :
							break loop11;
						}
					}

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom2"


	public static class atom_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "atom"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:75:1: atom : ( dims | tags | '(' ( r_exp )* ')' | '[' ( dimSet | set_of_dimSets ) ']' );
	public final aexp17Parser.atom_return atom() throws RecognitionException {
		aexp17Parser.atom_return retval = new aexp17Parser.atom_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal30=null;
		Token char_literal32=null;
		Token char_literal33=null;
		Token char_literal36=null;
		ParserRuleReturnScope dims28 =null;
		ParserRuleReturnScope tags29 =null;
		ParserRuleReturnScope r_exp31 =null;
		ParserRuleReturnScope dimSet34 =null;
		ParserRuleReturnScope set_of_dimSets35 =null;

		CommonTree char_literal30_tree=null;
		CommonTree char_literal32_tree=null;
		CommonTree char_literal33_tree=null;
		CommonTree char_literal36_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:76:3: ( dims | tags | '(' ( r_exp )* ')' | '[' ( dimSet | set_of_dimSets ) ']' )
			int alt15=4;
			switch ( input.LA(1) ) {
			case ALL:
				{
				alt15=1;
				}
				break;
			case ID:
				{
				int LA15_2 = input.LA(2);
				if ( (LA15_2==EOF||(LA15_2 >= ALL && LA15_2 <= AND)||LA15_2==ID||LA15_2==NOT||LA15_2==OR||(LA15_2 >= 18 && LA15_2 <= 21)||LA15_2==23||LA15_2==28||(LA15_2 >= 30 && LA15_2 <= 31)) ) {
					alt15=1;
				}
				else if ( (LA15_2==25) ) {
					alt15=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 31:
				{
				int LA15_3 = input.LA(2);
				if ( (LA15_3==ID) ) {
					int LA15_7 = input.LA(3);
					if ( (LA15_7==22||LA15_7==32) ) {
						alt15=1;
					}
					else if ( (LA15_7==25) ) {
						alt15=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 15, 7, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA15_3==30) ) {
					alt15=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 15, 3, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case 30:
				{
				alt15=2;
				}
				break;
			case 19:
				{
				alt15=3;
				}
				break;
			case 28:
				{
				alt15=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}
			switch (alt15) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:77:3: dims
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dims_in_atom286);
					dims28=dims();
					state._fsp--;

					adaptor.addChild(root_0, dims28.getTree());

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:79:3: tags
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_tags_in_atom294);
					tags29=tags();
					state._fsp--;

					adaptor.addChild(root_0, tags29.getTree());

					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:81:3: '(' ( r_exp )* ')'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal30=(Token)match(input,19,FOLLOW_19_in_atom302); 
					char_literal30_tree = (CommonTree)adaptor.create(char_literal30);
					adaptor.addChild(root_0, char_literal30_tree);

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:81:7: ( r_exp )*
					loop13:
					while (true) {
						int alt13=2;
						int LA13_0 = input.LA(1);
						if ( (LA13_0==ALL||LA13_0==ID||LA13_0==NOT||LA13_0==19||LA13_0==28||(LA13_0 >= 30 && LA13_0 <= 31)) ) {
							alt13=1;
						}

						switch (alt13) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:81:7: r_exp
							{
							pushFollow(FOLLOW_r_exp_in_atom304);
							r_exp31=r_exp();
							state._fsp--;

							adaptor.addChild(root_0, r_exp31.getTree());

							}
							break;

						default :
							break loop13;
						}
					}

					char_literal32=(Token)match(input,20,FOLLOW_20_in_atom307); 
					char_literal32_tree = (CommonTree)adaptor.create(char_literal32);
					adaptor.addChild(root_0, char_literal32_tree);


					  if(this.debug)
					  System.out.println("Encountered rexp in parenthesis");
					  
					}
					break;
				case 4 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:87:3: '[' ( dimSet | set_of_dimSets ) ']'
					{
					root_0 = (CommonTree)adaptor.nil();


					char_literal33=(Token)match(input,28,FOLLOW_28_in_atom319); 
					char_literal33_tree = (CommonTree)adaptor.create(char_literal33);
					adaptor.addChild(root_0, char_literal33_tree);

					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:87:7: ( dimSet | set_of_dimSets )
					int alt14=2;
					int LA14_0 = input.LA(1);
					if ( (LA14_0==ALL||LA14_0==ID) ) {
						alt14=1;
					}
					else if ( (LA14_0==31) ) {
						alt14=2;
					}

					else {
						NoViableAltException nvae =
							new NoViableAltException("", 14, 0, input);
						throw nvae;
					}

					switch (alt14) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:87:8: dimSet
							{
							pushFollow(FOLLOW_dimSet_in_atom322);
							dimSet34=dimSet();
							state._fsp--;

							adaptor.addChild(root_0, dimSet34.getTree());

							}
							break;
						case 2 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:87:15: set_of_dimSets
							{
							pushFollow(FOLLOW_set_of_dimSets_in_atom324);
							set_of_dimSets35=set_of_dimSets();
							state._fsp--;

							adaptor.addChild(root_0, set_of_dimSets35.getTree());

							}
							break;

					}

					char_literal36=(Token)match(input,29,FOLLOW_29_in_atom327); 
					char_literal36_tree = (CommonTree)adaptor.create(char_literal36);
					adaptor.addChild(root_0, char_literal36_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "atom"


	public static class dims_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dims"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:90:1: dims : ( ALL | dim | set_of_dims );
	public final aexp17Parser.dims_return dims() throws RecognitionException {
		aexp17Parser.dims_return retval = new aexp17Parser.dims_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ALL37=null;
		ParserRuleReturnScope dim38 =null;
		ParserRuleReturnScope set_of_dims39 =null;

		CommonTree ALL37_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:91:3: ( ALL | dim | set_of_dims )
			int alt16=3;
			switch ( input.LA(1) ) {
			case ALL:
				{
				alt16=1;
				}
				break;
			case ID:
				{
				alt16=2;
				}
				break;
			case 31:
				{
				alt16=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 16, 0, input);
				throw nvae;
			}
			switch (alt16) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:92:3: ALL
					{
					root_0 = (CommonTree)adaptor.nil();


					ALL37=(Token)match(input,ALL,FOLLOW_ALL_in_dims344); 
					ALL37_tree = (CommonTree)adaptor.create(ALL37);
					adaptor.addChild(root_0, ALL37_tree);

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:94:3: dim
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dim_in_dims353);
					dim38=dim();
					state._fsp--;

					adaptor.addChild(root_0, dim38.getTree());

					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:96:3: set_of_dims
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_set_of_dims_in_dims361);
					set_of_dims39=set_of_dims();
					state._fsp--;

					adaptor.addChild(root_0, set_of_dims39.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dims"


	public static class set_of_dims_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_of_dims"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:99:1: set_of_dims : ( '{' dim '}' -> '{' dim '}' | '{' dim ( ',' dim )+ '}' -> '{' ^( ',' ( dim )+ ) '}' );
	public final aexp17Parser.set_of_dims_return set_of_dims() throws RecognitionException {
		aexp17Parser.set_of_dims_return retval = new aexp17Parser.set_of_dims_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal40=null;
		Token char_literal42=null;
		Token char_literal43=null;
		Token char_literal45=null;
		Token char_literal47=null;
		ParserRuleReturnScope dim41 =null;
		ParserRuleReturnScope dim44 =null;
		ParserRuleReturnScope dim46 =null;

		CommonTree char_literal40_tree=null;
		CommonTree char_literal42_tree=null;
		CommonTree char_literal43_tree=null;
		CommonTree char_literal45_tree=null;
		CommonTree char_literal47_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleSubtreeStream stream_dim=new RewriteRuleSubtreeStream(adaptor,"rule dim");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:100:3: ( '{' dim '}' -> '{' dim '}' | '{' dim ( ',' dim )+ '}' -> '{' ^( ',' ( dim )+ ) '}' )
			int alt18=2;
			int LA18_0 = input.LA(1);
			if ( (LA18_0==31) ) {
				int LA18_1 = input.LA(2);
				if ( (LA18_1==ID) ) {
					int LA18_2 = input.LA(3);
					if ( (LA18_2==32) ) {
						alt18=1;
					}
					else if ( (LA18_2==22) ) {
						alt18=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 18, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 18, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 18, 0, input);
				throw nvae;
			}

			switch (alt18) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:101:3: '{' dim '}'
					{
					char_literal40=(Token)match(input,31,FOLLOW_31_in_set_of_dims377);  
					stream_31.add(char_literal40);

					pushFollow(FOLLOW_dim_in_set_of_dims379);
					dim41=dim();
					state._fsp--;

					stream_dim.add(dim41.getTree());
					char_literal42=(Token)match(input,32,FOLLOW_32_in_set_of_dims381);  
					stream_32.add(char_literal42);

					// AST REWRITE
					// elements: 31, dim, 32
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 101:15: -> '{' dim '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						adaptor.addChild(root_0, stream_dim.nextTree());
						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:103:3: '{' dim ( ',' dim )+ '}'
					{
					char_literal43=(Token)match(input,31,FOLLOW_31_in_set_of_dims397);  
					stream_31.add(char_literal43);

					pushFollow(FOLLOW_dim_in_set_of_dims399);
					dim44=dim();
					state._fsp--;

					stream_dim.add(dim44.getTree());
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:103:11: ( ',' dim )+
					int cnt17=0;
					loop17:
					while (true) {
						int alt17=2;
						int LA17_0 = input.LA(1);
						if ( (LA17_0==22) ) {
							alt17=1;
						}

						switch (alt17) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:103:12: ',' dim
							{
							char_literal45=(Token)match(input,22,FOLLOW_22_in_set_of_dims402);  
							stream_22.add(char_literal45);

							pushFollow(FOLLOW_dim_in_set_of_dims404);
							dim46=dim();
							state._fsp--;

							stream_dim.add(dim46.getTree());
							}
							break;

						default :
							if ( cnt17 >= 1 ) break loop17;
							EarlyExitException eee = new EarlyExitException(17, input);
							throw eee;
						}
						cnt17++;
					}

					char_literal47=(Token)match(input,32,FOLLOW_32_in_set_of_dims408);  
					stream_32.add(char_literal47);

					// AST REWRITE
					// elements: dim, 32, 22, 31
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 103:27: -> '{' ^( ',' ( dim )+ ) '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:103:33: ^( ',' ( dim )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_22.nextNode(), root_1);
						if ( !(stream_dim.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_dim.hasNext() ) {
							adaptor.addChild(root_1, stream_dim.nextTree());
						}
						stream_dim.reset();

						adaptor.addChild(root_0, root_1);
						}

						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "set_of_dims"


	public static class set_of_dimSets_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "set_of_dimSets"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:106:1: set_of_dimSets : ( '{' dimSet '}' -> '{' dimSet '}' | '{' dimSet ( ',' dimSet )+ '}' -> '{' ^( ',' ( dimSet )+ ) '}' );
	public final aexp17Parser.set_of_dimSets_return set_of_dimSets() throws RecognitionException {
		aexp17Parser.set_of_dimSets_return retval = new aexp17Parser.set_of_dimSets_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal48=null;
		Token char_literal50=null;
		Token char_literal51=null;
		Token char_literal53=null;
		Token char_literal55=null;
		ParserRuleReturnScope dimSet49 =null;
		ParserRuleReturnScope dimSet52 =null;
		ParserRuleReturnScope dimSet54 =null;

		CommonTree char_literal48_tree=null;
		CommonTree char_literal50_tree=null;
		CommonTree char_literal51_tree=null;
		CommonTree char_literal53_tree=null;
		CommonTree char_literal55_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleSubtreeStream stream_dimSet=new RewriteRuleSubtreeStream(adaptor,"rule dimSet");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:107:3: ( '{' dimSet '}' -> '{' dimSet '}' | '{' dimSet ( ',' dimSet )+ '}' -> '{' ^( ',' ( dimSet )+ ) '}' )
			int alt20=2;
			int LA20_0 = input.LA(1);
			if ( (LA20_0==31) ) {
				int LA20_1 = input.LA(2);
				if ( (LA20_1==ALL||LA20_1==ID) ) {
					int LA20_2 = input.LA(3);
					if ( (LA20_2==32) ) {
						alt20=1;
					}
					else if ( (LA20_2==22) ) {
						alt20=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 20, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 20, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 20, 0, input);
				throw nvae;
			}

			switch (alt20) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:108:3: '{' dimSet '}'
					{
					char_literal48=(Token)match(input,31,FOLLOW_31_in_set_of_dimSets436);  
					stream_31.add(char_literal48);

					pushFollow(FOLLOW_dimSet_in_set_of_dimSets438);
					dimSet49=dimSet();
					state._fsp--;

					stream_dimSet.add(dimSet49.getTree());
					char_literal50=(Token)match(input,32,FOLLOW_32_in_set_of_dimSets440);  
					stream_32.add(char_literal50);

					// AST REWRITE
					// elements: 31, 32, dimSet
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 108:18: -> '{' dimSet '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						adaptor.addChild(root_0, stream_dimSet.nextTree());
						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:110:3: '{' dimSet ( ',' dimSet )+ '}'
					{
					char_literal51=(Token)match(input,31,FOLLOW_31_in_set_of_dimSets456);  
					stream_31.add(char_literal51);

					pushFollow(FOLLOW_dimSet_in_set_of_dimSets458);
					dimSet52=dimSet();
					state._fsp--;

					stream_dimSet.add(dimSet52.getTree());
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:110:14: ( ',' dimSet )+
					int cnt19=0;
					loop19:
					while (true) {
						int alt19=2;
						int LA19_0 = input.LA(1);
						if ( (LA19_0==22) ) {
							alt19=1;
						}

						switch (alt19) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:110:15: ',' dimSet
							{
							char_literal53=(Token)match(input,22,FOLLOW_22_in_set_of_dimSets461);  
							stream_22.add(char_literal53);

							pushFollow(FOLLOW_dimSet_in_set_of_dimSets463);
							dimSet54=dimSet();
							state._fsp--;

							stream_dimSet.add(dimSet54.getTree());
							}
							break;

						default :
							if ( cnt19 >= 1 ) break loop19;
							EarlyExitException eee = new EarlyExitException(19, input);
							throw eee;
						}
						cnt19++;
					}

					char_literal55=(Token)match(input,32,FOLLOW_32_in_set_of_dimSets467);  
					stream_32.add(char_literal55);

					// AST REWRITE
					// elements: 32, dimSet, 22, 31
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 110:33: -> '{' ^( ',' ( dimSet )+ ) '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:110:39: ^( ',' ( dimSet )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_22.nextNode(), root_1);
						if ( !(stream_dimSet.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_dimSet.hasNext() ) {
							adaptor.addChild(root_1, stream_dimSet.nextTree());
						}
						stream_dimSet.reset();

						adaptor.addChild(root_0, root_1);
						}

						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "set_of_dimSets"


	public static class dim_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dim"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:112:1: dim : ID ;
	public final aexp17Parser.dim_return dim() throws RecognitionException {
		aexp17Parser.dim_return retval = new aexp17Parser.dim_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID56=null;

		CommonTree ID56_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:113:3: ( ID )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:114:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID56=(Token)match(input,ID,FOLLOW_ID_in_dim494); 
			ID56_tree = (CommonTree)adaptor.create(ID56);
			adaptor.addChild(root_0, ID56_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dim"


	public static class tags_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tags"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:116:1: tags : ( '{' tag '}' -> '{' tag '}' | '{' tag ( ',' tag )+ '}' -> '{' ^( ',' ( tag )+ ) '}' | tag );
	public final aexp17Parser.tags_return tags() throws RecognitionException {
		aexp17Parser.tags_return retval = new aexp17Parser.tags_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal57=null;
		Token char_literal59=null;
		Token char_literal60=null;
		Token char_literal62=null;
		Token char_literal64=null;
		ParserRuleReturnScope tag58 =null;
		ParserRuleReturnScope tag61 =null;
		ParserRuleReturnScope tag63 =null;
		ParserRuleReturnScope tag65 =null;

		CommonTree char_literal57_tree=null;
		CommonTree char_literal59_tree=null;
		CommonTree char_literal60_tree=null;
		CommonTree char_literal62_tree=null;
		CommonTree char_literal64_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_22=new RewriteRuleTokenStream(adaptor,"token 22");
		RewriteRuleSubtreeStream stream_tag=new RewriteRuleSubtreeStream(adaptor,"rule tag");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:117:3: ( '{' tag '}' -> '{' tag '}' | '{' tag ( ',' tag )+ '}' -> '{' ^( ',' ( tag )+ ) '}' | tag )
			int alt22=3;
			int LA22_0 = input.LA(1);
			if ( (LA22_0==31) ) {
				int LA22_1 = input.LA(2);
				if ( (LA22_1==ID) ) {
					int LA22_3 = input.LA(3);
					if ( (LA22_3==25) ) {
						int LA22_5 = input.LA(4);
						if ( (LA22_5==ID) ) {
							int LA22_6 = input.LA(5);
							if ( (LA22_6==32) ) {
								alt22=1;
							}
							else if ( (LA22_6==22) ) {
								alt22=2;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 22, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 22, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}
				else if ( (LA22_1==30) ) {
					int LA22_4 = input.LA(3);
					if ( (LA22_4==25) ) {
						int LA22_5 = input.LA(4);
						if ( (LA22_5==ID) ) {
							int LA22_6 = input.LA(5);
							if ( (LA22_6==32) ) {
								alt22=1;
							}
							else if ( (LA22_6==22) ) {
								alt22=2;
							}

							else {
								int nvaeMark = input.mark();
								try {
									for (int nvaeConsume = 0; nvaeConsume < 5 - 1; nvaeConsume++) {
										input.consume();
									}
									NoViableAltException nvae =
										new NoViableAltException("", 22, 6, input);
									throw nvae;
								} finally {
									input.rewind(nvaeMark);
								}
							}

						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 22, 5, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 22, 4, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 22, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA22_0==ID||LA22_0==30) ) {
				alt22=3;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 22, 0, input);
				throw nvae;
			}

			switch (alt22) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:118:3: '{' tag '}'
					{
					char_literal57=(Token)match(input,31,FOLLOW_31_in_tags510);  
					stream_31.add(char_literal57);

					pushFollow(FOLLOW_tag_in_tags512);
					tag58=tag();
					state._fsp--;

					stream_tag.add(tag58.getTree());
					char_literal59=(Token)match(input,32,FOLLOW_32_in_tags514);  
					stream_32.add(char_literal59);

					// AST REWRITE
					// elements: 31, 32, tag
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 118:15: -> '{' tag '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						adaptor.addChild(root_0, stream_tag.nextTree());
						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:120:3: '{' tag ( ',' tag )+ '}'
					{
					char_literal60=(Token)match(input,31,FOLLOW_31_in_tags530);  
					stream_31.add(char_literal60);

					pushFollow(FOLLOW_tag_in_tags532);
					tag61=tag();
					state._fsp--;

					stream_tag.add(tag61.getTree());
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:120:11: ( ',' tag )+
					int cnt21=0;
					loop21:
					while (true) {
						int alt21=2;
						int LA21_0 = input.LA(1);
						if ( (LA21_0==22) ) {
							alt21=1;
						}

						switch (alt21) {
						case 1 :
							// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:120:12: ',' tag
							{
							char_literal62=(Token)match(input,22,FOLLOW_22_in_tags535);  
							stream_22.add(char_literal62);

							pushFollow(FOLLOW_tag_in_tags537);
							tag63=tag();
							state._fsp--;

							stream_tag.add(tag63.getTree());
							}
							break;

						default :
							if ( cnt21 >= 1 ) break loop21;
							EarlyExitException eee = new EarlyExitException(21, input);
							throw eee;
						}
						cnt21++;
					}

					char_literal64=(Token)match(input,32,FOLLOW_32_in_tags541);  
					stream_32.add(char_literal64);

					// AST REWRITE
					// elements: 31, 32, 22, tag
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 120:26: -> '{' ^( ',' ( tag )+ ) '}'
					{
						adaptor.addChild(root_0, stream_31.nextNode());
						// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:120:32: ^( ',' ( tag )+ )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						root_1 = (CommonTree)adaptor.becomeRoot(stream_22.nextNode(), root_1);
						if ( !(stream_tag.hasNext()) ) {
							throw new RewriteEarlyExitException();
						}
						while ( stream_tag.hasNext() ) {
							adaptor.addChild(root_1, stream_tag.nextTree());
						}
						stream_tag.reset();

						adaptor.addChild(root_0, root_1);
						}

						adaptor.addChild(root_0, stream_32.nextNode());
					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:122:3: tag
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_tag_in_tags560);
					tag65=tag();
					state._fsp--;

					adaptor.addChild(root_0, tag65.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tags"


	public static class tag_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tag"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:125:1: tag : ( tagScheme | '_' ) ':' ID ;
	public final aexp17Parser.tag_return tag() throws RecognitionException {
		aexp17Parser.tag_return retval = new aexp17Parser.tag_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal67=null;
		Token char_literal68=null;
		Token ID69=null;
		ParserRuleReturnScope tagScheme66 =null;

		CommonTree char_literal67_tree=null;
		CommonTree char_literal68_tree=null;
		CommonTree ID69_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:126:3: ( ( tagScheme | '_' ) ':' ID )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:127:3: ( tagScheme | '_' ) ':' ID
			{
			root_0 = (CommonTree)adaptor.nil();


			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:127:3: ( tagScheme | '_' )
			int alt23=2;
			int LA23_0 = input.LA(1);
			if ( (LA23_0==ID) ) {
				alt23=1;
			}
			else if ( (LA23_0==30) ) {
				alt23=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 23, 0, input);
				throw nvae;
			}

			switch (alt23) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:127:4: tagScheme
					{
					pushFollow(FOLLOW_tagScheme_in_tag577);
					tagScheme66=tagScheme();
					state._fsp--;

					adaptor.addChild(root_0, tagScheme66.getTree());

					}
					break;
				case 2 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:127:14: '_'
					{
					char_literal67=(Token)match(input,30,FOLLOW_30_in_tag579); 
					char_literal67_tree = (CommonTree)adaptor.create(char_literal67);
					adaptor.addChild(root_0, char_literal67_tree);

					}
					break;

			}

			char_literal68=(Token)match(input,25,FOLLOW_25_in_tag582); 
			char_literal68_tree = (CommonTree)adaptor.create(char_literal68);
			adaptor.addChild(root_0, char_literal68_tree);

			ID69=(Token)match(input,ID,FOLLOW_ID_in_tag584); 
			ID69_tree = (CommonTree)adaptor.create(ID69);
			adaptor.addChild(root_0, ID69_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tag"


	public static class tagScheme_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tagScheme"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:130:1: tagScheme : ID ;
	public final aexp17Parser.tagScheme_return tagScheme() throws RecognitionException {
		aexp17Parser.tagScheme_return retval = new aexp17Parser.tagScheme_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID70=null;

		CommonTree ID70_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:131:3: ( ID )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:132:3: ID
			{
			root_0 = (CommonTree)adaptor.nil();


			ID70=(Token)match(input,ID,FOLLOW_ID_in_tagScheme599); 
			ID70_tree = (CommonTree)adaptor.create(ID70);
			adaptor.addChild(root_0, ID70_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tagScheme"


	public static class dimSet_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dimSet"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:135:1: dimSet : ( ALL | ID );
	public final aexp17Parser.dimSet_return dimSet() throws RecognitionException {
		aexp17Parser.dimSet_return retval = new aexp17Parser.dimSet_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set71=null;

		CommonTree set71_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:136:3: ( ALL | ID )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set71=input.LT(1);
			if ( input.LA(1)==ALL||input.LA(1)==ID ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set71));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "dimSet"


	public static class durations_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "durations"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:142:1: durations : '{' duration ( ';' duration )* '}' -> '{' ^( ';' ( duration )+ ) '}' ;
	public final aexp17Parser.durations_return durations() throws RecognitionException {
		aexp17Parser.durations_return retval = new aexp17Parser.durations_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal72=null;
		Token char_literal74=null;
		Token char_literal76=null;
		ParserRuleReturnScope duration73 =null;
		ParserRuleReturnScope duration75 =null;

		CommonTree char_literal72_tree=null;
		CommonTree char_literal74_tree=null;
		CommonTree char_literal76_tree=null;
		RewriteRuleTokenStream stream_32=new RewriteRuleTokenStream(adaptor,"token 32");
		RewriteRuleTokenStream stream_31=new RewriteRuleTokenStream(adaptor,"token 31");
		RewriteRuleTokenStream stream_26=new RewriteRuleTokenStream(adaptor,"token 26");
		RewriteRuleSubtreeStream stream_duration=new RewriteRuleSubtreeStream(adaptor,"rule duration");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:143:3: ( '{' duration ( ';' duration )* '}' -> '{' ^( ';' ( duration )+ ) '}' )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:144:3: '{' duration ( ';' duration )* '}'
			{
			char_literal72=(Token)match(input,31,FOLLOW_31_in_durations643);  
			stream_31.add(char_literal72);

			pushFollow(FOLLOW_duration_in_durations645);
			duration73=duration();
			state._fsp--;

			stream_duration.add(duration73.getTree());
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:144:16: ( ';' duration )*
			loop24:
			while (true) {
				int alt24=2;
				int LA24_0 = input.LA(1);
				if ( (LA24_0==26) ) {
					alt24=1;
				}

				switch (alt24) {
				case 1 :
					// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:144:17: ';' duration
					{
					char_literal74=(Token)match(input,26,FOLLOW_26_in_durations648);  
					stream_26.add(char_literal74);

					pushFollow(FOLLOW_duration_in_durations650);
					duration75=duration();
					state._fsp--;

					stream_duration.add(duration75.getTree());
					}
					break;

				default :
					break loop24;
				}
			}

			char_literal76=(Token)match(input,32,FOLLOW_32_in_durations654);  
			stream_32.add(char_literal76);

			// AST REWRITE
			// elements: duration, 31, 32, 26
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 144:36: -> '{' ^( ';' ( duration )+ ) '}'
			{
				adaptor.addChild(root_0, stream_31.nextNode());
				// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:144:42: ^( ';' ( duration )+ )
				{
				CommonTree root_1 = (CommonTree)adaptor.nil();
				root_1 = (CommonTree)adaptor.becomeRoot(stream_26.nextNode(), root_1);
				if ( !(stream_duration.hasNext()) ) {
					throw new RewriteEarlyExitException();
				}
				while ( stream_duration.hasNext() ) {
					adaptor.addChild(root_1, stream_duration.nextTree());
				}
				stream_duration.reset();

				adaptor.addChild(root_0, root_1);
				}

				adaptor.addChild(root_0, stream_32.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "durations"


	public static class duration_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "duration"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:147:1: duration : start_time ',' end_time ;
	public final aexp17Parser.duration_return duration() throws RecognitionException {
		aexp17Parser.duration_return retval = new aexp17Parser.duration_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal78=null;
		ParserRuleReturnScope start_time77 =null;
		ParserRuleReturnScope end_time79 =null;

		CommonTree char_literal78_tree=null;

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:147:9: ( start_time ',' end_time )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:148:3: start_time ',' end_time
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_start_time_in_duration676);
			start_time77=start_time();
			state._fsp--;

			adaptor.addChild(root_0, start_time77.getTree());

			char_literal78=(Token)match(input,22,FOLLOW_22_in_duration678); 
			char_literal78_tree = (CommonTree)adaptor.create(char_literal78);
			adaptor.addChild(root_0, char_literal78_tree);

			pushFollow(FOLLOW_end_time_in_duration680);
			end_time79=end_time();
			state._fsp--;

			adaptor.addChild(root_0, end_time79.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "duration"


	public static class start_time_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "start_time"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:150:1: start_time : INT -> INT ;
	public final aexp17Parser.start_time_return start_time() throws RecognitionException {
		aexp17Parser.start_time_return retval = new aexp17Parser.start_time_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT80=null;

		CommonTree INT80_tree=null;
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:151:3: ( INT -> INT )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:152:3: INT
			{
			INT80=(Token)match(input,INT,FOLLOW_INT_in_start_time695);  
			stream_INT.add(INT80);

			// AST REWRITE
			// elements: INT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 152:7: -> INT
			{
				adaptor.addChild(root_0, stream_INT.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "start_time"


	public static class end_time_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "end_time"
	// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:154:1: end_time : INT -> INT ;
	public final aexp17Parser.end_time_return end_time() throws RecognitionException {
		aexp17Parser.end_time_return retval = new aexp17Parser.end_time_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INT81=null;

		CommonTree INT81_tree=null;
		RewriteRuleTokenStream stream_INT=new RewriteRuleTokenStream(adaptor,"token INT");

		try {
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:155:3: ( INT -> INT )
			// /Users/su22797/eclipse-kepler-workspace/kql/src/main/java/edu/mit/ll/antlr/aexp17.g:156:3: INT
			{
			INT81=(Token)match(input,INT,FOLLOW_INT_in_end_time714);  
			stream_INT.add(INT81);

			// AST REWRITE
			// elements: INT
			// token labels: 
			// rule labels: retval
			// token list labels: 
			// rule list labels: 
			// wildcard labels: 
			retval.tree = root_0;
			RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

			root_0 = (CommonTree)adaptor.nil();
			// 156:7: -> INT
			{
				adaptor.addChild(root_0, stream_INT.nextNode());
			}


			retval.tree = root_0;

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "end_time"

	// Delegated rules


	protected DFA9 dfa9 = new DFA9(this);
	static final String DFA9_eotS =
		"\40\uffff";
	static final String DFA9_eofS =
		"\2\uffff\2\4\5\uffff\1\4\6\uffff\1\4\5\uffff\1\4\3\uffff\1\4\5\uffff";
	static final String DFA9_minS =
		"\1\4\1\11\2\4\1\uffff\1\26\1\37\2\uffff\1\4\1\11\1\12\1\37\2\26\1\12\1"+
		"\4\1\12\1\26\1\32\2\12\1\4\1\32\1\26\1\12\1\4\1\12\1\26\1\32\1\12\1\32";
	static final String DFA9_maxS =
		"\1\37\1\36\2\37\1\uffff\1\40\1\37\2\uffff\1\37\1\11\1\12\1\37\1\40\1\26"+
		"\1\12\1\37\1\12\1\26\1\40\2\12\1\37\1\40\1\26\1\12\1\37\1\12\1\26\1\40"+
		"\1\12\1\40";
	static final String DFA9_acceptS =
		"\4\uffff\1\3\2\uffff\1\1\1\2\27\uffff";
	static final String DFA9_specialS =
		"\40\uffff}>";
	static final String[] DFA9_transitionS = {
			"\1\2\4\uffff\1\3\11\uffff\1\4\10\uffff\1\4\1\uffff\1\4\1\1",
			"\1\5\24\uffff\1\4",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\6\1\7"+
			"\2\uffff\1\10\1\4\1\uffff\2\4",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\6\1\7"+
			"\1\4\1\uffff\1\10\1\4\1\uffff\2\4",
			"",
			"\1\12\2\uffff\1\4\6\uffff\1\11",
			"\1\13",
			"",
			"",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\14\1"+
			"\7\2\uffff\1\10\1\4\1\uffff\2\4",
			"\1\15",
			"\1\16",
			"\1\17",
			"\1\12\11\uffff\1\20",
			"\1\21",
			"\1\22",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\14\1"+
			"\7\2\uffff\1\10\1\4\1\uffff\2\4",
			"\1\23",
			"\1\24",
			"\1\25\5\uffff\1\26",
			"\1\27",
			"\1\30",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\6\1\7"+
			"\2\uffff\1\10\1\4\1\uffff\2\4",
			"\1\31\5\uffff\1\32",
			"\1\33",
			"\1\34",
			"\2\4\3\uffff\1\4\2\uffff\1\4\1\uffff\1\4\3\uffff\4\4\1\uffff\1\14\1"+
			"\7\2\uffff\1\10\1\4\1\uffff\2\4",
			"\1\35",
			"\1\36",
			"\1\25\5\uffff\1\26",
			"\1\37",
			"\1\31\5\uffff\1\32"
	};

	static final short[] DFA9_eot = DFA.unpackEncodedString(DFA9_eotS);
	static final short[] DFA9_eof = DFA.unpackEncodedString(DFA9_eofS);
	static final char[] DFA9_min = DFA.unpackEncodedStringToUnsignedChars(DFA9_minS);
	static final char[] DFA9_max = DFA.unpackEncodedStringToUnsignedChars(DFA9_maxS);
	static final short[] DFA9_accept = DFA.unpackEncodedString(DFA9_acceptS);
	static final short[] DFA9_special = DFA.unpackEncodedString(DFA9_specialS);
	static final short[][] DFA9_transition;

	static {
		int numStates = DFA9_transitionS.length;
		DFA9_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA9_transition[i] = DFA.unpackEncodedString(DFA9_transitionS[i]);
		}
	}

	protected class DFA9 extends DFA {

		public DFA9(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 9;
			this.eot = DFA9_eot;
			this.eof = DFA9_eof;
			this.min = DFA9_min;
			this.max = DFA9_max;
			this.accept = DFA9_accept;
			this.special = DFA9_special;
			this.transition = DFA9_transition;
		}
		@Override
		public String getDescription() {
			return "60:1: slash_exp : ( atom2 ( '/' ^ atom2 )+ | atom2 ( '?' ^)+ | atom ( '.' ^ durations )* );";
		}
	}

	public static final BitSet FOLLOW_r_exp_in_start76 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_period_exp_in_r_exp97 = new BitSet(new long[]{0x0000000000004022L});
	public static final BitSet FOLLOW_AND_in_r_exp101 = new BitSet(new long[]{0x00000000D0080210L});
	public static final BitSet FOLLOW_OR_in_r_exp104 = new BitSet(new long[]{0x00000000D0080210L});
	public static final BitSet FOLLOW_period_exp_in_r_exp108 = new BitSet(new long[]{0x0000000000004022L});
	public static final BitSet FOLLOW_NOT_in_r_exp118 = new BitSet(new long[]{0x00000000D0081210L});
	public static final BitSet FOLLOW_r_exp_in_r_exp120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_star_exp_in_period_exp145 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_period_exp149 = new BitSet(new long[]{0x00000000D0080210L});
	public static final BitSet FOLLOW_star_exp_in_period_exp152 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_slash_exp_in_star_exp169 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_21_in_star_exp172 = new BitSet(new long[]{0x00000000D0080210L});
	public static final BitSet FOLLOW_slash_exp_in_star_exp175 = new BitSet(new long[]{0x0000000000200002L});
	public static final BitSet FOLLOW_atom2_in_slash_exp191 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_slash_exp194 = new BitSet(new long[]{0x0000000080000210L});
	public static final BitSet FOLLOW_atom2_in_slash_exp197 = new BitSet(new long[]{0x0000000001000002L});
	public static final BitSet FOLLOW_atom2_in_slash_exp207 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_slash_exp210 = new BitSet(new long[]{0x0000000008000002L});
	public static final BitSet FOLLOW_atom_in_slash_exp221 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_slash_exp224 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_durations_in_slash_exp227 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_set_of_dims_in_atom2244 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_atom2247 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_durations_in_atom2250 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_dimSet_in_atom2261 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_23_in_atom2264 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_durations_in_atom2267 = new BitSet(new long[]{0x0000000000800002L});
	public static final BitSet FOLLOW_dims_in_atom286 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tags_in_atom294 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_19_in_atom302 = new BitSet(new long[]{0x00000000D0181210L});
	public static final BitSet FOLLOW_r_exp_in_atom304 = new BitSet(new long[]{0x00000000D0181210L});
	public static final BitSet FOLLOW_20_in_atom307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_atom319 = new BitSet(new long[]{0x0000000080000210L});
	public static final BitSet FOLLOW_dimSet_in_atom322 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_set_of_dimSets_in_atom324 = new BitSet(new long[]{0x0000000020000000L});
	public static final BitSet FOLLOW_29_in_atom327 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALL_in_dims344 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dim_in_dims353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_set_of_dims_in_dims361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dims377 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_dim_in_set_of_dims379 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_set_of_dims381 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dims397 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_dim_in_set_of_dims399 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_set_of_dims402 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_dim_in_set_of_dims404 = new BitSet(new long[]{0x0000000100400000L});
	public static final BitSet FOLLOW_32_in_set_of_dims408 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dimSets436 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_dimSet_in_set_of_dimSets438 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_set_of_dimSets440 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_set_of_dimSets456 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_dimSet_in_set_of_dimSets458 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_set_of_dimSets461 = new BitSet(new long[]{0x0000000000000210L});
	public static final BitSet FOLLOW_dimSet_in_set_of_dimSets463 = new BitSet(new long[]{0x0000000100400000L});
	public static final BitSet FOLLOW_32_in_set_of_dimSets467 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_dim494 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_tags510 = new BitSet(new long[]{0x0000000040000200L});
	public static final BitSet FOLLOW_tag_in_tags512 = new BitSet(new long[]{0x0000000100000000L});
	public static final BitSet FOLLOW_32_in_tags514 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_tags530 = new BitSet(new long[]{0x0000000040000200L});
	public static final BitSet FOLLOW_tag_in_tags532 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_tags535 = new BitSet(new long[]{0x0000000040000200L});
	public static final BitSet FOLLOW_tag_in_tags537 = new BitSet(new long[]{0x0000000100400000L});
	public static final BitSet FOLLOW_32_in_tags541 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tag_in_tags560 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tagScheme_in_tag577 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_30_in_tag579 = new BitSet(new long[]{0x0000000002000000L});
	public static final BitSet FOLLOW_25_in_tag582 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_ID_in_tag584 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_tagScheme599 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_31_in_durations643 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_duration_in_durations645 = new BitSet(new long[]{0x0000000104000000L});
	public static final BitSet FOLLOW_26_in_durations648 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_duration_in_durations650 = new BitSet(new long[]{0x0000000104000000L});
	public static final BitSet FOLLOW_32_in_durations654 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_start_time_in_duration676 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_duration678 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_end_time_in_duration680 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_start_time695 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INT_in_end_time714 = new BitSet(new long[]{0x0000000000000002L});
}
