package Carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CartaIniziale extends Carta {
	
	public String risorsaRetroCentraleAggiuntiva1;
	public String risorsaRetroCentraleAggiuntiva2;

	
	public CartaIniziale(String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, String risorsaRetroCentrale,
			String risorsaRetroCentraleAggiuntiva1, String risorsaRetroCentraleAggiuntiva2) {
		super(angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorsaRetroCentrale);
		this.risorsaRetroCentraleAggiuntiva1 = risorsaRetroCentraleAggiuntiva1;
		this.risorsaRetroCentraleAggiuntiva2 = risorsaRetroCentraleAggiuntiva2;
	}

public static void costruisciCarteIniziali() throws FileNotFoundException {
	int i=1;
	File fileIniziali= new File ("carteIniziali.txt");
	Scanner leggi = new Scanner (fileIniziali);
	leggi.useDelimiter(",");
	CartaIniziale[] cartaIniziale= new CartaIniziale[6];
	
	// il ciclo legge dal file ogni elemento diviso da una virgola e li carica in cartaIniziale
	while(leggi.hasNextLine()) {
		//cartaIniziale[i]= new cartaIniziale(angoloFronteTopLeft,angoloFronteTopRight,angoloFronteBottomLeft,angoloFronteBottomRight,angoloRetroTopLeft,angoloRetroTopRight,angoloRetroBottomLeft,angoloRetroBottomRight,risorsaRetroCentrale,risorsaRetroCentraleAggiuntiva1,risorsaRetroCentraleAggiuntiva2);
		cartaIniziale[i]= new CartaIniziale(leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),leggi.next());
		i++;
	}		
	
	leggi.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		costruisciCarteIniziali();
		
	}
}


