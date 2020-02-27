// Generated from FOOL.g4 by ANTLR 4.7

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, TIMES=3, DIV=4, LPAR=5, RPAR=6, CLPAR=7, CRPAR=8, SEMIC=9, 
		COLON=10, COMMA=11, DOT=12, OR=13, AND=14, NOT=15, GE=16, LE=17, EQ=18, 
		ASS=19, TRUE=20, FALSE=21, IF=22, THEN=23, ELSE=24, PRINT=25, LET=26, 
		IN=27, VAR=28, FUN=29, CLASS=30, EXTENDS=31, NEW=32, NULL=33, INT=34, 
		BOOL=35, ARROW=36, INTEGER=37, ID=38, WHITESP=39, COMMENT=40, ERR=41;
	public static final int
		RULE_prog = 0, RULE_declist = 1, RULE_type = 2, RULE_exp = 3, RULE_term = 4, 
		RULE_factor = 5, RULE_value = 6;
	public static final String[] ruleNames = {
		"prog", "declist", "type", "exp", "term", "factor", "value"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "';'", "':'", 
		"','", "'.'", "'||'", "'&&'", "'!'", "'>='", "'<='", "'=='", "'='", "'true'", 
		"'false'", "'if'", "'then'", "'else'", "'print'", "'let'", "'in'", "'var'", 
		"'fun'", "'class'", "'extends'", "'new'", "'null'", "'int'", "'bool'", 
		"'->'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "PLUS", "MINUS", "TIMES", "DIV", "LPAR", "RPAR", "CLPAR", "CRPAR", 
		"SEMIC", "COLON", "COMMA", "DOT", "OR", "AND", "NOT", "GE", "LE", "EQ", 
		"ASS", "TRUE", "FALSE", "IF", "THEN", "ELSE", "PRINT", "LET", "IN", "VAR", 
		"FUN", "CLASS", "EXTENDS", "NEW", "NULL", "INT", "BOOL", "ARROW", "INTEGER", 
		"ID", "WHITESP", "COMMENT", "ERR"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	int stErrors=0;

	private int nestingLevel = 0;
	private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
	//livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
	//il "fronte" della lista di tabelle � symTable.get(nestingLevel)

	public FOOLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public Node ast;
		public ExpContext e;
		public DeclistContext d;
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public TerminalNode EOF() { return getToken(FOOLParser.EOF, 0); }
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public DeclistContext declist() {
			return getRuleContext(DeclistContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			HashMap<String,STentry> hm = new HashMap<String,STentry> ();
			       symTable.add(hm);
			setState(24);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
			case TRUE:
			case FALSE:
			case IF:
			case PRINT:
			case INTEGER:
			case ID:
				{
				setState(15);
				((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				{
				setState(18);
				match(LET);
				setState(19);
				((ProgContext)_localctx).d = declist();
				setState(20);
				match(IN);
				setState(21);
				((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(27);
			match(SEMIC);
			setState(28);
			match(EOF);
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

	public static class DeclistContext extends ParserRuleContext {
		public ArrayList<Node> astlist;
		public Token i;
		public TypeContext t;
		public ExpContext e;
		public Token fid;
		public TypeContext fty;
		public Token id;
		public TypeContext ty;
		public DeclistContext d;
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(FOOLParser.VAR, i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(FOOLParser.COLON, i);
		}
		public List<TerminalNode> ASS() { return getTokens(FOOLParser.ASS); }
		public TerminalNode ASS(int i) {
			return getToken(FOOLParser.ASS, i);
		}
		public List<TerminalNode> FUN() { return getTokens(FOOLParser.FUN); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FOOLParser.LPAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FOOLParser.RPAR); }
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> LET() { return getTokens(FOOLParser.LET); }
		public TerminalNode LET(int i) {
			return getToken(FOOLParser.LET, i);
		}
		public List<TerminalNode> IN() { return getTokens(FOOLParser.IN); }
		public TerminalNode IN(int i) {
			return getToken(FOOLParser.IN, i);
		}
		public List<DeclistContext> declist() {
			return getRuleContexts(DeclistContext.class);
		}
		public DeclistContext declist(int i) {
			return getRuleContext(DeclistContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public DeclistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declist; }
	}

	public final DeclistContext declist() throws RecognitionException {
		DeclistContext _localctx = new DeclistContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			((DeclistContext)_localctx).astlist =  new ArrayList<Node>() ;
				   int offset=-2; 
			setState(78); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(74);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(31);
					match(VAR);
					setState(32);
					((DeclistContext)_localctx).i = match(ID);
					setState(33);
					match(COLON);
					setState(34);
					((DeclistContext)_localctx).t = type();
					setState(35);
					match(ASS);
					setState(36);
					((DeclistContext)_localctx).e = exp();
					VarNode v = new VarNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast,((DeclistContext)_localctx).e.ast);  
					             _localctx.astlist.add(v);                                 
					             HashMap<String,STentry> hm = symTable.get(nestingLevel);
					             if ( hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).t.ast,offset--)) != null  ) {
					              System.out.println("Var id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
					              stErrors++; }  
					            
					}
					break;
				case FUN:
					{
					setState(39);
					match(FUN);
					setState(40);
					((DeclistContext)_localctx).i = match(ID);
					setState(41);
					match(COLON);
					setState(42);
					((DeclistContext)_localctx).t = type();
					//inserimento di ID nella symtable
					               FunNode f = new FunNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast);      
					               _localctx.astlist.add(f);                              
					               HashMap<String,STentry> hm = symTable.get(nestingLevel);
					               ArrayList<Node> parTypes = new ArrayList<Node>();
					               if ( hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),new STentry(nestingLevel,new ArrowTypeNode(parTypes,((DeclistContext)_localctx).t.ast),offset--)) != null  ) {
					                System.out.println("Fun id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
					                stErrors++; }
					                //creare una nuova hashmap per la symTable
					                nestingLevel++;
					                HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
					                symTable.add(hmn);
					                
					setState(44);
					match(LPAR);
					int paroffset=1;
					setState(61);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(46);
						((DeclistContext)_localctx).fid = match(ID);
						setState(47);
						match(COLON);
						setState(48);
						((DeclistContext)_localctx).fty = type();
						 
						                  parTypes.add(((DeclistContext)_localctx).fty.ast);
						                  ParNode fpar = new ParNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fty.ast); //creo nodo ParNode
						                  f.addPar(fpar);                                 //lo attacco al FunNode con addPar
						                  if ( hmn.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).fty.ast,paroffset++)) != null  ) { //aggiungo dich a hmn
						                   System.out.println("Parameter id "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null)+" at line "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0)+" already declared");
						                   stErrors++; }
						                  
						setState(58);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(50);
							match(COMMA);
							setState(51);
							((DeclistContext)_localctx).id = match(ID);
							setState(52);
							match(COLON);
							setState(53);
							((DeclistContext)_localctx).ty = type();

							                    parTypes.add(((DeclistContext)_localctx).ty.ast);
							                    ParNode par = new ParNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),((DeclistContext)_localctx).ty.ast);
							                    f.addPar(par);
							                    if ( hmn.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).ty.ast,paroffset++)) != null  ) {
							                     System.out.println("Parameter id "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null)+" at line "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0)+" already declared");
							                     stErrors++; }
							                    
							}
							}
							setState(60);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(63);
					match(RPAR);
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(64);
						match(LET);
						setState(65);
						((DeclistContext)_localctx).d = declist();
						setState(66);
						match(IN);
						f.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(71);
					((DeclistContext)_localctx).e = exp();
					f.addBody(((DeclistContext)_localctx).e.ast);
					               //rimuovere la hashmap corrente poich� esco dallo scope               
					               symTable.remove(nestingLevel--);    
					              
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76);
				match(SEMIC);
				}
				}
				setState(80); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==VAR || _la==FUN );
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

	public static class TypeContext extends ParserRuleContext {
		public Node ast;
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_type);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				match(BOOL);
				((TypeContext)_localctx).ast = new BoolTypeNode();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class ExpContext extends ParserRuleContext {
		public Node ast;
		public TermContext f;
		public TermContext l;
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FOOLParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(FOOLParser.PLUS, i);
		}
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(90);
				match(PLUS);
				setState(91);
				((ExpContext)_localctx).l = term();
				((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TermContext extends ParserRuleContext {
		public Node ast;
		public FactorContext f;
		public FactorContext l;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(FOOLParser.TIMES); }
		public TerminalNode TIMES(int i) {
			return getToken(FOOLParser.TIMES, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TIMES) {
				{
				{
				setState(101);
				match(TIMES);
				setState(102);
				((TermContext)_localctx).l = factor();
				((TermContext)_localctx).ast =  new TimesNode (_localctx.ast,((TermContext)_localctx).l.ast);
				}
				}
				setState(109);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FactorContext extends ParserRuleContext {
		public Node ast;
		public ValueContext f;
		public ValueContext l;
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> EQ() { return getTokens(FOOLParser.EQ); }
		public TerminalNode EQ(int i) {
			return getToken(FOOLParser.EQ, i);
		}
		public List<TerminalNode> LE() { return getTokens(FOOLParser.LE); }
		public TerminalNode LE(int i) {
			return getToken(FOOLParser.LE, i);
		}
		public List<TerminalNode> GE() { return getTokens(FOOLParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(FOOLParser.GE, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << EQ))) != 0)) {
				{
				setState(124);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case EQ:
					{
					setState(112);
					match(EQ);
					setState(113);
					((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case LE:
					{
					setState(116);
					match(LE);
					setState(117);
					((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new LessEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case GE:
					{
					setState(120);
					match(GE);
					setState(121);
					((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new GreatEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ValueContext extends ParserRuleContext {
		public Node ast;
		public Token n;
		public ExpContext e;
		public ExpContext x;
		public ExpContext y;
		public ExpContext z;
		public Token i;
		public ExpContext a;
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public TerminalNode PRINT() { return getToken(FOOLParser.PRINT, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_value);
		int _la;
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(LPAR);
				setState(136);
				((ValueContext)_localctx).e = exp();
				setState(137);
				match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(140);
				match(IF);
				setState(141);
				((ValueContext)_localctx).x = exp();
				setState(142);
				match(THEN);
				setState(143);
				match(CLPAR);
				setState(144);
				((ValueContext)_localctx).y = exp();
				setState(145);
				match(CRPAR);
				setState(146);
				match(ELSE);
				setState(147);
				match(CLPAR);
				setState(148);
				((ValueContext)_localctx).z = exp();
				setState(149);
				match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(152);
				match(PRINT);
				setState(153);
				match(LPAR);
				setState(154);
				((ValueContext)_localctx).e = exp();
				setState(155);
				match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 7);
				{
				setState(158);
				((ValueContext)_localctx).i = match(ID);
				//cercare la dichiarazione
				           int j=nestingLevel;
				           STentry entry=null; 
				           while (j>=0 && entry==null)
				             entry=(symTable.get(j--)).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
				           if (entry==null) {
				             System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				             stErrors++; }               
					   ((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(160);
					match(LPAR);
					ArrayList<Node> arglist = new ArrayList<Node>();
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(162);
						((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(170);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(164);
							match(COMMA);
							setState(165);
							((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(172);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(175);
					match(RPAR);
					((ValueContext)_localctx).ast =  new CallNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,arglist,nestingLevel);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3+\u00b8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2\33\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3;\n\3\f\3\16\3>\13\3\5\3@\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"H\n\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\6\3Q\n\3\r\3\16\3R\3\4\3\4\3\4\3\4"+
		"\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5a\n\5\f\5\16\5d\13\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\7\6l\n\6\f\6\16\6o\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\7\7\177\n\7\f\7\16\7\u0082\13\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\7\b\u00ab\n\b\f\b\16\b\u00ae\13\b\5\b\u00b0\n\b\3\b\3\b\5\b\u00b4\n\b"+
		"\5\b\u00b6\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\2\u00c5\2\20\3\2\2\2\4 \3"+
		"\2\2\2\6X\3\2\2\2\bZ\3\2\2\2\ne\3\2\2\2\fp\3\2\2\2\16\u00b5\3\2\2\2\20"+
		"\32\b\2\1\2\21\22\5\b\5\2\22\23\b\2\1\2\23\33\3\2\2\2\24\25\7\34\2\2\25"+
		"\26\5\4\3\2\26\27\7\35\2\2\27\30\5\b\5\2\30\31\b\2\1\2\31\33\3\2\2\2\32"+
		"\21\3\2\2\2\32\24\3\2\2\2\33\34\3\2\2\2\34\35\b\2\1\2\35\36\7\13\2\2\36"+
		"\37\7\2\2\3\37\3\3\2\2\2 P\b\3\1\2!\"\7\36\2\2\"#\7(\2\2#$\7\f\2\2$%\5"+
		"\6\4\2%&\7\25\2\2&\'\5\b\5\2\'(\b\3\1\2(M\3\2\2\2)*\7\37\2\2*+\7(\2\2"+
		"+,\7\f\2\2,-\5\6\4\2-.\b\3\1\2./\7\7\2\2/?\b\3\1\2\60\61\7(\2\2\61\62"+
		"\7\f\2\2\62\63\5\6\4\2\63<\b\3\1\2\64\65\7\r\2\2\65\66\7(\2\2\66\67\7"+
		"\f\2\2\678\5\6\4\289\b\3\1\29;\3\2\2\2:\64\3\2\2\2;>\3\2\2\2<:\3\2\2\2"+
		"<=\3\2\2\2=@\3\2\2\2><\3\2\2\2?\60\3\2\2\2?@\3\2\2\2@A\3\2\2\2AG\7\b\2"+
		"\2BC\7\34\2\2CD\5\4\3\2DE\7\35\2\2EF\b\3\1\2FH\3\2\2\2GB\3\2\2\2GH\3\2"+
		"\2\2HI\3\2\2\2IJ\5\b\5\2JK\b\3\1\2KM\3\2\2\2L!\3\2\2\2L)\3\2\2\2MN\3\2"+
		"\2\2NO\7\13\2\2OQ\3\2\2\2PL\3\2\2\2QR\3\2\2\2RP\3\2\2\2RS\3\2\2\2S\5\3"+
		"\2\2\2TU\7$\2\2UY\b\4\1\2VW\7%\2\2WY\b\4\1\2XT\3\2\2\2XV\3\2\2\2Y\7\3"+
		"\2\2\2Z[\5\n\6\2[b\b\5\1\2\\]\7\3\2\2]^\5\n\6\2^_\b\5\1\2_a\3\2\2\2`\\"+
		"\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2c\t\3\2\2\2db\3\2\2\2ef\5\f\7\2"+
		"fm\b\6\1\2gh\7\5\2\2hi\5\f\7\2ij\b\6\1\2jl\3\2\2\2kg\3\2\2\2lo\3\2\2\2"+
		"mk\3\2\2\2mn\3\2\2\2n\13\3\2\2\2om\3\2\2\2pq\5\16\b\2q\u0080\b\7\1\2r"+
		"s\7\24\2\2st\5\16\b\2tu\b\7\1\2u\177\3\2\2\2vw\7\23\2\2wx\5\16\b\2xy\b"+
		"\7\1\2y\177\3\2\2\2z{\7\22\2\2{|\5\16\b\2|}\b\7\1\2}\177\3\2\2\2~r\3\2"+
		"\2\2~v\3\2\2\2~z\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0081\r\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\7\'\2\2\u0084"+
		"\u00b6\b\b\1\2\u0085\u0086\7\26\2\2\u0086\u00b6\b\b\1\2\u0087\u0088\7"+
		"\27\2\2\u0088\u00b6\b\b\1\2\u0089\u008a\7\7\2\2\u008a\u008b\5\b\5\2\u008b"+
		"\u008c\7\b\2\2\u008c\u008d\b\b\1\2\u008d\u00b6\3\2\2\2\u008e\u008f\7\30"+
		"\2\2\u008f\u0090\5\b\5\2\u0090\u0091\7\31\2\2\u0091\u0092\7\t\2\2\u0092"+
		"\u0093\5\b\5\2\u0093\u0094\7\n\2\2\u0094\u0095\7\32\2\2\u0095\u0096\7"+
		"\t\2\2\u0096\u0097\5\b\5\2\u0097\u0098\7\n\2\2\u0098\u0099\b\b\1\2\u0099"+
		"\u00b6\3\2\2\2\u009a\u009b\7\33\2\2\u009b\u009c\7\7\2\2\u009c\u009d\5"+
		"\b\5\2\u009d\u009e\7\b\2\2\u009e\u009f\b\b\1\2\u009f\u00b6\3\2\2\2\u00a0"+
		"\u00a1\7(\2\2\u00a1\u00b3\b\b\1\2\u00a2\u00a3\7\7\2\2\u00a3\u00af\b\b"+
		"\1\2\u00a4\u00a5\5\b\5\2\u00a5\u00ac\b\b\1\2\u00a6\u00a7\7\r\2\2\u00a7"+
		"\u00a8\5\b\5\2\u00a8\u00a9\b\b\1\2\u00a9\u00ab\3\2\2\2\u00aa\u00a6\3\2"+
		"\2\2\u00ab\u00ae\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad"+
		"\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00a4\3\2\2\2\u00af\u00b0\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\7\b\2\2\u00b2\u00b4\b\b\1\2\u00b3"+
		"\u00a2\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b6\3\2\2\2\u00b5\u0083\3\2"+
		"\2\2\u00b5\u0085\3\2\2\2\u00b5\u0087\3\2\2\2\u00b5\u0089\3\2\2\2\u00b5"+
		"\u008e\3\2\2\2\u00b5\u009a\3\2\2\2\u00b5\u00a0\3\2\2\2\u00b6\17\3\2\2"+
		"\2\21\32<?GLRXbm~\u0080\u00ac\u00af\u00b3\u00b5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}