package Gioco;

import Colori.ColoreSegnalino;

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

	
}
