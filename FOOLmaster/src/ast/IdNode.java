package ast;
import lib.*;

public class IdNode implements Node {

  private String id;
  private int nestingLevel;
  private STentry entry;
  
  
  public IdNode (String i, STentry st, int nl) {
   id=i;
   nestingLevel=nl;
   entry=st;   
  }
  
  public String toPrint(String s) {
	   return s+"Id:" + id + " at nestinglevel "+ nestingLevel + "\n" + 
			   entry.toPrint(s+"  ");  
  }

  public Node typeCheck() throws TypeException {
	if (entry.getType() instanceof ArrowTypeNode) 
		throw new TypeException("PROVA COMMENTOWrong usage of function identifier "+id);
	return entry.getType();
  }
  
  public String codeGeneration() {
	  String getAR="";
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
		  getAR+="lw\n";
	  return "lfp\n"+
                getAR+ //risalgo la catena statica degli AL per ottenere 
                       //l'indirizzo dell'AR che contiene la dichiarazione di id 
             "push "+entry.getOffset()+"\n"+
			 "add\n"+
             "lw\n";
  }
}  