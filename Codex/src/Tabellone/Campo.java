package Tabellone;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Carte.Carta;
import Carte.CartaIniziale;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Gioco.Giocatore;
import Gioco.Mano;
import Gioco.Partita;

public class Campo {

	// Se l'utente dovesse posizionare tutte le carte in diagonale, la grandezza
	// massima sarebbe di 41 caselle occupate ma bisgona considerare ogni direzione
	private final Casella[][] tabella;
	private static final int SIZE = 21;

	public Campo() {
		tabella = new Casella[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				tabella[i][j]=new Casella(new Coordinata(i, j));
			}
		}
	}
	
	public Casella getCasella(Coordinata coordinata) {
		return this.tabella[coordinata.getX()][coordinata.getY()];
	}
	/*
	public String toString() {
		String ret = "";
		ret += "---------------------------------------------------";
		ret += "------------------------------------------------\n";
		for (int i = 0; i < SIZE; i++) {
		ret += "| ";
		for (int j = 0; j < SIZE; j++) {
		ret += tabella[i][j].toString();
		ret += " | ";
		}
		ret += "\n";
		ret += "------------------------------------------------\n";
		ret += "---------------------------------------------------";
		}
		ret += "\n ";
		return ret;
	}*/
	public void casellaSpecifica() {
		
		Scanner sc = new Scanner(System.in);
		
        String risposta="";
        boolean verifica=false;
        
        //Richiedo se vuole visualizzare una cella finchè non è soddisfatto
        while(!risposta.equals("no") && !risposta.equals("n")) {
        	//Controllo la risposta
	        do {
	            System.out.println("Vuoi visualizzare una casella nello specifico (si/no)? ");
	            risposta = sc.nextLine().toLowerCase();
	        } while (!risposta.equals("sì") && !risposta.equals("si") && !risposta.equals("s") && !risposta.equals("no") && !risposta.equals("n"));
	
	        //Se risponde sì devo chgiedere l'id della carta da visualizzare
	        if (risposta.equals("sì") || risposta.equals("si") || risposta.equals("s")) {
	        	int idCercato=-1;
	        	//Controllo che l'id inserito sia valido
	        	do {
		        	System.out.println("Qual è l'id della carta che vuoi visualizzare? ");
		        	idCercato = sc.nextInt();
		        	//pulisco il buffer
		        	sc.nextLine();
		        	//faccio passare tutta la tabella per cercare la cella con l'id richiestoo
		        	for(int i=0; i<SIZE; i++) {
		        		for(int j=0; j<SIZE; j++) {
		        			if(tabella[i][j].getId()==idCercato) {
		        				System.out.println("Visualizzazione della casella specificata...");
		        				tabella[i][j].visualizzaCasella();
		        				verifica=true;
		        			}
		        		}
		        	}
		        	//se non trova la carta lo dico all'utente
		        	if(verifica==false) {
		        		System.out.println("L'id inserito non è stato trovato, riprovare con un altro id.");
		        	}
	        	}while(verifica==false);
	        }
        }
		//sc.close();
	}
public void visualizzaCampo() {
		
		//RIGA NUMERI
		System.out.print( "  ");
		for(int i=0; i<SIZE-2; i++) {
		System.out.print(" "+i+" ");
		}
		System.out.println();
		//Sopra
		System.out.print("  ┌─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┬─");
		}
		System.out.print("─┐");
		//Mezzo
		System.out.println();
		System.out.print(0);// PRIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		System.out.print(" │");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[0][i].getIdColored());
			System.out.print("│");
		}
		
		//Sotto
		System.out.println();
		System.out.print("  ├─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┼─");
		}
		System.out.print("─┤");
		
		//RIGHE IN MEZZO
		int k=0;
		for(int j=1; j<SIZE-1; j++) {
			System.out.println();
			k=j;
			System.out.print(k);
			if (j<10) {
				System.out.print(" │");
			}else {
				System.out.print("│");
			}
			
			for(int i=0; i<SIZE; i++) {
				System.out.print(tabella[j][i].getIdColored());
				System.out.print("│");
			}
			//COLONNA NUMERI
			
			//Sotto
			System.out.println();
			System.out.print("  ├─");
			for(int i=0; i<SIZE-1; i++) {
				System.out.print("─┼─");
			}
			System.out.print("─┤");
			
		}
		//RIGA IN MEZZO CON CARTA INIZIALE
		//ULTIMA RIGA
		System.out.println();
		k=SIZE-2;
		System.out.print(k);// ULTIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		System.out.print("│");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[SIZE-1][i].getIdColored());
			System.out.print("│");
		}
		
		System.out.println();
		System.out.print("  └─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┴─");
		}
		System.out.print("─┘");
		System.out.println();
		
		//casellaSpecifica();
	}
	   
	  /*public void posizionaCartaIniziale(Giocatore giocatore) {
		    int X = SIZE / 2;
		    int Y = SIZE / 2;
		    giocatore.getCampo().setCartaIniziale(giocatore.getCartaIniziale().getId());
		   /*dovrebbe essere modificata a
		    *  tabella[X][Y].setCartaIniziale(giocatore.getCartaIniziale());
		    * cosi prende tutta la carta anzi che solo l'id
		    * 
		    
		}*/
	  public void posizionaCartaIniziale(Giocatore giocatore) {
	        int centroX = SIZE/2-1;
	        int centroY = SIZE/2-1;
	        int k =  SIZE/2-1;
	        System.out.println("la posizion della carta centrale è:"+k);
	        tabella[centroX][centroY].setCartaIniziale(giocatore.getCartaIniziale());
	    }

	public int getSize() {
		return SIZE;
	}	
		/*
	
	public void giocataCarta(Giocatore player) {
	    Scanner sc = new Scanner(System.in);

	    // Display cards in hand
	    System.out.println("Carte nella tua mano:");
	    Mano mano = player.getMano();
	    
	    // Show resource cards
	    List<CartaRisorsa> manoRisorsa = mano.getManoRisorsa();
	    if (!manoRisorsa.isEmpty()) {
	        System.out.println("Carte Risorsa:");
	        for (int i = 0; i < manoRisorsa.size(); i++) {
	            System.out.println((i + 1) + ". " + manoRisorsa.get(i));
	        }
	    }
	    
	    // Show gold cards
	    List<CartaOro> manoOro = mano.getManoOro();
	    if (!manoOro.isEmpty()) {
	        System.out.println("Carte Oro:");
	        for (int i = 0; i < manoOro.size(); i++) {
	            System.out.println((i + 1) + ". " + manoOro.get(i));
	        }
	    }
	    
	    // Choose type of card to play
	    int tipoCarta = -1;
	    do {
	        System.out.print("Scegli il tipo di carta che vuoi giocare (1 per Risorsa, 2 per Oro): ");
	        tipoCarta = sc.nextInt();
	        if (tipoCarta != 1 && tipoCarta != 2) {
	            System.out.println("Scelta non valida. Riprova.");
	        }
	    } while (tipoCarta != 1 && tipoCarta != 2);

	    // Choose the specific card to play
	    int sceltaCarta = -1;
	    List<? extends Carta> carteInMano;
	    if (tipoCarta == 1) {
	        carteInMano = manoRisorsa;
	    } else {
	        carteInMano = manoOro;
	    }

	    do {
	        System.out.print("Scegli il numero della carta che vuoi giocare: ");
	        sceltaCarta = sc.nextInt() - 1;
	        if (sceltaCarta < 0 || sceltaCarta >= carteInMano.size()) {
	            System.out.println("Scelta non valida. Riprova.");
	        }
	    } while (sceltaCarta < 0 || sceltaCarta >= carteInMano.size());

	    Carta cartaDaGiocare = carteInMano.get(sceltaCarta);

	    // Ask for coordinates
	    int x = -1, y = -1;
	    boolean coordinataValida = false;
	    do {
	        System.out.print("Inserisci la coordinata X dove vuoi posizionare la carta: ");
	        x = sc.nextInt();
	        System.out.print("Inserisci la coordinata Y dove vuoi posizionare la carta: ");
	        y = sc.nextInt();

	        if (x >= 0 && x < player.getCampo().getSize() && y >= 0 && y < player.getCampo().getSize()) {
	            Coordinata coordinata = new Coordinata(x, y);
	            if (player.getCampo().getCasella(coordinata).getId()!=0) {
	                coordinataValida = true;
	            } else {
	                System.out.println("La casella è già occupata. Riprova.");
	            }
	        } else {
	            System.out.println("Coordinate fuori dai limiti del campo. Riprova.");
	        }
	    } while (!coordinataValida);

	    Coordinata coordinata = new Coordinata(x, y);
	    player.getCampo().getCasella(coordinata).setCarta(cartaDaGiocare.getId());
	    
	    // Remove the card from player's hand
	    if (tipoCarta == 1) {
	        mano.rimuoviCartaRisorsa((CartaRisorsa) cartaDaGiocare);
	    } else {
	        mano.rimuoviCartaOro((CartaOro) cartaDaGiocare);
	    }

	    System.out.println("Hai posizionato la carta " + cartaDaGiocare + " sulla casella (" + x + ", " + y + ").");
	}
*/

}
