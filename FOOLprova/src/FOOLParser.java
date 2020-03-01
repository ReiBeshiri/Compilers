// Generated from FOOL.g4 by ANTLR 4.4

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
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, TIMES=3, DIV=4, LPAR=5, RPAR=6, CLPAR=7, CRPAR=8, SEMIC=9, 
		COLON=10, COMMA=11, DOT=12, OR=13, AND=14, NOT=15, GE=16, LE=17, EQ=18, 
		ASS=19, TRUE=20, FALSE=21, IF=22, THEN=23, ELSE=24, PRINT=25, LET=26, 
		IN=27, VAR=28, FUN=29, CLASS=30, EXTENDS=31, NEW=32, NULL=33, INT=34, 
		BOOL=35, ARROW=36, INTEGER=37, ID=38, WHITESP=39, COMMENT=40, ERR=41;
	public static final String[] tokenNames = {
		"<INVALID>", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'{'", "'}'", "';'", 
		"':'", "','", "'.'", "'||'", "'&&'", "'!'", "'>='", "'<='", "'=='", "'='", 
		"'true'", "'false'", "'if'", "'then'", "'else'", "'print'", "'let'", "'in'", 
		"'var'", "'fun'", "'class'", "'extends'", "'new'", "'null'", "'int'", 
		"'bool'", "'->'", "INTEGER", "ID", "WHITESP", "COMMENT", "ERR"
	};
	public static final int
		RULE_prog = 0, RULE_declist = 1, RULE_type = 2, RULE_exp = 3, RULE_term = 4, 
		RULE_factor = 5, RULE_value = 6;
	public static final String[] ruleNames = {
		"prog", "declist", "type", "exp", "term", "factor", "value"
	};

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

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
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode SEMIC() { return getToken(FOOLParser.SEMIC, 0); }
		public TerminalNode EOF() { return getToken(FOOLParser.EOF, 0); }
		public TerminalNode LET() { return getToken(FOOLParser.LET, 0); }
		public TerminalNode IN() { return getToken(FOOLParser.IN, 0); }
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
			switch (_input.LA(1)) {
			case LPAR:
			case NOT:
			case TRUE:
			case FALSE:
			case IF:
			case PRINT:
			case INTEGER:
			case ID:
				{
				setState(15); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				{
				setState(18); match(LET);
				setState(19); ((ProgContext)_localctx).d = declist();
				setState(20); match(IN);
				setState(21); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(27); match(SEMIC);
			setState(28); match(EOF);
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
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(FOOLParser.ID, i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode RPAR(int i) {
			return getToken(FOOLParser.RPAR, i);
		}
		public List<TerminalNode> ID() { return getTokens(FOOLParser.ID); }
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TerminalNode LET(int i) {
			return getToken(FOOLParser.LET, i);
		}
		public List<DeclistContext> declist() {
			return getRuleContexts(DeclistContext.class);
		}
		public DeclistContext declist(int i) {
			return getRuleContext(DeclistContext.class,i);
		}
		public List<TerminalNode> COLON() { return getTokens(FOOLParser.COLON); }
		public TerminalNode FUN(int i) {
			return getToken(FOOLParser.FUN, i);
		}
		public TerminalNode VAR(int i) {
			return getToken(FOOLParser.VAR, i);
		}
		public List<TerminalNode> LPAR() { return getTokens(FOOLParser.LPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> IN() { return getTokens(FOOLParser.IN); }
		public List<TerminalNode> SEMIC() { return getTokens(FOOLParser.SEMIC); }
		public TerminalNode IN(int i) {
			return getToken(FOOLParser.IN, i);
		}
		public TerminalNode COLON(int i) {
			return getToken(FOOLParser.COLON, i);
		}
		public List<TerminalNode> RPAR() { return getTokens(FOOLParser.RPAR); }
		public List<TerminalNode> ASS() { return getTokens(FOOLParser.ASS); }
		public List<TerminalNode> FUN() { return getTokens(FOOLParser.FUN); }
		public List<TerminalNode> LET() { return getTokens(FOOLParser.LET); }
		public TerminalNode ASS(int i) {
			return getToken(FOOLParser.ASS, i);
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
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(31); match(VAR);
					setState(32); ((DeclistContext)_localctx).i = match(ID);
					setState(33); match(COLON);
					setState(34); ((DeclistContext)_localctx).t = type();
					setState(35); match(ASS);
					setState(36); ((DeclistContext)_localctx).e = exp();
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
					setState(39); match(FUN);
					setState(40); ((DeclistContext)_localctx).i = match(ID);
					setState(41); match(COLON);
					setState(42); ((DeclistContext)_localctx).t = type();
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
					                
					setState(44); match(LPAR);
					int paroffset=1;
					setState(61);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(46); ((DeclistContext)_localctx).fid = match(ID);
						setState(47); match(COLON);
						setState(48); ((DeclistContext)_localctx).fty = type();
						 
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
							setState(50); match(COMMA);
							setState(51); ((DeclistContext)_localctx).id = match(ID);
							setState(52); match(COLON);
							setState(53); ((DeclistContext)_localctx).ty = type();

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

					setState(63); match(RPAR);
					setState(69);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(64); match(LET);
						setState(65); ((DeclistContext)_localctx).d = declist();
						setState(66); match(IN);
						f.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(71); ((DeclistContext)_localctx).e = exp();
					f.addBody(((DeclistContext)_localctx).e.ast);
					               //rimuovere la hashmap corrente poich� esco dallo scope               
					               symTable.remove(nestingLevel--);    
					              
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(76); match(SEMIC);
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
		public TerminalNode BOOL() { return getToken(FOOLParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(FOOLParser.INT, 0); }
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
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82); match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(84); match(BOOL);
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
		public TerminalNode MINUS(int i) {
			return getToken(FOOLParser.MINUS, i);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(FOOLParser.PLUS); }
		public List<TerminalNode> MINUS() { return getTokens(FOOLParser.MINUS); }
		public List<TerminalNode> OR() { return getTokens(FOOLParser.OR); }
		public TerminalNode PLUS(int i) {
			return getToken(FOOLParser.PLUS, i);
		}
		public TerminalNode OR(int i) {
			return getToken(FOOLParser.OR, i);
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
			setState(88); ((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) {
				{
				setState(102);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(90); match(PLUS);
					setState(91); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				case MINUS:
					{
					setState(94); match(MINUS);
					setState(95); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new MinusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				case OR:
					{
					setState(98); match(OR);
					setState(99); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new OrNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(106);
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
		public TerminalNode AND(int i) {
			return getToken(FOOLParser.AND, i);
		}
		public TerminalNode TIMES(int i) {
			return getToken(FOOLParser.TIMES, i);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> TIMES() { return getTokens(FOOLParser.TIMES); }
		public List<TerminalNode> AND() { return getTokens(FOOLParser.AND); }
		public List<TerminalNode> DIV() { return getTokens(FOOLParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(FOOLParser.DIV, i);
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
			setState(107); ((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) {
				{
				setState(121);
				switch (_input.LA(1)) {
				case TIMES:
					{
					setState(109); match(TIMES);
					setState(110); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new TimesNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				case DIV:
					{
					setState(113); match(DIV);
					setState(114); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new DivNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				case AND:
					{
					setState(117); match(AND);
					setState(118); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new AndNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(125);
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
		public List<TerminalNode> GE() { return getTokens(FOOLParser.GE); }
		public TerminalNode GE(int i) {
			return getToken(FOOLParser.GE, i);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public TerminalNode EQ(int i) {
			return getToken(FOOLParser.EQ, i);
		}
		public TerminalNode LE(int i) {
			return getToken(FOOLParser.LE, i);
		}
		public List<TerminalNode> LE() { return getTokens(FOOLParser.LE); }
		public List<TerminalNode> EQ() { return getTokens(FOOLParser.EQ); }
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
			setState(126); ((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << EQ))) != 0)) {
				{
				setState(140);
				switch (_input.LA(1)) {
				case EQ:
					{
					setState(128); match(EQ);
					setState(129); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case LE:
					{
					setState(132); match(LE);
					setState(133); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new LessEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case GE:
					{
					setState(136); match(GE);
					setState(137); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new GreatEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(144);
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
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public TerminalNode ELSE() { return getToken(FOOLParser.ELSE, 0); }
		public TerminalNode IF() { return getToken(FOOLParser.IF, 0); }
		public TerminalNode PRINT() { return getToken(FOOLParser.PRINT, 0); }
		public TerminalNode INTEGER() { return getToken(FOOLParser.INTEGER, 0); }
		public TerminalNode FALSE() { return getToken(FOOLParser.FALSE, 0); }
		public List<TerminalNode> CRPAR() { return getTokens(FOOLParser.CRPAR); }
		public TerminalNode TRUE() { return getToken(FOOLParser.TRUE, 0); }
		public TerminalNode THEN() { return getToken(FOOLParser.THEN, 0); }
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public List<TerminalNode> CLPAR() { return getTokens(FOOLParser.CLPAR); }
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public TerminalNode NOT() { return getToken(FOOLParser.NOT, 0); }
		public TerminalNode ID() { return getToken(FOOLParser.ID, 0); }
		public TerminalNode CLPAR(int i) {
			return getToken(FOOLParser.CLPAR, i);
		}
		public TerminalNode CRPAR(int i) {
			return getToken(FOOLParser.CRPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
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
			setState(201);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(145); ((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(149); match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(151); match(LPAR);
				setState(152); ((ValueContext)_localctx).e = exp();
				setState(153); match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(156); match(IF);
				setState(157); ((ValueContext)_localctx).x = exp();
				setState(158); match(THEN);
				setState(159); match(CLPAR);
				setState(160); ((ValueContext)_localctx).y = exp();
				setState(161); match(CRPAR);
				setState(162); match(ELSE);
				setState(163); match(CLPAR);
				setState(164); ((ValueContext)_localctx).z = exp();
				setState(165); match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(168); match(NOT);
				setState(169); match(LPAR);
				setState(170); ((ValueContext)_localctx).e = exp();
				setState(171); match(RPAR);
				((ValueContext)_localctx).ast =  new NotNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(174); match(PRINT);
				setState(175); match(LPAR);
				setState(176); ((ValueContext)_localctx).e = exp();
				setState(177); match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(180); ((ValueContext)_localctx).i = match(ID);
				//cercare la dichiarazione
				           int j=nestingLevel;
				           STentry entry=null; 
				           while (j>=0 && entry==null)
				             entry=(symTable.get(j--)).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null));
				           if (entry==null) {
				             System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				             stErrors++; }               
					   ((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(199);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(182); match(LPAR);
					ArrayList<Node> arglist = new ArrayList<Node>();
					setState(195);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(184); ((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(192);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(186); match(COMMA);
							setState(187); ((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(194);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(197); match(RPAR);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00ce\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2\33\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\7\3;\n\3\f\3\16\3>\13\3\5\3@\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"H\n\3\3\3\3\3\3\3\5\3M\n\3\3\3\3\3\6\3Q\n\3\r\3\16\3R\3\4\3\4\3\4\3\4"+
		"\5\4Y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"i\n\5\f\5\16\5l\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\3\6\7\6|\n\6\f\6\16\6\177\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\7\7\u008f\n\7\f\7\16\7\u0092\13\7\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\7\b\u00c1\n\b\f\b\16\b\u00c4\13\b\5\b\u00c6\n"+
		"\b\3\b\3\b\5\b\u00ca\n\b\5\b\u00cc\n\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2\u00e0"+
		"\2\20\3\2\2\2\4 \3\2\2\2\6X\3\2\2\2\bZ\3\2\2\2\nm\3\2\2\2\f\u0080\3\2"+
		"\2\2\16\u00cb\3\2\2\2\20\32\b\2\1\2\21\22\5\b\5\2\22\23\b\2\1\2\23\33"+
		"\3\2\2\2\24\25\7\34\2\2\25\26\5\4\3\2\26\27\7\35\2\2\27\30\5\b\5\2\30"+
		"\31\b\2\1\2\31\33\3\2\2\2\32\21\3\2\2\2\32\24\3\2\2\2\33\34\3\2\2\2\34"+
		"\35\b\2\1\2\35\36\7\13\2\2\36\37\7\2\2\3\37\3\3\2\2\2 P\b\3\1\2!\"\7\36"+
		"\2\2\"#\7(\2\2#$\7\f\2\2$%\5\6\4\2%&\7\25\2\2&\'\5\b\5\2\'(\b\3\1\2(M"+
		"\3\2\2\2)*\7\37\2\2*+\7(\2\2+,\7\f\2\2,-\5\6\4\2-.\b\3\1\2./\7\7\2\2/"+
		"?\b\3\1\2\60\61\7(\2\2\61\62\7\f\2\2\62\63\5\6\4\2\63<\b\3\1\2\64\65\7"+
		"\r\2\2\65\66\7(\2\2\66\67\7\f\2\2\678\5\6\4\289\b\3\1\29;\3\2\2\2:\64"+
		"\3\2\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2><\3\2\2\2?\60\3\2\2\2"+
		"?@\3\2\2\2@A\3\2\2\2AG\7\b\2\2BC\7\34\2\2CD\5\4\3\2DE\7\35\2\2EF\b\3\1"+
		"\2FH\3\2\2\2GB\3\2\2\2GH\3\2\2\2HI\3\2\2\2IJ\5\b\5\2JK\b\3\1\2KM\3\2\2"+
		"\2L!\3\2\2\2L)\3\2\2\2MN\3\2\2\2NO\7\13\2\2OQ\3\2\2\2PL\3\2\2\2QR\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2S\5\3\2\2\2TU\7$\2\2UY\b\4\1\2VW\7%\2\2WY\b\4"+
		"\1\2XT\3\2\2\2XV\3\2\2\2Y\7\3\2\2\2Z[\5\n\6\2[j\b\5\1\2\\]\7\3\2\2]^\5"+
		"\n\6\2^_\b\5\1\2_i\3\2\2\2`a\7\4\2\2ab\5\n\6\2bc\b\5\1\2ci\3\2\2\2de\7"+
		"\17\2\2ef\5\n\6\2fg\b\5\1\2gi\3\2\2\2h\\\3\2\2\2h`\3\2\2\2hd\3\2\2\2i"+
		"l\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\t\3\2\2\2lj\3\2\2\2mn\5\f\7\2n}\b\6\1\2"+
		"op\7\5\2\2pq\5\f\7\2qr\b\6\1\2r|\3\2\2\2st\7\6\2\2tu\5\f\7\2uv\b\6\1\2"+
		"v|\3\2\2\2wx\7\20\2\2xy\5\f\7\2yz\b\6\1\2z|\3\2\2\2{o\3\2\2\2{s\3\2\2"+
		"\2{w\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\13\3\2\2\2\177}\3\2\2\2"+
		"\u0080\u0081\5\16\b\2\u0081\u0090\b\7\1\2\u0082\u0083\7\24\2\2\u0083\u0084"+
		"\5\16\b\2\u0084\u0085\b\7\1\2\u0085\u008f\3\2\2\2\u0086\u0087\7\23\2\2"+
		"\u0087\u0088\5\16\b\2\u0088\u0089\b\7\1\2\u0089\u008f\3\2\2\2\u008a\u008b"+
		"\7\22\2\2\u008b\u008c\5\16\b\2\u008c\u008d\b\7\1\2\u008d\u008f\3\2\2\2"+
		"\u008e\u0082\3\2\2\2\u008e\u0086\3\2\2\2\u008e\u008a\3\2\2\2\u008f\u0092"+
		"\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\r\3\2\2\2\u0092"+
		"\u0090\3\2\2\2\u0093\u0094\7\'\2\2\u0094\u00cc\b\b\1\2\u0095\u0096\7\26"+
		"\2\2\u0096\u00cc\b\b\1\2\u0097\u0098\7\27\2\2\u0098\u00cc\b\b\1\2\u0099"+
		"\u009a\7\7\2\2\u009a\u009b\5\b\5\2\u009b\u009c\7\b\2\2\u009c\u009d\b\b"+
		"\1\2\u009d\u00cc\3\2\2\2\u009e\u009f\7\30\2\2\u009f\u00a0\5\b\5\2\u00a0"+
		"\u00a1\7\31\2\2\u00a1\u00a2\7\t\2\2\u00a2\u00a3\5\b\5\2\u00a3\u00a4\7"+
		"\n\2\2\u00a4\u00a5\7\32\2\2\u00a5\u00a6\7\t\2\2\u00a6\u00a7\5\b\5\2\u00a7"+
		"\u00a8\7\n\2\2\u00a8\u00a9\b\b\1\2\u00a9\u00cc\3\2\2\2\u00aa\u00ab\7\21"+
		"\2\2\u00ab\u00ac\7\7\2\2\u00ac\u00ad\5\b\5\2\u00ad\u00ae\7\b\2\2\u00ae"+
		"\u00af\b\b\1\2\u00af\u00cc\3\2\2\2\u00b0\u00b1\7\33\2\2\u00b1\u00b2\7"+
		"\7\2\2\u00b2\u00b3\5\b\5\2\u00b3\u00b4\7\b\2\2\u00b4\u00b5\b\b\1\2\u00b5"+
		"\u00cc\3\2\2\2\u00b6\u00b7\7(\2\2\u00b7\u00c9\b\b\1\2\u00b8\u00b9\7\7"+
		"\2\2\u00b9\u00c5\b\b\1\2\u00ba\u00bb\5\b\5\2\u00bb\u00c2\b\b\1\2\u00bc"+
		"\u00bd\7\r\2\2\u00bd\u00be\5\b\5\2\u00be\u00bf\b\b\1\2\u00bf\u00c1\3\2"+
		"\2\2\u00c0\u00bc\3\2\2\2\u00c1\u00c4\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00ba\3\2"+
		"\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\7\b\2\2\u00c8"+
		"\u00ca\b\b\1\2\u00c9\u00b8\3\2\2\2\u00c9\u00ca\3\2\2\2\u00ca\u00cc\3\2"+
		"\2\2\u00cb\u0093\3\2\2\2\u00cb\u0095\3\2\2\2\u00cb\u0097\3\2\2\2\u00cb"+
		"\u0099\3\2\2\2\u00cb\u009e\3\2\2\2\u00cb\u00aa\3\2\2\2\u00cb\u00b0\3\2"+
		"\2\2\u00cb\u00b6\3\2\2\2\u00cc\17\3\2\2\2\23\32<?GLRXhj{}\u008e\u0090"+
		"\u00c2\u00c5\u00c9\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}