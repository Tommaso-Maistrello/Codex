package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class CartaRisorsa extends Carta {

	private static String colore;
	private static int punti;
	private static String setAngoloFronteTopLeft;

	
	public CartaRisorsa(int id, String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, String risorsaRetroCentrale, String colore,
			int punti) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
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
	
public static  CartaRisorsa[] costruisciCarteRisorsa() throws FileNotFoundException{
	 String topLeft, topRight, bottomLeft, bottomRight, colore, risorsa;
	 int punti, id;	 
	
	int i=1;
	 
	File fileRisorsa= new File ("carteRisorsa.txt");  
	
	Scanner leggi = new Scanner (fileRisorsa);  

		leggi.useDelimiter(",");		
		
		CartaRisorsa[] cartaRisorsa= new CartaRisorsa[40];  
		// il ciclo legge dal file ogni elemento diviso da una virgola e li carica in cartaRisorsa
		
		
	 
		 

		while(leggi.hasNextLine()) {
			
		 //cartaRisorsa[i]= new CartaRisorsa(angoloTopLeft,angoloTopRight,angoloBottomLeft,angoloBottomRight,"vuoto","vuoto","vuoto","vuoto",risorsa,colore,punti);
		// cartaRisorsa[i]= new CartaRisorsa(leggi.nextInt(),leggi.next(),leggi.next(),leggi.next(),leggi.next(),"vuoto","vuoto","vuoto","vuoto",leggi.next(),leggi.next(),leggi.nextInt());
			 id = leggi.nextInt();
			 topLeft =leggi.next();
			 topRight=leggi.next();
			 bottomLeft=leggi.next();
			 bottomRight=leggi.next();
			 risorsa= leggi.next();
			 colore=leggi.next();
			 punti=leggi.nextInt();
			 leggi.next();
			 
			 if ("".equals(topLeft)) {
				 topLeft = null;
				 
			 }
		
			 if ("".equals(topRight)) {
				 topRight = null;
				 
			 } if ("".equals(bottomLeft)) {
				 bottomLeft = null;
			 } if ("".equals(bottomRight)) {
				 bottomRight = null;
			 }
			 
			 cartaRisorsa[i]= new CartaRisorsa(id,topLeft,topRight,bottomLeft,bottomRight,"vuoto","vuoto","vuoto","vuoto",risorsa,colore,punti);
		//System.out.println(id + topLeft+topRight+bottomLeft+bottomRight+"vuoto"+"vuoto"+"vuoto"+"vuoto"+risorsa+colore+punti );// codice di debug
			// System.out.println("il top left è " + cartaRisorsa[i].getId());
			 
	//	 System.out.println(id+" "+ cartaRisorsa[i].getId()+" "+cartaRisorsa[i].getAngoloFronteTopLeft());	
		 
		 i++;
	}		
	
	leggi.close();
	return cartaRisorsa;
	
	  
	}
	public static void main(String[] args) throws FileNotFoundException {
		CartaRisorsa[] mazzo = new CartaRisorsa[40];  
		mazzo= costruisciCarteRisorsa();
		 mazzo= mescolaMazzo();
		 System.out.println("fine");
			for (int j = 1; j<20;j++) {
				System.out.println( +mazzo[j].getId()+" "+mazzo[j].getAngoloFronteTopLeft());	
			//	  System.out.println(Arrays(listaCarte.get(j)));	
			}
		
	}
	public static  CartaRisorsa[] mescolaMazzo() throws FileNotFoundException{
		CartaRisorsa[] mazzo = new CartaRisorsa[40];  
		CartaRisorsa[] temp = new CartaRisorsa[40]; 
		mazzo= costruisciCarteRisorsa();
		Random rnd = new Random();
		int posizioneRandom;
		
	for (int i = 19; i>0;i--) {
		posizioneRandom=rnd.nextInt(i );
		posizioneRandom+=1; // il numero random viene generato da 0 a 19, non esistono elementi nella posizine 0 quindi aggiungiamo 1
		
		temp[i]=mazzo[posizioneRandom];
		mazzo[posizioneRandom]= mazzo[i];
		mazzo[i]=temp[i];
		
		
		//System.out.println(posizioneRandom+"id random"+temp[i].getId()+"id mazzo"+mazzo[i].getId());
		System.out.println(i+"posizione random"+posizioneRandom);
		//	mazzo[posizioneRandom].equals(mazzo[i]);
		//mazzo[i].equals(temp);
				
		// System.out.println( mazzo[i].getId()+" "+mazzo[i].getAngoloFronteTopLeft());	
	}

	
//	ArrayList<CartaRisorsa[]> listaCarte = new ArrayList<>();
	//  Collections.(listaCarte,mazzo);
	  //Collections.shuffle(listaCarte);
	
	//	  for (int j =1; j<10; j++) {
			  
	//		  System.out.println("il top left è " + cartaRisorsa[j].getId());
			  
	//	  }
		return mazzo;
	}
	
	
}


