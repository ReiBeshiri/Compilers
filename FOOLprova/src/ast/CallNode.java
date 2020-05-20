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
	  for (int i=parlist.size()-1;i>=0;i--)
		  parCode += parlist.get(i).codeGeneration();
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
		  getAR+="lw\n";
	  System.out.println(id + ": " + nestingLevel);
	  System.out.println(id + ": " + ((ArrowTypeNode) entry.getType()).isFunction());
	  System.out.println(this.getClass().toString());
	  if(!((ArrowTypeNode) entry.getType()).isFunction()) {
		  System.out.println("VADO DENTRO");
		  return "lfp\n"+ 						 // push Control Link (pointer to frame of function id caller)
			"push 223\n"+ //CALL NODE ARROW
			"pop\n"+
		     parCode+ 						 // generate code for parameter expressions in reversed order
		     "lfp\n"+
	         getAR+ 						 // push Access Link (pointer to frame of function id declaration, reached as for variable id)
		     "stm\n"+"ltm\n"+"ltm\n"+ 		 // duplicate top of the stack
		     "push "+entry.getOffset()+"\n"+ //indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID) usato per settare nuovo Access Link (AL)
			 "add\n"+
	         "lw\n"+ 						 // push function address (value at: pointer to frame of function id declaration + its offset)
			 //"lfp\n"+	//TODO MODIFICATO, PROVA
	         //"push "+ (entry.getOffset() - 1)+"\n"+ // indir funzione (recuperato a offset ID - 1) usato per saltare a codice funzione
			 //"add\n"+
			 "push 777\n"+ //CALL NODE ARROW
			 "pop\n"+
	         //"lw\n"+ //TODO MODIFICATO, PROVA
		     "js\n";						 // jump to popped address (putting in $ra address of subsequent instruction)
		     						 // jump to popped address (putting in $ra address of subsequent instruction)
	  }
	  System.out.println("RIMANGO FUORI");
	  return  	"lfp\n"+ 						 // push Control Link (pointer to frame of function id caller)
		  		"push 222\n"+ //CALL NODE
		  		"pop\n"+
			    parCode+ 						 // generate code for parameter expressions in reversed order
			    "lfp\n"+
			    getAR+ 						 // push Access Link (pointer to frame of function id declaration, reached as for variable id)
			    "stm\n"+"ltm\n"+"ltm\n"+ 		 // duplicate top of the stack
			    "push "+entry.getOffset()+"\n"+ //indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID)
				"add\n"+
			    "lw\n"+ 						 // push function address (value at: pointer to frame of function id declaration + its offset)
			    "push "+ (entry.getOffset() - 1)+"\n"+ // indir funzione (recuperato a offset ID - 1) usato per saltare a codice funzione
			    "add\n"+
			    "lw\n"+ 
			    "js\n";							 // jump to popped address (putting in $ra address of subsequent instruction)
  }
}  