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

	public void newPartita( )throws FileNotFoundException {
		
	
		 Scanner sc = new Scanner(System.in);
		
	//	Campo campo = new Campo();
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
			
			 
			System.out.println(" la carta ha "+player[i].getUsername()+"ha la carta con id"+player[i].getMano().getManoRisorsa().get(0).getId());
  			System.out.println(" la carta ha "+player[i].getUsername()+"ha la carta con id"+player[i].getMano().getManoRisorsa().get(1).getId());
  			
			
		 
		}
		  for(int j =0; j<player.length; j++) {
	   			 
	  			System.out.println(" la carta ha "+player[j].getUsername()+"ha la carta con id"+player[j].getMano().getManoRisorsa().get(0).getId());
	  			System.out.println(" la carta ha "+player[j].getUsername()+"ha la carta con id"+player[j].getMano().getManoRisorsa().get(1).getId());
	  			
	  		 
	  		}
			System.out.println("-------------------------------------------------------------"  );
	     	System.out.println("Il giocatore 1 è: "+ player[0].getUsername() );
	     	System.out.println("con segnalino colore: "+ player[0].getColoreSegnalino().toString().toLowerCase() );
	    	System.out.println("Il giocatore 2 è: "+ player[1].getUsername() );
	    	System.out.println("con segnalino colore: "+ player[1].getColoreSegnalino().toString().toLowerCase() );
	    	System.out.println("-------------------------------------------------------------"  );
	    	System.out.println("Premi Invio per continuare...");
	    	sc.nextLine();
	    	//player= Giocatore.disordinaGiocatori(player);
	    	System.out.println("Il primo giocatore è: "+ player[0].getUsername() );
	    	System.out.println("-------------------------------------------------------------"  );
	    	System.out.println("Premi Invio per continuare...");
	    	sc.nextLine();
	    	  for(int j =0; j<player.length; j++) {
		   			 
		  			System.out.println(" la carta ha "+player[j].getUsername()+"ha la carta con id"+player[j].getMano().getManoRisorsa().get(0).getId());
		  			System.out.println(" la carta ha "+player[j].getUsername()+"ha la carta con id"+player[j].getMano().getManoRisorsa().get(1).getId());
		  			
		  		 
		  		}
	    	estraiObbiettivi();
	     
	    	mostraMano();
	    	
		
			
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
	public void  mostraMano() {
		Scanner sc= new Scanner(System.in);
		CartaRisorsa cartaRisorsa;
		 
		int lunghezza;
		for(int i =0; i<player.length; i++) {
			System.out.println("è il turno del giocatore : "+ player[i].getUsername() );
    		System.out.println(" in mano ha le carte:" );
    		
    		lunghezza=player[i].getMano().getManoRisorsa().size();
			for(int j =0; j<lunghezza; j++) {
				 
				System.out.println(" la carta ha id"+player[i].getMano().getManoRisorsa().get(j).getId());
				cartaRisorsa=player[i].getMano().getManoRisorsa().get(j);
			Mano.visualizzaCartaRisorsa(cartaRisorsa);;
			
			}
			System.out.println("Premi Invio per continuare...");
	    	sc.nextLine();
    		
    		
		}
      
	 
	
	}
	public void estraiObbiettivi() throws FileNotFoundException {
	
		Scanner sc = new Scanner(System.in);
		CartaObiettivo[] mazzoObbiettivo= CartaObiettivo.costruisciCarteObiettivo();
		mazzoObbiettivo= CartaObiettivo.mescolaMazzo(mazzoObbiettivo);
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(mazzoObbiettivo);
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.visualizzaObiettiviComuni();
		System.out.println("Premi Invio per continuare...");
    	sc.nextLine();
		System.out.println("-------------------------------------------------------------"  );
		System.out.println("Scegli uno di questi 2 obbiettivi"  );
		
		
		
		  int id = 2;
        for (int i = 0; i < player.length; i++) {
            boolean valido = false;
            int scelta=-1;
               

            
            System.out.println("Il giocatore " + player[i].getUsername() + " può scegliere tra le carte:");
            System.out.println("1) Obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            System.out.println("2) Obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            do { 
            	System.out.print("Scegli l'id della carta (1 o 2): ");
             
                scelta=sc.nextInt();
                
                if (scelta == 1) {
                    valido = true;
                    scelta = id-2;
                    player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                    System.out.println("Il giocatore " + player[i].getUsername() + " ha scelto l'obiettivo con id " +player[i].getCartaObiettivo().getId());
                    System.out.println("-------------------------------------------------------------"  );
                } else if(scelta == 2) {
                	 valido = true;
                	 scelta = id-1;
                	   player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                	   player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                      System.out.println("Il giocatore " + player[i].getUsername() + " ha scelto l'obiettivo con id " +player[i].getCartaObiettivo().getId());
                      System.out.println("-------------------------------------------------------------"  );
                 
                     
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            } while (!valido);
        
        }

      
        
 
	
	}
	
}
