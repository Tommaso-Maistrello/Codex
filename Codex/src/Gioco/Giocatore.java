package Gioco;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import Carte.CartaIniziale;
import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.ColoreSegnalino;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;
import Tabellone.Campo;

public class Giocatore {

	private String username;
	private ColoreSegnalino coloreSegnalino;
	private int punteggio;
	private static int numGiocatore;
	private  Mano mano;
	private static Giocatore[] giocatori;
	private static CartaObiettivo obbiettivo;
	private Campo campo;
	private CartaIniziale cartaIniziale;
	
	public Giocatore(String username ) {
		this.username=username;
		this.coloreSegnalino=ColoreSegnalino.getColore();
		this.punteggio=0;
		this.mano= null;
		this.obbiettivo=null;
		this.setCartaIniziale(null);		
		this.campo=new Campo();
		
	}
	public void setCampo(Campo campo) {
		this.campo = campo;
	}
	public  Campo getCampo() {
		return campo;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Aggiorna la nuova punteggio del giocatore
	 * @param punteggio
	 */
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}
	
	public String getUsername() {
		return username;
	}
	
	public ColoreSegnalino getColoreSegnalino() {
		return coloreSegnalino;
	}

	public int  getNumGiocatori() {
		return numGiocatore;
	}
	
	
	
	public static Giocatore[] setGiocatori() {
		Scanner sc=new Scanner(System.in);
		
		int numGiocatori=0;
				
		/*do {
			System.out.print("Inserisci il numero di giocatori: ");
			numGiocatori=sc.nextInt();
			if(numGiocatori<2 || numGiocatori>4) {
				System.out.println("Numero dei giocatori inseriti non valido");
			}
		}while(numGiocatori<2 || numGiocatori>4);*/
		do {
            System.out.print("Inserisci il numero di giocatori: ");
            while (!sc.hasNextInt()) {
                System.out.println("Inserisci un numero valido tra 2 e 4.");
                sc.next(); // Consuma l'input non valido
            }
            numGiocatori = sc.nextInt();
            sc.nextLine(); // Consuma il newline rimanente
            if (numGiocatori < 2 || numGiocatori > 4) {
                System.out.println("Numero dei giocatori inseriti non valido. Inserisci un numero tra 2 e 4.");
            }
        } while (numGiocatori < 2 || numGiocatori > 4);
		
		System.out.println();
		Giocatore[] giocatori = new Giocatore[numGiocatori];
		
		
		for(int i=0; i<giocatori.length; i++)
		{
			int j=i+1;
			//DO-WHILE ERRORE STATIC
			//do {
				System.out.print("Inserisci lo username del giocatore numero "+ j+": ");
				String username=sc.nextLine();
				if(username.trim().isEmpty()) {
					System.out.println("Username inserito non valido");
				}
			//}while(username.trim().isEmpty());
			giocatori[i]=new Giocatore(username);
		}
		//sc.close();
		 
		return giocatori;
		}
	
	
	
	
	/*
	public static void creaGiocatori() {
		
		Giocatore[] giocatori = disordinaGiocatori();
		for(int i=0; i<giocatori.length; i++)
		{
			 int j=i+1;
			 System.out.println("Il giocatore che giocherà per "+j+"° è "+giocatori[i].getUsername()+" e ha segnalino "+ giocatori[i].getColoreSegnalino().toString().toLowerCase()+".");
			 
		}
	}
	*/

    public static Giocatore[] getGiocatori() {
       
        return giocatori;
    }
public static void  disordinaGiocatori( Giocatore[] giocatori) {
	 
		
		Random rnd = new Random();
		for (int i = 0; i < giocatori.length; i++) {
			int posizioneRandom = rnd.nextInt(giocatori.length);
			Giocatore temp = giocatori[posizioneRandom];
			
			giocatori[posizioneRandom] = giocatori[i];
			giocatori[i] = temp;
		}
		System.out.println("\n-------------------------------------------------------------\n"  );
		System.out.println("Elaborazione dell'ordine casuale di gioco in corso...\n");
		 
	}

	
	public void setMano(Mano mano) {
 
		this.mano= mano;
	}
	public  Mano getMano() {
		return mano;
	}

	public void setCartaObiettivo(CartaObiettivo cartaObiettivo) {
		this.obbiettivo= cartaObiettivo;
	}
	public CartaObiettivo getCartaObiettivo() {
		return obbiettivo;
	}
	public CartaIniziale getCartaIniziale() {
		return cartaIniziale;
	}
	public void setCartaIniziale(CartaIniziale cartaIniziale) {
		this.cartaIniziale = cartaIniziale;
	}
	 
	  
 
 
	
	
			
	
}