package ast;
import lib.*;

public class NotNode implements Node {

  private Node exp;
  
  public NotNode (Node e) {
   exp=e;
  }
  
  public String toPrint(String s) {
    return s+"Not\n" + exp.toPrint(s+"  ") ;
  }

  public Node typeCheck() throws TypeException {
	  if ( ! (FOOLlib.isSubtype(exp.typeCheck(), new IntTypeNode()))) 
			throw new TypeException("Non bool or derivate in NOT");
		return new BoolTypeNode();
  }
      

  public String codeGeneration() {
	  String isTrue= FOOLlib.freshLabel();
	  String isFalse= FOOLlib.freshLabel();
	  String ends= FOOLlib.freshLabel();
	  return  	 exp.codeGeneration()+		// prendo l'espressione tra parentesi e trovo ricorsivamente il risultato (bool)
				 "push 1\n"+				// e lo confronto con 1
				 "beq "+isTrue+"\n"+		// se � 1 vado is true e pusho 0 (inverso)
				 "b "+isFalse+"\n"+			// se non � 1 vado is false e pusho 1 (inverso)	 
				 isTrue+": \n"+
				 "push 0\n"+
				 "b "+ends+"\n"+	
	  			 isFalse+ ": \n"+
	  			 "push 1\n"+
	  			 ends+": \n";
  }
} 
