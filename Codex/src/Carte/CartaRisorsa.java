package Carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Enum.Colore;
import Enum.Risorsa;

public class CartaRisorsa extends Carta {

	private static Colore colore;
	private static int punti;
	private static String setAngoloFronteTopLeft;

	
	public CartaRisorsa(String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, Risorsa[] risorseRetroCentrali, Colore colore,
			int punti) {
		super(angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorseRetroCentrali);
		this.colore = colore;
		this.punti = punti;
	}

	public Colore getColore() {
		return colore;
	}
	
	
	public int getPunti() {
		return punti;
	}
	
public static  void costruisciMazzo() throws FileNotFoundException{
		 int i=0;
		
		
	File fileRisorsa= new File ("carteRisorsa.txt");  
	
	Scanner leggi = new Scanner (fileRisorsa);  

		leggi.useDelimiter(",");
		
		
		
		CartaRisorsa[] cr= new CartaRisorsa[40];  
		// il ciclo legge dal file ogni elemento diviso da una virgola 
		while(leggi.hasNextLine()) {
	
		 
		cr[i].setAngoloFronteTopLeft(leggi.next());
		cr[i].setAngoloFronteTopRight(leggi.next());
		cr[i].setAngoloFronteBottomLeft(leggi.next());
		cr[i].setAngoloFronteBottomRight(leggi.next());
		
		cr[i].setAngoloRetroTopLeft("vuoto");
		cr[i].setAngoloRetroTopRight("vuoto");
		cr[i].setAngoloRetroBottomLeft("vuoto");
		cr[i].setAngoloRetroBottomRight("vuoto");
 
		i++;
 
		 
		
	}		
	
	
	leggi.close();
 
	
	}
	public static void main(String[] args) throws FileNotFoundException {
		
	costruisciMazzo();
 
		//System.out.println( CartaRisorsa.angoloFronteTopLeft );
		
	}
	
	
}


