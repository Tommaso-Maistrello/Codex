package Tabellone;

import java.util.Formatter;
import java.util.List;

import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.Colore;
import Enum.StatoAngolo;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;

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
		this.id=9;		
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
		
		case VEGETALE: 	risorsaCentraleToString="    \u001B[32m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case ANIMALE: 	risorsaCentraleToString="    \u001B[36m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case INSETTI: 	risorsaCentraleToString="    \u001B[31m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		case FUNGHI: 	risorsaCentraleToString="     \u001B[35m"+risorsaCentrale.toString()+"\u001B[0m ";
									break;
		default: 	risorsaCentraleToString="\t";
					break;
		}
		for(int i=0; i<SIZE; i++) {
			
			if(i==0 || i==2) {
				switch(angoli[i]) {
				
				case VEGETALE: 	angoliToString[i]="\u001B[32m"+angoli[i].toString()+"\u001B[0m\t    ";
											break;
				case ANIMALE: 	angoliToString[i]="\u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INSETTI: 	angoliToString[i]="\u001B[31m"+angoli[i].toString()+"\u001B[0m\t     ";
											break;
				case FUNGHI: 	angoliToString[i]="\u001B[35m"+angoli[i].toString()+"\u001B[0m\t      ";
											break;
				case PIUMA: 	angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m\t       ";
											break;
				case INCHIOSTRO:angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m   ";				
											break;
				case PERGAMENA: angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case NULL: 		angoliToString[i]="\t       ";
											break;
				case VUOTO: 	angoliToString[i]=angoli[i].toString()+"        ";
											break;
				case COPERTO: 	angoliToString[i]=angoli[i].toString()+"      ";
											break;
				}
				angoliToString[i]=" "+angoliToString[i];
			}
			else{
				switch(angoli[i]) {
				
				case VEGETALE: 	angoliToString[i]="     \u001B[32m"+angoli[i].toString()+"\u001B[0m";
											break;
				case ANIMALE: 	angoliToString[i]="   \u001B[36m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INSETTI: 	angoliToString[i]="      \u001B[31m"+angoli[i].toString()+"\u001B[0m";
											break;
				case FUNGHI: 	angoliToString[i]="       \u001B[35m"+angoli[i].toString()+"\u001B[0m";
											break;
				case PIUMA: 	angoliToString[i]="        \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case INCHIOSTRO:angoliToString[i]="   \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case PERGAMENA: angoliToString[i]=" \u001B[33m"+angoli[i].toString()+"\u001B[0m";
											break;
				case NULL: 		angoliToString[i]="\t     ";
											break;
				case VUOTO: 	angoliToString[i]="        "+angoli[i].toString();
											break;
				case COPERTO: 	angoliToString[i]="      "+angoli[i].toString();
											break;
				}
				angoliToString[i]=angoliToString[i]+" ";
			}
		}
			
	}

	protected int getId() {
		return id;
	}
	protected String getIdColored() {
		String idColorato = String.valueOf(getId());
		Colore coloreCarta;
		
		if(getId()>=1 && getId()<=40) {
			List<CartaRisorsa> mazzoRisorsa = MazzoCarteRisorsa.getMazzoRisorsa();
			CartaRisorsa cartaRisorsaCercata = mazzoRisorsa.get(getId()-1);
			coloreCarta=cartaRisorsaCercata.getColore();
		} else if(getId()>=41 && getId()<=80) {
			List<CartaOro> mazzoOro = MazzoCarteOro.getMazzoOro();
			CartaOro cartaOroCercata = mazzoOro.get(getId()-41);
			coloreCarta=cartaOroCercata.getColore();
		} else {
			coloreCarta=null;
		}
		
		if(coloreCarta!=null) {
			switch(coloreCarta) {
				case VERDE:	idColorato="\u001B[32m"+idColorato+"\u001B[0m";
					break;
				case VIOLA:	idColorato="\u001B[35m"+idColorato+"\u001B[0m";
					break;
				case BLU:	idColorato="\u001B[36m"+idColorato+"\u001B[0m";
					break;
				case ROSSO:	idColorato="\u001B[31m"+idColorato+"\u001B[0m";
					break;
				case ORO: 	idColorato="\u001B[33m"+idColorato+"\u001B[0m";
					break;
			}
		} else if(getId()<80) idColorato=" ";
		
		if(getId()<10) idColorato=idColorato+" ";
		
		return idColorato;
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
