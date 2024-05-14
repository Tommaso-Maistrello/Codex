package Gioco;

import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;

public class Mano {
	public void creaManoIniziale(List<Giocatore> giocatori, Mazzo mazzoCarteRisorsa, Mazzo mazzoCarteOro) {
    for (Giocatore giocatore : giocatori) {
        // Aggiungi due carte risorsa alla mano del giocatore
        for (int i = 0; i < 2; i++) {
            CartaRisorsa cartaRisorsa = mazzoCarteRisorsa.pescaCarta();
            giocatore.aggiungiCartaInMano(cartaRisorsa);
        }
        
        // Aggiungi una carta oro alla mano del giocatore
        CartaOro cartaOro = mazzoCarteOro.pescaCarta();
        giocatore.aggiungiCartaInMano(cartaOro);
    }
}


}
