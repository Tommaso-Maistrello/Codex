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
	  //private static Mano mano;

	public void newPartita( )throws FileNotFoundException {
		
		//CartaRisorsa.newMazzoRisorsa();
		MazzoCarteRisorsa.costruisciMazzo();
		MazzoCarteOro.costruisciMazzo();
		
	//	CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
	//	Tavolo tavolo = new Tavolo(estratte);
	//	tavolo.visualizzaObiettiviComuni();
		
		
		Campo campo = new Campo();
		campo.visualizzaCampo();
		//Giocatore.creaGiocatori();
		
		
		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
		
		player = Giocatore.setGiocatori();
		Mano mano;
		

		for(int i =0; i<player.length; i++) {
			mano = pescaCarte();
			player[i].setMano(mano);
			System.out.println("il giocatore "+player[i].getUsername()+"la risorsa 1 in mano ha id" + player[i].getMano().getCartaRisorsa(0).getId());
			System.out.println("il giocatore "+player[i].getUsername()+"la risorsa 2 in mano ha id" + player[i].getMano().getCartaRisorsa(1).getId());
			System.out.println("il giocatore "+player[i].getUsername()+"la risorsa oro 1 in mano ha id" + player[i].getMano().getCartaRisorsa(0).getId());
			//System.out.println("id della carta pescata debug04321 è : "+mano.getCartaRisorsa(1).getId());
		 
		
		}
		
	}
	public Mano pescaCarte() {
		// crea i mazzi
		
		
        
        List<CartaRisorsa> mazzoRisorsa= MazzoCarteRisorsa.getMazzoRisorsa();
        List<CartaOro> mazzoOro =MazzoCarteOro.getMazzoOro();
        
       
     	System.out.println("lungezza lista iniziale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
    	System.out.println("lungezza listaf iniziale mazzoOro" +MazzoCarteOro.mazzoOro.size()); 
  
    	   
       
    	;
    	
         List<CartaRisorsa> mazzoRisorsaNew = null;
        List<CartaOro> mazzoOroNew=null;
        
      
       Mano mano= new Mano(mazzoRisorsaNew, mazzoOroNew);
       mano.PescaCartaRisorsa(mazzoRisorsa);
    	mano.PescaCartaRisorsa(mazzoRisorsa);
    	mano.PescaCartaOro(mazzoOro);
       
	System.out.println("lungezza lista finale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
	System.out.println("lungezza lista finale mazzoOro" +MazzoCarteOro.mazzoOro.size()); 

	return mano;
	
	}
}
