package ast;

import lib.*;

public class MinusNode implements Node {

	private Node left;
	private Node right;

	public MinusNode(Node l, Node r) {
		left = l;
		right = r;
	}

	public String toPrint(String s) {
		return s + "Minus\n" + left.toPrint(s + "  ") + right.toPrint(s + "  ");
	}

	//type check per verificare che i tipi dei nodi siano comparabili.
	public Node typeCheck() throws TypeException {
		if (!(FOOLlib.isSubtype(left.typeCheck(), new IntTypeNode())
				&& FOOLlib.isSubtype(right.typeCheck(), new IntTypeNode())))
			throw new TypeException("Non integers in minus");
		return new IntTypeNode();
	}

	public String codeGeneration() {
		return left.codeGeneration() + right.codeGeneration() + "sub\n";
	}
}
