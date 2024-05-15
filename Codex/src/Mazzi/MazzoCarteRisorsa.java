package Mazzi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Carte.CartaRisorsa;
import Enum.Colore;
import Enum.StatoAngolo;

public class MazzoCarteRisorsa {
	public  static CartaRisorsa[] mazzoRisorse = new  CartaRisorsa[40];

	public static  void costruisciMazzo() {
		int i=0;
	        
	        try {
	            File fileRisorsa = new File("carteRisorsa.txt");
	            Scanner leggi = new Scanner(fileRisorsa);
	            leggi.useDelimiter(",");
	            
	            while (leggi.hasNextLine()) {
	                int id = leggi.nextInt();
	                StatoAngolo fronteTopLeft = StatoAngolo.valueOf(leggi.next());
	                StatoAngolo fronteTopRight = StatoAngolo.valueOf(leggi.next());
	                StatoAngolo fronteBottomLeft = StatoAngolo.valueOf(leggi.next());
	                StatoAngolo fronteBottomRight = StatoAngolo.valueOf(leggi.next());
	                StatoAngolo retroTopLeft = StatoAngolo.VUOTO;
	                StatoAngolo retroTopRight = StatoAngolo.VUOTO;
	                StatoAngolo retroBottomLeft = StatoAngolo.VUOTO;
	                StatoAngolo retroBottomRight = StatoAngolo.VUOTO;
	                StatoAngolo risorsaRetroCentrale = StatoAngolo.valueOf(leggi.next());
	                Colore colore = Colore.valueOf(leggi.next());
	                int punti = leggi.nextInt();
	                leggi.nextLine(); // Sposta alla riga successiva

	                mazzoRisorse[i] = new CartaRisorsa(id, fronteTopLeft, fronteTopRight, fronteBottomLeft, fronteBottomRight, 
	                                                     retroTopLeft, retroTopRight, retroBottomLeft, retroBottomRight, risorsaRetroCentrale, 
	                                                     colore, punti);
	                i++;
	            }
	            
	            leggi.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Contenuto del mazzo di risorse:");			
	        
	    

	}
	
	public static CartaRisorsa[]  getMazzoRisorsa() {
		return mazzoRisorse;
		
	}
	public static void mischiaMazzo() {
		   List<CartaRisorsa> listaMazzo = new ArrayList<>();
	        Collections.addAll(listaMazzo, mazzoRisorse);

	        // Mischia la lista
	        Collections.shuffle(listaMazzo);

	        // Converto la lista mischiata di nuovo in un array
	        listaMazzo.toArray(mazzoRisorse);
	}
	
	/*
	public static void main(String[] args) throws FileNotFoundException {
	 
		//main di prova per vedere se funziona
		costruisciMazzo();
	
		mischiaMazzo() ;
		CartaRisorsa[] a = getMazzoRisorsa(	);
		    for (int i=0;i<a.length;i++) {
	            System.out.println(i+"id "+a[i].getId() +"   - "+a[i].getAngoloFronteBottomLeft()+ "  .");
	        }
		    
		  
		  
	}
	*/
}
