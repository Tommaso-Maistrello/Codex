package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
	
public static  void costruisciCarteRisorsa() throws FileNotFoundException{
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
		
			 if ("".equals(topLeft)) {
				 topLeft = null;
			 } if ("".equals(bottomLeft)) {
				 topLeft = null;
			 } if ("".equals(bottomRight)) {
				 bottomLeft = null;
			 }
			 
			 cartaRisorsa[i]= new CartaRisorsa(id,topLeft,topRight,bottomLeft,bottomRight,"vuoto","vuoto","vuoto","vuoto",risorsa,colore,punti);
		//System.out.println(id + topLeft+topRight+bottomLeft+bottomRight+"vuoto"+"vuoto"+"vuoto"+"vuoto"+risorsa+colore+punti );// codice di debug
			// System.out.println("il top left è " + cartaRisorsa[i].getId());
			 i++;
		 
		
	}		
	
	leggi.close();
	
	
	  
	}
	public static void main(String[] args) throws FileNotFoundException {
		costruisciCarteRisorsa();
	
	 
		
	}
	public static  void mescolaMazzo(){
		List<CartaRisorsa> mazzo = new ArrayList<>();
	      Collections.shuffle(mazzo);

	//	  for (int j =1; j<10; j++) {
			  
	//		  System.out.println("il top left è " + cartaRisorsa[j].getId());
			  
	//	  }
	}
	
}


