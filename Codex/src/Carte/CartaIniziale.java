package Carte;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import Enum.StatoAngolo;



public class CartaIniziale extends Carta {
	
	public final StatoAngolo risorsaRetroCentraleAggiuntiva1;
	public final StatoAngolo risorsaRetroCentraleAggiuntiva2;
	
	
	
	public CartaIniziale(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft, StatoAngolo angoloFronteBottomRight, 
			StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight, StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale,
			StatoAngolo risorsaRetroCentraleAggiuntiva1, StatoAngolo risorsaRetroCentraleAggiuntiva2) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight, 
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight, risorsaRetroCentrale);
		this.risorsaRetroCentraleAggiuntiva1 = risorsaRetroCentraleAggiuntiva1;
		this.risorsaRetroCentraleAggiuntiva2 = risorsaRetroCentraleAggiuntiva2;
	}
	
	
	public StatoAngolo getRisorsaRetroCentraleAggiuntiva1() {
		return risorsaRetroCentraleAggiuntiva1;
	}
	
	
	public StatoAngolo getRisorsaRetroCentraleAggiuntiva2() {
		return risorsaRetroCentraleAggiuntiva2;
	}
	
	
	public static CartaIniziale[] costruisciCarteIniziali() throws FileNotFoundException {
		int i=0;
		File fileIniziali = new File ("carteIniziali.txt");
		Scanner leggi = new Scanner (fileIniziali);
		leggi.useDelimiter(",");
		CartaIniziale[] cartaIniziale= new CartaIniziale[6];
		while(leggi.hasNextLine()) {
			cartaIniziale[i] = new CartaIniziale ( leggi.nextInt(), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), // id, fronteTopLeft, fronteTopRight, fronteBottomLeft, fronteBottomRight
					StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()), // retroTopLeft, retroTopRight, retroBottomLeft, retroBottomRight, risorsaRetroCentrale
					StatoAngolo.valueOf(leggi.next()), StatoAngolo.valueOf(leggi.next()) ); // risorsaRetroCentraleAggiuntiva1, risorsaRetroCentraleAggiuntiva2
			leggi.next();
			i++;
		}
		leggi.close();
		return cartaIniziale;
	}
	
	
	public static CartaIniziale[] mescolaMazzo() throws FileNotFoundException {
		CartaIniziale[] mazzo = new CartaIniziale[6];  
		CartaIniziale[] temp = new CartaIniziale[6]; 
		mazzo = costruisciCarteIniziali();
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
	
}