package ast;
import lib.*;

public class GreatEqualNode implements Node {

  private Node left;
  private Node right;
  
  public GreatEqualNode (Node l, Node r) {
   //inverto i nodi left e right perchè posso usare bleq e quindi invertendo è come fare >=.
   left=r;
   right=l;
  }
  
  public String toPrint(String s) {
   return s+"GreatEqual\n" + left.toPrint(s+"  ")   
                      + right.toPrint(s+"  ") ; 
  }
    
  public Node typeCheck() throws TypeException {
	Node l= left.typeCheck();  
	Node r= right.typeCheck();  
    if ( !(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l)) ) 
    	throw new TypeException("Incompatible types in great equal");
    return new BoolTypeNode();
  }
  
  public String codeGeneration() {
    String l1= FOOLlib.freshLabel();
    String l2= FOOLlib.freshLabel();
	  return left.codeGeneration()+
			 right.codeGeneration()+
			 "bleq "+l1+"\n"+
			 "push 0\n"+
			 "b "+l2+"\n"+
			 l1+": \n"+
			 "push 1\n"+
			 l2+": \n";	         
  }
  
}  