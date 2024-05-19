package Tabellone;

import Enum.Colore;
import Enum.StatoAngolo;

public class Casella {

	private final Coordinata coordinata;
	private int id;
	private StatoAngolo[] angoli;
	private static final int SIZE=4;
	private StatoAngolo risorsaCentrale;
	private Colore colore;
	private int punti;

	protected Casella(Coordinata coordinata) {
		/*cancellato per prova sotto
		this.coordinata = coordinata;
		this.id=0;
		this.angoli = null;
		this.risorsaCentrale = null;
		this.colore = null;
		this.punti=0;*/
		//per prova
		this.coordinata = new Coordinata(1,1);
		this.id=1;		//1,VEGETALE,VEGETALE,NULL,VUOTO,VEGETALE,VERDE,0,
		this.angoli[0] = StatoAngolo.VEGETALE;
		this.angoli[1] = StatoAngolo.VEGETALE;
		this.angoli[2] = StatoAngolo.NULL;
		this.angoli[3] = StatoAngolo.VUOTO;
		this.risorsaCentrale = StatoAngolo.VEGETALE;
		this.colore = Colore.VERDE;
		this.punti=0;
	}

	protected int getId() {
		return id;
	}

	protected void setCarta(int id) {
		this.id = id;
		
	}
	protected boolean isEmpty() {
		if (this.id == 0) {
			return true;
		}
		return false;
	}

	protected Coordinata getCoordinata() {
		return coordinata;
	}
	
	protected void visualizzaCasella() {
		System.out.println(angoli[0]/*.getColoreSegnalino().toString().toLowerCase()*/);
	}
	
	/*
	@Override public String toString() { if (this.getCarta() != null) { return
	this.getCarta().toString(); } else { return " "; } }
	*/
}
