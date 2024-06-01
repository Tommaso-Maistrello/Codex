package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Carte.CartaIniziale;
import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;
import Tabellone.Campo;
import Tabellone.Casella;

public class Partita {
	private static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();
	  private static List<CartaOro> mazzoOro = new ArrayList<>();
	  public static CartaObiettivo[] carteObbiettivo;
	  private static Giocatore[] player;

	public void newPartita( )throws FileNotFoundException {
		
	
		 Scanner sc = new Scanner(System.in);
		
		
		
		//costruzione mazzi  
		
		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
    
        CartaIniziale[] carteIniziali = CartaIniziale.mescolaMazzo();
        
        player = Giocatore.setGiocatori();
        
        Giocatore.disordinaGiocatori(player) ;
		
        assegnaCarteIniziali(player, carteIniziali);
        

		for(int i =0; i<player.length; i++) {
			Mano mano = pescaCarte();
			 player[i].setMano(mano);
			 player[i].setCampo(new Campo());
			 
			
		}
		System.out.println("\n-------------------------------------------------------------\n"  );
	  	for(int i=0; i<player.length; i++) {
	  		int j=i+1;
	     	System.out.print("Il giocatore "+j+" è "+ player[i].getUsername());
	     	System.out.print(" con segnalino colore ");
	     	switch(player[i].getColoreSegnalino().toString().toLowerCase()) {
	     		case "rosso":	System.out.print("\u001B[31mrosso");
	     						player[i].setUsername("\u001B[31m"+player[i].getUsername()+"\u001B[0m");
	     						break;
	
	     		
	     		
	     		
	     		case "blu":		System.out.print("\u001B[34mblu");
	     						player[i].setUsername("\u001B[34m"+player[i].getUsername()+"\u001B[0m");
	     						break;
	     		case "verde":	System.out.print("\u001B[32mverde");
	     						player[i].setUsername("\u001B[32m"+player[i].getUsername()+"\u001B[0m");
	     						break;
	     		case "giallo":	System.out.print("\u001B[33mgiallo");
	     						player[i].setUsername("\u001B[33m"+player[i].getUsername()+"\u001B[0m");
	     						break;
	     		case "nero":	System.out.print("\u001B[30mnero");
	     						player[i].setUsername("\u001B[30m"+player[i].getUsername()+"\u001B[0m");
	     						break;
	     	}
	     	System.out.println("\u001B[0m.");
	    }
    	System.out.println("\n-------------------------------------------------------------"  );
    	System.out.println("\nPremi invio per continuare...");
    	sc.nextLine();
   
    
    	estraiObbiettivi();
     
    
    	 //mostraManoGiocatore(player[0]);
    	 //mostraManoGiocatore(player[1]);
        //Per visualizzare il campo di un giocatore usare:
    	for (Giocatore giocatore : player) {
    	        giocatore.getCampo().posizionaCartaIniziale(giocatore); // Aggiungi questa riga
    	        //mostraManoGiocatore(giocatore);
    	        //giocatore.getCampo().visualizzaCampo();
    	    }
    	//CICLO GIOCO
    	//verificare che quando un giocatore arriva a venti, acnhe gli altri finiscano il turno
    	//altrimenti creare una nuova variabile Giocatore a cui viene attribuito il numero del giocatore che ha finito, poi fare un for da quell'indice alla fine
    	boolean finito=false;
    	
    	do {
    		
	        for(Giocatore giocatore: player) {
	        	
	        	giocatore.getCampo().visualizzaCampo();
	        	mostraManoGiocatore(giocatore);
	        	giocatore.getCampo().giocaCarta(giocatore);
	        	giocatore.getCampo().visualizzaCampo();
	        	if(giocatore.getPunteggio()>=20) finito=true;
	        }
	        
    	}while(finito==false);
    	//AGGIUNGERE TURNO EXTRA -> VEDI REGOLE
	}
	public static void assegnaCarteIniziali( Giocatore[] giocatori,CartaIniziale[] cartaIniziale) {
		 

		System.out.println("Sono state assegnate le carte inziali");
		for (int i = 0; i < giocatori.length; i++) {
			giocatori[i].setCartaIniziale(cartaIniziale[i]);
			System.out.println("Il giocatore "+giocatori[i].getUsername()+" ha la carta con id: "+cartaIniziale[i].getId());
		}
		
	}
	public Mano pescaCarte() {

		List<CartaRisorsa> mazzoRisorsa = MazzoCarteRisorsa.getMazzoRisorsa();
	    List<CartaOro> mazzoOro = MazzoCarteOro.getMazzoOro();

	    List<CartaRisorsa> manoRisorsa = new ArrayList<>();
	    List<CartaOro> manoOro = new ArrayList<>();

	    manoRisorsa.add(mazzoRisorsa.remove(0));
	    manoRisorsa.add(mazzoRisorsa.remove(0));
	    manoOro.add(mazzoOro.remove(0));
      
        return new Mano(manoRisorsa, manoOro);
	
	}
	public static void  mostraMano(Giocatore[] player) {
		Scanner sc= new Scanner(System.in);
		CartaRisorsa cartaRisorsa;
		CartaOro cartaOro;
		int lunghezza;
		for(int i =0; i<player.length; i++) {
			System.out.println("È il turno del giocatore : "+ player[i].getUsername() );
    		System.out.println(" in mano ha le carte:" );
    		
    		 
			for(int j =0; j<player[i].getMano().getManoRisorsa().size(); j++) {
				 
				System.out.println(" la carta ha id "+player[i].getMano().getManoRisorsa().get(j).getId());
				cartaRisorsa=player[i].getMano().getManoRisorsa().get(j);
			//Mano.visualizzaCartaRisorsa(cartaRisorsa);
			Casella casellaRisorsa=new Casella(cartaRisorsa);
			casellaRisorsa.visualizzaCasella();
			
			}
			
			for(int j =0; j<player[i].getMano().getManoOro().size(); j++) {
				 
				System.out.println(" la carta ha id "+player[i].getMano().getManoOro().get(j).getId());
				cartaOro=player[i].getMano().getManoOro().get(j);
				//Mano.visualizzaCartaOro(cartaOro);
				Casella casellaRisorsa=new Casella(cartaOro);
				casellaRisorsa.visualizzaCasellaOro(cartaOro);
			
			}
			System.out.println("Premi Invio per continuare...");
	    	sc.nextLine();
	    	}
    		
    		
		}
		public static void  mostraManoGiocatore(Giocatore player) {
			Scanner sc= new Scanner(System.in);
			CartaRisorsa cartaRisorsa;
			CartaOro cartaOro;
			int lunghezza;
			
				System.out.println("È il turno del giocatore : "+ player.getUsername() );
	    		System.out.println(" in mano ha le carte:" );
	    		
	    		 
				for(int j =0; j<player.getMano().getManoRisorsa().size(); j++) {
					 
					System.out.println(" la carta ha id "+player.getMano().getManoRisorsa().get(j).getId());
					cartaRisorsa=player.getMano().getManoRisorsa().get(j);
				//Mano.visualizzaCartaRisorsa(cartaRisorsa);
				Casella casellaRisorsa=new Casella(cartaRisorsa);
				casellaRisorsa.visualizzaCasella();
				
				}
				
				for(int j =0; j<player.getMano().getManoOro().size(); j++) {
					 
					System.out.println(" la carta ha id "+player.getMano().getManoOro().get(j).getId());
					cartaOro=player.getMano().getManoOro().get(j);
					//Mano.visualizzaCartaOro(cartaOro);
					Casella casellaRisorsa=new Casella(cartaOro);
					casellaRisorsa.visualizzaCasellaOro(cartaOro);
				
				}
				System.out.println("Premi Invio per continuare...");
		    	sc.nextLine();
	    		
	    		
			
      
	 
	
	}
	public void estraiObbiettivi() throws FileNotFoundException {
	
		Scanner sc = new Scanner(System.in);
		CartaObiettivo[] mazzoObbiettivo= CartaObiettivo.costruisciCarteObiettivo();
		mazzoObbiettivo= CartaObiettivo.mescolaMazzo(mazzoObbiettivo);
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(mazzoObbiettivo);
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.visualizzaObiettiviComuni();
		System.out.println("-------------------------------------------------------------"  );
		System.out.println("\nPremi Invio per continuare...");
    	sc.nextLine();
		System.out.println("Ora ogni giocatore deve scegliere il proprio obiettivo segreto\n"  );
		
		
		
		  int id = 2;
        for (int i = 0; i < player.length; i++) {
            boolean valido = false;
            int scelta=-1;
               

            
            System.out.println(player[i].getUsername() + " può scegliere tra le carte:");
            System.out.println("1) obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            System.out.println("2) obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            do { 
            	System.out.print("Scegli la carta (1 o 2): ");
             
                scelta=sc.nextInt();
                
                if (scelta == 1) {
                    valido = true;
                    scelta = id-2;
                    player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                    System.out.println("\nIl giocatore " + player[i].getUsername() + " ha scelto l'obiettivo con id " +player[i].getCartaObiettivo().getId());
                    System.out.println("\n-------------------------------------------------------------\n"  );
                } else if(scelta == 2) {
                	 valido = true;
                	 scelta = id-1;
                	   player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                	   player[i].setCartaObiettivo(mazzoObbiettivo[scelta]);
                      System.out.println("\nIl giocatore " + player[i].getUsername() + " ha scelto l'obiettivo con id " +player[i].getCartaObiettivo().getId());
                      System.out.println("\n-------------------------------------------------------------\n"  );
                 
                     
                } else {
                    System.out.println("Scelta non valida. Riprova.");
                }
            } while (!valido);
        
        }

      
        
 
	
	}
	public static Giocatore[] getGiocatore( ) {
		return player;
	}

	
	
}
