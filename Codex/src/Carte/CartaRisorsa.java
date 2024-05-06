package Carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Enum.Colore;
import Enum.Risorsa;

public class CartaRisorsa extends Carta {

	private static String colore;
	private static int punti;
	private static String setAngoloFronteTopLeft;

	
	public CartaRisorsa(String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, String risorseRetroCentrali, String colore,
			int punti) {
		super(angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorseRetroCentrali);
		this.colore = colore;
		this.punti = punti;
	}

	public String getColore() {
		return colore;
	}
	
	
	public int getPunti() {
		return punti;
	}
	
public static  void costruisciMazzo() throws FileNotFoundException{
		 int i=1;
		 String angoloTopLeft, angoloTopRight, angoloBottomLeft, angoloBottomRight, colore, risorsa;
		 int punti;
	File fileRisorsa= new File ("carteRisorsa.txt");  
	
	Scanner leggi = new Scanner (fileRisorsa);  

		leggi.useDelimiter(",");
		
		
		
		CartaRisorsa[] cartaRisorsa= new CartaRisorsa[40];  
		// il ciclo legge dal file ogni elemento diviso da una virgola e li carica nel vettore cartaRisorsa
		while(leggi.hasNextLine()) {
			
			 angoloTopLeft=leggi.next();
			 angoloTopRight=leggi.next();
			 angoloBottomLeft=leggi.next();
			 angoloBottomRight=leggi.next();
			 risorsa= leggi.next();
			 colore=leggi.next();
			 punti=leggi.nextInt();
			 
		 cartaRisorsa[i]= new CartaRisorsa(angoloTopLeft,angoloTopRight,angoloBottomLeft,angoloBottomLeft,"vuoto","vuoto","vuoto","vuoto",risorsa,colore,punti);
		 System.out.println(i + angoloTopLeft+angoloTopRight+angoloBottomLeft+angoloBottomLeft+risorsa+colore+punti);
		 
		 //System.out.println("il top left è " +cr[i].getAngoloFronteTopLeft());
		// System.out.println("il top right è " + cr[i].getAngoloFronteTopRight());
		i++;
 
		 
		
	}		
	
	
	leggi.close();
 
	
	}
	public static void main(String[] args) throws FileNotFoundException {
		
	costruisciMazzo();
 
		//System.out.println( CartaRisorsa.angoloFronteTopLeft );
		
	}
	
	
}


