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
	public  static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();

	public static  void costruisciMazzo() {
		
	        
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

	                CartaRisorsa carta = new CartaRisorsa(id, fronteTopLeft, fronteTopRight, fronteBottomLeft, fronteBottomRight, 
	                                                     retroTopLeft, retroTopRight, retroBottomLeft, retroBottomRight, risorsaRetroCentrale, 
	                                                     colore, punti);
	                mazzoRisorse.add(carta);
	            }
	            
	            leggi.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        }
	        System.out.println("Contenuto del mazzo di risorse:");			
	        
	    

	}
	
	public static List<CartaRisorsa> getMazzoRisorsa() {
		return mazzoRisorse;
		
	}
	   public static void mischiaMazzo() {
	        Collections.shuffle(mazzoRisorse);
	    }
	public static void main(String[] args) throws FileNotFoundException {
	
		//main di prova per vedere se funziona
		costruisciMazzo();
		List<CartaRisorsa> a = getMazzoRisorsa();
		
		    for (CartaRisorsa carta : a) {
	            System.out.println(carta.getId() +"   - "+ carta.getAngoloFronteBottomLeft()+ "  .");
	        }
		    
		  
		  
	}
}
