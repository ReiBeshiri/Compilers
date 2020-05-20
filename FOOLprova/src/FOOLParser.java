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
		RULE_prog = 0, RULE_declist = 1, RULE_exp = 2, RULE_term = 3, RULE_factor = 4, 
		RULE_value = 5, RULE_hotype = 6, RULE_type = 7, RULE_arrow = 8;
	public static final String[] ruleNames = {
		"prog", "declist", "exp", "term", "factor", "value", "hotype", "type", 
		"arrow"
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
			setState(28);
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
				setState(19); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgNode(((ProgContext)_localctx).e.ast);
				}
				break;
			case LET:
				{
				setState(22); match(LET);
				setState(23); ((ProgContext)_localctx).d = declist();
				setState(24); match(IN);
				setState(25); ((ProgContext)_localctx).e = exp();
				((ProgContext)_localctx).ast =  new ProgLetInNode(((ProgContext)_localctx).d.astlist,((ProgContext)_localctx).e.ast);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			symTable.remove(nestingLevel);
			setState(31); match(SEMIC);
			setState(32); match(EOF);
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
		public HotypeContext t;
		public ExpContext e;
		public Token fid;
		public HotypeContext fty;
		public Token id;
		public HotypeContext ty;
		public DeclistContext d;
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
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
		public HotypeContext hotype(int i) {
			return getRuleContext(HotypeContext.class,i);
		}
		public TerminalNode SEMIC(int i) {
			return getToken(FOOLParser.SEMIC, i);
		}
		public List<TerminalNode> VAR() { return getTokens(FOOLParser.VAR); }
		public TerminalNode LPAR(int i) {
			return getToken(FOOLParser.LPAR, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
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
		public List<HotypeContext> hotype() {
			return getRuleContexts(HotypeContext.class);
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
			setState(82); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(35); match(VAR);
					setState(36); ((DeclistContext)_localctx).i = match(ID);
					setState(37); match(COLON);
					setState(38); ((DeclistContext)_localctx).t = hotype();
					setState(39); match(ASS);
					setState(40); ((DeclistContext)_localctx).e = exp();

						        	VarNode variable = new VarNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast,((DeclistContext)_localctx).e.ast);  
						            _localctx.astlist.add(variable);                                 
						            HashMap<String,STentry> hm = symTable.get(nestingLevel);
						            if ( hm.put((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),new STentry(nestingLevel,((DeclistContext)_localctx).t.ast,offset--)) != null  ) {
						              System.out.println("Var id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
						              stErrors++; 
						            }
						            if(variable.getSymType() instanceof ArrowTypeNode){ //una var di tipo arrowtype node ha doppio offset
					                	  offset--;
					                }   
					            
					}
					break;
				case FUN:
					{
					setState(43); match(FUN);
					setState(44); ((DeclistContext)_localctx).i = match(ID);
					setState(45); match(COLON);
					setState(46); ((DeclistContext)_localctx).t = hotype();
						//inserimento di ID nella symtable
						            //Creo un nodo funzione
						            FunNode functionNode = new FunNode((((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null),((DeclistContext)_localctx).t.ast); 
						            //Aggiungo il nodo funzione all'ast   
						            _localctx.astlist.add(functionNode);
						            //Mi faccio dare la SymTable dello stesso livello in cui viene dichiarata la funzione                              
						            HashMap<String,STentry> SymTableThisNestLev = symTable.get(nestingLevel);
						            //Creo array per i parametri
						            ArrayList<Node> parTypes = new ArrayList<Node>();
						            //Controllo se esiste gi� la stessa funzione nella SymbolTable (il controllo restituisce null se NON c'� una funzione uguale)
						            if ( SymTableThisNestLev.put( (((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null), new STentry(nestingLevel, new ArrowTypeNode(parTypes,((DeclistContext)_localctx).t.ast, true),offset)) != null  ) {
						               System.out.println("Fun id "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getText():null)+" at line "+(((DeclistContext)_localctx).i!=null?((DeclistContext)_localctx).i.getLine():0)+" already declared");
						               stErrors++; 
						            }
						            offset-=2; //tutte le funz sono di tipo arrowtypeNode quindi occupano offset doppio
					                //Aggiorno il NestingLevel siccome sto entrando in una funzione 
					                nestingLevel++;
					                //Creo la HashMap per la nuova funzone
					                HashMap<String,STentry> hashMapNewFunction = new HashMap<String,STentry> ();
					                symTable.add(hashMapNewFunction);
					           
					setState(48); match(LPAR);
					int paroffset=1;
					setState(65);
					_la = _input.LA(1);
					if (_la==ID) {
						{
						setState(50); ((DeclistContext)_localctx).fid = match(ID);
						setState(51); match(COLON);
						setState(52); ((DeclistContext)_localctx).fty = hotype();
						 
						           		//Aggiunge alla lista dei parametri il nodo relativo ad un parametro
						               	parTypes.add(((DeclistContext)_localctx).fty.ast);
						               	//creo il nodo di un parametro
						                ParNode funParameter = new ParNode((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null),((DeclistContext)_localctx).fty.ast);
						                //aggiungo alla lista dei parametri della funzione un parametro
						                functionNode.addPar(funParameter);
						                //Aggiungo alla Hash Map le informazioni del parametro
						                	if ( hashMapNewFunction.put((((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null), new STentry(nestingLevel,((DeclistContext)_localctx).fty.ast,paroffset++)) != null  ) { //Se c'� un parametro con lo stesso nome c'� un errore
						                   		System.out.println("Parameter id "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getText():null)+" at line "+(((DeclistContext)_localctx).fid!=null?((DeclistContext)_localctx).fid.getLine():0)+" already declared");
						                   		stErrors++; 
						                	}
						                	if(funParameter.getSymType() instanceof ArrowTypeNode){
						                	  paroffset++;
						                	} 
						                	//System.out.println("HA FATTO LA STAMPA");
						            	
						setState(62);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(54); match(COMMA);
							setState(55); ((DeclistContext)_localctx).id = match(ID);
							setState(56); match(COLON);
							setState(57); ((DeclistContext)_localctx).ty = hotype();

							                	//Faccio la stessa cosa fatta sopra per ogni parametro della funzione
							                    parTypes.add(((DeclistContext)_localctx).ty.ast);
							                    ParNode otherFunParameter = new ParNode((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null),((DeclistContext)_localctx).ty.ast);
							                    functionNode.addPar(otherFunParameter);
							                    if (hashMapNewFunction.put((((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null), new STentry(nestingLevel,((DeclistContext)_localctx).ty.ast,paroffset++)) != null  ) {
							                     	System.out.println("Parameter id "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getText():null)+" at line "+(((DeclistContext)_localctx).id!=null?((DeclistContext)_localctx).id.getLine():0)+" already declared");
							                     	stErrors++; 
							                    }
							                    if(otherFunParameter.getSymType() instanceof ArrowTypeNode){
							                	  paroffset++;
							                	}
							                 
							}
							}
							setState(64);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(67); match(RPAR);
					setState(73);
					_la = _input.LA(1);
					if (_la==LET) {
						{
						setState(68); match(LET);
						setState(69); ((DeclistContext)_localctx).d = declist();
						setState(70); match(IN);
						functionNode.addDec(((DeclistContext)_localctx).d.astlist);
						}
					}

					setState(75); ((DeclistContext)_localctx).e = exp();

					              functionNode.addBody(((DeclistContext)_localctx).e.ast);
					              //rimuovere la hashmap corrente poich� esco dallo scope               
					              symTable.remove(nestingLevel); //COSAAAAAA???
					              nestingLevel--;
					           
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(80); match(SEMIC);
				}
				}
				setState(84); 
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
		enterRule(_localctx, 4, RULE_exp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); ((ExpContext)_localctx).f = term();
			((ExpContext)_localctx).ast =  ((ExpContext)_localctx).f.ast;
			setState(102);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << OR))) != 0)) {
				{
				setState(100);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(88); match(PLUS);
					setState(89); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new PlusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				case MINUS:
					{
					setState(92); match(MINUS);
					setState(93); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new MinusNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				case OR:
					{
					setState(96); match(OR);
					setState(97); ((ExpContext)_localctx).l = term();
					((ExpContext)_localctx).ast =  new OrNode (_localctx.ast,((ExpContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(104);
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
		enterRule(_localctx, 6, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105); ((TermContext)_localctx).f = factor();
			((TermContext)_localctx).ast =  ((TermContext)_localctx).f.ast;
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << TIMES) | (1L << DIV) | (1L << AND))) != 0)) {
				{
				setState(119);
				switch (_input.LA(1)) {
				case TIMES:
					{
					setState(107); match(TIMES);
					setState(108); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new TimesNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				case DIV:
					{
					setState(111); match(DIV);
					setState(112); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new DivNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				case AND:
					{
					setState(115); match(AND);
					setState(116); ((TermContext)_localctx).l = factor();
					((TermContext)_localctx).ast =  new AndNode (_localctx.ast,((TermContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(123);
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
		enterRule(_localctx, 8, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124); ((FactorContext)_localctx).f = value();
			((FactorContext)_localctx).ast =  ((FactorContext)_localctx).f.ast;
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GE) | (1L << LE) | (1L << EQ))) != 0)) {
				{
				setState(138);
				switch (_input.LA(1)) {
				case EQ:
					{
					setState(126); match(EQ);
					setState(127); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new EqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case LE:
					{
					setState(130); match(LE);
					setState(131); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new LessEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				case GE:
					{
					setState(134); match(GE);
					setState(135); ((FactorContext)_localctx).l = value();
					((FactorContext)_localctx).ast =  new GreatEqualNode (_localctx.ast,((FactorContext)_localctx).l.ast);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(142);
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
		enterRule(_localctx, 10, RULE_value);
		int _la;
		try {
			setState(199);
			switch (_input.LA(1)) {
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); ((ValueContext)_localctx).n = match(INTEGER);
				((ValueContext)_localctx).ast =  new IntNode(Integer.parseInt((((ValueContext)_localctx).n!=null?((ValueContext)_localctx).n.getText():null)));
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(145); match(TRUE);
				((ValueContext)_localctx).ast =  new BoolNode(true);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(147); match(FALSE);
				((ValueContext)_localctx).ast =  new BoolNode(false);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(149); match(LPAR);
				setState(150); ((ValueContext)_localctx).e = exp();
				setState(151); match(RPAR);
				((ValueContext)_localctx).ast =  ((ValueContext)_localctx).e.ast;
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 5);
				{
				setState(154); match(IF);
				setState(155); ((ValueContext)_localctx).x = exp();
				setState(156); match(THEN);
				setState(157); match(CLPAR);
				setState(158); ((ValueContext)_localctx).y = exp();
				setState(159); match(CRPAR);
				setState(160); match(ELSE);
				setState(161); match(CLPAR);
				setState(162); ((ValueContext)_localctx).z = exp();
				setState(163); match(CRPAR);
				((ValueContext)_localctx).ast =  new IfNode(((ValueContext)_localctx).x.ast,((ValueContext)_localctx).y.ast,((ValueContext)_localctx).z.ast);
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 6);
				{
				setState(166); match(NOT);
				setState(167); match(LPAR);
				setState(168); ((ValueContext)_localctx).e = exp();
				setState(169); match(RPAR);
				((ValueContext)_localctx).ast =  new NotNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 7);
				{
				setState(172); match(PRINT);
				setState(173); match(LPAR);
				setState(174); ((ValueContext)_localctx).e = exp();
				setState(175); match(RPAR);
				((ValueContext)_localctx).ast =  new PrintNode(((ValueContext)_localctx).e.ast);
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 8);
				{
				setState(178); ((ValueContext)_localctx).i = match(ID);
				//cercare la dichiarazione
				           int j=nestingLevel;
				           STentry entry=null; 
				           while (j>=0 && entry==null)
				             entry=(symTable.get(j--)).get((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)); //cerca se l'id esiste nella symTable (arraylist) e ritorna la STentry
				           if (entry==null) {
				             System.out.println("Id "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null)+" at line "+(((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getLine():0)+" not declared");
				             stErrors++; }               
					   ((ValueContext)_localctx).ast =  new IdNode((((ValueContext)_localctx).i!=null?((ValueContext)_localctx).i.getText():null),entry,nestingLevel);
				setState(197);
				_la = _input.LA(1);
				if (_la==LPAR) {
					{
					setState(180); match(LPAR);
					ArrayList<Node> arglist = new ArrayList<Node>();
					setState(193);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << NOT) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << PRINT) | (1L << INTEGER) | (1L << ID))) != 0)) {
						{
						setState(182); ((ValueContext)_localctx).a = exp();
						arglist.add(((ValueContext)_localctx).a.ast);
						setState(190);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==COMMA) {
							{
							{
							setState(184); match(COMMA);
							setState(185); ((ValueContext)_localctx).a = exp();
							arglist.add(((ValueContext)_localctx).a.ast);
							}
							}
							setState(192);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						}
					}

					setState(195); match(RPAR);
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

	public static class HotypeContext extends ParserRuleContext {
		public Node ast;
		public TypeContext t;
		public ArrowContext a;
		public ArrowContext arrow() {
			return getRuleContext(ArrowContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public HotypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_hotype; }
	}

	public final HotypeContext hotype() throws RecognitionException {
		HotypeContext _localctx = new HotypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_hotype);
		try {
			setState(207);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
				enterOuterAlt(_localctx, 1);
				{
				setState(201); ((HotypeContext)_localctx).t = type();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).t.ast;
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(204); ((HotypeContext)_localctx).a = arrow();
				((HotypeContext)_localctx).ast =  ((HotypeContext)_localctx).a.ast;
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
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(213);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(209); match(INT);
				((TypeContext)_localctx).ast = new IntTypeNode();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 2);
				{
				setState(211); match(BOOL);
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

	public static class ArrowContext extends ParserRuleContext {
		public Node ast;
		public HotypeContext h;
		public TypeContext t;
		public HotypeContext hotype(int i) {
			return getRuleContext(HotypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FOOLParser.COMMA); }
		public List<HotypeContext> hotype() {
			return getRuleContexts(HotypeContext.class);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(FOOLParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(FOOLParser.RPAR, 0); }
		public TerminalNode ARROW() { return getToken(FOOLParser.ARROW, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(FOOLParser.COMMA, i);
		}
		public ArrowContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrow; }
	}

	public final ArrowContext arrow() throws RecognitionException {
		ArrowContext _localctx = new ArrowContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arrow);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			ArrayList<Node> parArrowTypes = new ArrayList<Node>();
			setState(216); match(LPAR);
			setState(228);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LPAR) | (1L << INT) | (1L << BOOL))) != 0)) {
				{
				setState(217); ((ArrowContext)_localctx).h = hotype();

							parArrowTypes.add(((ArrowContext)_localctx).h.ast);
						
				setState(225);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(219); match(COMMA);
					setState(220); ((ArrowContext)_localctx).h = hotype();

								parArrowTypes.add(((ArrowContext)_localctx).h.ast);
							
					}
					}
					setState(227);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(230); match(RPAR);
			setState(231); match(ARROW);
			setState(232); ((ArrowContext)_localctx).t = type();

					((ArrowContext)_localctx).ast =  new ArrowTypeNode(parArrowTypes, ((ArrowContext)_localctx).t.ast, false);
				
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3+\u00ee\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2\37\n\2\3\2\3\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\7\3?\n\3\f\3\16\3B\13\3\5\3D\n\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\5\3L\n\3\3\3\3\3\3\3\5\3Q\n\3\3\3\3\3\6\3U\n\3\r\3\16\3V"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\7\4g\n\4\f\4"+
		"\16\4j\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7"+
		"\5z\n\5\f\5\16\5}\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\7\6\u008d\n\6\f\6\16\6\u0090\13\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\7\7\u00bf\n\7\f\7\16\7\u00c2\13\7\5\7\u00c4\n\7\3\7\3\7\5"+
		"\7\u00c8\n\7\5\7\u00ca\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00d2\n\b\3\t\3"+
		"\t\3\t\3\t\5\t\u00d8\n\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00e2\n\n"+
		"\f\n\16\n\u00e5\13\n\5\n\u00e7\n\n\3\n\3\n\3\n\3\n\3\n\3\n\2\2\13\2\4"+
		"\6\b\n\f\16\20\22\2\2\u0101\2\24\3\2\2\2\4$\3\2\2\2\6X\3\2\2\2\bk\3\2"+
		"\2\2\n~\3\2\2\2\f\u00c9\3\2\2\2\16\u00d1\3\2\2\2\20\u00d7\3\2\2\2\22\u00d9"+
		"\3\2\2\2\24\36\b\2\1\2\25\26\5\6\4\2\26\27\b\2\1\2\27\37\3\2\2\2\30\31"+
		"\7\34\2\2\31\32\5\4\3\2\32\33\7\35\2\2\33\34\5\6\4\2\34\35\b\2\1\2\35"+
		"\37\3\2\2\2\36\25\3\2\2\2\36\30\3\2\2\2\37 \3\2\2\2 !\b\2\1\2!\"\7\13"+
		"\2\2\"#\7\2\2\3#\3\3\2\2\2$T\b\3\1\2%&\7\36\2\2&\'\7(\2\2\'(\7\f\2\2("+
		")\5\16\b\2)*\7\25\2\2*+\5\6\4\2+,\b\3\1\2,Q\3\2\2\2-.\7\37\2\2./\7(\2"+
		"\2/\60\7\f\2\2\60\61\5\16\b\2\61\62\b\3\1\2\62\63\7\7\2\2\63C\b\3\1\2"+
		"\64\65\7(\2\2\65\66\7\f\2\2\66\67\5\16\b\2\67@\b\3\1\289\7\r\2\29:\7("+
		"\2\2:;\7\f\2\2;<\5\16\b\2<=\b\3\1\2=?\3\2\2\2>8\3\2\2\2?B\3\2\2\2@>\3"+
		"\2\2\2@A\3\2\2\2AD\3\2\2\2B@\3\2\2\2C\64\3\2\2\2CD\3\2\2\2DE\3\2\2\2E"+
		"K\7\b\2\2FG\7\34\2\2GH\5\4\3\2HI\7\35\2\2IJ\b\3\1\2JL\3\2\2\2KF\3\2\2"+
		"\2KL\3\2\2\2LM\3\2\2\2MN\5\6\4\2NO\b\3\1\2OQ\3\2\2\2P%\3\2\2\2P-\3\2\2"+
		"\2QR\3\2\2\2RS\7\13\2\2SU\3\2\2\2TP\3\2\2\2UV\3\2\2\2VT\3\2\2\2VW\3\2"+
		"\2\2W\5\3\2\2\2XY\5\b\5\2Yh\b\4\1\2Z[\7\3\2\2[\\\5\b\5\2\\]\b\4\1\2]g"+
		"\3\2\2\2^_\7\4\2\2_`\5\b\5\2`a\b\4\1\2ag\3\2\2\2bc\7\17\2\2cd\5\b\5\2"+
		"de\b\4\1\2eg\3\2\2\2fZ\3\2\2\2f^\3\2\2\2fb\3\2\2\2gj\3\2\2\2hf\3\2\2\2"+
		"hi\3\2\2\2i\7\3\2\2\2jh\3\2\2\2kl\5\n\6\2l{\b\5\1\2mn\7\5\2\2no\5\n\6"+
		"\2op\b\5\1\2pz\3\2\2\2qr\7\6\2\2rs\5\n\6\2st\b\5\1\2tz\3\2\2\2uv\7\20"+
		"\2\2vw\5\n\6\2wx\b\5\1\2xz\3\2\2\2ym\3\2\2\2yq\3\2\2\2yu\3\2\2\2z}\3\2"+
		"\2\2{y\3\2\2\2{|\3\2\2\2|\t\3\2\2\2}{\3\2\2\2~\177\5\f\7\2\177\u008e\b"+
		"\6\1\2\u0080\u0081\7\24\2\2\u0081\u0082\5\f\7\2\u0082\u0083\b\6\1\2\u0083"+
		"\u008d\3\2\2\2\u0084\u0085\7\23\2\2\u0085\u0086\5\f\7\2\u0086\u0087\b"+
		"\6\1\2\u0087\u008d\3\2\2\2\u0088\u0089\7\22\2\2\u0089\u008a\5\f\7\2\u008a"+
		"\u008b\b\6\1\2\u008b\u008d\3\2\2\2\u008c\u0080\3\2\2\2\u008c\u0084\3\2"+
		"\2\2\u008c\u0088\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e"+
		"\u008f\3\2\2\2\u008f\13\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\'\2"+
		"\2\u0092\u00ca\b\7\1\2\u0093\u0094\7\26\2\2\u0094\u00ca\b\7\1\2\u0095"+
		"\u0096\7\27\2\2\u0096\u00ca\b\7\1\2\u0097\u0098\7\7\2\2\u0098\u0099\5"+
		"\6\4\2\u0099\u009a\7\b\2\2\u009a\u009b\b\7\1\2\u009b\u00ca\3\2\2\2\u009c"+
		"\u009d\7\30\2\2\u009d\u009e\5\6\4\2\u009e\u009f\7\31\2\2\u009f\u00a0\7"+
		"\t\2\2\u00a0\u00a1\5\6\4\2\u00a1\u00a2\7\n\2\2\u00a2\u00a3\7\32\2\2\u00a3"+
		"\u00a4\7\t\2\2\u00a4\u00a5\5\6\4\2\u00a5\u00a6\7\n\2\2\u00a6\u00a7\b\7"+
		"\1\2\u00a7\u00ca\3\2\2\2\u00a8\u00a9\7\21\2\2\u00a9\u00aa\7\7\2\2\u00aa"+
		"\u00ab\5\6\4\2\u00ab\u00ac\7\b\2\2\u00ac\u00ad\b\7\1\2\u00ad\u00ca\3\2"+
		"\2\2\u00ae\u00af\7\33\2\2\u00af\u00b0\7\7\2\2\u00b0\u00b1\5\6\4\2\u00b1"+
		"\u00b2\7\b\2\2\u00b2\u00b3\b\7\1\2\u00b3\u00ca\3\2\2\2\u00b4\u00b5\7("+
		"\2\2\u00b5\u00c7\b\7\1\2\u00b6\u00b7\7\7\2\2\u00b7\u00c3\b\7\1\2\u00b8"+
		"\u00b9\5\6\4\2\u00b9\u00c0\b\7\1\2\u00ba\u00bb\7\r\2\2\u00bb\u00bc\5\6"+
		"\4\2\u00bc\u00bd\b\7\1\2\u00bd\u00bf\3\2\2\2\u00be\u00ba\3\2\2\2\u00bf"+
		"\u00c2\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c4\3\2"+
		"\2\2\u00c2\u00c0\3\2\2\2\u00c3\u00b8\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c6\7\b\2\2\u00c6\u00c8\b\7\1\2\u00c7\u00b6\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u0091\3\2\2\2\u00c9"+
		"\u0093\3\2\2\2\u00c9\u0095\3\2\2\2\u00c9\u0097\3\2\2\2\u00c9\u009c\3\2"+
		"\2\2\u00c9\u00a8\3\2\2\2\u00c9\u00ae\3\2\2\2\u00c9\u00b4\3\2\2\2\u00ca"+
		"\r\3\2\2\2\u00cb\u00cc\5\20\t\2\u00cc\u00cd\b\b\1\2\u00cd\u00d2\3\2\2"+
		"\2\u00ce\u00cf\5\22\n\2\u00cf\u00d0\b\b\1\2\u00d0\u00d2\3\2\2\2\u00d1"+
		"\u00cb\3\2\2\2\u00d1\u00ce\3\2\2\2\u00d2\17\3\2\2\2\u00d3\u00d4\7$\2\2"+
		"\u00d4\u00d8\b\t\1\2\u00d5\u00d6\7%\2\2\u00d6\u00d8\b\t\1\2\u00d7\u00d3"+
		"\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d8\21\3\2\2\2\u00d9\u00da\b\n\1\2\u00da"+
		"\u00e6\7\7\2\2\u00db\u00dc\5\16\b\2\u00dc\u00e3\b\n\1\2\u00dd\u00de\7"+
		"\r\2\2\u00de\u00df\5\16\b\2\u00df\u00e0\b\n\1\2\u00e0\u00e2\3\2\2\2\u00e1"+
		"\u00dd\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2"+
		"\2\2\u00e4\u00e7\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6\u00db\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00e9\7\b\2\2\u00e9\u00ea\7&"+
		"\2\2\u00ea\u00eb\5\20\t\2\u00eb\u00ec\b\n\1\2\u00ec\23\3\2\2\2\26\36@"+
		"CKPVfhy{\u008c\u008e\u00c0\u00c3\u00c7\u00c9\u00d1\u00d7\u00e3\u00e6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}