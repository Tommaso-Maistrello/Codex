package Enum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Gioco.Giocatore;

import java.util.List;

public enum ColoreSegnalino {
	
	ROSSO, BLU, VERDE, GIALLO, NERO;
	
	private static int conta = 1;
	private static final int giocatoreNero;
	private static List<ColoreSegnalino> coloriRestanti;
	private static List<ColoreSegnalino> sequenzaColori;
	
	static {
		Random random = new Random ();
		giocatoreNero = random.nextInt(4) + 1; // Genera un numero random tra 1 a 4
		coloriRestanti = new ArrayList<>();
		Collections.addAll(coloriRestanti, ROSSO, BLU, VERDE, GIALLO);
		Collections.shuffle(coloriRestanti); // Mescola i colori che rimangono da assegnare
		
		// costruisci l'ordine dei colori da assegnare con il nero come primo colore
		sequenzaColori = new ArrayList<>();
		sequenzaColori.add(NERO); // il primo colore assegnato è il nero 
		for(int i=0; i<=4; i++) {
			if ( i==giocatoreNero - 1) {
				continue; // il giocatore nero salta l'assegnazione dei colori restanti
			}
			sequenzaColori.add(coloriRestanti.remove(0));
		}
	}
	
	public static ColoreSegnalino getColore() {
		if ( conta>sequenzaColori.size()) {
			return null; //se non ci sono più colori disponibili
		}
		return sequenzaColori.get(conta++ - 1);
	}
	//variabile per contare quanti giocatori sono stati costruiti e sapere il numero del giocatore corrente
    //private static int conta=1;

    /**
     * Ad ogni nuovo giocatore viene assegnato un colore e la variabile conta viene incrementata. 
     * Ogni volta che viene richiamato il metodo getColore(), conta viene incrementato cosicchè il giocatore successivo riceva un nuovo colore
     * 
     * @return Colore del segnalino in base al numero di giocatore
     */
    /*public static ColoreSegnalino getColore() {
        switch (conta) {
            case 1:
                conta++;
                return NERO;
            case 2:
                conta++;
                return BLU;
            case 3:
                conta++;
                return VERDE;
            case 4:
                conta++;
                return GIALLO;
            case 5:
            	conta++;
            	return ROSSO;
            default:
                return null;
        }
       } 
    */

/*
   public static void main(String[] args) {
	   for(int i=1; i <= 4; i++) {
		   ColoreSegnalino colore = ColoreSegnalino.getColore();
		   System.out.println("Giocatore "+i+": "+colore);
	   }
   }
  */  
}

