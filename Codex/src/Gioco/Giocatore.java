package Gioco;

import java.util.Scanner;

import Enum.ColoreSegnalino;

public class Giocatore {

	private final String username;
	private final ColoreSegnalino coloreSegnalino;
	private boolean pedinaNera;
	private int posizione;
	
	/***
	 * Costruttore della classe Giocatore
	 * 
	 * @param username		->	parametro che passa lo username del nuovo giocatore
	 * @param numGiocatore	->	parametro che passa il numero del giocatore 
	 * 							(1o giocatore: 1, 2o giocatore: 2, ecc...)
	 * 							così da sapere a quale giocatore assenare la pedina nera
	 */
	public Giocatore(String username, int numGiocatore){
		this.username=username;
		this.posizione=0;
		coloreSegnalino=ColoreSegnalino.getColore();
		if(numGiocatore==1) this.pedinaNera=true;
		else this.pedinaNera=false;
	}
	
	public int getPosizione() {
		return posizione;
	}
	
	
	/**
	 * Aggiorna la nuova posizione del giocatore
	 * @param posizione
	 */
	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	public String getUsername() {
		return username;
	}
	public ColoreSegnalino getColoreSegnalino() {
		return coloreSegnalino;
	}
	public boolean isPedinaNera() {
		return pedinaNera;
	}
	
	private static  Giocatore[] setGiocatori() {


		

		Scanner sc=new Scanner(System.in);
		
		int numGiocatori=0;
				
		do {
			System.out.println("Inserisci il numero di giocatori: ");
			numGiocatori=sc.nextInt();
		}while(numGiocatori<2 || numGiocatori>4);
		
		//libera il buffer
		sc.nextLine();
		
		Giocatore[] giocatori= new Giocatore[numGiocatori];
		
		for(int i=0; i<giocatori.length; i++)
		{
			int j=i+1;
			System.out.println("Inserisci l'username "+ j +"o giocatore: ");
			String nome=sc.nextLine();
			giocatori[i]=new Giocatore(nome, j);
		}
	
			return giocatori;
			
		}
	public static void main(String[] args) {
		
		Giocatore[] giocatori= new Giocatore[2];
		giocatori= setGiocatori();
		for(int i=0; i<giocatori.length; i++)
		{
	
			 
			 System.out.println("il giocatore "+i+1+" è "+giocatori[i].getClass()+giocatori[i].getUsername());
			 
		}
		}
			
	
}
