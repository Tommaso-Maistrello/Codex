package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Enum.Colore;
import Enum.StatoAngolo;
import Gioco.Partita;



public class CartaOro extends Carta {
	
	private final Colore colore;
	private final int punti;
	private final String condizioneA, condizioneF, condizioneI, condizioneV;
	private final int numeroAnimale, numeroFunghi, numeroInsetti, numeroVegetale;
	
	
	
	public CartaOro(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft, StatoAngolo angoloFronteBottomRight, 
			StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight, StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale, 
			Colore colore, int punti, String condizioneA, int numeroAnimale, String condizioneF, int numeroFunghi, String condizioneI, int numeroInsetti, String condizioneV, int numeroVegetale ) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight, 
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight, risorsaRetroCentrale ); 
			
		
		this.colore = colore;
		this.punti = punti;
		this.condizioneA = condizioneA;
		this.condizioneF = condizioneF;
		this.condizioneI = condizioneI;
		this.condizioneV = condizioneV;
		this.numeroAnimale = numeroAnimale;
		this.numeroFunghi = numeroFunghi;
		this.numeroInsetti = numeroInsetti;
		this.numeroVegetale = numeroVegetale;
		}
		
	
	public Colore getColore() {
		return colore;
	}
	
	
	public int getPunti() {
		return punti;
	}
	
	
	public static  CartaOro[] costruisciCarteRisorsa() throws FileNotFoundException {
	    int i = 0; // Inizia da 0 anziché da 1
	    File fileRisorsa = new File("carteRisorsa.txt");
	    Scanner leggi = new Scanner(fileRisorsa);
	    leggi.useDelimiter(",");
	    CartaOro[] cartaRisorsa = new CartaOro[41];
	    while (leggi.hasNextLine()) {
	        cartaRisorsa[i] = new CartaOro(leggi.nextInt(), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), // id, fronteTopLeft, fronteTopRight, fronteBottomLeft, fronteBottomRight
	                StatoAngolo.VUOTO, StatoAngolo.VUOTO, StatoAngolo.VUOTO, StatoAngolo.VUOTO, StatoAngolo.valueOf(leggi.next()), // retroTopLeft, retroTopRight, retroBottomLeft, retroBottomRight, risorsaRetroCentrale
	                Colore.valueOf(leggi.next()), leggi.nextInt(), leggi.next(), leggi.nextInt(), leggi.next(), leggi.nextInt(), leggi.next(), leggi.nextInt(), leggi.next(), leggi.nextInt()); // colore, punti
	        leggi.next();
	        i++; // Incrementa subito dopo aver inserito un elemento nell'array
	    }
	    leggi.close();
	    return cartaRisorsa;
	}

	public static void main(String[] args) throws FileNotFoundException {
		CartaOro[] mazzo = new CartaOro[41];  
		mazzo = mescolaMazzo();
		
		for (int j = 41; j<mazzo.length-1; j++) {
			System.out.println( +mazzo[j].getId()+" "+mazzo[j].getAngoloFronteTopLeft()); }
		
	}
	
	public static CartaOro[] mescolaMazzo() throws FileNotFoundException {
		CartaOro[] mazzo = new CartaOro[41];  
		CartaOro[] temp = new CartaOro[41]; 
		mazzo = costruisciCarteRisorsa();
		Random rnd = new Random();
		int posizioneRandom;
		for (int i = mazzo.length-1; i>0; i--) {
			posizioneRandom=rnd.nextInt(i);
			posizioneRandom+=1; // il numero random viene generato da 0 in poi, non esistono elementi nella posizine 0 quindi aggiungiamo 1
			
			temp[i]=mazzo[posizioneRandom];
			mazzo[posizioneRandom]= mazzo[i];
			mazzo[i]=temp[i];
		}
		return mazzo;
	}
	
	
	public static void newMazzoRisorsa() throws FileNotFoundException {
		CartaOro[] mazzo = new CartaOro[41];  
		mazzo = mescolaMazzo();
		
		for (int j = 1; j<mazzo.length-1; j++) {
			System.out.println( +mazzo[j].getId()+" "+mazzo[j].getAngoloFronteTopLeft());
		}
	}
}