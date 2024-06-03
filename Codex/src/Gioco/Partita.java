package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Carte.CartaIniziale;
import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.StatoAngolo;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;
import Tabellone.Campo;
import Tabellone.Casella;

public class Partita {
		private static List<CartaRisorsa> mazzoRisorse = new ArrayList<>();
		private static List<CartaOro> mazzoOro = new ArrayList<>();
		private static List<CartaRisorsa> mazzoRisorsaOrigianle = new ArrayList<>();
		private static List<CartaOro> mazzoOroOriginale = new ArrayList<>();
		public static CartaObiettivo[] carteObbiettivo; 
		private static Giocatore[] player;

	public void newPartita( )throws FileNotFoundException {
		
		 Scanner sc = new Scanner(System.in);
		
		//costruzione mazzi  
		MazzoCarteOro.costruisciMazzo();
        MazzoCarteRisorsa.costruisciMazzo();
        MazzoCarteOro.setMazzoOroOriginale();
        MazzoCarteRisorsa.setMazzoRisorsaOriginale();
        
        //Mischia mazzi
        MazzoCarteOro.mischiaMazzo();
        MazzoCarteRisorsa.mischiaMazzo();
        CartaIniziale[] carteIniziali = CartaIniziale.mescolaMazzo();
        
        //Crea giocatori
        player = Giocatore.setGiocatori();
        
        assegnaCarteIniziali(player, carteIniziali);
        
        //Crea mano giocatori
		for(int i =0; i<player.length; i++) {
			Mano mano = pescaCarte();
			 player[i].setMano(mano);
			 player[i].setCampo(new Campo());
			
		}
		
		//Stampa il nome del giocatore con il colore assegnato
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
     
    
        //Per visualizzare il campo di un giocatore usare:
    	for (Giocatore giocatore : player) {
    	        giocatore.getCampo().posizionaCartaIniziale(giocatore); // Aggiungi questa riga
    	    }
    	
    	System.out.println("INIZIA IL GIOCO");
    	//CICLO GIOCO
    	boolean finito=false;
    	
    	do {
    		
	        for(Giocatore giocatore: player) {
	        	System.out.println("\n-------------------------------------------------------------\n"  );
	        	System.out.println("È IL TURNO DEL GIOCATORE "+giocatore.getUsername());
	        	System.out.println("\nPremi invio per continuare...");
	        	sc.nextLine();
	        	giocatore.getCampo().visualizzaCampo();
	        	mostraManoGiocatore(giocatore);
	        	giocatore.getCampo().casellaSpecifica();
	        	giocatore.getCampo().giocaCarta(giocatore);
	        	System.out.println("\nPremi invio per continuare...");
	        	sc.nextLine();
	        	
	        	System.out.println("Il numero di punti attuale é: "+giocatore.getPunteggio());
	        	System.out.println("\n-------------------------------------------------------------"  );
	        	System.out.println("\nPremi invio per continuare...");
	        	sc.nextLine();
	        	System.out.println("Pesca una nuova carta tra queste:\n");
	        	//sc.nextLine();
	        	pescaNuovaCarta(giocatore, sc);
	        	if(giocatore.getPunteggio()>=20) finito=true;
	        	sc.nextLine();
	        }
	        
    	}while(finito==false);
    	//AGGIUNGERE TURNO EXTRA 
    	System.out.println("\n-------------------------------------------------------------"  );
    	System.out.println("\nAVETE RAGGIUNTO 20 PUNTI, QUINDI ORA FARETE L'ULTIMO TURNO");
    	
    	for(Giocatore giocatore: player) {
        	System.out.println("\n-------------------------------------------------------------\n"  );
        	System.out.println("È IL TURNO DEL GIOCATORE "+giocatore.getUsername());
        	System.out.println("\nPremi invio per continuare...");
        	sc.nextLine();
        	giocatore.getCampo().visualizzaCampo();
        	mostraManoGiocatore(giocatore);
        	giocatore.getCampo().casellaSpecifica();
        	giocatore.getCampo().giocaCarta(giocatore);
        	System.out.println("\nPremi invio per continuare...");
        	sc.nextLine();
        	
        	System.out.println("Il numero di punti attuale é: "+giocatore.getPunteggio());
        	System.out.println("\n-------------------------------------------------------------"  );
        	System.out.println("\nPremi invio per continuare...");
        	sc.nextLine();
        	System.out.println("Pesca una nuova carta tra queste:\n");
        	//sc.nextLine();
        	pescaNuovaCarta(giocatore, sc);
        	sc.nextLine();
        }
    	//FINE PARTITA
    	System.out.println("\n-------------------------------------------------------------"  );
    	System.out.println("\nLA PARTITA È FINITA");
    	System.out.println("\n-------------------------------------------------------------\n"  );
    	int punti=0;
    	Giocatore vincitore=new Giocatore();
    	vincitore=player[0];
		for(int j =0; j<player.length;j++) {
			punti=player[j].getPunteggio();
			punti+= player[j].getCampo().controllaCarteObbiettivo(player[j], carteObbiettivo[0]);
			punti+= player[j].getCampo().controllaCarteObbiettivo(player[j], carteObbiettivo[1]);
			punti+= player[j].getCampo().controllaCarteObbiettivo(player[j], player[j].getCartaObiettivo());
			if(punti>vincitore.getPunteggio()) vincitore=player[j];
			System.out.println(player[j].getUsername()+" ha raggiunto "+punti+ " punti.");
		}
		System.out.println();
		System.out.println(vincitore.getUsername()+ " HAI VINTO!");
    		
    	
	}
	public static void assegnaCarteIniziali( Giocatore[] giocatori,CartaIniziale[] cartaIniziale) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\n-------------------------------------------------------------\n"  );
		for (int i = 0; i < giocatori.length; i++) {
			giocatori[i].setCartaIniziale(cartaIniziale[i]);
			System.out.println("Il giocatore "+giocatori[i].getUsername()+" ha la carta iniziale con id: "+cartaIniziale[i].getId());
		
		System.out.println("Per giocare la carta sul fronte scrivi 1, per giocare la carta sul retro scrivi 2");
		int verso=0;
		 do {
			 System.out.println("fornisci un input valido per il verso della carta");
			verso=sc.nextInt();
		}while(verso!=1 && verso!=2 );
		if (verso==2) {
			cartaIniziale[i].setAngoloFronteBottomLeft(StatoAngolo.VUOTO);
			cartaIniziale[i].setAngoloFronteBottomRight(StatoAngolo.VUOTO);
			cartaIniziale[i].setAngoloFronteTopLeft(StatoAngolo.VUOTO);
			cartaIniziale[i].setAngoloFronteTopRight(StatoAngolo.VUOTO);
		}
		player[i].setCartaIniziale(cartaIniziale[i]);
		 System.out.println("\nHai giocato la carta inziale sul fronte\n");
		}
		
		System.out.println("Sono state assegnate le carte inziali\n");
	}
	public void pescaNuovaCarta(Giocatore player, Scanner sc) {
		
		//importo i mazzi
		List<CartaRisorsa> mazzoRisorsa = MazzoCarteRisorsa.getMazzoRisorsa();
	    List<CartaOro> mazzoOro = MazzoCarteOro.getMazzoOro();
	    //due carte risorsa
	    CartaRisorsa cartaRisorsa1 = mazzoRisorsa.get(0);
	    CartaRisorsa cartaRisorsa2 = mazzoRisorsa.get(1);
	    CartaRisorsa cartaRisorsa3 = mazzoRisorsa.get(2);
	    Casella casellaRisorsa1=new Casella(mazzoRisorsa.get(0));
	    Casella casellaRisorsa2=new Casella(mazzoRisorsa.get(1));
	    Casella casellaRisorsa3=new Casella(mazzoRisorsa.get(2));
	    System.out.println("La seguente carta risorsa ha id "+casellaRisorsa1.getId());
		casellaRisorsa1.visualizzaCasella();
		System.out.println("La seguente carta risorsa ha id "+casellaRisorsa2.getId());
		casellaRisorsa2.visualizzaCasella();
		//due carte oro
		CartaOro cartaOro1 = mazzoOro.get(0);
		CartaOro cartaOro2 = mazzoOro.get(1);
		CartaOro cartaOro3 = mazzoOro.get(2);
		Casella casellaOro1=new Casella(mazzoOro.get(0));
		Casella casellaOro2=new Casella(mazzoOro.get(1));
		Casella casellaOro3=new Casella(mazzoOro.get(2));
		System.out.println("La seguente carta oro ha id "+casellaOro1.getId());
		casellaOro1.visualizzaCasellaOro(mazzoOro.get(0));
		System.out.println("La seguente carta oro ha id "+casellaOro2.getId());
		casellaOro2.visualizzaCasellaOro(mazzoOro.get(1));
		
		int scelta=-1;
		int mazzoScelto=-1;
		int idCartaScelta=-1;
		do {
            System.out.println("Vuoi pescare una carta scoperta o prenderne una dal mazzo? (1=carta scoperta, 2=mazzo)");
            while (!sc.hasNextInt()) {
                System.out.println("Inserisci un numero valido (1=carta scoperta, 2=mazzo) ");
                sc.next(); // Consuma l'input non valido
            }
            scelta = sc.nextInt();
            sc.nextLine(); // Consuma il newline rimanente
        } while (scelta != 1 && scelta != 2);
		
		if(scelta==1) {
			do {
	            System.out.print("Inserisci l'id della carta che vuoi pescare: ");
	            while (!sc.hasNextInt()) {
	                System.out.println("Id inserito non valido. Per favore, inserisci l'id di una carta presente.");
	                sc.next(); // Consuma l'input non valido
	                System.out.print("Inserisci l'id della carta che vuoi pescare: ");
	            }
	            idCartaScelta = sc.nextInt();
	        } while (idCartaScelta != casellaRisorsa1.getId() && idCartaScelta != casellaRisorsa2.getId() && idCartaScelta != casellaOro1.getId() && idCartaScelta != casellaOro2.getId());
			//AGGIUNTA CARTA IN MANO
			if(idCartaScelta<41) {
				if(idCartaScelta==cartaRisorsa1.getId()) {
					player.getMano().addCartaRisorsa(player, cartaRisorsa1);
					mazzoRisorsa.remove(0);
				}
				else {
					player.getMano().addCartaRisorsa(player, cartaRisorsa2);
					mazzoRisorsa.remove(1);
				}
				
			} else {
				if(idCartaScelta==cartaOro1.getId()) {
					player.getMano().addCartaOro(player, cartaOro1);
					mazzoOro.remove(0);

				}
				else {
					player.getMano().addCartaOro(player, cartaOro2);
					mazzoOro.remove(1);
				}
			}
			
			//TOLTA CARTA DAL MAZZO
		} else {
				do {
					System.out.print("Inserisci 1 se vuoi pescare dal mazzo risorsa e 2 se vuoi pescare dal mazzo oro: ");
					mazzoScelto=sc.nextInt();
				}while(mazzoScelto!=1 && mazzoScelto!=2);
				
				if(mazzoScelto==1) {
					player.getMano().addCartaRisorsa(player, cartaRisorsa3);
					mazzoRisorsa.remove(2);
					System.out.println("\nHai pescato la carta risorsa con id "+casellaRisorsa3.getId());
					casellaRisorsa3.visualizzaCasella();
				} else {
					player.getMano().addCartaOro(player, cartaOro3);
					mazzoOro.remove(2);
					System.out.println("\nHai pescato la carta oro con id "+casellaOro3.getId());
					casellaOro3.visualizzaCasellaOro(mazzoOro.get(2));
				}
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
			Casella casellaRisorsa=new Casella(cartaRisorsa);
			casellaRisorsa.visualizzaCasella();
			
			}
			
			for(int j =0; j<player[i].getMano().getManoOro().size(); j++) {
				 
				System.out.println(" la carta ha id "+player[i].getMano().getManoOro().get(j).getId());
				cartaOro=player[i].getMano().getManoOro().get(j);
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
			
	    		System.out.println("In mano ha le carte:\n" );
	    		
	    		 
				for(int j =0; j<player.getMano().getManoRisorsa().size(); j++) {
					 
					System.out.println("La carta risorsa con id "+player.getMano().getManoRisorsa().get(j).getId());
					cartaRisorsa=player.getMano().getManoRisorsa().get(j);
				Casella casellaRisorsa=new Casella(cartaRisorsa);
				casellaRisorsa.visualizzaCasella();
				
				}
				
				for(int j =0; j<player.getMano().getManoOro().size(); j++) {
					 
					System.out.println("La carta oro con id "+player.getMano().getManoOro().get(j).getId());
					cartaOro=player.getMano().getManoOro().get(j);
					Casella casellaRisorsa=new Casella(cartaOro);
					casellaRisorsa.visualizzaCasellaOro(cartaOro);
				
				}
				System.out.println("Premi invio per continuare...");
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
		System.out.println("\nPremi invio per continuare...");
    	sc.nextLine();
		System.out.println("Ora ogni giocatore deve scegliere il proprio obiettivo segreto\n"  );
		
		
		
		  int id = 2;
        for (int i = 0; i < player.length; i++) {
            boolean valido = false;
            int scelta=-1;
               

            
            System.out.println(player[i].getUsername() + " può scegliere tra le carte:\n");
            System.out.println("1) obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            System.out.println();
            System.out.println("2) obiettivo con id " + mazzoObbiettivo[id].getId()+": ");
            tavolo.visualizzaCaso(mazzoObbiettivo[id].getId());
            id++;
            do { 
            	System.out.print("\nScegli la carta (1 o 2): ");
             
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
	 public static CartaRisorsa prendiCartaRisorsaConID(int id) {
		 List<CartaRisorsa> mazzoRisorsaOrigianle = MazzoCarteRisorsa.getMazzoRisorsaOriginale();
		    
		 CartaRisorsa cartaR= null;
			for(CartaRisorsa carta: mazzoRisorsaOrigianle) {
				if (carta.getId()==id) {
					cartaR= carta;
				
					
					
				}
			}
		 return cartaR;
	 }
	 public static CartaOro prendiCartaOroConID(int id) {
	 
		 List<CartaOro> mazzoOroOriginale = MazzoCarteOro.getMazzoOroOriginale();
		 CartaOro cartaOro= null;
			for(CartaOro carta: mazzoOroOriginale) {
				if (carta.getId()==id) {
					cartaOro= carta;
					break;
				}
			}
		 return cartaOro;
	 }
	public static Giocatore[] getGiocatore( ) {
		return player;
	}
	public static void setCarteObbiettivo(CartaObiettivo[] carteObbiettivo) {
		Partita.carteObbiettivo = carteObbiettivo;
	}
	
	
	
}
