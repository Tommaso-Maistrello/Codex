package Tabellone;

import java.io.FileNotFoundException;

import Enum.Colore;
import Enum.StatoAngolo;
import Gioco.Partita;

public class Casella {

	private final Coordinata coordinata;
	private int id;
	private StatoAngolo[] angoli;
	private static String[] angoliToString;
//	private static final int SIZE=4;
	private static final int SIZE=10;
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
		this.angoli = new StatoAngolo[Casella.SIZE];
		this.angoliToString = new String[SIZE];
		this.angoli[0] = StatoAngolo.FUNGHI;
		this.angoli[1] = StatoAngolo.ANIMALE;
		this.angoli[2] = StatoAngolo.INSETTI;
		this.angoli[3] = StatoAngolo.NULL;
		this.angoli[4] = StatoAngolo.VEGETALE;
		this.angoli[5] = StatoAngolo.COPERTO;
		this.angoli[6] = StatoAngolo.VUOTO;
		this.angoli[7] = StatoAngolo.INCHIOSTRO;
		this.angoli[8] = StatoAngolo.PIUMA;
		this.angoli[9] = StatoAngolo.PERGAMENA;
		this.risorsaCentrale = StatoAngolo.VEGETALE;
		this.colore = Colore.VERDE;
		this.punti=0;
		
		for(int i=1; i<SIZE; i=i+2) {
			angoliToString[i]=angoli[i].toString();
		}
		for(int i=0; i<SIZE; i=i++) {
			
			switch(angoli[i]) {
				
				case StatoAngolo.VEGETALE: 	angoliToString[i]=angoli[i].toString();
											break;
				case StatoAngolo.ANIMALE: 	angoliToString[i]=angoli[i].toString()+"\t  ";
											break;
				case StatoAngolo.INSETTI: 	angoliToString[i]=angoli[i].toString();
											break;
				case StatoAngolo.FUNGHI: 	angoliToString[i]=angoli[i].toString();
											break;
				case StatoAngolo.PIUMA: 	angoliToString[i]=angoli[i].toString();
											break;
				case StatoAngolo.INCHIOSTRO:angoliToString[i]=angoli[i].toString();
											break;
				case StatoAngolo.PERGAMENA: angoliToString[i]=angoli[i].toString()+" ";
											break;
				case StatoAngolo.NULL: 		angoliToString[i]="\t  ";;
											break;
				case StatoAngolo.VUOTO: 	angoliToString[i]=angoli[i].toString()+"\t  ";
											break;
				case StatoAngolo.COPERTO: 	angoliToString[i]=angoli[i].toString()+"\t  ";
											break;
			}
		}
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
		System.out.println("| "+angoliToString[0]+"\t"+angoliToString[1]+" |");
		//System.out.println("|\t\t\t |");
		System.out.println("| "+angoliToString[2]+"  \t"+angoliToString[3]+" |");
		System.out.println("| "+angoliToString[4]+"  \t"+angoliToString[5]+" |");
		System.out.println("| "+angoliToString[6]+"  \t"+angoliToString[7]+" |");
		System.out.println("| "+angoliToString[8]+"  \t"+angoliToString[9]+" |");
		System.out.println();
		
		System.out.println("| "+angoliToString[3]+"\t"+angoliToString[6]+" |"/*.getColoreSegnalino().toString().toLowerCase()*/);
		//System.out.println("|\t\t\t |");
		System.out.println("| "+angoliToString[7]+"  \t"+angoliToString[8]+" |");
		System.out.println("| "+angoliToString[5]+"  \t"+angoliToString[4]+" |");
		System.out.println("| "+angoliToString[1]+"  \t"+angoliToString[2]+" |");
		System.out.println("| "+angoliToString[9]+"  \t"+angoliToString[0]+" |");
	}
	
	/*
	@Override public String toString() { if (this.getCarta() != null) { return
	this.getCarta().toString(); } else { return " "; } }
	*/
}
