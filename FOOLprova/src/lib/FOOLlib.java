package lib;
import java.util.ArrayList;
import java.util.List;

import ast.*;

public class FOOLlib {
	
  public static int typeErrors = 0;	

  /*
   * 1 -> true
   * tutti gli altri numeri -> false
   * 
   * */
  //valuta se il tipo "a" � <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
  public static boolean isSubtype (Node a, Node b) {
	boolean isSubtype=false;
	if (a instanceof ArrowTypeNode && b instanceof ArrowTypeNode) {
		isSubtype=true;
		//Ottengo l'istanza di ogni Arrowtype
		ArrowTypeNode aArrow = (ArrowTypeNode) a;
		ArrowTypeNode bArrow = (ArrowTypeNode) b;
		//Controllo che abbiano lo stesso numero di parametri
		List<Node> listParA = aArrow.getParList();
		List<Node> listParB = bArrow.getParList();
		if(listParA.size() != listParB.size()) {isSubtype=false;}
		//Covarianza sul tipo di ritorno
		isSubtype = isSubtype(aArrow.getRet(), bArrow.getRet());
		//Controllo che il tipo di ogni parametro del nodo A e del nodo B sia lo stesso (Contravariance)
		for(int i=0; i<listParA.size(); i++) {
			isSubtype = isSubtype && isSubtype(listParB.get(i), listParA.get(i));
		}
	}
	else {
		
		isSubtype = a.getClass().equals(b.getClass()) || ( (a instanceof BoolTypeNode) && (b instanceof IntTypeNode) );
			
	}
	    	 
	return isSubtype;
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
  
  public static int prova = 0;
  
}
