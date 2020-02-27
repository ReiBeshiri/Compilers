package ast;

public class STentry {
   
  private int nl;
  private Node type;
  private int offset;

  public STentry (int n, Node t, int o) {
	  nl=n;
	  type=t;
	  offset=o;
  } 
  
  public Node getType() {
	  return type;
  }
  
  public int getOffset() {
	  return offset;
  }
  
  public int getNestingLevel() {
	  return nl;
  }
  
  public String toPrint(String s) {
	   return s+"STentry: nestlev " + nl +"\n"+
			  s+"STentry: type\n " +
			      type.toPrint(s+"  ") +
			  s+"STentry: offset " + offset +"\n";
  }
  
}  