package Gioco;

import java.util.ArrayList;
import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;



public class Mano {
    private List<CartaRisorsa> cartaRisorsa;
    private List<CartaOro>  cartaOro;

  
    
    public Mano(List<CartaRisorsa> cartaR,List<CartaOro> cartaO) {
    	 
    	this.cartaRisorsa = cartaR;
        this.cartaOro = cartaO;
      
          //  this.numeroGiocatore= numeroGiocatore;
    }
    public void PescaCartaRisorsa(List<CartaRisorsa> mazzoRisorsa ) {
    	 if (cartaRisorsa == null) {
 	        cartaRisorsa = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
 	    }
        	cartaRisorsa.add(mazzoRisorsa.get(0));
        	mazzoRisorsa.remove(0);
        		 
      //  this.numeroGiocatore= numeroGiocatore;
}
    public void PescaCartaOro(List<CartaOro> mazzoOro ) {
    	 if (cartaOro == null) {
    	        cartaOro = new ArrayList<>(); // Initialize cartaRisorsa list if it's null
    	    }
        	cartaOro.add(mazzoOro.get(0)) ;
        	mazzoOro.remove(0);
        		
        
        
       
        
      //  this.numeroGiocatore= numeroGiocatore;
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
		 return cartaR;
	 }
	 public static CartaOro prendiCartaOroConID(int id, Giocatore player) {
		 CartaOro cartaOro= null;
			for(CartaOro carta: player.getMano().getManoOro()) {
				if (carta.getId()==id) {
					cartaOro= carta;
				}
			}
		 return cartaOro;
	 }
    
    /*
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
    protected static void visualizzaCartaOro(CartaOro cartaOro ) {
 		System.out.println("┌──────────────┬──────────────┐");
 		System.out.println("│"+cartaOro.angoloFronteTopLeft+"		"+cartaOro.angoloFronteTopRight+"│");
 		System.out.println("├──────────────┴──────────────┤");
 		System.out.println("│\t\t\t      │");
 		if(cartaOro.getRisorsaRetroCentrale().toString()!="\t")System.out.println("│\t"+cartaOro.getRisorsaRetroCentrale()+"\t      │");
 		System.out.println("│\t       "+cartaOro.getCondizione()+" \t      │");
 		System.out.println("│\t\t\t      │");
 		System.out.println("├──────────────┬──────────────┤");
 		System.out.println("│"+cartaOro.angoloFronteBottomLeft+"		│"+cartaOro.angoloFronteBottomLeft+"│");
 		System.out.println("└──────────────┴──────────────┘");
 		System.out.println();
 	}*/
	 
 

    }






