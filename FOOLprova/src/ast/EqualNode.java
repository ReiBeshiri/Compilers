package ast;
import lib.*;

public class EqualNode implements Node {

  private Node left;
  private Node right;
  
  public EqualNode (Node l, Node r) {
   left=l;
   right=r;
  }
  
  public String toPrint(String s) {
   return s+"Equal\n" + left.toPrint(s+"  ")   
                      + right.toPrint(s+"  ") ; 
  }
   
  public Node typeCheck() throws TypeException {
	//non viene consentita l'espressione con nodi di tipo funzionale
	if (left instanceof ArrowTypeNode || right instanceof ArrowTypeNode)
		throw new TypeException("ArrowTypeNode not allowed in equal");
	Node l= left.typeCheck();  
	Node r= right.typeCheck();  
    if ( !(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l)) ) 
    	throw new TypeException("Incompatible types in equal");
    return new BoolTypeNode();
  }
  
  public String codeGeneration() {
    String l1= FOOLlib.freshLabel();
    String l2= FOOLlib.freshLabel();
	  return left.codeGeneration()+
			 right.codeGeneration()+
			 "beq "+l1+"\n"+
			 "push 0\n"+
			 "b "+l2+"\n"+
			 l1+": \n"+
			 "push 1\n"+
			 l2+": \n";	         
  }
  
}  