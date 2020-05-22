package ast;

import lib.*;

public class NotNode implements Node {

	private Node exp;

	public NotNode(Node e) {
		exp = e;
	}

	public String toPrint(String s) {
		return s + "Not\n" + exp.toPrint(s + "  ");
	}

	// type check per verificare che i tipi dei nodi siano comparabili.
	public Node typeCheck() throws TypeException {
		if (!(FOOLlib.isSubtype(exp.typeCheck(), new IntTypeNode())))
			throw new TypeException("Non bool or derivate in NOT");
		return new BoolTypeNode();
	}

	public String codeGeneration() {
		String isTrue = FOOLlib.freshLabel();
		String isFalse = FOOLlib.freshLabel();
		String ends = FOOLlib.freshLabel();
		return exp.codeGeneration() + 		// codeGeneration dell'espressione, ritorna il risultato (0 o 1) al quale fare il not
				"push 1\n" + 				// e lo confronto con 1
				"beq " + isTrue + "\n" + 	// se è uguale ad 1 vado all'etichetta isTrue
				"b " + isFalse + "\n" + 	// se non è uguale vado all'etichetta isFalse
				isTrue + ": \n" +			// etichetta isTrue
				"push 0\n" +				// metto nello stack 0 (invertendo il risultato dell'espressione)
				"b " + ends + "\n" +		// salto all'etichetta ends per non eseguire altre istruzioni
				isFalse + ": \n" +			// etichetta isFalse
				"push 1\n" +				// metto nello stack 1 (invertendo il risultato dell'espressione)
				ends + ": \n";				// eticehtta ends
	}
}
