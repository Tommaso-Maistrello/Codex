package Tabellone;

import java.io.FileNotFoundException;

import Enum.Colore;
import Enum.StatoAngolo;
import Gioco.Partita;

public class Casella {

	private final Coordinata coordinata;
	private int id;
	private StatoAngolo[] angoli;
	private String[] angoliToString;
	private static final int SIZE=8;
	private StatoAngolo risorsaCentrale;
	private String risorsaCentraleToString;
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
		this.angoli[1] = StatoAngolo.VEGETALE;
		this.angoli[0] = StatoAngolo.INSETTI;
		this.angoli[3] = StatoAngolo.NULL;
		this.angoli[2] = StatoAngolo.INCHIOSTRO;
		this.angoli[4] = StatoAngolo.COPERTO;
		this.angoli[5] = StatoAngolo.VEGETALE;
		this.angoli[6] = StatoAngolo.VUOTO;
		this.angoli[7] = StatoAngolo.PIUMA;
		/*this.angoli[8] = StatoAngolo.PERGAMENA;
		this.angoli[9] = StatoAngolo.PIUMA;*/
		this.risorsaCentrale = StatoAngolo.ANIMALE;
		this.colore = Colore.VERDE;
		this.punti=2;
		this.risorsaCentraleToString=null;
		
		switch(risorsaCentrale) {
		
		case VEGETALE: 	risorsaCentraleToString="\u001B[32m"+risorsaCentrale.toString()+"\u001B[0m";
									break;
		case ANIMALE: 	risorsaCentraleToString="\u001B[36m"+risorsaCentrale.toString()+"\u001B[0m";
									break;
		case INSETTI: 	risorsaCentraleToString="\u001B[31m"+risorsaCentrale.toString()+"\u001B[0m";
									break;
		case FUNGHI: 	risorsaCentraleToString="\u001B[35m"+risorsaCentrale.toString()+"\u001B[0m";
									break;
		//MANCA CASO ORO
		}
		for(int i=0; i<SIZE; i++) {
			
			if(i==0 || i==2 || i==4 || i==6) {
				switch(angoli[i]) {
				
				case VEGETALE: 	angoliToString[i]="\u001B[32m"+angoli[i].toString()+"\u001B[0m";
											break;
				case ANIMALE: 	angoliToString[i]="\u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INSETTI: 	angoliToString[i]="\u001B[31m"+angoli[i].toString()+"\u001B[0m";
											break;
				case FUNGHI: 	angoliToString[i]="\u001B[35m"+angoli[i].toString()+"\u001B[0m";
											break;
				case PIUMA: 	angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INCHIOSTRO:angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";				
											break;
				case PERGAMENA: angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case NULL: 		angoliToString[i]="\t  ";
											break;
				case VUOTO: 	angoliToString[i]=angoli[i].toString();
											break;
				case COPERTO: 	angoliToString[i]=angoli[i].toString();
											break;
				}
				angoliToString[i]=" "+angoliToString[i];
			}
			else{
				switch(angoli[i]) {
				
				case VEGETALE: 	angoliToString[i]="  \u001B[32m"+angoli[i].toString()+"\u001B[0m";
											break;
				case ANIMALE: 	angoliToString[i]="   \u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INSETTI: 	angoliToString[i]="   \u001B[31m"+angoli[i].toString()+"\u001B[0m";
											break;
				case FUNGHI: 	angoliToString[i]="    \u001B[35m"+angoli[i].toString()+"\u001B[0m";
											break;
				case PIUMA: 	angoliToString[i]="     \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INCHIOSTRO:angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case PERGAMENA: angoliToString[i]=" \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case NULL: 		angoliToString[i]="\t  ";
											break;
				case VUOTO: 	angoliToString[i]="     "+angoli[i].toString();
											break;
				case COPERTO: 	angoliToString[i]="   "+angoli[i].toString();
											break;
				}
				angoliToString[i]=angoliToString[i]+" ";
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
		System.out.println("┌──────────────┬──────────────┐");
		System.out.println("│"+angoliToString[2]+"   │   "+angoliToString[1]+"│");
		//System.out.println("_____¯¯");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		System.out.println("│\t    "+risorsaCentraleToString+" \t      │");
		System.out.println("│\t       "+punti+" \t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		//INCHIOSTRO X2
		//System.out.println("│ "+angoliToString[0]+"  │  "+angoliToString[3]+" │");
		System.out.println("│"+angoliToString[0]+"      │   "+angoliToString[3]+"   │");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println();


		
		System.out.println("┌──────────────┬──────────────┐");
		System.out.println("│"+angoliToString[4]+"      │   "+angoliToString[5]+"│");
		//System.out.println("_____¯¯");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		System.out.println("│\t    "+"\u001B[32m"+risorsaCentrale.toString()+"\u001B[0m"+" \t      │");
		System.out.println("│\t       "+"1"+" \t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		//INCHIOSTRO X2
		//System.out.println("│ "+angoliToString[0]+"  │  "+angoliToString[3]+" │");
		System.out.println("│"+angoliToString[6]+"        │   "+angoliToString[7]+"│");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println();
		
		/*
		for(int i=0; i<SIZE; i++) {
			System.out.println("| "+angoliToString[i]+" |");
		}*/
	}
	
	/*
	@Override public String toString() { if (this.getCarta() != null) { return
	this.getCarta().toString(); } else { return " "; } }
	*/
}
