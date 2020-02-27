package lib;
import ast.*;

public class FOOLlib {
	
  public static int typeErrors = 0;	

  //valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	return a.getClass().equals(b.getClass()) ||
	    	   ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode) );  
  }
	
  private static int labCount=0; 

  public static String freshLabel() { 
	return "label"+(labCount++);
  }  
  
  private static int funlabCount=0; 

  public static String freshFunLabel() { 
	return "function"+(funlabCount++);
  }  
  
  private static String funCode="" ; 

  public static void putCode(String c) { 
    funCode+="\n"+c; //aggiunge una linea vuota di separazione prima  di funzione
  } 
  
  public static String getCode() { 
    return funCode;
  } 

  
}
