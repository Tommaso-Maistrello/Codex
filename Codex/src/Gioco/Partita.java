package Gioco;

import java.io.FileNotFoundException;

import Carte.CartaObiettivo;
import Carte.CartaRisorsa;
import Tabellone.Campo;

public class Partita {

	public void newPartita( )throws FileNotFoundException {
		/*
		Giocatore.creaGiocatori();
		//CartaRisorsa.newMazzoRisorsa();
		
		
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.visualizzaObiettiviComuni();
		*/
		Campo campo = new Campo();
		campo.visualizzaCampo();
		//System.out.println(campo.toString());
	}
}
