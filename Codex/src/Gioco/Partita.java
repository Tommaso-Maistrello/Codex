package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;
import Tabellone.Campo;

public class Partita {
	public static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();
	  public static List<CartaOro> mazzoOro = new ArrayList<>();
	  private static Giocatore[] player;
	  private static Mano mano;

	public void newPartita( )throws FileNotFoundException {
		
		//CartaRisorsa.newMazzoRisorsa();
		
		
	//	CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
	//	Tavolo tavolo = new Tavolo(estratte);
	//	tavolo.visualizzaObiettiviComuni();
		
		
		//Campo campo = new Campo();
		//campo.visualizzaCampo();
		//Giocatore.creaGiocatori();
		
		
		player = Giocatore.setGiocatori();
		 
		//System.out.println("il giocatore 1 :"+ player[0].getUsername());
		//System.out.println("il giocatore 2c:"+ player[1].getUsername());
		
		for(int i =0; i<player.length; i++) {
			
		player[i].setMano(pescaCarte());
		System.out.println("il giocatore " + player[i].getUsername()+"ha id della carta risorsa 1: " +mano.getCartaRisorsa1(player[i]).getId() );	
		System.out.println("ilgiocatore " + player[i].getUsername()+"ha id della carta risorsa 2: " +mano.getCartaRisorsa2(player[i]).getId());	
		System.out.println("ilgiocatore " + player[i].getUsername()+"ha id della carta carta oro: " +mano.getCartaOro(player[i]).getId());
		}
		
		
		
//		player = Giocatore.disordinaGiocatori();
		pescaCarte();
	}
	public Mano pescaCarte() {
		// crea i mazzi

		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        
        List<CartaRisorsa> mazzoRisorsa= MazzoCarteRisorsa.getMazzoRisorsa();
        List<CartaOro> mazzoOro =MazzoCarteOro.getMazzoOro();
        
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
        
  
  
       
        Mano.PescaCartaRisorsa(mazzoRisorsa, 1);
        Mano.PescaCartaRisorsa(mazzoRisorsa, 2);
        Mano.PescaCartaOro(mazzoOro);
    
        mano= new Mano(Mano.getCartaRisorsa1(player[0]), Mano.getCartaRisorsa2(player[0]), Mano.getCartaOro(player[0]));
      //  System.out.println("lungezza lista inizialie mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
       
     
        
       // Mano[] mano = new Mano[]; //pesca le prime 2 carte da mazzo risorsa e la prima da mazzo oro
        /*
       
        System.out.println("carta oro" + mano.getCartaOro(player[0]).getId());
       
        System.out.println("carta risorsa 1  " + mano.getCartaRisorsa1(player[0]).getId());
        System.out.println("carta risorsa 2  " +mano.getCartaRisorsa2(player[0]).getId());
	System.out.println("lungezza listafinale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
	System.out.println("lungezza listafinale mazzoOro" +MazzoCarteOro.mazzoOro.size());
	*/
		 //System.out.println("id giocatore " +mano.getNumeroGiocatore());
	return mano;
	
	}
}
