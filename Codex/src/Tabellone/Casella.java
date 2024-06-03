package Tabellone;

import java.util.List;

import Carte.CartaIniziale;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.Colore;
import Enum.StatoAngolo;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;

public class Casella {

	private  Coordinata coordinata;
	private int id;
	private StatoAngolo[] angoli;
	private String[] angoliToString;
	private static final int SIZE=4;
	private StatoAngolo risorsaCentrale;
	private String risorsaCentraleToString;
	private Colore colore;
	private int punti;

	//2 costruttori diversi per carta oro e carta obiettivo e carta iniziale
	
	protected Casella(Coordinata coordinata) {
		
		this.coordinata = coordinata;
		this.id=0;
		controlli();
		
	}
    public Casella(CartaIniziale cartaIniziale) {
    	 
        this.id = -1;
        this.coordinata=new Coordinata(); 
        this.angoli = new StatoAngolo[SIZE];
        this.angoli[0] = cartaIniziale.getAngoloFronteTopLeft();
        this.angoli[1] = cartaIniziale.getAngoloFronteTopRight();
        this.angoli[2] = cartaIniziale.getAngoloFronteBottomLeft();
        this.angoli[3] = cartaIniziale.getAngoloFronteBottomRight();
        this.angoliToString = new String[SIZE];
        this.risorsaCentrale = cartaIniziale.getRisorsaRetroCentrale();
        this.risorsaCentraleToString = null;
        this.setColore(null); 
        this.punti = 0; 
        controlli();
    }
    public void setCartaIniziale(CartaIniziale cartaIniziale) {
        this.id = cartaIniziale.getId();
        this.coordinata= new Coordinata(SIZE/2,SIZE/2);
        this.angoli = new StatoAngolo[SIZE];
        angoli[0] = cartaIniziale.getAngoloFronteTopLeft();
        angoli[1] = cartaIniziale.getAngoloFronteTopRight();
        angoli[2] = cartaIniziale.getAngoloFronteBottomLeft();
        angoli[3] = cartaIniziale.getAngoloFronteBottomRight();
        this.angoliToString = new String[SIZE];
        this.risorsaCentrale = cartaIniziale.getRisorsaRetroCentrale();
        this.risorsaCentraleToString = null;
        switch (this.risorsaCentrale) {
        case VEGETALE:
        	this.colore=Colore.VERDE;
        	break;
        case INSETTI:
        	this.colore=Colore.VIOLA;
        	break;
        case FUNGHI:
        	this.colore=Colore.ROSSO;
        	break;
        case ANIMALE:
        	this.colore=Colore.BLU;
        	break;
        	
        }
         
        this.punti = 0; 
        controlli();
    }
  

	public Casella(CartaRisorsa cartaRisorsa) {
		this.coordinata=null;
		this.id=cartaRisorsa.getId();
		this.angoli = new StatoAngolo[SIZE];
		angoli[0]=cartaRisorsa.getAngoloFronteTopLeft();
		angoli[1]=cartaRisorsa.getAngoloFronteTopRight();
		angoli[2]=cartaRisorsa.getAngoloFronteBottomLeft();
		angoli[3]=cartaRisorsa.getAngoloFronteBottomRight();
		this.angoliToString = new String[SIZE];
		this.risorsaCentrale=cartaRisorsa.getRisorsaRetroCentrale();
		this.risorsaCentraleToString=null;
		this.setColore(cartaRisorsa.getColore());
		this.punti=cartaRisorsa.getPunti();
		controlli();
	}
	public void setCartaRisorsa(CartaRisorsa cartaRisorsa) {
		    this.coordinata=null;
		    this.id = cartaRisorsa.getId();
			this.angoli = new StatoAngolo[SIZE];
			angoli[0]=cartaRisorsa.getAngoloFronteTopLeft();
			angoli[1]=cartaRisorsa.getAngoloFronteTopRight();
			angoli[2]=cartaRisorsa.getAngoloFronteBottomLeft();
			angoli[3]=cartaRisorsa.getAngoloFronteBottomRight();
			this.angoliToString = new String[SIZE];
			this.risorsaCentrale=cartaRisorsa.getRisorsaRetroCentrale();
			this.risorsaCentraleToString=null;
			this.setColore(cartaRisorsa.getColore());
			this.punti=cartaRisorsa.getPunti();
			controlli();
	    }
	public Casella(CartaOro cartaOro) {
		this.coordinata=null;
		this.id=cartaOro.getId();
		this.angoli = new StatoAngolo[SIZE];
		this.angoli[0]=cartaOro.getAngoloFronteTopLeft();
		this.angoli[1]=cartaOro.getAngoloFronteTopRight();
		this.angoli[2]=cartaOro.getAngoloFronteBottomLeft();
		this.angoli[3]=cartaOro.getAngoloFronteBottomRight();
		this.angoliToString = new String[SIZE];
		this.risorsaCentrale=cartaOro.getRisorsaRetroCentrale();
		this.risorsaCentraleToString=null;
		this.setColore(cartaOro.getColore());
		this.punti=-1;
		controlli();
	}
	public void setCartaOro(CartaOro cartaOro) {
		this.coordinata=null;
		this.id = cartaOro.getId();
		this.angoli = new StatoAngolo[SIZE];
		this.angoli[0]=cartaOro.getAngoloFronteTopLeft();
		this.angoli[1]=cartaOro.getAngoloFronteTopRight();
		this.angoli[2]=cartaOro.getAngoloFronteBottomLeft();
		this.angoli[3]=cartaOro.getAngoloFronteBottomRight();
		this.angoliToString = new String[SIZE];
		this.risorsaCentrale=cartaOro.getRisorsaRetroCentrale();
		this.risorsaCentraleToString=null;
		this.setColore(cartaOro.getColore());
		this.punti=-1;
		controlli();
	}
	private void controlli(){
		if(risorsaCentrale!=null) {
			switch(risorsaCentrale) {
			
			case VEGETALE: 	risorsaCentraleToString="    \u001B[32m"+risorsaCentrale.toString()+"\u001B[0m ";
										break;
			case ANIMALE: 	risorsaCentraleToString="    \u001B[36m"+risorsaCentrale.toString()+"\u001B[0m ";
										break;
			case INSETTI: 	risorsaCentraleToString="    \u001B[35m"+risorsaCentrale.toString()+"\u001B[0m ";
										break;
			case FUNGHI: 	risorsaCentraleToString="     \u001B[31m"+risorsaCentrale.toString()+"\u001B[0m ";
										break;
			default: 	risorsaCentraleToString="\t";
						break;
			}
			for(int i=0; i<SIZE; i++) {
				
				if(i==0 || i==2) {
					switch(angoli[i]) {
					
					case VEGETALE: 	angoliToString[i]="\u001B[32m"+angoli[i].toString()+"\u001B[0m\t    ";
												break;
					case ANIMALE: 	angoliToString[i]="\u001B[36m"+angoli[i].toString()+"\u001B[0m      ";
												break;
					case INSETTI: 	angoliToString[i]="\u001B[35m"+angoli[i].toString()+"\u001B[0m\t     ";
												break;
					case FUNGHI: 	angoliToString[i]="\u001B[31m"+angoli[i].toString()+"\u001B[0m\t      ";
												break;
					case PIUMA: 	angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m\t       ";
												break;
					case INCHIOSTRO:angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m   ";				
												break;
					case PERGAMENA: angoliToString[i]="\u001B[33m"+angoli[i].toString()+"\u001B[0m    ";
												break;
					case NULLO: 		angoliToString[i]="\t       ";
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
					case ANIMALE: 	angoliToString[i]="      \u001B[36m"+angoli[i].toString()+"\u001B[0m";
												break;
					case INSETTI: 	angoliToString[i]="      \u001B[35m"+angoli[i].toString()+"\u001B[0m";
												break;
					case FUNGHI: 	angoliToString[i]="       \u001B[31m"+angoli[i].toString()+"\u001B[0m";
												break;
					case PIUMA: 	angoliToString[i]="        \u001B[33m"+angoli[i].toString()+"\u001B[0m";
												break;
					case INCHIOSTRO:angoliToString[i]="   \u001B[33m"+angoli[i].toString()+"\u001B[0m";
												break;
					case PERGAMENA: angoliToString[i]="    \u001B[33m"+angoli[i].toString()+"\u001B[0m";
												break;
					case NULLO: 		angoliToString[i]="\t     ";
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
	}
	
	public int getId() {
		return id;
	}
	
	/**
	 * 
	 * @return String idColorato -> ritorna la stringa id ma con il colore della carta stessa
	 */
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
	public void visualizzaCasella() {
		System.out.println("┌──────────────┬──────────────┐");
		System.out.println("│"+angoliToString[0]+"│"+angoliToString[1]+"│");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		if(risorsaCentraleToString!="\t")System.out.println("│\t"+risorsaCentraleToString+"\t      │");
		if(punti!=0)System.out.println("│\t       "+punti+" \t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		System.out.println("│"+angoliToString[2]+"│"+angoliToString[3]+"│");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println();
		
	}
	public void visualizzaCasellaOroDaId(int id) {
		List<CartaOro> mazzoOro = MazzoCarteOro.getMazzoOro();
		CartaOro cartaOroCercata = mazzoOro.get(getId()-41);
		visualizzaCasellaOro(cartaOroCercata);
	}
	public void visualizzaCasellaOro(CartaOro cartaOro) {
		System.out.println("┌──────────────┬──────────────┐");
		System.out.println("│"+angoliToString[0]+"│"+angoliToString[1]+"│");
		System.out.println("├──────────────┴──────────────┤");
		System.out.println("│\t\t\t      │");
		if(risorsaCentraleToString!="\t")System.out.println("│\t"+risorsaCentraleToString+"\t      │");
		System.out.println("│\t\t\t      │");
		System.out.println("├──────────────┬──────────────┤");
		System.out.println("│"+angoliToString[2]+"│"+angoliToString[3]+"│");
		System.out.println("└──────────────┴──────────────┘");
		System.out.println(cartaOro.getCondizione()+" punti per ogni: ");
		if(cartaOro.getNumeroAnimali()!=0) {
			if(cartaOro.getNumeroAnimali()==1) System.out.println(cartaOro.getNumeroAnimali()+" animale visibile ");
			else System.out.println(cartaOro.getNumeroAnimali()+" animali visibili ");
		}
		if(cartaOro.getNumeroFunghi()!=0) {
			if(cartaOro.getNumeroFunghi()==1) System.out.println(cartaOro.getNumeroFunghi()+" fungo visibile ");
			else System.out.println(cartaOro.getNumeroFunghi()+" funghi visibili ");
		}
		if(cartaOro.getNumeroInsetti()!=0) {
			if(cartaOro.getNumeroInsetti()==1) System.out.println(cartaOro.getNumeroInsetti()+" insetto visibile ");
			else System.out.println(cartaOro.getNumeroInsetti()+" insetti visibili ");
		}
		if(cartaOro.getNumeroVegetale()!=0) {
			if(cartaOro.getNumeroAnimali()==1) System.out.println(cartaOro.getNumeroVegetale()+" vegetale visibile ");
			else System.out.println(cartaOro.getNumeroVegetale()+" vegetali visibili ");
		}
		System.out.println();
		System.out.println("I requisiti della carta oro "+cartaOro.getId()+" sono: numero animali = "+cartaOro.getNumeroAnimali()+", numero insetti = "+cartaOro.getNumeroInsetti()+", numero funghi = "+cartaOro.getNumeroFunghi()+", numero vegetale = "+cartaOro.getNumeroVegetale());
		System.out.println();
	}
	public void setCartaIniziale(int id) {
		this.id = id;
		this.coordinata=new Coordinata(SIZE/2,SIZE/2);
	}
	public StatoAngolo[] getAngoli() {
		return this.angoli;
		
	}
	public void setAngoloAltoSx() {
		this.angoli[0]=StatoAngolo.COPERTO;
		controlli();
	}
	public void setAngoloAltoDx() {
		this.angoli[1]=StatoAngolo.COPERTO;
		controlli();
	}
	public void setAngoloBassoSx() {
		this.angoli[2]=StatoAngolo.COPERTO;
		controlli();
	}
	public void setAngoloBassoDx() {
		this.angoli[3]=StatoAngolo.COPERTO;
		controlli();
	}
	public Colore getColore() {
		return colore;
	}
	public void setColore(Colore colore) {
		this.colore = colore;
	}
}
