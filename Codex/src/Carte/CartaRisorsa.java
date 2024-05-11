package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Enum.Colore;
import Enum.StatoAngolo;


public class CartaRisorsa extends Carta {

	private final Colore colore;
	private final int punti;
	//private static String setAngoloFronteTopLeft;

	
	public CartaRisorsa(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft,
			StatoAngolo angoloFronteBottomRight, StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight,
			StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale, Colore colore,
			int punti) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorsaRetroCentrale);
		this.colore = colore;
		this.punti = punti;
	}

	public Colore getColore() {
		return colore;
	}
		
	public int getPunti() {
		return punti;
	}
	
public static  CartaRisorsa[] costruisciCarteRisorsa() throws FileNotFoundException{
 
	int i=1;
	 
	File fileRisorsa= new File ("carteRisorsa.txt");  
	
	Scanner leggi = new Scanner (fileRisorsa);  

		leggi.useDelimiter(",");		
	
		CartaRisorsa[] cartaRisorsa= new CartaRisorsa[41];  

		while(leggi.hasNextLine()) {
			
			 //cartaRisorsa[i]= new CartaRisorsa(id,topLeft,topRight,bottomLeft,bottomRight,StatoAngolo.VUOTO,StatoAngolo.VUOTO,StatoAngolo.VUOTO,StatoAngolo.VUOTO,risorsa,colore,punti);
		 cartaRisorsa[i]= new CartaRisorsa(leggi.nextInt(),StatoAngolo.valueOf(leggi.next()),StatoAngolo.valueOf(leggi.next()),StatoAngolo.valueOf(leggi.next()),StatoAngolo.valueOf(leggi.next()), // id,topLeft,topRight,bottomLeft,bottomRight
				 StatoAngolo.VUOTO,StatoAngolo.VUOTO,StatoAngolo.VUOTO,StatoAngolo.VUOTO,StatoAngolo.valueOf(leggi.next()),// angoli retro
				 Colore.valueOf(leggi.next()),leggi.nextInt()); // risorsa,colore,punti
			 	 leggi.next();
		 i++;
	}		
	
	leggi.close();
	return cartaRisorsa;
	
	}
	public static  CartaRisorsa[] mescolaMazzo() throws FileNotFoundException{
		CartaRisorsa[] mazzo = new CartaRisorsa[41];  
		CartaRisorsa[] temp = new CartaRisorsa[41]; 
		mazzo= costruisciCarteRisorsa();
		Random rnd = new Random();
		int posizioneRandom;
		
	for (int i = mazzo.length-1; i>0;i--) {
		posizioneRandom=rnd.nextInt(i );
		posizioneRandom+=1; // il numero random viene generato da 0 in poi, non esistono elementi nella posizine 0 quindi aggiungiamo 1
		
		temp[i]=mazzo[posizioneRandom];
		mazzo[posizioneRandom]= mazzo[i];
		mazzo[i]=temp[i];
	}

		return mazzo;
	}
	public static void main(String[] args) throws FileNotFoundException {
		CartaRisorsa[] mazzo = new CartaRisorsa[41];  
		mazzo= mescolaMazzo();
		
			for (int j = 1; j<mazzo.length-1;j++) {
				System.out.println( +mazzo[j].getId()+" "+mazzo[j].getAngoloFronteTopLeft());		
			}
		
	}
	
}


