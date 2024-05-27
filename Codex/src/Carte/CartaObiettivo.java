package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Enum.Colore;
import Enum.StatoAngolo;



public class CartaObiettivo {
	
	public final int id;
	public final String requisitiPunti;
	
	
	
	public CartaObiettivo(int id, String requisitiPunti) {
		this.id = id;
		this.requisitiPunti = requisitiPunti;
	}
	
	
	public int getId() {
		return id;
	}


	public String getRequisitiPunti() {
		return requisitiPunti;
	}
	
	
	public static CartaObiettivo[] costruisciCarteObiettivo() throws FileNotFoundException {
		int i=1;
		File fileObiettivo = new File ("carteObiettivo.txt");
		Scanner leggi = new Scanner (fileObiettivo);
		leggi.useDelimiter(",");
		CartaObiettivo[] CartaObiettivo= new CartaObiettivo[17];
		while(leggi.hasNextLine()) {
			CartaObiettivo[i] = new CartaObiettivo ( leggi.nextInt(), leggi.next() ); // id, requisitiPunti
			leggi.next();
			i++;
		}
		leggi.close();
		return CartaObiettivo;
	}


	public static void mescolaMazzo(CartaObiettivo[] mazzo) throws FileNotFoundException {
		   
		CartaObiettivo[] temp = new CartaObiettivo[17]; 
		mazzo = costruisciCarteObiettivo();
		Random rnd = new Random();
		int posizioneRandom;
		for (int i = mazzo.length-1; i>0; i--) {
			posizioneRandom=rnd.nextInt(i);
			posizioneRandom+=1; // il numero random viene generato da 0 in poi, non esistono elementi nella posizine 0 quindi aggiungiamo 1
			
			temp[i]=mazzo[posizioneRandom];
			mazzo[posizioneRandom]= mazzo[i];
			mazzo[i]=temp[i];
		}
		 
	}
	
	/*
	public static void main(String[] args) throws FileNotFoundException {
		CartaObiettivo[] mazzo = new CartaObiettivo[17];  
		mazzo = mescolaMazzo();
		
		for (int j = 1; j<mazzo.length-1; j++) {
			System.out.println( +mazzo[j].getId()+" "+mazzo[j].getRequisitiPunti());
		}
		
		
	}*/
	
	public static CartaObiettivo[] carteObiettivoEstratte(CartaObiettivo[] mazzo) {
		CartaObiettivo[] estratte=new CartaObiettivo[2];
		for(int i=0; i<2; i++)
		{
			estratte[i]=mazzo[i+1];
		}
		return estratte;
	}
	
	
}