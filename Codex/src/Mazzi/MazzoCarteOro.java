package Mazzi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.Colore;
import Enum.StatoAngolo;

public class MazzoCarteOro {
    public static List<CartaOro> mazzoOro = new ArrayList<>();
    public static void costruisciMazzo() {
        try {
            File fileOro = new File("carteOro.txt");
            Scanner leggi = new Scanner(fileOro);
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
                String condizione = leggi.next();
                String condizioneA = leggi.next();
                int numeroAnimale = leggi.nextInt();
                String condizioneFunghi = leggi.next();
                int numeroF = leggi.nextInt();
                String condizioneInsetti = leggi.next();
                int numeroI = leggi.nextInt();
                String condizioneVegetali = leggi.next();
                int numeroV = leggi.nextInt();
                leggi.nextLine(); // Move to the next line

                mazzoOro.add(new CartaOro(id, fronteTopLeft, fronteTopRight, fronteBottomLeft, fronteBottomRight, 
                                          retroTopLeft, retroTopRight, retroBottomLeft, retroBottomRight, 
                                          risorsaRetroCentrale, colore, condizione, condizioneA, numeroAnimale, 
                                          condizioneFunghi, numeroF, condizioneInsetti, numeroI, condizioneVegetali, 
                                          numeroV));
            }

            leggi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
	public static List<CartaOro>  getMazzoOro() {
		return mazzoOro;
		
	}
	
	public static void mischiaMazzo() {
	        Collections.shuffle(mazzoOro);    
	    	
	}
	
}
