package ast;
import lib.*;

public class IdNode implements Node {

  private String id;
  private int nestingLevel;
  private STentry entry;
  
  
  public IdNode (String i, STentry st, int nl) {
   id=i;
   nestingLevel=nl;
   entry=st;   
  }
  
  public String toPrint(String s) {
	   return s+"Id:" + id + " at nestinglevel "+ nestingLevel + "\n" + 
			   entry.toPrint(s+"  ");  
  }

  public Node typeCheck() throws TypeException {
	  //ora id ammette tipi anche funzionali (arrowtype), questo if dava errore con ogni id di tipo funzionale
	//if (entry.getType() instanceof ArrowTypeNode) throw new TypeException("Wrong usage of function identifier "+id);
	return entry.getType();
  }
  
  public String codeGeneration() {
	  String getAR="";
	  for (int i=0; i<nestingLevel-entry.getNestingLevel();i++)
		  getAR+="lw\n";
	  
	  System.out.println("ID Node -> " + id);
	  //IdNode viene utilizzato quando devo prendere il valore di una variabile (NON FUNZIONI)
	  if(entry.getType() instanceof ArrowTypeNode) {
		  System.out.println("RICHIAMO UN ARROWTYPE");
		  return "lfp\n"+
				  "push 112\n"+ //IDNODEARROW
			 	 "pop\n"+
          		 getAR+ //risalgo la catena statica degli AL per ottenere 
                 //l'indirizzo dell'AR che contiene la dichiarazione di id 
          		 "push "+entry.getOffset()+"\n"+ //indir (fp) ad AR dichiaraz. funzione (recuperato a offset ID)
          		 //"push "+(entry.getOffset() + 1)+"\n"+ //CANCELLAAAAA
          		 "add\n"+ 		//TODO bisogna capire bene cosa fa add+lw
          		 "lw\n"+
          		 "lfp\n"+   //TODO MODIFICATO, PROVA
          		 "push "+(entry.getOffset()-1)+"\n"+ // indir funzione (recuperato a offset ID - 1) 
          		 //"push "+(entry.getOffset())+"\n"+ //CANCELLAAAAA
          		 "add\n"+
         		 "lw\n"
          		 ;
	  }
	  System.out.println("RICHIAMO VARIABILE NORMALE");
	  return  "lfp\n"+
	  			"push 111\n"+ //ID NODE
		 		"pop\n"+
                getAR+ //risalgo la catena statica degli AL per ottenere 
                       //l'indirizzo dell'AR che contiene la dichiarazione di id 
               "push 1111\n"+ //ID NODE
		 		"pop\n"+
		 		"push "+entry.getOffset()+"\n"+
		 		"add\n"+
		 		"lw\n";
  }
}  