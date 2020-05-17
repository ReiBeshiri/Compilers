package ast;
import java.util.ArrayList;
import lib.*;

public class FunNode implements DecNode {

  private String id;
  private Node type; 
  private ArrayList<Node> parlist = new ArrayList<Node>(); // campo "parlist" che è lista di Node
  private ArrayList<Node> declist = new ArrayList<Node>(); 
  private Node exp;
  
  public FunNode (String i, Node t) {
   id=i;
   type=t;
  }
  
  public void addDec (ArrayList<Node> d) {
    declist=d;
  }  

  public void addBody (Node b) {
	exp=b;
  }  

  public void addPar (Node p) { //metodo "addPar" che aggiunge un nodo a campo "parlist"
   parlist.add(p);  
  }  
  
  public String toPrint(String s) {
		 String parlstr="";
		 for (Node par:parlist) 
			 parlstr+=par.toPrint(s+"  ");
		 String declstr="";
		 for (Node dec:declist) 
			 declstr+=dec.toPrint(s+"  ");
	   return s+"Fun:" + id +"\n"
			   +type.toPrint(s+"  ")
			   +parlstr
			   +declstr
               +exp.toPrint(s+"  ");
  }
  
  public Node typeCheck() throws TypeException {
	  for (Node dec:declist)
	    try {
	      dec.typeCheck(); } 
	    catch (TypeException e) {
	      System.out.println("Type checking error in a declaration: "+e.text); }    	
      if ( !FOOLlib.isSubtype(exp.typeCheck(),type) ) 
    	  throw new TypeException("Wrong return type for function "+id);
      return null;
  }
	     
  public String codeGeneration() {
	  //agiiunto l'if dove verifico se il nodo è di tipo arrowtype e nel caso faccio due pop.
	  String declCode="", popDecl="", popParl="";
	  for (Node dec:declist) {
		    declCode+=dec.codeGeneration();	
		    popDecl+="pop\n"; 
		    if(dec instanceof ArrowTypeNode) {
		    	popDecl+="pop\n"; 
		    }
	  }
	  for (Node par:parlist) {
	    	popParl+="pop\n"; 
	    	if(par instanceof ArrowTypeNode) {
	    		popParl+="pop\n";
	    	}
	  }
	  
	  String funl=FOOLlib.freshFunLabel();
	  FOOLlib.putCode(
			    funl+":\n"+ 
			    "cfp\n"+ //set $fp to $sp value				
				"lra\n"+ //push $ra value
	    		declCode+ //generate code for local declarations (they use the new $fp!!!)
	    		exp.codeGeneration()+//generate code for function body expression
	    		"stm\n"+ //set $tm to popped value (function result)
	    		popDecl+ // remove local declarations from stack
	    		"sra\n"+ // set $ra to popped value
	    		"pop\n"+ // remove Access Link from stack 
	    		popParl+ // remove parameters from stack
	    		"sfp\n"+ // set $fp to popped value (Control Link)
	    		"ltm\n"+ // push $tm value (function result)
	    		"lra\n"+"js\n" // jump to $ra value
			  );	  
	  return  "lfp\n"+ 
	  		"push 333\n"+ //DEBUG
	  		"pop\n"+
	  	    "push "+ funl +"\n";
  }

  public Node getSymType() {
	return type;
  }

}  