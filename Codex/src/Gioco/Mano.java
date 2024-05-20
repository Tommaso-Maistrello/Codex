package Gioco;

import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;



public class Mano {
    private CartaRisorsa cartaRisorsa1;
    private CartaRisorsa cartaRisorsa2;
    private CartaOro cartaOro;
    private int numeroGiocatore;
    
    public Mano(List<CartaRisorsa> mazzoRisorsa, List<CartaOro> mazzoOro ) {
            
            cartaRisorsa1 = mazzoRisorsa.remove(0);
            cartaRisorsa2 = mazzoRisorsa.remove(0);
            cartaOro = mazzoOro.remove(0);  
          //  this.numeroGiocatore= numeroGiocatore;
    }

    public CartaRisorsa getCartaRisorsa1() {
        return cartaRisorsa1;
    }

    public CartaRisorsa getCartaRisorsa2() {
        return cartaRisorsa2;
    }

    public CartaOro getCartaOro() {
        return cartaOro;
    }
/*
	public int getNumeroGiocatore() {
		return numeroGiocatore;
	}
*/
    }






