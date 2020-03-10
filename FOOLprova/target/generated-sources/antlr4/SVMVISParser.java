// Generated from SVMVIS.g4 by ANTLR 4.4

import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMVISParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, JS=12, LOADRA=13, STORERA=14, LOADTM=15, 
		STORETM=16, LOADFP=17, STOREFP=18, COPYFP=19, LOADHP=20, STOREHP=21, PRINT=22, 
		HALT=23, COL=24, LABEL=25, NUMBER=26, COMMENT=27, WHITESP=28, ERR=29;
	public static final String[] tokenNames = {
		"<INVALID>", "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
		"'lw'", "'b'", "'beq'", "'bleq'", "'js'", "'lra'", "'sra'", "'ltm'", "'stm'", 
		"'lfp'", "'sfp'", "'cfp'", "'lhp'", "'shp'", "'print'", "'halt'", "':'", 
		"LABEL", "NUMBER", "COMMENT", "WHITESP", "ERR"
	};
	public static final int
		RULE_assembly = 0;
	public static final String[] ruleNames = {
		"assembly"
	};

	@Override
	public String getGrammarFileName() { return "SVMVIS.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	      
	    int[] code = new int[VisualVM.CODESIZE];
	    int[] sourceMap = new int[VisualVM.CODESIZE];
	    private int i = 0;

	    private HashMap<String,Integer> labelDef = new HashMap<String,Integer>();
	    private HashMap<Integer,String> labelRef = new HashMap<Integer,String>();
	    
	    private void codem(int line, int ... c) {
	    	for (int x : c) {
	    		this.code[i] = x;
	    		this.sourceMap[i] = line-1;
	    		i++;
	    	}
	    }
	    

	public SVMVISParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class AssemblyContext extends ParserRuleContext {
		public Token t;
		public Token n;
		public Token l;
		public TerminalNode POP(int i) {
			return getToken(SVMVISParser.POP, i);
		}
		public TerminalNode COL(int i) {
			return getToken(SVMVISParser.COL, i);
		}
		public TerminalNode ADD(int i) {
			return getToken(SVMVISParser.ADD, i);
		}
		public List<TerminalNode> LOADRA() { return getTokens(SVMVISParser.LOADRA); }
		public TerminalNode MULT(int i) {
			return getToken(SVMVISParser.MULT, i);
		}
		public List<TerminalNode> BRANCHLESSEQ() { return getTokens(SVMVISParser.BRANCHLESSEQ); }
		public TerminalNode PUSH(int i) {
			return getToken(SVMVISParser.PUSH, i);
		}
		public List<TerminalNode> BRANCHEQ() { return getTokens(SVMVISParser.BRANCHEQ); }
		public TerminalNode JS(int i) {
			return getToken(SVMVISParser.JS, i);
		}
		public List<TerminalNode> LOADW() { return getTokens(SVMVISParser.LOADW); }
		public TerminalNode BRANCHEQ(int i) {
			return getToken(SVMVISParser.BRANCHEQ, i);
		}
		public TerminalNode SUB(int i) {
			return getToken(SVMVISParser.SUB, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SVMVISParser.DIV); }
		public List<TerminalNode> PRINT() { return getTokens(SVMVISParser.PRINT); }
		public List<TerminalNode> MULT() { return getTokens(SVMVISParser.MULT); }
		public TerminalNode STOREW(int i) {
			return getToken(SVMVISParser.STOREW, i);
		}
		public List<TerminalNode> SUB() { return getTokens(SVMVISParser.SUB); }
		public TerminalNode LABEL(int i) {
			return getToken(SVMVISParser.LABEL, i);
		}
		public List<TerminalNode> STORERA() { return getTokens(SVMVISParser.STORERA); }
		public TerminalNode BRANCHLESSEQ(int i) {
			return getToken(SVMVISParser.BRANCHLESSEQ, i);
		}
		public List<TerminalNode> POP() { return getTokens(SVMVISParser.POP); }
		public TerminalNode STORERA(int i) {
			return getToken(SVMVISParser.STORERA, i);
		}
		public List<TerminalNode> LOADHP() { return getTokens(SVMVISParser.LOADHP); }
		public TerminalNode COPYFP(int i) {
			return getToken(SVMVISParser.COPYFP, i);
		}
		public List<TerminalNode> LOADTM() { return getTokens(SVMVISParser.LOADTM); }
		public TerminalNode LOADW(int i) {
			return getToken(SVMVISParser.LOADW, i);
		}
		public TerminalNode LOADTM(int i) {
			return getToken(SVMVISParser.LOADTM, i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(SVMVISParser.NUMBER); }
		public List<TerminalNode> BRANCH() { return getTokens(SVMVISParser.BRANCH); }
		public TerminalNode LOADRA(int i) {
			return getToken(SVMVISParser.LOADRA, i);
		}
		public List<TerminalNode> STOREHP() { return getTokens(SVMVISParser.STOREHP); }
		public TerminalNode STOREFP(int i) {
			return getToken(SVMVISParser.STOREFP, i);
		}
		public TerminalNode BRANCH(int i) {
			return getToken(SVMVISParser.BRANCH, i);
		}
		public List<TerminalNode> STORETM() { return getTokens(SVMVISParser.STORETM); }
		public List<TerminalNode> ADD() { return getTokens(SVMVISParser.ADD); }
		public List<TerminalNode> COL() { return getTokens(SVMVISParser.COL); }
		public List<TerminalNode> STOREFP() { return getTokens(SVMVISParser.STOREFP); }
		public TerminalNode DIV(int i) {
			return getToken(SVMVISParser.DIV, i);
		}
		public TerminalNode NUMBER(int i) {
			return getToken(SVMVISParser.NUMBER, i);
		}
		public List<TerminalNode> COPYFP() { return getTokens(SVMVISParser.COPYFP); }
		public TerminalNode STORETM(int i) {
			return getToken(SVMVISParser.STORETM, i);
		}
		public TerminalNode HALT(int i) {
			return getToken(SVMVISParser.HALT, i);
		}
		public TerminalNode LOADFP(int i) {
			return getToken(SVMVISParser.LOADFP, i);
		}
		public List<TerminalNode> PUSH() { return getTokens(SVMVISParser.PUSH); }
		public List<TerminalNode> LABEL() { return getTokens(SVMVISParser.LABEL); }
		public TerminalNode LOADHP(int i) {
			return getToken(SVMVISParser.LOADHP, i);
		}
		public List<TerminalNode> JS() { return getTokens(SVMVISParser.JS); }
		public TerminalNode PRINT(int i) {
			return getToken(SVMVISParser.PRINT, i);
		}
		public List<TerminalNode> STOREW() { return getTokens(SVMVISParser.STOREW); }
		public List<TerminalNode> LOADFP() { return getTokens(SVMVISParser.LOADFP); }
		public List<TerminalNode> HALT() { return getTokens(SVMVISParser.HALT); }
		public TerminalNode STOREHP(int i) {
			return getToken(SVMVISParser.STOREHP, i);
		}
		public AssemblyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assembly; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SVMVISListener ) ((SVMVISListener)listener).enterAssembly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SVMVISListener ) ((SVMVISListener)listener).exitAssembly(this);
		}
	}

	public final AssemblyContext assembly() throws RecognitionException {
		AssemblyContext _localctx = new AssemblyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_assembly);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PUSH) | (1L << POP) | (1L << ADD) | (1L << SUB) | (1L << MULT) | (1L << DIV) | (1L << STOREW) | (1L << LOADW) | (1L << BRANCH) | (1L << BRANCHEQ) | (1L << BRANCHLESSEQ) | (1L << JS) | (1L << LOADRA) | (1L << STORERA) | (1L << LOADTM) | (1L << STORETM) | (1L << LOADFP) | (1L << STOREFP) | (1L << COPYFP) | (1L << LOADHP) | (1L << STOREHP) | (1L << PRINT) | (1L << HALT) | (1L << LABEL))) != 0)) {
				{
				setState(58);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(2); ((AssemblyContext)_localctx).t = match(PUSH);
					setState(3); ((AssemblyContext)_localctx).n = match(NUMBER);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), PUSH, Integer.parseInt((((AssemblyContext)_localctx).n!=null?((AssemblyContext)_localctx).n.getText():null))); 
					}
					break;
				case 2:
					{
					setState(5); ((AssemblyContext)_localctx).t = match(PUSH);
					setState(6); ((AssemblyContext)_localctx).l = match(LABEL);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), PUSH); labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null)); 
					}
					break;
				case 3:
					{
					setState(8); ((AssemblyContext)_localctx).t = match(POP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), POP); 
					}
					break;
				case 4:
					{
					setState(10); ((AssemblyContext)_localctx).t = match(ADD);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), ADD); 
					}
					break;
				case 5:
					{
					setState(12); ((AssemblyContext)_localctx).t = match(SUB);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), SUB); 
					}
					break;
				case 6:
					{
					setState(14); ((AssemblyContext)_localctx).t = match(MULT);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), MULT); 
					}
					break;
				case 7:
					{
					setState(16); ((AssemblyContext)_localctx).t = match(DIV);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), DIV); 
					}
					break;
				case 8:
					{
					setState(18); ((AssemblyContext)_localctx).t = match(STOREW);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), STOREW); 
					}
					break;
				case 9:
					{
					setState(20); ((AssemblyContext)_localctx).t = match(LOADW);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), LOADW); 
					}
					break;
				case 10:
					{
					setState(22); ((AssemblyContext)_localctx).l = match(LABEL);
					setState(23); match(COL);
					 labelDef.put((((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null), i); 
					}
					break;
				case 11:
					{
					setState(25); ((AssemblyContext)_localctx).t = match(BRANCH);
					setState(26); ((AssemblyContext)_localctx).l = match(LABEL);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), BRANCH); labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null)); 
					}
					break;
				case 12:
					{
					setState(28); ((AssemblyContext)_localctx).t = match(BRANCHEQ);
					setState(29); ((AssemblyContext)_localctx).l = match(LABEL);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), BRANCHEQ); labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null)); 
					}
					break;
				case 13:
					{
					setState(31); ((AssemblyContext)_localctx).t = match(BRANCHLESSEQ);
					setState(32); ((AssemblyContext)_localctx).l = match(LABEL);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), BRANCHLESSEQ); labelRef.put(i++,(((AssemblyContext)_localctx).l!=null?((AssemblyContext)_localctx).l.getText():null)); 
					}
					break;
				case 14:
					{
					setState(34); ((AssemblyContext)_localctx).t = match(JS);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), JS); 
					}
					break;
				case 15:
					{
					setState(36); ((AssemblyContext)_localctx).t = match(LOADRA);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), LOADRA); 
					}
					break;
				case 16:
					{
					setState(38); ((AssemblyContext)_localctx).t = match(STORERA);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), STORERA); 
					}
					break;
				case 17:
					{
					setState(40); ((AssemblyContext)_localctx).t = match(LOADTM);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), LOADTM); 
					}
					break;
				case 18:
					{
					setState(42); ((AssemblyContext)_localctx).t = match(STORETM);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), STORETM); 
					}
					break;
				case 19:
					{
					setState(44); ((AssemblyContext)_localctx).t = match(LOADFP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), LOADFP); 
					}
					break;
				case 20:
					{
					setState(46); ((AssemblyContext)_localctx).t = match(STOREFP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), STOREFP); 
					}
					break;
				case 21:
					{
					setState(48); ((AssemblyContext)_localctx).t = match(COPYFP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), COPYFP); 
					}
					break;
				case 22:
					{
					setState(50); ((AssemblyContext)_localctx).t = match(LOADHP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), LOADHP); 
					}
					break;
				case 23:
					{
					setState(52); ((AssemblyContext)_localctx).t = match(STOREHP);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), STOREHP); 
					}
					break;
				case 24:
					{
					setState(54); ((AssemblyContext)_localctx).t = match(PRINT);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), PRINT); 
					}
					break;
				case 25:
					{
					setState(56); ((AssemblyContext)_localctx).t = match(HALT);
					 codem((((AssemblyContext)_localctx).t!=null?((AssemblyContext)_localctx).t.getLine():0), HALT); 
					}
					break;
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			 for (Integer j: labelRef.keySet()) {
				              code[j]=labelDef.get(labelRef.get(j));
					 } 		   
				  
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\37D\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\7\2=\n\2\f\2\16\2@\13\2\3\2\3\2\3\2\2\2\3\2\2\2[\2>\3\2\2\2\4"+
		"\5\7\3\2\2\5\6\7\34\2\2\6=\b\2\1\2\7\b\7\3\2\2\b\t\7\33\2\2\t=\b\2\1\2"+
		"\n\13\7\4\2\2\13=\b\2\1\2\f\r\7\5\2\2\r=\b\2\1\2\16\17\7\6\2\2\17=\b\2"+
		"\1\2\20\21\7\7\2\2\21=\b\2\1\2\22\23\7\b\2\2\23=\b\2\1\2\24\25\7\t\2\2"+
		"\25=\b\2\1\2\26\27\7\n\2\2\27=\b\2\1\2\30\31\7\33\2\2\31\32\7\32\2\2\32"+
		"=\b\2\1\2\33\34\7\13\2\2\34\35\7\33\2\2\35=\b\2\1\2\36\37\7\f\2\2\37 "+
		"\7\33\2\2 =\b\2\1\2!\"\7\r\2\2\"#\7\33\2\2#=\b\2\1\2$%\7\16\2\2%=\b\2"+
		"\1\2&\'\7\17\2\2\'=\b\2\1\2()\7\20\2\2)=\b\2\1\2*+\7\21\2\2+=\b\2\1\2"+
		",-\7\22\2\2-=\b\2\1\2./\7\23\2\2/=\b\2\1\2\60\61\7\24\2\2\61=\b\2\1\2"+
		"\62\63\7\25\2\2\63=\b\2\1\2\64\65\7\26\2\2\65=\b\2\1\2\66\67\7\27\2\2"+
		"\67=\b\2\1\289\7\30\2\29=\b\2\1\2:;\7\31\2\2;=\b\2\1\2<\4\3\2\2\2<\7\3"+
		"\2\2\2<\n\3\2\2\2<\f\3\2\2\2<\16\3\2\2\2<\20\3\2\2\2<\22\3\2\2\2<\24\3"+
		"\2\2\2<\26\3\2\2\2<\30\3\2\2\2<\33\3\2\2\2<\36\3\2\2\2<!\3\2\2\2<$\3\2"+
		"\2\2<&\3\2\2\2<(\3\2\2\2<*\3\2\2\2<,\3\2\2\2<.\3\2\2\2<\60\3\2\2\2<\62"+
		"\3\2\2\2<\64\3\2\2\2<\66\3\2\2\2<8\3\2\2\2<:\3\2\2\2=@\3\2\2\2><\3\2\2"+
		"\2>?\3\2\2\2?A\3\2\2\2@>\3\2\2\2AB\b\2\1\2B\3\3\2\2\2\4<>";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}