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
			String angoloRetroBottomLeft, String angoloRetroBottomRight, String risorsaRetroCentrale, String colore,
			int punti) {
		super(angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorsaRetroCentrale);
		this.colore = colore;
		this.punti = punti;
	}

	public String getColore() {
		return colore;
	}
		
	public int getPunti() {
		return punti;
	}
	
public static  void costruisciCarteRisorsa() throws FileNotFoundException{
		 int i=1;
		 int punti;
	File fileRisorsa= new File ("carteRisorsa.txt");  
	
	Scanner leggi = new Scanner (fileRisorsa);  

		leggi.useDelimiter(",");		
		
		CartaRisorsa[] cartaRisorsa= new CartaRisorsa[40];  
		// il ciclo legge dal file ogni elemento diviso da una virgola e li carica in cartaRisorsa
		
		while(leggi.hasNextLine()) {
			
		 //cartaRisorsa[i]= new CartaRisorsa(angoloTopLeft,angoloTopRight,angoloBottomLeft,angoloBottomRight,"vuoto","vuoto","vuoto","vuoto",risorsa,colore,punti);
		 cartaRisorsa[i]= new CartaRisorsa(leggi.next(),leggi.next(),leggi.next(),leggi.next(),"vuoto","vuoto","vuoto","vuoto",leggi.next(),leggi.next(),leggi.nextInt());
		 System.out.println(cartaRisorsa[i].getAngoloFronteTopLeft());
		 i++;
		
	}		
	
	leggi.close();
	
	}
	public static void main(String[] args) throws FileNotFoundException {
		costruisciCarteRisorsa();
		
	}
	
	
}


