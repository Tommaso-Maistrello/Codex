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
		
		
	//	CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
	//	Tavolo tavolo = new Tavolo(estratte);
	//	tavolo.visualizzaObiettiviComuni();
		
		
		//Campo campo = new Campo();
		//campo.visualizzaCampo();
		//Giocatore.creaGiocatori();
		
		
		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
		
		player = Giocatore.setGiocatori();
		 
		//System.out.println("il giocatore 1 :"+ player[0].getUsername());
		//System.out.println("il giocatore 2c:"+ player[1].getUsername());
		
		for(int i =0; i<player.length; i++) {
			
		player[i].setMano(pescaCarte());
		/*
		System.out.println("il giocatore " + player[i].getUsername()+" ha id della carta risorsa 1: " +mano.getCartaRisorsa(player[i],0).getId());	
		System.out.println("ilgiocatore " + player[i].getUsername()+" ha id della carta risorsa 2: " +mano.getCartaRisorsa(player[i],5).getId());	
		System.out.println("ilgiocatore " + player[i].getUsername()+" ha id della carta carta oro: " +mano.getCartaOro(player[i],0).getId());
				System.out.println("il giocatore " + player[i].getUsername()+" ha id della carta risorsa 1: "+player[i].getMano().getCartaRisorsa(0).toString());
		System.out.println("il giocatore " + player[i].getUsername()+" ha id della carta risorsa 1: "+player[i].getMano().getCartaRisorsa(1).toString());
		System.out.println("il giocatore " + player[i].getUsername()+" ha id della carta risorsa 2: "+player[i].getMano().getCartaOro(0).toString());
		
		*/
		Mano mano2;
		mano2= player[i].getMano();
		
		System.out.println("il giocatore " + player[i].getUsername()+" ha id della carta risorsa 1:" +mano2.getCartaRisorsa(0).toString());

		
		}
		
		
		
//		player = Giocatore.disordinaGiocatori();
		
	}
	public Mano pescaCarte() {
		// crea i mazzi
		Mano manoTemporanea = null;
		
		Mano mano= null;
        
        List<CartaRisorsa> mazzoRisorsa= MazzoCarteRisorsa.getMazzoRisorsa();
        List<CartaOro> mazzoOro =MazzoCarteOro.getMazzoOro();
        
       
     	System.out.println("lungezza lista iniziale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
    	System.out.println("lungezza listaf iniziale mazzoOro" +MazzoCarteOro.mazzoOro.size()); 
  
    	   
       
    	manoTemporanea.PescaCartaRisorsa(mazzoRisorsa);
    	manoTemporanea.PescaCartaRisorsa(mazzoRisorsa);
    	manoTemporanea.PescaCartaOro(mazzoOro);
         List<CartaRisorsa> mazzoRisorsaTemporaneo;
        List<CartaOro> mazzoOroTemporaneo;
        mazzoRisorsaTemporaneo= manoTemporanea.getManoRisorsa();
        mazzoOroTemporaneo= manoTemporanea.getManoOro();
        mano= new Mano(mazzoRisorsaTemporaneo, mazzoOroTemporaneo);
        mazzoRisorsa =null;
        mazzoOro= null;
        System.out.println( mazzoOroTemporaneo.get(0).getId()+ "è stata eliminata");
      //  System.out.println("lungezza lista inizialie mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
       
     
        
       // Mano[] mano = new Mano[]; //pesca le prime 2 carte da mazzo risorsa e la prima da mazzo oro
        /*
       
        System.out.println("carta oro" + mano.getCartaOro(player[0]).getId());
       
        System.out.println("carta risorsa 1  " + mano.getCartaRisorsa1(player[0]).getId());
        System.out.println("carta risorsa 2  " +mano.getCartaRisorsa2(player[0]).getId());
      	*/  
	System.out.println("lungezza lista finale mazzoRisorse " +MazzoCarteRisorsa.mazzoRisorse.size());
	System.out.println("lungezza lista finale mazzoOro" +MazzoCarteOro.mazzoOro.size()); 

      	 
	    
        
		 //System.out.println("id giocatore " +mano.getNumeroGiocatore());
	return mano;
	
	}
}
