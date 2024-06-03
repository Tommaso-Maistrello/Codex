package Gioco;

import java.util.ArrayList;
import java.util.List;

import Carte.CartaIniziale;
import Carte.CartaOro;
import Carte.CartaRisorsa;



public class Mano {
    private List<CartaRisorsa> cartaRisorsa;
    private List<CartaOro>  cartaOro;

  
    
    public Mano(List<CartaRisorsa> cartaR,List<CartaOro> cartaO) {
    	 
    	this.cartaRisorsa = cartaR;
        this.cartaOro = cartaO;
      
    }
    public void PescaCartaRisorsa(List<CartaRisorsa> mazzoRisorsa ) {
    	 if (cartaRisorsa == null) {
 	        cartaRisorsa = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
 	    }
        	cartaRisorsa.add(mazzoRisorsa.get(0));
        	mazzoRisorsa.remove(0);
        	
    }
    public void PescaCartaOro(List<CartaOro> mazzoOro ) {
    	 if (cartaOro == null) {
    	        cartaOro = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
    	    }
        cartaOro.add(mazzoOro.get(0)) ;
        mazzoOro.remove(0);
        	
    }
    
    

    public CartaRisorsa getCartaRisorsa(int posizione) {
        CartaRisorsa carta = null;
        int l = cartaRisorsa.size();
        if (posizione < l) {
            carta = cartaRisorsa.get(posizione);
        } else {
            System.out.println("Non esiste la carta in posizione: " + posizione);
        }
        return carta;
    }

    public List<CartaRisorsa> getManoRisorsa() {
        return cartaRisorsa;
    }
    public  List<CartaOro> getManoOro() {
    	
    	return cartaOro;
        
    }
    public  CartaOro getCartaOro( int posizione) {
    	CartaOro carta = null;
    	if (posizione<cartaOro.size()) {
    		carta= cartaOro.get(posizione);
    	}
    	else {
    		System.out.println("non esiste la carta in posizione:"+posizione);
    	}
    	
        return carta;
    }
	 public boolean haCartaConId(Giocatore player, int id) {
		 
	        for (CartaOro carta : player.getMano().getManoOro()) {
	            if (carta.getId() == id) {
	                return true;
	            }
	        }
	        for (CartaRisorsa carta : player.getMano().getManoRisorsa()) {
	            if (carta.getId() == id) {
	                return true;
	            }
	        }
	        return false;
	    }
	 public static CartaRisorsa prendiCartaRisorsaConID(int id, Giocatore player) {
		 CartaRisorsa cartaR= null;
			for(CartaRisorsa carta: player.getMano().getManoRisorsa()) {
				if (carta.getId()==id) {
					cartaR= carta;
				
					
					
				}
			}
				rimuoviCartaRisorsa(player, cartaR);
		 return cartaR;
	 }
	 public static CartaIniziale prendiCartaInizialeConID(int id, Giocatore player) {
		 return player.getCartaIniziale();
	 }
	 public static CartaOro prendiCartaOroConID(int id, Giocatore player) {
		 CartaOro cartaOro= null;
			for(CartaOro carta: player.getMano().getManoOro()) {
				if (carta.getId()==id) {
					cartaOro= carta;
					
				}
			}
			rimuoviCartaOro(player, cartaOro);
		 return cartaOro;
	 }
	 public static void rimuoviCartaOro(Giocatore player, CartaOro cartaOro) {
		 if (player != null && cartaOro != null) {
		        List<CartaOro> manoOro = player.getMano().getManoOro();
		        if (manoOro != null) {
		            manoOro.remove(cartaOro);
		        }
		    }
		}

	 public static void rimuoviCartaRisorsa(Giocatore player, CartaRisorsa cartaRisorsa) {
		    if (player != null && cartaRisorsa != null) {
		        List<CartaRisorsa> manoRisorsa = player.getMano().getManoRisorsa();
		        if (manoRisorsa != null) {
		            manoRisorsa.remove(cartaRisorsa);
		        }
		    }
		}
	 public void addCartaRisorsa(Giocatore player, CartaRisorsa cartaRisorsa) {
		 List<CartaRisorsa> manoRisorsa = player.getMano().getManoRisorsa();
	     manoRisorsa.add(cartaRisorsa);  
	 }
	 public void addCartaOro(Giocatore player, CartaOro cartaOro) {
		 List<CartaOro> manoOro = player.getMano().getManoOro();
	     manoOro.add(cartaOro);  
	 }
    
}






