package Tabellone;

import Enum.Colore;
import Enum.StatoAngolo;

public class Casella {

	private final Coordinata coordinata;
	private int id;
	private StatoAngolo[] angoli;
	private String[] angoliToString;
	private static final int SIZE=4;
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
		/*this.angoli[4] = StatoAngolo.COPERTO;
		this.angoli[5] = StatoAngolo.FUNGHI;
		this.angoli[6] = StatoAngolo.VUOTO;
		this.angoli[7] = StatoAngolo.PIUMA;
		this.angoli[8] = StatoAngolo.PERGAMENA;
		this.angoli[9] = StatoAngolo.PIUMA;*/
		this.risorsaCentrale = StatoAngolo.FUNGHI;
		this.colore = Colore.VERDE;
		this.punti=2;
		this.risorsaCentraleToString=null;
		
		switch(risorsaCentrale) {
		
		case StatoAngolo.VEGETALE: 	risorsaCentraleToString="    \u001B[32m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case StatoAngolo.ANIMALE: 	risorsaCentraleToString="    \u001B[36m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case StatoAngolo.INSETTI: 	risorsaCentraleToString="    \u001B[31m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case StatoAngolo.FUNGHI: 	risorsaCentraleToString="     \u001B[35m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		default: 	risorsaCentraleToString="\t";
					break;
		}
		for(int i=0; i<SIZE; i++) {
			
			if(i==0 || i==2) {
				switch(angoli[i]) {
				
				case StatoAngolo.VEGETALE: 	angoliToString[i]="\u001B[32m"+angoli[i].toString()+"\u001B[0m\t    ";
											break;
				case StatoAngolo.ANIMALE: 	angoliToString[i]="\u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.INSETTI: 	angoliToString[i]="\u001B[31m"+angoli[i].toString()+"\u001B[0m\t     ";
											break;
				case StatoAngolo.FUNGHI: 	angoliToString[i]="\u001B[35m"+angoli[i].toString()+"\u001B[0m\t      ";
											break;
				case StatoAngolo.PIUMA: 	angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m\t       ";
											break;
				case StatoAngolo.INCHIOSTRO:angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m   ";				
											break;
				case StatoAngolo.PERGAMENA: angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.NULL: 		angoliToString[i]="\t       ";
											break;
				case StatoAngolo.VUOTO: 	angoliToString[i]=angoli[i].toString()+"        ";
											break;
				case StatoAngolo.COPERTO: 	angoliToString[i]=angoli[i].toString()+"      ";
											break;
				}
				angoliToString[i]=" "+angoliToString[i];
			}
			else{
				switch(angoli[i]) {
				
				case StatoAngolo.VEGETALE: 	angoliToString[i]="     \u001B[32m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.ANIMALE: 	angoliToString[i]="   \u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.INSETTI: 	angoliToString[i]="      \u001B[31m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.FUNGHI: 	angoliToString[i]="       \u001B[35m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.PIUMA: 	angoliToString[i]="        \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.INCHIOSTRO:angoliToString[i]="   \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.PERGAMENA: angoliToString[i]=" \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case StatoAngolo.NULL: 		angoliToString[i]="\t     ";
											break;
				case StatoAngolo.VUOTO: 	angoliToString[i]="        "+angoli[i].toString();
											break;
				case StatoAngolo.COPERTO: 	angoliToString[i]="      "+angoli[i].toString();
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
		System.out.println("│"+angoliToString[0]+"│"+angoliToString[1]+"│");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		if(risorsaCentraleToString!="\t")System.out.println("│\t"+risorsaCentraleToString+"\t      │");
		System.out.println("│\t       "+punti+" \t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		System.out.println("│"+angoliToString[2]+"│"+angoliToString[3]+"│");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println();
	}
	
	/*
	@Override public String toString() { if (this.getCarta() != null) { return
	this.getCarta().toString(); } else { return " "; } }
	*/
}
