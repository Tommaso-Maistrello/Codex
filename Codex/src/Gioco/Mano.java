package Gioco;

import java.util.ArrayList;
import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;



public class Mano {
    private static List<CartaRisorsa> cartaRisorsa;
    private static List<CartaOro>  cartaOro;

  
    
    public Mano(List<CartaRisorsa> cartaR,List<CartaOro> cartaO) {
    	 
    	this.cartaRisorsa = cartaR;
        this.cartaOro = cartaO;
      
          //  this.numeroGiocatore= numeroGiocatore;
    }
    public static void PescaCartaRisorsa(List<CartaRisorsa> mazzoRisorsa ) {
    	 if (cartaRisorsa == null) {
 	        cartaRisorsa = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
 	    }
        	cartaRisorsa.add(mazzoRisorsa.get(0));
        	mazzoRisorsa.remove(0);
        		 
      //  this.numeroGiocatore= numeroGiocatore;
}
    public static void PescaCartaOro(List<CartaOro> mazzoOro ) {
    	 if (cartaOro == null) {
    	        cartaOro = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
    	    }
        	cartaOro.add(mazzoOro.get(0)) ;
        	mazzoOro.remove(0);
        		
        
        
       
        ;  
      //  this.numeroGiocatore= numeroGiocatore;
}
    
    

    public static CartaRisorsa getCartaRisorsa(int posizione) {
    	CartaRisorsa carta = null;
    	int l= cartaRisorsa.size();
    	if (posizione<l) {
    		carta= cartaRisorsa.get(posizione);
    	}
    	else {
    		System.out.println("non esiste la carta in posizione:"+posizione);
    	}
    	
        return carta;
    }
    public static List<CartaRisorsa> getManoRisorsa() {
    	
    	return cartaRisorsa;
        
    }
  public static List<CartaOro> getManoOro() {
    	
    	return cartaOro;
        
    }
    public static CartaOro getCartaOro( int posizione) {
    	CartaOro carta = null;
    	if (posizione<cartaOro.size()) {
    		carta= cartaOro.get(posizione);
    	}
    	else {
    		System.out.println("non esiste la carta in posizione:"+posizione);
    	}
    	
        return carta;
    }
    public static void visualizzaCartaRisorsa(CartaRisorsa cartaRisorsa ) {
		System.out.println("┌──────────────┬──────────────┐");
		System.out.println("│"+cartaRisorsa.angoloFronteTopLeft.toString()+"		│"+cartaRisorsa.angoloFronteTopRight.toString()+"│");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		if(cartaRisorsa.getRisorsaRetroCentrale().toString()!="\t")System.out.println("│\t"+cartaRisorsa.getRisorsaRetroCentrale()+"\t      │");
		System.out.println("│\t       "+cartaRisorsa.getPunti()+" \t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		System.out.println("│"+cartaRisorsa.angoloFronteBottomLeft+"		│"+cartaRisorsa.angoloFronteBottomLeft+"│");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println();
	}
    protected void visualizzaCartaOro(CartaOro cartaOro ) {
 		System.out.println("┌──────────────┬──────────────┐");
 		System.out.println("│"+cartaOro.angoloFronteTopLeft+"│"+cartaOro.angoloFronteTopRight+"│");
 		System.out.println("├──────────────┴──────────────┤");
 		System.out.println("│\t\t\t      │");
 		if(cartaOro.getRisorsaRetroCentrale().toString()!="\t")System.out.println("│\t"+cartaOro.getRisorsaRetroCentrale()+"\t      │");
 		System.out.println("│\t       "+cartaOro.getCondizione()+" \t      │");
 		System.out.println("│\t\t\t      │");
 		System.out.println("├──────────────┬──────────────┤");
 		System.out.println("│"+cartaOro.angoloFronteBottomLeft+"│"+cartaOro.angoloFronteBottomLeft+"│");
 		System.out.println("└──────────────┴──────────────┘");
 		System.out.println();
 	}
   
    
/*
 * 
 *     public static CartaRisorsa PescaCartaRisorsa(List<CartaRisorsa> mazzoRisorsa) {
        if (cartaRisorsa == null) {
            cartaRisorsa = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
        }
        
        CartaRisorsa carta = mazzoRisorsa.get(0); // Get the first carta from mazzoRisorsa
        cartaRisorsa.add(carta); // Add the carta to cartaRisorsa list
        mazzoRisorsa.remove(0); // Remove the carta from mazzoRisorsa
        
        return carta; // Return the carta
    }
    public static CartaOro PescaCartaOro(List<CartaOro> mazzoOro) {
        if (cartaRisorsa == null) {
            cartaRisorsa = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
        }
        
        CartaOro carta = mazzoOro.get(0); // Get the first carta from mazzoRisorsa
        cartaOro.add(carta); // Add the carta to cartaRisorsa list
        mazzoOro.remove(0); // Remove the carta from mazzoRisorsa
        
        return carta; // Return the carta
    }
    
    public static CartaRisorsa getCartaRisorsa2(Giocatore player) {
        return cartaRisorsa2;
    }

    public static CartaOro getCartaOro(Giocatore player) {
        return cartaOro;
    }
    */
/*
	public int getNumeroGiocatore() {
		return numeroGiocatore;
	}
*/
    }






