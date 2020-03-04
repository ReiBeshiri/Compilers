
import java.io.BufferedWriter;
import java.io.FileWriter;
import ast.*;

import org.antlr.v4.runtime.*;

import ast.Node;
import lib.FOOLlib;
import lib.TypeException;

public class Test {
    public static void main(String[] args) throws Exception {
      
        String fileName = "linsum2.fool";
      
        CharStream chars = CharStreams.fromFileName(fileName);
        FOOLLexer lexer = new FOOLLexer(chars);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FOOLParser parser = new FOOLParser(tokens);
        
        Node ast = parser.prog().ast; //generazione AST con Id associate a relative entry symbol table
        
        System.out.println("You had: "+lexer.lexicalErrors+" lexical errors, "+
                parser.getNumberOfSyntaxErrors()+" syntax errors and "+
                parser.stErrors+" symbol table errors.\n");

        int errors=lexer.lexicalErrors+parser.getNumberOfSyntaxErrors()+parser.stErrors;
        
        if (errors==0) {
          System.out.println("Visualizing Annotated AST...");
          System.out.println(ast.toPrint(""));

          try {
          Node type=ast.typeCheck(); //type-checking bottom-up         
          System.out.print(type.toPrint("Type of main program expression is: ")); 
          }
          catch (TypeException e) {
        	System.out.println("Type checking error in main program expression: "+e.text); 
          }       	
          System.out.println("You had: "+FOOLlib.typeErrors+" type checking errors.\n");
          errors=FOOLlib.typeErrors;
        }
        
        if (errors>0) System.exit(1);    // end of compiler front-end    
        
        // CODE GENERATION  prova.fool.asm
        String code=ast.codeGeneration(); 
        BufferedWriter out = new BufferedWriter(new FileWriter(fileName+".asm")); 
        out.write(code);
        out.close(); 
        System.out.println("Code generated! Assembling and running generated code.");

        CharStream charsASM = CharStreams.fromFileName(fileName+".asm");
        SVMLexer lexerASM = new SVMLexer(charsASM);
        CommonTokenStream tokensASM = new CommonTokenStream(lexerASM);
        SVMParser parserASM = new SVMParser(tokensASM);
                
        parserASM.assembly();
        
        System.out.println("You had: "+lexerASM.lexicalErrors+" lexical errors and "+parserASM.getNumberOfSyntaxErrors()+" syntax errors.\n");
        if (lexerASM.lexicalErrors>0 || parserASM.getNumberOfSyntaxErrors()>0) System.exit(1);

        System.out.println("Starting Virtual Machine...");
        ExecuteVM vm = new ExecuteVM(parserASM.code);
        vm.cpu();
       
    }
}
