package Gioco;

import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;



public class Mano {
    private static CartaRisorsa cartaRisorsa1;
    private static CartaRisorsa cartaRisorsa2;
    private static CartaOro cartaOro;
    private int numeroGiocatore;
  
    
    public Mano(CartaRisorsa cartaRisorsa1, CartaRisorsa cartaRisorsa2, CartaOro cartaOro) {
            
            this.cartaRisorsa1 = cartaRisorsa1;
            this.cartaRisorsa2 = cartaRisorsa2;
            this.cartaOro = cartaOro;  
          //  this.numeroGiocatore= numeroGiocatore;
    }
    public static void PescaCartaRisorsa(List<CartaRisorsa> mazzoRisorsa, int posizione   ) {
        if (posizione == 1) {
        	cartaRisorsa1 = mazzoRisorsa.remove(0);
        	}else if (posizione ==2){
        		cartaRisorsa2 = mazzoRisorsa.remove(0);
        	}
        		 
      //  this.numeroGiocatore= numeroGiocatore;
}
    public static void PescaCartaOro(List<CartaOro> mazzoOro ) {
       
        	cartaOro = mazzoOro.remove(0);
        	 
        		
        
        
       
        ;  
      //  this.numeroGiocatore= numeroGiocatore;
}
    

    public static CartaRisorsa getCartaRisorsa1() {
        return cartaRisorsa1;
    }

    public static CartaRisorsa getCartaRisorsa2() {
        return cartaRisorsa2;
    }

    public static CartaOro getCartaOro() {
        return cartaOro;
    }
/*
	public int getNumeroGiocatore() {
		return numeroGiocatore;
	}
*/
    }






