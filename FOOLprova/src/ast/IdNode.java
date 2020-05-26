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
	  
	  if(entry.getType() instanceof ArrowTypeNode) {
		  return "push 111\n" +
				 "pop\n" +
				 //carico sullo stack l'indirizzo fp dell'AR in cui è dichiarata la funzione (recuperato a offset ID)
				 "lfp\n"+	//carico il frame corrente
          		 getAR+ 	//risalgo la catena statica degli AL per ottenere l'indirizzo dell'AR che contiene la dichiarazione di id 
          		 "push "+entry.getOffset()+"\n"+
          		 "add\n"+ 
          		 "lw\n"+
          		 // carico sullo stack l'indirizzo della funzione (recuperato a offset ID - 1) 
          		 "lfp\n"+  
          		 "push "+(entry.getOffset()-1)+"\n"+ 
          		 "add\n"+
         		 "lw\n";
	  }
	  return  	"push 111\n" +
				"pop\n" +
			  	"lfp\n"+ //carico il frame corrente
                getAR+ //risalgo la catena statica degli AL per ottenere 
                       //l'indirizzo dell'AR che contiene la dichiarazione di id 
		 		"push "+entry.getOffset()+"\n"+ //aggiungo l'offset per calcolare l'indirizzo
                       							//in cui è contenuto il valore del parametro
		 		"add\n"+
		 		"lw\n"; //carico il valore del parametro
  }
}  