grammar FOOL; 

@header{
import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
}
 
@parser::members{
int stErrors=0;

private int nestingLevel = 0;
private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
//livello ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
}

@lexer::members {
int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
prog returns [Node ast]
	: {HashMap<String,STentry> hm = new HashMap<String,STentry> ();
       symTable.add(hm);}          
	  ( e=exp 	
        {$ast = new ProgNode($e.ast);} 
      | LET d=declist IN e=exp  
        {$ast = new ProgLetInNode($d.astlist,$e.ast);}      
	  ) 
	  {symTable.remove(nestingLevel);}
      SEMIC EOF ;

declist	returns [ArrayList<Node> astlist]        
	: {$astlist= new ArrayList<Node>() ;
	   int offset=-2; }      
	  ( (
            VAR i=ID COLON t=hotype ASS e=exp 
	        {
	        	VarNode variable = new VarNode($i.text,$t.ast,$e.ast);  
	            $astlist.add(variable);                                 
	            HashMap<String,STentry> hm = symTable.get(nestingLevel);
	            if ( hm.put($i.text,new STentry(nestingLevel,$t.ast,offset--)) != null  ) {
	              System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
	              stErrors++; 
	            }
	            if(variable.getSymType() instanceof ArrowTypeNode){ //una var di tipo arrowtype node ha doppio offset
                	  offset--;
                }   
            } 
      |  
            FUN i=ID COLON t=type //TODO SAREBBE TYPE MA DA ERROR (???)
	        {	//inserimento di ID nella symtable
	            //Creo un nodo funzione
	            FunNode functionNode = new FunNode($i.text,$t.ast); 
	            //Aggiungo il nodo funzione all'ast   
	            $astlist.add(functionNode);
	            //Mi faccio dare la SymTable dello stesso livello in cui viene dichiarata la funzione                              
	            HashMap<String,STentry> SymTableThisNestLev = symTable.get(nestingLevel);
	            //Creo array per i parametri
	            ArrayList<Node> parTypes = new ArrayList<Node>();
	            //Controllo se esiste già la stessa funzione nella SymbolTable (il controllo restituisce null se NON c'è una funzione uguale)
	            if ( SymTableThisNestLev.put( $i.text, new STentry(nestingLevel, new ArrowTypeNode(parTypes,$t.ast, true),offset)) != null  ) {
	               System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
	               stErrors++; 
	            }
	            offset-=2; //tutte le funz sono di tipo arrowtypeNode quindi occupano offset doppio
                //Aggiorno il NestingLevel siccome sto entrando in una funzione 
                nestingLevel++;
                //Creo la HashMap per la nuova funzone
                HashMap<String,STentry> hashMapNewFunction = new HashMap<String,STentry> ();
                symTable.add(hashMapNewFunction);
           } 
           LPAR {int paroffset=1;} 
           (fid=ID COLON fty=hotype
           { 
           		//Aggiunge alla lista dei parametri il nodo relativo ad un parametro
               	parTypes.add($fty.ast);
               	//creo il nodo di un parametro
                ParNode funParameter = new ParNode($fid.text,$fty.ast);
                //aggiungo alla lista dei parametri della funzione un parametro
                functionNode.addPar(funParameter);
                //Aggiungo alla Hash Map le informazioni del parametro
                	if(funParameter.getSymType() instanceof ArrowTypeNode){
                	  paroffset++;
                	}
                	if ( hashMapNewFunction.put($fid.text, new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ) { //Se c'è un parametro con lo stesso nome c'è un errore
                   		System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
                   		stErrors++; 
                	}
                	//System.out.println("HA FATTO LA STAMPA");
            	}
                (COMMA id=ID COLON ty=hotype {
                	//Faccio la stessa cosa fatta sopra per ogni parametro della funzione
                    parTypes.add($ty.ast);
                    ParNode otherFunParameter = new ParNode($id.text,$ty.ast);
                    functionNode.addPar(otherFunParameter);
                    if(otherFunParameter.getSymType() instanceof ArrowTypeNode){
                	  paroffset++;
                	}
                    if (hashMapNewFunction.put($id.text, new STentry(nestingLevel,$ty.ast,paroffset++)) != null  ) {
                     	System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
                     	stErrors++; 
                    }
                 } 
                 )*
           )? 
           RPAR (LET d=declist IN {functionNode.addDec($d.astlist);})? e=exp
           {
              functionNode.addBody($e.ast);
              //rimuovere la hashmap corrente poiché esco dallo scope               
              symTable.remove(nestingLevel); //COSAAAAAA???
              nestingLevel--;
           }
      ) SEMIC
    )+          
	;

exp	returns [Node ast]
 	: f=term {$ast= $f.ast;}
 	    (PLUS l=term
 	     {$ast= new PlusNode ($ast,$l.ast);}
 	     | MINUS l=term
 	     {$ast= new MinusNode ($ast,$l.ast);}
 	     | OR l = term
 	     {$ast= new OrNode ($ast,$l.ast);}
 	    )*
 	;
 	
term	returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    (TIMES l=factor
	     {$ast= new TimesNode ($ast,$l.ast);}
	     | DIV l=factor
	     {$ast= new DivNode ($ast,$l.ast);}
	     | AND l = factor
	     {$ast= new AndNode ($ast,$l.ast);}
	    )*
	;
	
factor	returns [Node ast]
	: f=value {$ast= $f.ast;}
	    (EQ l=value 
	     {$ast= new EqualNode ($ast,$l.ast);}
	     | LE l=value 
	     {$ast= new LessEqualNode ($ast,$l.ast);}
	     | GE l=value 
	     {$ast= new GreatEqualNode ($ast,$l.ast);}
	    )*
 	;	 	
 
value	returns [Node ast]
	: n=INTEGER   
	  {$ast= new IntNode(Integer.parseInt($n.text));}  
	| TRUE 
	  {$ast= new BoolNode(true);}  
	| FALSE
	  {$ast= new BoolNode(false);}  
	| LPAR e=exp RPAR
	  {$ast= $e.ast;}  
	| IF x=exp THEN CLPAR y=exp CRPAR 
		   ELSE CLPAR z=exp CRPAR 
	  {$ast= new IfNode($x.ast,$y.ast,$z.ast);}	
	| NOT LPAR e=exp RPAR 
	  {$ast= new NotNode($e.ast);}
	| PRINT LPAR e=exp RPAR	
	  {$ast= new PrintNode($e.ast);}
	| i=ID 
	  {//cercare la dichiarazione
           int j=nestingLevel;
           STentry entry=null; 
           while (j>=0 && entry==null)
             entry=(symTable.get(j--)).get($i.text); //cerca se l'id esiste nella symTable (arraylist) e ritorna la STentry
           if (entry==null) {
             System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
             stErrors++; }               
	   $ast= new IdNode($i.text,entry,nestingLevel);} 
	   ( LPAR
	   	 {ArrayList<Node> arglist = new ArrayList<Node>();} 
	   	 ( a=exp {arglist.add($a.ast);} 
	   	 	(COMMA a=exp {arglist.add($a.ast);} )*
	   	 )? 
	   	 RPAR
	   	 {$ast= new CallNode($i.text,entry,arglist,nestingLevel);} //ATTENZIONEEEEEEEEE
	   )?
 	; 
 	
hotype  returns [Node ast]
		: t=type {$ast = $t.ast;} 
        | a=arrow {$ast = $a.ast;}
        ;
	
type	returns [Node ast]
  : INT  {$ast=new IntTypeNode();}
  | BOOL {$ast=new BoolTypeNode();} 
  //| ID   {$ast=new IdNode();} //controllo se id esiste -> x:fun
	;	

arrow returns [Node ast] : 
		{ArrayList<Node> parArrowTypes = new ArrayList<Node>();} 
	LPAR ( h = hotype
		{
			parArrowTypes.add($h.ast);
		} 
	( COMMA h = hotype
		{
			parArrowTypes.add($h.ast);
		}
	)* 
	)? RPAR ARROW t=type {
		$ast = new ArrowTypeNode(parArrowTypes, $t.ast, false);
	} ;
  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

PLUS  	: '+' ;
MINUS   : '-' ;
TIMES   : '*' ;
DIV 	: '/' ;
LPAR	: '(' ;
RPAR	: ')' ;
CLPAR	: '{' ;
CRPAR	: '}' ;
SEMIC 	: ';' ;
COLON   : ':' ; 
COMMA	: ',' ;
DOT	    : '.' ;
OR	    : '||';
AND	    : '&&';
NOT	    : '!' ;
GE	    : '>=' ;
LE	    : '<=' ;
EQ	    : '==' ;	
ASS	    : '=' ;
TRUE	: 'true' ;
FALSE	: 'false' ;
IF	    : 'if' ;
THEN	: 'then';
ELSE	: 'else' ;
PRINT	: 'print' ;
LET     : 'let' ;	
IN      : 'in' ;	
VAR     : 'var' ;
FUN	    : 'fun' ; 
CLASS	: 'class' ; 
EXTENDS : 'extends' ;	
NEW 	: 'new' ;	
NULL    : 'null' ;	  
INT	    : 'int' ;
BOOL	: 'bool' ;
ARROW   : '->' ; 	
INTEGER : '0' | ('-')?(('1'..'9')('0'..'9')*) ; 

ID  	: ('a'..'z'|'A'..'Z')('a'..'z' | 'A'..'Z' | '0'..'9')* ;


WHITESP  : ( '\t' | ' ' | '\r' | '\n' )+    -> channel(HIDDEN) ;

COMMENT : '/*' (.)*? '*/' -> channel(HIDDEN) ;
 
ERR   	 : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
