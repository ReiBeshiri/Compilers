// Generated from SVMVIS.g4 by ANTLR 4.4

import java.util.HashMap;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SVMVISParser}.
 */
public interface SVMVISListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SVMVISParser#assembly}.
	 * @param ctx the parse tree
	 */
	void enterAssembly(@NotNull SVMVISParser.AssemblyContext ctx);
	/**
	 * Exit a parse tree produced by {@link SVMVISParser#assembly}.
	 * @param ctx the parse tree
	 */
	void exitAssembly(@NotNull SVMVISParser.AssemblyContext ctx);
}