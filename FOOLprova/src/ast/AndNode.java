package ast;
import lib.*;

public class AndNode implements Node {

  private Node left;
  private Node right;
  
  public AndNode (Node l, Node r) {
   left=l;
   right=r;
  }
  
  public String toPrint(String s) {
   return s+"And\n" + left.toPrint(s+"  ")  
                     + right.toPrint(s+"  ") ; 
  }

  public Node typeCheck() throws TypeException {
	if ( ! ( FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode()) &&
	         FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode()) ) ) 
		throw new TypeException("Non bool or derivate in &&");
	return new BoolTypeNode();
  }
  
  public String codeGeneration() {
	  String isTrue= FOOLlib.freshLabel();
	  String isFalse= FOOLlib.freshLabel();
	  String ends= FOOLlib.freshLabel();
	  return  	 left.codeGeneration()+		// left è 0 o 1
				 "push 0\n"+				// e lo confronto con 1
				 "beq "+isFalse+"\n"+
				 right.codeGeneration()+		// right è 0 o 1
				 "push 0\n"+				// e lo confronto con 1
				 "beq "+isFalse+"\n"+
				 "b "+isTrue+"\n"+				 
				 isFalse+": \n"+
				 "push 0\n"+
				 "b "+ends+"\n"+	
	  			 isTrue+ ": \n"+
	  			 "push 1\n"+
	  			 ends+": \n";
  }
} 
