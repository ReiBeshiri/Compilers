package ast;
import java.util.ArrayList;
import java.util.Collections;

import lib.*;

public class CallNode implements Node {

  private String id;
  private int nestingLevel;
  private STentry entry;
  private ArrayList<Node> parlist = new ArrayList<Node>(); 
  
  public CallNode (String i, STentry st, ArrayList<Node> p, int nl) {
   id=i;
   entry=st;
   parlist=p;
   nestingLevel=nl;
  }
  
  
  public String toPrint(String s) {
		 String parlstr="";
		 for (Node par:parlist) 
			 parlstr+=par.toPrint(s+"  ");
	     return s+"Call:" + id + " at nestinglevel " + nestingLevel +"\n" +
 	            entry.toPrint(s+"  ") +  
			    parlstr;
  }
  
  public Node typeCheck() throws TypeException {	
	     if ( !(entry.getType() instanceof ArrowTypeNode) )
	       throw new TypeException("Invocation of a non-function "+id);
		 ArrowTypeNode t=(ArrowTypeNode) entry.getType(); 
	     ArrayList<Node> p = t.getParList();
	     if ( !(p.size() == parlist.size()) ) 
	       throw new TypeException("Wrong number of parameters in the invocation of "+id);
	     for (int i=0; i<parlist.size(); i++) 
	       if ( !(FOOLlib.isSubtype( (parlist.get(i)).typeCheck(), p.get(i)) ) ) 
	    	 throw new TypeException("Wrong type for "+(i+1)+"-th parameter in the invocation of "+id);
	     return t.getRet();
  }
  
  public String codeGeneration() {
	  String parCode="", getAR="";
	  
	  for (int i=parlist.size()-1;i>=0;i--) {
		 parCode += parlist.get(i).codeGeneration();
	  }
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
			  getAR+="lw\n";
	  //CallNode viene utilizzato per richiamare una funzione
	  return 	"lfp\n" + // Metto Control Link (Frame Pointer dell'ID della funzione chiamante) in cima allo stack
				parCode + // Genero il codice delle espressioni dei parametri (in ordine inverso)
				"lfp\n" +
				getAR + // Push dell'Access Link (puntatore all'AR della dichiarazione della funzione)
				"push " + entry.getOffset() + "\n" +
				"add\n" + 
				"lw\n" + // Push dell'indirizzo della dichiarazione della funzione (set nuovo AL)
				"lfp\n" + 
				getAR +
				"push " + (entry.getOffset() - 1) + "\n" +
				"add\n" +
				"lw\n" +
				"js\n"; // Salto a codice funzione
  }
}
