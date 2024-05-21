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
	  Giocatore[] player;
	  private static Mano mano;

	public void newPartita( )throws FileNotFoundException {
		
		//CartaRisorsa.newMazzoRisorsa();
		
		
	//	CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
	//	Tavolo tavolo = new Tavolo(estratte);
	//	tavolo.visualizzaObiettiviComuni();
		
		
		//Campo campo = new Campo();
		//campo.visualizzaCampo();
		Giocatore.creaGiocatori();
//		player = Giocatore.disordinaGiocatori();
		pescaCarte();
	}
	public void pescaCarte() {
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
    
        mano= new Mano(Mano.getCartaRisorsa1(), Mano.getCartaRisorsa2(), Mano.getCartaOro());
      //  System.out.println("lungezza lista inizialie mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
       
        Giocatore.getMano(mano);
        
       // Mano[] mano = new Mano[]; //pesca le prime 2 carte da mazzo risorsa e la prima da mazzo oro
        
       
        System.out.println("carta oro" + mano.getCartaOro().getId());
       
        System.out.println("carta risorsa 1" + mano.getCartaRisorsa1().getId());
        System.out.println("carta risorsa 2" +mano.getCartaRisorsa2().getId());
	System.out.println("lungezza listafinale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
	System.out.println("lungezza listafinale mazzoOro" +MazzoCarteOro.mazzoOro.size());
		 //System.out.println("id giocatore " +mano.getNumeroGiocatore());
 
	}
}
