package Gioco;

import java.io.FileNotFoundException;

import Carte.CartaRisorsa;

public class Partita {

	public void newPartita( )throws FileNotFoundException {
		Giocatore.creaGiocatori();
		CartaRisorsa.newMazzoRisorsa();
	}
}
