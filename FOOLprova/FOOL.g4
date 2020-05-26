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
//il livello d'ambiente con dichiarazioni piu' esterno è 0 (prima posizione ArrayList) invece che 1 (slides)
//il "fronte" della lista di tabelle è symTable.get(nestingLevel)
}

@lexer::members {
int lexicalErrors=0;
}

/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/
prog returns [Node ast] //MANCA QUESTA PARTE
	: {HashMap<String,STentry> hm = new HashMap<String,STentry> ();
       symTable.add(hm);}
      //Codice che viene eseguto quando non c'è nessuna dichiarazione di variabili/funzioni         
	  ( e=exp 	
        {$ast = new ProgNode($e.ast);} 
      //Codice che viene eseguito quando ci sono dichiarazioni di variabili/funzioni
      | LET d=declist IN e=exp  
        {$ast = new ProgLetInNode($d.astlist,$e.ast);}      
	  ) 
	  {symTable.remove(nestingLevel);}
      SEMIC EOF ;

declist	returns [ArrayList<Node> astlist]        
	: {$astlist= new ArrayList<Node>() ;
	   int offset=-2; }      
	  ( (
	  		// Codice che viene eseguito quando viene trovata una dichiarazione di variabile*/
            VAR i=ID COLON t1=hotype ASS e=exp 
	        {
	        	// Viene creato un nuovo oggetto che contiene le informazioni relative alla variabile */
	        	VarNode variable = new VarNode($i.text,$t1.ast,$e.ast);
	            // Aggiungo il nodo appena creato all'ast */
	            $astlist.add(variable);                            
	            // Controllo che non ci sia un altra variabile con lo stesso nome all'interno dello scope in cui viene dichiarata questa variabile*/
	            HashMap<String,STentry> hm = symTable.get(nestingLevel);
	            if ( hm.put($i.text,new STentry(nestingLevel,$t1.ast,offset--)) != null  ) {
	              // Nel caso ci sia restituisco un errore */
	              System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
	              stErrors++; 
	            }
	            // Nel caso la variabile sia di tipo funzionale occupa offset doppio (indirizzo fp di AR, indirizzo funzione(invocazione suo codice))*/
	            if(variable.getSymType() instanceof ArrowTypeNode){ 
                	  offset--;
                }    
            } 
      |  
			/* Codice che viene eseguito quando viene trovata una dichiarazione di funzione*/      
            FUN i=ID COLON t=type 
	        {	
	        	//Tipo inserito nella symbolTable (utilizzato successivamente nella getSymType)
	        	ArrayList<Node> parTypes = new ArrayList<Node>();
				ArrowTypeNode funType = new ArrowTypeNode(parTypes,$t.ast);
	        	// Creo un nuovo nodo che possa contenere le informazioni della funzione */
	            FunNode functionNode = new FunNode($i.text,$t.ast, funType);
	            // Aggiungo il nodo appena creato all'ast */
	            $astlist.add(functionNode); 
	            // Prendo in considerazione la SymTable dello stesso livello in cui viene dichiarata la funzione */                            
	            HashMap<String,STentry> SymTableThisNestLev = symTable.get(nestingLevel);
	            // Controllo se esiste già una funzione con lo stesso nome nella SymbolTable (il controllo restituisce null se NON c'è una funzione con nome uguale) */
	            if ( SymTableThisNestLev.put( $i.text, new STentry(nestingLevel, funType, offset)) != null  ) {
	               // Nel caso ci sia restituisco un errore */
	               System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
	               stErrors++; 
	            }
	            // Siccome tutte le funzioni sono un ArrowTypeNode occupano offset doppio */
	            offset-=2;
                // Aggiorno il NestingLevel siccome "entrando" nella funzione lo scope incrementa */
                nestingLevel++;
                // Creo la HashMap per la nuova funzone */
                HashMap<String,STentry> hashMapNewFunction = new HashMap<String,STentry> ();
                symTable.add(hashMapNewFunction);
           } 
           LPAR {int paroffset=1;} 
           (fid=ID COLON fty=hotype
           { 
           		// Aggiungo alla lista riguardante i tipi dei parametri il tipo del primo parametro */
               	parTypes.add($fty.ast);
               	// Creo un nodo che possa contenere le informazioni relative al parametro */
                ParNode funParameter = new ParNode($fid.text,$fty.ast);
                // Aggiungo un parametro alla lista dei parametri della funzione */
                functionNode.addPar(funParameter);
                // I parametri di tipo funzionale occupano offset doppio (indirizzo fp di AR, indirizzo funzione(invocazione suo codice)) */
                if(funParameter.getSymType() instanceof ArrowTypeNode){
                  paroffset++;
                }
                // Non è possibile dichiarare due parametri con lo stesso nome all'interno della stessa funzione */
                if ( hashMapNewFunction.put($fid.text, new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ) { 
                  System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
                  stErrors++; 
                }
            }
            (COMMA id=ID COLON ty=hotype 
            {
                // Per ogni parametro eseguo nuovamente le istruzioni scritte per il primo parametro */
                parTypes.add($ty.ast);
                ParNode otherFunParameter = new ParNode($id.text,$ty.ast);
                functionNode.addPar(otherFunParameter);
                if(otherFunParameter.getSymType() instanceof ArrowTypeNode){
                	paroffset++;
                }
                if(hashMapNewFunction.put($id.text, new STentry(nestingLevel,$ty.ast,paroffset++)) != null  ) {
                	System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
                	stErrors++; 
                }
           })*
           
           )? 
           RPAR (LET d=declist IN {functionNode.addDec($d.astlist);})? e=exp
           {
           		// Aggiungo il corpo della funzione*/
           		functionNode.addBody($e.ast);
           		// Rimuove la hashmap corrente poiché quando la funzione finisce si esce dallo scope (non è più necessario mantenere le informazioni di questa funzione) */
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
	  {
      	int j=nestingLevel;
        STentry entry=null; 
        while (j>=0 && entry==null)
        	// Risale di nestingLevel per trovare la dichiarazione della variabile */
        	entry=(symTable.get(j--)).get($i.text);
        if (entry==null) {
			// Se non viene trovata nessuna HashMap allora significa che la variabile utilizzata non è mai stata dichiarata */
        	System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
        	stErrors++; 
       }               
	   $ast= new IdNode($i.text,entry,nestingLevel);} 
	   // Nel caso in cui venga richiamata una funzione */
	   ( LPAR {ArrayList<Node> arglist = new ArrayList<Node>();}
	   		// Aggiungo tutti gli argomenti alla lista degli argomenti */
	   		( a=exp {arglist.add($a.ast);} 
	   			(COMMA a=exp {arglist.add($a.ast);} )*
	   		)? 
	   		RPAR
	   		// Aggiungo all'ast un nuovo nodo per la chiamata di funzione */
	   		{$ast= new CallNode($i.text,entry,arglist,nestingLevel);}
	   )?
 	; 
 	
hotype  returns [Node ast]
		: t=type {$ast = $t.ast;} 
        | a=arrow {$ast = $a.ast;}
        ;
	
type	returns [Node ast]
  : INT  {$ast=new IntTypeNode();}
  | BOOL {$ast=new BoolTypeNode();} 
  ;	

arrow returns [Node ast] : 
		{ArrayList<Node> parArrowTypes = new ArrayList<Node>();} 
		// Memorizzo ogni parametro */
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
		// Creo un nuovo nodo contenente tutte le informazioni della variabile funzionale */
		$ast = new ArrowTypeNode(parArrowTypes, $t.ast);
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
