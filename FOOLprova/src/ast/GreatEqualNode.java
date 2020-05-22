package ast;

import lib.*;

public class GreatEqualNode implements Node {

	private Node left;
	private Node right;

	public GreatEqualNode(Node l, Node r) {
		//inverto i nodi left e right così facendo posso continuare ad utilizzare l'operatore <= per ottenere il >=.
		left = r;
		right = l;
	}

	public String toPrint(String s) {
		return s + "GreatEqual\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	//type check per verificare che i tipi dei nodi siano comparabili.
	public Node typeCheck() throws TypeException {
		Node l = left.typeCheck();
		Node r = right.typeCheck();
		if (!(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l)))
			throw new TypeException("Incompatible types in great equal");
		return new BoolTypeNode();
	}
	
	//NOTA: è come il lessEqualNode, ma left e right sono invertiti
	public String codeGeneration() {
		String l1 = FOOLlib.freshLabel();
		String l2 = FOOLlib.freshLabel();
		return left.codeGeneration() +		//risolvo ricorsivamente il nodo di sinistra (ci sarà il risultato dell'espressione)
				right.codeGeneration() +	//risolvo ricorsivamente il nodo di destra (ci sarà il risultato dell'espressione)
				"bleq " + l1 + "\n" +		//se left è <= right allora salto all'etichetta l1
				"push 0\n" +				//questa istruzione viene eseguita nel caso in cui left > right, e mette nello stack 0
				"b " + l2 + "\n" +			//dopo aver messo 0 sullo stack salta per non eseguire altre istruzioni
				l1 + ": \n" +				//branch nel caso in cui left sia stato <= di right
				"push 1\n" +				//viene quindi messo 1 sullo stack
				l2 + ": \n";				//etichetta richiamata per terminare la code generation
	}

}