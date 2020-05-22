package ast;

import lib.*;

public class IdNode implements Node {

	private String id; // id nel nodo
	private int nestingLevel; // netinglevel del nodo
	private STentry entry; // STentry del nodo -> ottenere informazioni salvate nell'entry della symbol
							// table

	public IdNode(String i, STentry st, int nl) {
		id = i;
		nestingLevel = nl;
		entry = st;
	}

	public String toPrint(String s) {
		return s + "Id:" + id + " at nestinglevel " + nestingLevel + "\n" + entry.toPrint(s + "  ");
	}

	public Node typeCheck() throws TypeException {
		//ora IdNode ammette tipi anche funzionali (arrowtype)
		return entry.getType();
	}
  
  public String codeGeneration() {
	  String getAR="";
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
		  getAR+="lw\n";
	  
	  //IdNode viene utilizzato quando devo prendere il valore di una variabile (NON FUNZIONI)
	  if(entry.getType() instanceof ArrowTypeNode) {
		  return "lfp\n"+
          		 getAR+ //risalgo la catena statica degli AL per ottenere l'indirizzo dell'AR che contiene la dichiarazione di id 
          		 "push "+entry.getOffset()+"\n"+ //indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID)
          		 "add\n"+ 
          		 "lw\n"+
          		 "lfp\n"+  
          		 "push "+(entry.getOffset()-1)+"\n"+ // indir funzione (recuperato a offset ID - 1) 
          		 "add\n"+
         		 "lw\n"
          		 ;
	  }
	  return  	"lfp\n"+
                getAR+ //risalgo la catena statica degli AL per ottenere 
                       //l'indirizzo dell'AR che contiene la dichiarazione di id 
		 		"push "+entry.getOffset()+"\n"+
		 		"add\n"+
		 		"lw\n";
  }
}  