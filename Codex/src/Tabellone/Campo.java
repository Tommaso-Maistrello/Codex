package Tabellone;

import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Carte.CartaIniziale;
import Gioco.Giocatore;
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
		
		//PRIMA RIGA
		//Sopra
		System.out.print("┌─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┬─");
		}
		System.out.print("─┐");
		//Mezzo
		System.out.println();
		System.out.print("│");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[0][i].getIdColored());
			System.out.print("│");
		}
		//Sotto
		System.out.println();
		System.out.print("├─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┼─");
		}
		System.out.print("─┤");
		//RIGHE IN MEZZO
		for(int j=1; j<SIZE-1; j++) {
			System.out.println();
			System.out.print("│");
			for(int i=0; i<SIZE; i++) {
				System.out.print(tabella[j][i].getIdColored());
				System.out.print("│");
			}
			//Sotto
			System.out.println();
			System.out.print("├─");
			for(int i=0; i<SIZE-1; i++) {
				System.out.print("─┼─");
			}
			System.out.print("─┤");
		}
		//RIGA IN MEZZO CON CARTA INIZIALE
		//ULTIMA RIGA
		System.out.println();
		System.out.print("│");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[SIZE-1][i].getIdColored());
			System.out.print("│");
		}
		
		System.out.println();
		System.out.print("└─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┴─");
		}
		System.out.print("─┘");
		System.out.println();
		
		casellaSpecifica();
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
	        tabella[centroX][centroY].setCartaIniziale(giocatore.getCartaIniziale());
	    }

	public int getSize() {
		return SIZE;
	}
}
