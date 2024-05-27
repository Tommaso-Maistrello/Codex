package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;
import Tabellone.Campo;

public class Partita {
	private static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();
	  private static List<CartaOro> mazzoOro = new ArrayList<>();
	  public static CartaObiettivo[] carteObbiettivo;
	  private static Giocatore[] player;
	private Scanner sc;
	  //private static Mano mano;

	public void newPartita( )throws FileNotFoundException {
		
		//CartaRisorsa.newMazzoRisorsa();
		MazzoCarteRisorsa.costruisciMazzo();
		MazzoCarteOro.costruisciMazzo();
		
		
		
		
		//Campo campo = new Campo();
		//campo.visualizzaCampo();
		
		
		//costruzione mazzi  
		
		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
    
        
        player = Giocatore.setGiocatori();
        
		Mano mano;

		for(int i =0; i<player.length; i++) {
			mano = pescaCarte();
			player[i].setMano(mano);
		 
		}
			System.out.println("-------------------------------------------------------------"  );
	     	System.out.println("i giocatore 1 è:"+ player[0].getUsername() );
	     	System.out.println("con segnalino colore:"+ player[0].getColoreSegnalino() );
	    	System.out.println("i giocatore 2 è:"+ player[1].getUsername() );
	    	System.out.println("con segnalino colore:"+ player[1].getColoreSegnalino() );
	    	System.out.println("-------------------------------------------------------------"  );
	    	player= Giocatore.disordinaGiocatori(player);
	    	System.out.println("il primo giocatore è :"+ player[0].getUsername() );
	    	System.out.println("-------------------------------------------------------------"  );
	    	  sc = new Scanner(System.in);
	    	  sc.nextInt();
	    	estraiObbiettivi();
			
	    //	tavolo.setObiettivoSegreto(estratte);
			
			
	}
	public Mano pescaCarte() {

        List<CartaRisorsa> mazzoRisorsa= MazzoCarteRisorsa.getMazzoRisorsa();
        List<CartaOro> mazzoOro =MazzoCarteOro.getMazzoOro();

         List<CartaRisorsa> mazzoRisorsaNew = null;
        List<CartaOro> mazzoOroNew=null;
        
       Mano mano= new Mano(mazzoRisorsaNew, mazzoOroNew);
       mano.PescaCartaRisorsa(mazzoRisorsa);
    	mano.PescaCartaRisorsa(mazzoRisorsa);
    	mano.PescaCartaOro(mazzoOro);
      
	return mano;
	
	}
	public void estraiObbiettivi() throws FileNotFoundException {

		CartaObiettivo[] mazzoObbiettivo= CartaObiettivo.costruisciCarteObiettivo();
		CartaObiettivo.mescolaMazzo(mazzoObbiettivo);
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(mazzoObbiettivo);
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.visualizzaObiettiviComuni();
		System.out.println("-------------------------------------------------------------"  );
		System.out.println("scegli uno di questi 2 obbiettivi"  );
	
		/*
		  Scanner sc = new Scanner(System.in);
		 
        for (int i = 0; i < player.length; i++) {
            boolean valido = false;
            int scelta;
            int id = 2 + i * 2;  

            do {
                System.out.println("Il giocatore " + player[i].getUsername() + " può scegliere tra le carte:");
                System.out.println("1: Obiettivo con id " + mazzoObbiettivo[id+1].getId());
                tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
                System.out.println("2: Obiettivo con id " + mazzoObbiettivo[id + 2].getId());
                tavolo.visualizzaCaso(mazzoObbiettivo[id + 2].getId());
                
                System.out.print("Scegli l'id della carta (1 o 2): ");
             
                
                scelta = sc.nextInt();
      
                if (scelta == 1 || scelta == 2) {
                    valido = true;
                   // player[i].setCartaObiettivo(mazzoObbiettivo[id + (scelta - 1)]);
                    System.out.println("Il giocatore " + player[i].getUsername() + " ha scelto l'obiettivo con id " + mazzoObbiettivo[id + (scelta - 1)].getId());
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            } while (!valido);
        }

        sc.close();
        
        */
	
	}
}
