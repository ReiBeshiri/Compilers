package ast;
import lib.*;

public class OrNode implements Node {

	private Node left;
	private Node right;

	public OrNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "Or\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	//type check per verificare che i tipi dei nodi siano comparabili.
	public Node typeCheck() throws TypeException {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode())))
			throw new TypeException("Non bool or derivate in ||");
		return new BoolTypeNode();
	}
  
  public String codeGeneration() {
	  String isTrue= FOOLlib.freshLabel();
	  String isFalse= FOOLlib.freshLabel();
	  String ends= FOOLlib.freshLabel();
	  return  	 left.codeGeneration()+		// richiamo la code generation di left che restutuisce il risultato dell'espressione (0 o 1)
				 "push 1\n"+				// e lo confronto con 1 (true)
				 "beq "+isTrue+"\n"+		// nel caso in cui left sia true, salta all'etichetta isTrue
				 right.codeGeneration()+	// richiamo la code generation di right che restutuisce il risultato dell'espressione (0 o 1)
				 "push 1\n"+				// e lo confronto con 1 (true)
				 "beq "+isTrue+"\n"+		// nel caso in cui right sia true, salta all'etichetta isTrue
				 "b "+isFalse+"\n"+			// nel caso in cui entrambi i nodi siano false, salto all'etichetta isFalse
				 isTrue+": \n"+				// etichetta isTrue
				 "push 1\n"+				// mette 1 nello stack
				 "b "+ends+"\n"+			// dopo aver messo 1 nello stack salto nell'etichetta ends per non eseguire altre istruzioni
	  			 isFalse+ ": \n"+			// etichetta isFalse
	  			 "push 0\n"+				// mette 0 nello stack
	  			 ends+": \n";				// etichetta richiamata per terminare la code generation
  }
}  