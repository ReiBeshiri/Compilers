package ast;

import java.util.ArrayList;
import lib.*;

public class FunNode implements DecNode {

	private String id;
	private Node type;
	private ArrayList<Node> parlist = new ArrayList<Node>(); // campo "parlist" che è lista di Node
	private ArrayList<Node> declist = new ArrayList<Node>();
	private Node exp;
	private Node symType;

	public FunNode(String i, Node t, Node symType) {
		id = i;
		type = t;
		this.symType = symType;
	}

	public void addDec(ArrayList<Node> d) {
		declist = d;
	}

	public void addBody(Node b) {
		exp = b;
	}

	public void addPar(Node p) { // metodo "addPar" che aggiunge un nodo a campo "parlist"
		parlist.add(p);
	}

	public String toPrint(String s) {
		String parlstr = "";
		for (Node par : parlist)
			parlstr += par.toPrint(s + "  ");
		String declstr = "";
		for (Node dec : declist)
			declstr += dec.toPrint(s + "  ");
		return s + "Fun:" + id + "\n" + type.toPrint(s + "  ") + parlstr + declstr + exp.toPrint(s + "  ");
	}

	public Node typeCheck() throws TypeException {
		/* Controlla se c'è un TypeCheckError per ogni nodo all'interno della declist */
		for (Node dec : declist) {
			try {
				dec.typeCheck();
			} catch (TypeException e) {
				System.out.println("Type checking error in a declaration: " + e.text);
			}
		}
		/* Controllo che il tipo restituito dall'espressione della funzione sia sottotipo di quello specificato come tipo di ritorno */
		if (!FOOLlib.isSubtype(exp.typeCheck(), type))
			throw new TypeException("Wrong return type for function " + id);
		return null;
	}
	     
  public String codeGeneration() {
	  String declCode="", popDecl="", popParl="";
	  for (Node dec:declist) {
		    declCode+=dec.codeGeneration();	
		    popDecl+= "pop\n"; 
		    if(((DecNode) dec).getSymType() instanceof ArrowTypeNode) {
		    	popDecl+="pop\n"; 
		    }
	  }
	  for (Node par:parlist) {
	    	popParl+="pop\n"; 
	    	//se è di tipo ArrowTypeNode eseguo due pop
	    	if(((ParNode) par).getSymType() instanceof ArrowTypeNode) {
	    		popParl+="pop\n";
	    	}
	  }
	  String funl=FOOLlib.freshFunLabel();
	  /* questo codice viene inserito nell'etichetta  (ovvero è la parte che viene 
	   * eseguita quando viene richiamata la funzione */
	  FOOLlib.putCode(
			    funl+":\n"+ 			//etichetta della funzione 
			    "cfp\n"+ 				//cambia il frame pointer $fp mettendoci $sp (punterà al frame della funzione)				
				"lra\n"+ 				//carico sullo stack il return address ($ra)
	    		declCode+ 				//genero il codice per le dichiarazioni locali (utilizzando il nuovo valore di $fp)
	    		exp.codeGeneration()+	//genero il codice del corpo della funzione
	    		"stm\n"+ 				//metto sul registro $tm il risultato della funzione
	    		popDecl+ 				//rimuovo dallo stack le dichiarazioni locali
	    		"sra\n"+ 				//inserisco nel registro $ra l'indirizzo di ritorno presente sullo stack
	    		"pop\n"+ 				//rimuovo l'access link dallo stack
	    		popParl+ 				//rimuovo i parametri dallo stack
	    		"sfp\n"+ 				//modifico $fp per farlo puntare al frame del chiamante
	    		"ltm\n"+ 				//carico sullo stack $tm (il risultato della funzione chiamata)
	    		"lra\n"+"js\n" 			//carico sullo stack il return address ed effettuo il salto
			  );
	  /* code generation che viene inserita nello stack alla dichiarazione di una funzione */
	  return  "lfp\n"+ 					//carica il frame corrente, descrive in quale frame è stata dichiarata 
			  							//questa funzione (servirà successivamente per calcolare l'access link)
	  	      "push "+ funl +"\n";		//inserisce nello stack l'indirizzo della funzione
  }

  public Node getSymType() {
	return symType;
  }

}  