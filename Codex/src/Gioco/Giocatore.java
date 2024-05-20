package Gioco;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Carte.CartaIniziale;
import Enum.ColoreSegnalino;

public class Giocatore {

	private final String username;
	private final ColoreSegnalino coloreSegnalino;
	private int punteggio;
	public static int numGiocatore;

	
	
	/***
	 * Costruttore della classe Giocatore
	 * 
	 * @param username		->	parametro che passa lo username del nuovo giocatore
	 * 
	 */
	public Giocatore(String username) {
		this.username=username;
		coloreSegnalino=ColoreSegnalino.getColore();
		this.punteggio=0;
		
	}
	
	public int getPunteggio() {
		return punteggio;
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
	
	
	
	private static Giocatore[] setGiocatori() {
		Scanner sc=new Scanner(System.in);
		
		int numGiocatori=0;
				
		do {
			System.out.println("Inserisci il numero di giocatori: ");
			numGiocatori=sc.nextInt();
			if(numGiocatori<2 || numGiocatori>4) {
				System.out.println("Numero dei giocatori inseriti non valido");
			}
		}while(numGiocatori<2 || numGiocatori>4);
		
		sc.nextLine(); //libera il buffer
		
		Giocatore[] giocatori = new Giocatore[numGiocatori];
		
		for(int i=0; i<giocatori.length; i++)
		{
			int j=i+1;
			//DO-WHILE ERRORE STATIC
			//do {
				System.out.println("Inserisci lo username del giocatore numero: "+ j);
				String username=sc.nextLine();
				if(username.trim().isEmpty()) {
					System.out.println("Username inserito non valido");
				}
			//}while(username.trim().isEmpty());
			giocatori[i]=new Giocatore(username);
		}
			return giocatori;
		}
	
	
	
	private static Giocatore[] disordinaGiocatori() {
		Giocatore[] giocatori = new Giocatore[numGiocatore];
		giocatori = setGiocatori();
		
		Random rnd = new Random();
		for (int i = 0; i < giocatori.length; i++) {
			int posizioneRandom = rnd.nextInt(giocatori.length);
			Giocatore temp = giocatori[posizioneRandom];
			giocatori[posizioneRandom] = giocatori[i];
			giocatori[i] = temp;
		}
		System.out.println("Elaborazione dell'ordine casuale di gioco in corso...");
		return giocatori;
	}
	
	private static int numGiocatori() {
		return numGiocatore;
	}	
	
	
	public static void creaGiocatori() {
		
		Giocatore[] giocatori = disordinaGiocatori();
		for(int i=0; i<giocatori.length; i++)
		{
			 int j=i+1;
			 System.out.println("Il giocatore che giocherà per "+j+"° è "+giocatori[i].getUsername()+" e ha segnalino "+ giocatori[i].getColoreSegnalino().toString().toLowerCase()+".");
			 
		}
	}
			
	
}