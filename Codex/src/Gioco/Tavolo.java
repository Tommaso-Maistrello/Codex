package Gioco;

import java.io.FileNotFoundException;

import Carte.CartaObiettivo;

public class Tavolo {

	private static CartaObiettivo[] obiettiviComuni = new CartaObiettivo[2];
	
	public Tavolo(CartaObiettivo[] carteObiettivoEstratte) {
		for(int i=0; i<2; i++) {
			this.obiettiviComuni[i] = carteObiettivoEstratte[i];			
		}
	}
	
	public static void VisualizzaObiettiviComuni() {
        
        String RequisitiPunti0 = obiettiviComuni[0].getRequisitiPunti();
        
        //Devo leggere correttamente la stringa RequisitiPunti0
        
        
        
        System.out.println("Primo obiettivo comune: " + RequisitiPunti0);
	
        String RequisitiPunti1 = obiettiviComuni[1].getRequisitiPunti();
        System.out.println("Secondo obiettivo comune: " + RequisitiPunti1);		
    }
	
		
	public static void main(String[] args) throws FileNotFoundException {
		
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.VisualizzaObiettiviComuni();
		
	}

}
