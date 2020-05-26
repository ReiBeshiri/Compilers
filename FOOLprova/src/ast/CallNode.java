package ast;

import java.util.ArrayList;

import lib.*;

public class CallNode implements Node {

	private String id;
	private int nestingLevel;
	private STentry entry;
	private ArrayList<Node> parlist = new ArrayList<Node>();

	public CallNode(String i, STentry st, ArrayList<Node> p, int nl) {
		id = i;
		entry = st;
		parlist = p;
		nestingLevel = nl;
	}

	public String toPrint(String s) {
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		return s + "Call:" + id + " at nestinglevel " + nestingLevel + "\n" + entry.toPrint(s + "  ") + parlstr;
	}

	public Node typeCheck() throws TypeException {
		//il tipo dell'id deve essere funzionale, lancia un eccezzione altrimenti
		if (!(entry.getType() instanceof ArrowTypeNode))
			throw new TypeException("Invocation of a non-function " + id);
		/* Controllo che il numero di parametri utilizzati per l'invocazione della funzione sia uguale 
		 * al numero di parametri utilizzati nella dichiarazione della funzione */
		ArrowTypeNode t = (ArrowTypeNode) entry.getType();
		ArrayList<Node> p = t.getParList();
		if (!(p.size() == parlist.size()))
			throw new TypeException("Wrong number of parameters in the invocation of " + id);
		/* Controllo che il tipo utilizzato nell'invocazione della funzione sia sottotipo di quello utilizzato nella dichiarazione
		 * della funzione */
		for (int i = 0; i < parlist.size(); i++)
			if (!(FOOLlib.isSubtype((parlist.get(i)).typeCheck(), p.get(i))))
				throw new TypeException("Wrong type for " + (i + 1) + "-th parameter in the invocation of " + id);
		return t.getRet();
	}
  
  public String codeGeneration() {
	  String parCode="", getAR="";
	  /* Per ogni parametro genero il rispettivo codice */
	  for (int i=parlist.size()-1; i>=0 ;i--) {
		 parCode += parlist.get(i).codeGeneration();
	  }
	  /* Permette di risalire all'AR in cui è dichiarata la funzione (risalita di catena statica) */
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
			  getAR+="lw\n";
	  //CallNode viene utilizzato per richiamare una funzione
	  
	  return 	"lfp\n" + 	// Metto Control Link (Frame Pointer dell'ID della funzione chiamante) in cima allo stack
			  	parCode + 	// Inserisco il valore generato dall'espressione di ogni parametro (in ordine inverso)
				"lfp\n" +
				getAR + 	// Attraverso la risalita statica effettuata precedentemente inserisco nello stack l'Access 
							//Link (puntatore all'AR della dichiarazione della funzione)
				"push " + entry.getOffset() + "\n" +
				"add\n" + 
				"lw\n" + 	//(set nuovo AL)
				"lfp\n" + 	// Risalgo lo stack per ottenere l'indirizzo della funzione a cui devo saltare 
				getAR +   
				"push " + (entry.getOffset() - 1) + "\n" + 
				"add\n" +  
				"lw\n" +  
				"js\n"; 	// Salto a codice funzione
  }
}
