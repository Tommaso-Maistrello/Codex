package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Carte.CartaOro;
import Carte.CartaRisorsa;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;

public class Main {
	
	public static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();
	  public static List<CartaOro> mazzoOro = new ArrayList<>();
	  
	public static void main(String[] args) throws FileNotFoundException {
	
		Partita partita=new Partita();
		partita.newPartita();
		
	

       
	}
	
}
