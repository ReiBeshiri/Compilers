package ast;
import java.util.ArrayList;

public class ArrowTypeNode implements Node {

  private ArrayList<Node> parlist;
  private Node ret;
  private boolean isFunction;
  
  public ArrowTypeNode (ArrayList<Node> p, Node r, boolean isFunction) {
   parlist=p;
   ret=r;
   this.isFunction = isFunction;
  }
  
  public boolean isFunction() {
	  return isFunction;
  }
  
  public Node getRet () { 
	    return ret;
  }
	  
  public ArrayList<Node> getParList () { 
	    return parlist;
  }
  
  public String toPrint(String s) {
	 String parlstr="";
	 for (Node par:parlist)
		 parlstr+=par.toPrint(s+"  ");
     return s+"ArrowTypeNode\n" + parlstr + ret.toPrint(s+"  ->") ; 
  }

  //non utilizzato
  public Node typeCheck() {return null;}

  //non utilizzato
  public String codeGeneration() {return "";}

}  