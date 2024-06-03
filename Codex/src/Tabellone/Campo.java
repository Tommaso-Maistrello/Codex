package Tabellone;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Carte.Carta;
import Carte.CartaIniziale;
import Carte.CartaObiettivo;
import Carte.CartaOro;
import Carte.CartaRisorsa;
import Enum.Colore;
import Enum.StatoAngolo;
import Gioco.Giocatore;
import Gioco.Mano;
import Gioco.Partita;
import Mazzi.MazzoCarteOro;
import Mazzi.MazzoCarteRisorsa;

public class Campo {

	// Se l'utente dovesse posizionare tutte le carte in diagonale, la grandezza
	// massima sarebbe di 41 caselle occupate ma bisgona considerare ogni direzione
	private final Casella[][] tabella;
	private final static int SIZE = 11;

	public Campo() {
		tabella = new Casella[SIZE][SIZE];
		for(int i=0; i<SIZE; i++) {
			for(int j=0; j<SIZE; j++) {
				tabella[i][j]=new Casella(new Coordinata(i, j));
			}
		}
	}
	
	public Casella getCasella(Coordinata coordinata) {
		return this.tabella[coordinata.getX()][coordinata.getY()];
	}
	/*
	public String toString() {
		String ret = "";
		ret += "---------------------------------------------------";
		ret += "------------------------------------------------\n";
		for (int i = 0; i < SIZE; i++) {
		ret += "| ";
		for (int j = 0; j < SIZE; j++) {
		ret += tabella[i][j].toString();
		ret += " | ";
		}
		ret += "\n";
		ret += "------------------------------------------------\n";
		ret += "---------------------------------------------------";
		}
		ret += "\n ";
		return ret;
	}*/
	public void casellaSpecifica() {
		
		Scanner sc = new Scanner(System.in);
		
        String risposta="";
        boolean verifica=false;
        
        //Richiedo se vuole visualizzare una cella finchè non è soddisfatto
        while(!risposta.equals("no") && !risposta.equals("n")) {
        	//Controllo la risposta
	        do {
	            System.out.println("Vuoi visualizzare una casella nello specifico (si/no)? ");
	            risposta = sc.nextLine().toLowerCase();
	        } while (!risposta.equals("sì") && !risposta.equals("si") && !risposta.equals("s") && !risposta.equals("no") && !risposta.equals("n"));
	
	        //Se risponde sì devo chgiedere l'id della carta da visualizzare
	        if (risposta.equals("sì") || risposta.equals("si") || risposta.equals("s")) {
	        	int idCercato=-1;
	        	//Controllo che l'id inserito sia valido
	        	do {
		        	System.out.println("Qual è l'id della carta che vuoi visualizzare? ");
		        	idCercato = sc.nextInt();
		        	//pulisco il buffer
		        	sc.nextLine();
		        	//faccio passare tutta la tabella per cercare la cella con l'id richiesto
		        	for(int i=0; i<SIZE; i++) {
		        		for(int j=0; j<SIZE; j++) {
		        			if(tabella[i][j].getId()==idCercato) {
		        				System.out.println("Visualizzazione della casella specificata...");
		        				if(idCercato<41||idCercato>80)tabella[i][j].visualizzaCasella();
		        				else tabella[i][j].visualizzaCasellaOroDaId(idCercato);
		        				verifica=true;
		        			}
		        		}
		        	}
		        	//se non trova la carta lo dico all'utente
		        	if(verifica==false) {
		        		System.out.println("L'id inserito non è stato trovato, riprovare con un altro id.");
		        	}
	        	}while(verifica==false);
	        }
        }
		//sc.close();
	}
	public void visualizzaCampo() {
		
		//RIGA NUMERI
		System.out.print("  ");
		String numeroFormattato="";
		for(int i=0; i<SIZE; i++) {
			numeroFormattato = String.format("%3d", i);
			System.out.print(numeroFormattato);
		}
		System.out.println();
		//Sopra
		System.out.print("  ┌─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┬─");
		}
		System.out.print("─┐");
		//Mezzo
		System.out.println();
		System.out.print(0);// PRIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		System.out.print(" │");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[0][i].getIdColored());
			System.out.print("│");
		}
		System.out.print(" "+0);// PRIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		
		//Sotto
		System.out.println();
		System.out.print("  ├─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┼─");
		}
		System.out.print("─┤");
		
		//RIGHE IN MEZZO
		int k=0;
		for(int j=1; j<SIZE-1; j++) {
			System.out.println();
			k=j;
			System.out.print(k);
			if (j<10) {
				System.out.print(" │");
			}else {
				System.out.print("│");
			}
			
			for(int i=0; i<SIZE; i++) {
				System.out.print(tabella[i][j].getIdColored());
				System.out.print("│");
			}
			System.out.print(" "+k);
			//COLONNA NUMERI
			
			//Sotto
			System.out.println();
			System.out.print("  ├─");
			for(int i=0; i<SIZE-1; i++) {
				System.out.print("─┼─");
			}
			System.out.print("─┤");
			
		}
		//RIGA IN MEZZO CON CARTA INIZIALE
		//ULTIMA RIGA
		System.out.println();
		k=SIZE-1;
		System.out.print(k);// ULTIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		System.out.print("│");
		for(int i=0; i<SIZE; i++) {
			System.out.print(tabella[SIZE-1][i].getIdColored());
			System.out.print("│");
		}
		System.out.print(" "+k);// ULTIMO NUMERO DELLA COLONNA NUMERI A DESTRA
		System.out.println();
		System.out.print("  └─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┴─");
		}
		System.out.print("─┘");
		System.out.println();
		
		//RIGA NUMERI
		System.out.print("  ");
		for(int i=0; i<SIZE; i++) {
			numeroFormattato = String.format("%3d", i);
			System.out.print(numeroFormattato);
		}
		System.out.println("\n");
		//casellaSpecifica();
	}

 
public void posizionaCartaIniziale(Giocatore giocatore) {
	        int centroX = SIZE/2;
	        int centroY = SIZE/2;
	        int k =  SIZE/2;
	        //System.out.println("la posizion della carta centrale è:"+k+k);
	        tabella[centroX][centroY].setCartaIniziale(giocatore.getCartaIniziale());
	    }

	public int getSize() {
		return SIZE;
	}	
	
	public void giocaCarta(Giocatore player) {
		boolean esiste= false;
		
		int id,p;
		String red = "\033[31m";
		 String reset = "\033[0m";
		int x,y;
		esiste=false;
		do {
		 id =esisteCarta(player);// controlla che il giocatore abbia fornito id di una carta che ha in mano
		
		if (id >40) {
			
			
			
			esiste= controlloRequisiti(player,id);
			if(esiste==false) {
				System.out.println(red+" la carta oro non ha i requisiti per essere giocata"+reset);
		
			}
			
		}else {
			esiste=true;
		}
		}while(esiste==false);
		Scanner sc = new Scanner(System.in);
		do {

			esiste= false;
			int coordinata[]=verificaCoordinata(sc);//contrtolla che la posizione in qui si vuole giocare è libera ed se è x e y sono entrambi pari o dispari
			x= coordinata[0];
			y= coordinata[1];
			System.out.println("x:"+coordinata[0]+"y:"+coordinata[1]);
			
			// prende le carte che vengono toccate
			
			
			if(tabella[x][y].getId()==0) {
			System.out.println();
			esiste= true;
			}else {
			System.out.println(red+" La carta non si può giocare "+reset);
			System.out.println();
			}
				
			if (esiste == true) {
				
				
				esiste = posizioneGiocabile(x,y, id);// controlla se la coordintata è in un punto giocabile cioè se uno dei 4 angoli tocca un'altra carta
												// inoltre controlla se la carta viene giocata sopra ad un angolo coperto o meno
				if (esiste == false) {
					System.out.println(red+"La carta non si può giocare nelle coordinate fornite"+reset);// controlla se la coordintata è in un punto giocabile cioè se uno dei 4 angoli tocca un'altra carta
				}
			}
			
			if (esiste == true) {
			esiste =controlloAngoli(x,y);// controlla che la carta non venga giocata su angoli non coperti o nulli
			//GLI ANGOLI COPERTI DALLA CARTA DEVONO DIVENTARE "COPERTO"
			copriAngoli(x,y);
			}
			
		}while(esiste== false);// il ciclo finisce se la cella di coordinata x y esiste ed è libera
		
 	
	
		
	
		
		 System.out.println("Per giocare la carta sul fronte scrivi 1, per giocare la carta sul retro scrivi 2");
		int verso=0;
		 do {
			 System.out.println("fornisci un input valido per il verso della carta");
			verso=sc.nextInt();
			
			
		}while(verso!=1 && verso!=2 );
		//sc.close();
		 int punti;
		if (id <41) {
			CartaRisorsa carta= Mano.prendiCartaRisorsaConID(id, player);
			if (verso==2) {
				carta.setAngoloFronteBottomLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteBottomRight(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopRight(StatoAngolo.VUOTO);
				carta.setPunti(0);
			}else {
				punti=player.getPunteggio();
				punti+=carta.getPunti();
				player.setPunteggio(punti);
			}
			 tabella[x][y].setCartaRisorsa(carta);
			 System.out.println("\nHai giocato la carta risorsa");
		}else {
			CartaOro carta= Mano.prendiCartaOroConID(id, player);
			if (verso==2) {
				carta.setAngoloFronteBottomLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteBottomRight(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopRight(StatoAngolo.VUOTO);
				carta.setPunti("0");
			}else {
				punti=player.getPunteggio();
				 p=getPuntiOro(player, carta,x,y);
				punti+=p;
				
				player.setPunteggio(punti);
				
			}
			 tabella[x][y].setCartaOro(carta);
			 System.out.println("\nHai giocato la carta oro");
		}
		//System.out.println("hai giocato la carta");
		
	}
	private int getPuntiOro(Giocatore player, CartaOro carta, int x, int y) {
		int puntiFinale=0, punti=0;
		boolean puntiGiaAssegnati= false;
		int[] conteggioRisorse=new int[3];
		int	PIUMA=0, INCHISTRO=0,PERGAMENA=0;
		StatoAngolo topRight, topLeft, bottomRight,bottomLeft;
		CartaOro cartaOro;
		String condizione;
		
		int	id=0;
		
		for (int i = 0; (i < SIZE); i++) {
		    for (int j = 0; (j < SIZE); j++) {
		        id=tabella[i][j].getId();
		        
		    	 if (id !=0) {
		    		 cartaOro = Partita.prendiCartaOroConID(id);
		    		 topRight=cartaOro.getAngoloFronteTopRight();
		    		 topLeft=cartaOro.getAngoloFronteTopLeft();
		    		 bottomRight=cartaOro.getAngoloFronteBottomRight();
		    		 bottomLeft=cartaOro.getAngoloFronteBottomLeft();
		    		 
		    		 condizione= carta.getCondizione();
		    		 switch (condizione){
		    		 case "1xINCHIOSTRO":
		    			 if(topRight==StatoAngolo.INCHIOSTRO||topLeft==StatoAngolo.INCHIOSTRO||bottomRight==StatoAngolo.INCHIOSTRO||bottomLeft==StatoAngolo.INCHIOSTRO) {
		    				 INCHISTRO++; 
		    			 }
		    			break;
		    		 case "1xPERGAMENA":
		    			 if(topRight==StatoAngolo.PERGAMENA||topLeft==StatoAngolo.PERGAMENA||bottomRight==StatoAngolo.PERGAMENA||bottomLeft==StatoAngolo.PERGAMENA) {
		    				 PERGAMENA++; 
		    			 }
		    			break; 
		    		 case "1xPIUMA":
		    			 if(topRight==StatoAngolo.PIUMA||topLeft==StatoAngolo.PIUMA||bottomRight==StatoAngolo.PIUMA||bottomLeft==StatoAngolo.PIUMA) {
		    				 PIUMA++; 
		    			 }
		    			break; 
		    		 case "3":
		    			 if(puntiGiaAssegnati==false) {
		    				 punti+=3;
		    				 puntiGiaAssegnati=true;
		    			 }
		    			break; 
		    		 case "2":
		    			 if(puntiGiaAssegnati==false) {
		    				 punti+=2;
		    				 puntiGiaAssegnati=true;
		    			 }
		    			break; 
		    		 case "5":
		    			 if(puntiGiaAssegnati==false) {
		    				 punti+=5;
		    				 puntiGiaAssegnati=true;
		    			 }
		    			break; 
		    		 }
		    		 
		    	 }
		    }
		
		}
		condizione= carta.getCondizione();
		StatoAngolo[] angoli =new StatoAngolo[4];
		if (condizione=="2xANGOLO") {
			if (tabella[x-1][y-1].getId()!=0) {
				angoli=tabella[x-1][y-1].getAngoli();// carta in alto a sinistra rispetto alla coordinata		
				if(angoli[3]==StatoAngolo.COPERTO) {//controlla angol bottom right
					punti+=1;
	 
					}	
			}
			if (tabella[x-1][y+1].getId()!=0) {
					angoli=tabella[x-1][y+1].getAngoli();// carta in basso a sinistra rispetto alla coordinata
					if(angoli[1]==StatoAngolo.COPERTO) {//controlla angolo top right && angolo in bassso a sinitra della carta
						punti+=1;
					}	
			}
			if (tabella[x+1][y-1].getId()!=0 ) {
					angoli=tabella[x+1][y-1].getAngoli();// carta in alto a destra rispetto alla coordinata
					if( angoli[2]==StatoAngolo.COPERTO ) {//controlla angolo bottom left&& alto a destra della carta
						punti+=1;
					}	
			}
			if (tabella[x+1][y+1].getId()!=0) {
					angoli=tabella[x+1][y+1].getAngoli();// carta in basso a destra rispetto alla coordinata
					if( angoli[0]==StatoAngolo.COPERTO ) {//controlla angolo top left&& e in basso a destra della carta
						punti+=1; 
					}	
			}
			
			
		}
		puntiFinale+=punti+PIUMA+INCHISTRO+PERGAMENA;
		return puntiFinale;
	}
	private void copriAngoli(int x, int y) {
		if(tabella[x-1][y-1].getId()!=0) {
			tabella[x-1][y-1].setAngoloBassoDx();
		}
		if(tabella[x+1][y-1].getId()!=0) {
			tabella[x+1][y-1].setAngoloBassoSx();
		}
		if(tabella[x-1][y+1].getId()!=0) {
			tabella[x-1][y+1].setAngoloAltoDx();
		}
		if(tabella[x+1][y+1].getId()!=0) {
			tabella[x+1][y+1].setAngoloAltoSx();
		}
	}
	public int esisteCarta(Giocatore player) {
		boolean trovato= false;
		Scanner sc = new Scanner(System.in);
		int id;
		/*do {
			System.out.println("\n-------------------------------------------------------------\n"  );
			System.out.println("qual'è l'id della carta che vuoi giocare?");
			id = sc.nextInt();
			System.out.println("hai scalto la carta con id: "+id);
			esiste = player.getMano().haCartaConId(player, id);
		if (esiste == true) {
			System.out.println("il giocatore ha la carta in mano con id "+id);
			
		}else {
			System.out.println("il giocatore non ha la carta in mano "+id);
		}
		}while(esiste== false);// controlla che il giocatore abbia in mana la carta che si vuole giocare
		*/
		do {
			System.out.println("\n-------------------------------------------------------------\n"  );
			System.out.print("Qual è l'id della carta che vuoi giocare? ");
			id = sc.nextInt();
			//System.out.println("hai scalto la carta con id: "+id);
			trovato = player.getMano().haCartaConId(player, id);
			if(trovato != true) {
				System.out.println("Il giocatore non ha la carta in mano "+id);
			}
		}while(trovato == false);
		return id;
	}
	public int[] verificaCoordinata(Scanner sc) {
		boolean esiste= false;
		String red = "\033[31m";
		 String reset = "\033[0m";
		int x,y;
		do {
			System.out.print("Qual è la coordinata x in qui voi giocare la carta? ");
			x = sc.nextInt();
			System.out.print("Qual è la coordinata y in qui voi giocare la carta? ");
			y = sc.nextInt();
		
		if (x <SIZE-1 && y <SIZE-1 && (x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) {
			 
			esiste= true;
		}else {
			System.out.println(red+"non è possibile giocare la carta nelle coordinate fornite"+ reset);
		}
		
		}while(esiste== false);// controlla se la coordinata è valida
	 
		return new int[]{x, y};
	}
	public boolean posizioneGiocabile(int x, int y, int id) {
		boolean esiste = false;
		String red = "\033[31m";
		 String reset = "\033[0m";
		StatoAngolo[] angoli=null;
		StatoAngolo[] angoliCarta =new StatoAngolo[4];
		
		if (id >41) {
			
			CartaOro carta= Partita.prendiCartaOroConID(id);
			System.out.println(carta.getId());
			 angoliCarta[0] =carta.getAngoloFronteTopLeft();
			 angoliCarta[1] = carta.getAngoloFronteTopLeft();
			 angoliCarta[2] = carta.getAngoloFronteBottomLeft();
			 angoliCarta[3] = carta.getAngoloFronteBottomRight();
		}else {
			CartaRisorsa carta=Partita.prendiCartaRisorsaConID(id);
			System.out.println(carta.getId()+"stato angolo 0 "+ carta.getAngoloFronteTopLeft() +"angolo 1"+carta.getAngoloFronteTopLeft());
			angoliCarta[0] =carta.getAngoloFronteTopLeft();
			 
			 angoliCarta[1] = carta.getAngoloFronteTopRight();
			 angoliCarta[2] = carta.getAngoloFronteBottomLeft();
			 angoliCarta[3] = carta.getAngoloFronteBottomRight();
			
		}
		
		//boolean topRight, topLeft,boottomRight, boottomLeft = false;
		//for (int i=0; i<4;i++) {
		if ((tabella[x-1][y-1].getId()!=0  )||tabella[x-1][y+1].getId()!=0 ||tabella[x+1][y-1].getId()!=0||tabella[x+1][y+1].getId()!=0) {
			esiste = true;
		}
		
		if (tabella[x-1][y-1].getId()!=0 && esiste ==true) {
		angoli=tabella[x-1][y-1].getAngoli();// carta in alto a sinistra rispetto alla coordinata
		System.out.println("angoli 0 1 2 3:"+angoli[0]+","+angoli[1]+","+angoli[2]+","+angoli[3]+",");
		
		if(angoli[3]==StatoAngolo.NULLO||angoli[3]==StatoAngolo.COPERTO||angoliCarta[0]==StatoAngolo.NULLO) {//controlla angol bottom right && angolo alto a sinistra della  carta
				
				esiste = false;
			System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti o se l'angolo da giocare è nullo"+ reset);
			}	
		}
		if (tabella[x-1][y+1].getId()!=0&& esiste ==true) {
			angoli=tabella[x-1][y+1].getAngoli();// carta in basso a sinistra rispetto alla coordinata
			if(angoli[1]==StatoAngolo.NULLO||angoli[1]==StatoAngolo.COPERTO||angoliCarta[2]==StatoAngolo.NULLO) {//controlla angolo top right && angolo in bassso a sinitra della carta
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti o se l'angolo da giocare è nullo"+ reset);
			}	
			}
		if (tabella[x+1][y-1].getId()!=0&& esiste ==true) {
			angoli=tabella[x+1][y-1].getAngoli();// carta in alto a destra rispetto alla coordinata
			if(angoli[2]==StatoAngolo.NULLO||angoli[2]==StatoAngolo.COPERTO||angoliCarta[1]==StatoAngolo.NULLO) {//controlla angolo bottom left&& alto a destra della carta
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti o se l'angolo da giocare è nullo"+ reset);
			}	
			}
		if (tabella[x+1][y+1].getId()!=0 && esiste ==true) {
			angoli=tabella[x+1][y+1].getAngoli();// carta in basso a destra rispetto alla coordinata
			if(angoli[0]==StatoAngolo.NULLO||angoli[0]==StatoAngolo.COPERTO||angoliCarta[3]==StatoAngolo.NULLO) {//controlla angolo top left&& e in basso a destra della carta
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti o se l'angolo da giocare è nullo"+ reset);
				
			}	
			}
	
		
		
		

		//}
		return esiste;
	}

	public boolean controlloAngoli(int x, int y) {
		boolean esiste = true;
		String red = "\033[31m";
		 String reset = "\033[0m";
		StatoAngolo[] angoli=null;
		StatoAngolo[] nuoviAngoli=new StatoAngolo[4];
		
		/*
		 * nuoviAngolo è l'angolo che si andrà a creare controllando gli angoli che toccano o potrebbero toccare la carta da giocare
		 */
			
		
			if (tabella[x-1][y-1].getId()!=0) {// controlla la casella in alto a sinistra
				angoli=tabella[x-1][y-1].getAngoli();
				nuoviAngoli[3]=angoli[3];
				//System.out.println(angoli[3]);// controlla l'angolo in basso a destra
			}else if(tabella[x-1][y+1].getId()!=0) {// controlla la casella in alto a destra
				angoli=tabella[x-1][y+1].getAngoli();
				nuoviAngoli[2]=angoli[2];
				//System.out.println(angoli[2]);// controlla l'angolo in basso a sinistra
			}else if(tabella[x+1][y-1].getId()!=0) {// controlla la casella in basso a sinistra
				angoli=tabella[x+1][y-1].getAngoli();
				nuoviAngoli[1]=angoli[1];
				//System.out.println(angoli[1]);// controlla l'angolo in alto a destra
			}else if(tabella[x+1][y+1].getId()!=0){// controlla la casella in basso a destra
				angoli=tabella[x+1][y+1].getAngoli();
				nuoviAngoli[0]=angoli[0];
				//System.out.println(angoli[0]);// controlla l'angolo in alto a sinistra
			}
			//System.out.println("stampa nuovi angoli");
	
			
					for(StatoAngolo angol: nuoviAngoli ) {
						if(angol==StatoAngolo.NULLO || angol==StatoAngolo.COPERTO) {
							esiste =false;
						}
						
					}
					if (esiste == false) {
						System.out.println(red+"Non è possibile giocare la carta in quanto è presente un angolo nullo oppure gia coperto"+reset);
						
						
					}
					
				
		 
		return esiste;
	}
public boolean controlloRequisiti(Giocatore player, int id) {
	int  ANIMALE=0, FUNGHI=0, INSETTI=0, VEGETALE=0,idC=0;
	int condizioneA,condizioneI,condizioneF,condizioneV;
	String condizionePunti;
	CartaOro cartaOro, cartaOroC;
	CartaRisorsa cartaRisorsa;
	boolean requisiti= false;
	StatoAngolo[] angoli=null;

	
 
	if(id!=0 &&id >40) {
		cartaOro= Partita.prendiCartaOroConID(id);
		condizionePunti=cartaOro.getCondizione();
		condizioneA=cartaOro.getNumeroAnimali();
		condizioneF=cartaOro.getNumeroFunghi();
		condizioneI=cartaOro.getNumeroInsetti();
		condizioneV=cartaOro.getNumeroVegetale();
		
	 

		for (int i = 0; (i < SIZE) && requisiti==false; i++) {
		    for (int j = 0; (j < SIZE) && requisiti==false; j++) {
		        idC = tabella[i][j].getId(); // Prende id della carta
		        if (idC != 0 && idC!= player.getCartaIniziale().getId()&&idC>40) {
		        	
		            cartaOroC = Partita.prendiCartaOroConID(idC);
		            System.out.println(cartaOroC.getId()) ;
		            if (condizioneA != 0) {
		                if (( cartaOroC.getAngoloFronteTopLeft() == StatoAngolo.ANIMALE) ||
		                    (cartaOroC.getAngoloFronteTopRight() == StatoAngolo.ANIMALE) ||
		                    (cartaOroC.getAngoloFronteBottomLeft() == StatoAngolo.ANIMALE) ||
		                    ( cartaOroC.getAngoloFronteBottomRight() == StatoAngolo.ANIMALE)) {
		                    ANIMALE++;
		                }
		            }
		            
		            if (condizioneF != 0) {
		                if ((cartaOroC.getAngoloFronteTopLeft() == StatoAngolo.FUNGHI) ||
		                    ( cartaOroC.getAngoloFronteTopRight() == StatoAngolo.FUNGHI) ||
		                    ( cartaOroC.getAngoloFronteBottomLeft() == StatoAngolo.FUNGHI) ||
		                    ( cartaOroC.getAngoloFronteBottomRight() == StatoAngolo.FUNGHI)) {
		                    FUNGHI++;
		                }
		            }
		            
		            if (condizioneI != 0) {
		                if (( cartaOroC.getAngoloFronteTopLeft() == StatoAngolo.INSETTI) ||
		                    ( cartaOroC.getAngoloFronteTopRight() == StatoAngolo.INSETTI) ||
		                    ( cartaOroC.getAngoloFronteBottomLeft() == StatoAngolo.INSETTI) ||
		                    ( cartaOroC.getAngoloFronteBottomRight() == StatoAngolo.INSETTI)) {
		                    INSETTI++;
		                }
		            }
		            
		            if (condizioneV != 0) {
		                if (( cartaOroC.getAngoloFronteTopLeft() == StatoAngolo.VEGETALE) ||
		                    ( cartaOroC.getAngoloFronteTopRight() == StatoAngolo.VEGETALE) ||
		                    ( cartaOroC.getAngoloFronteBottomLeft() == StatoAngolo.VEGETALE) ||
		                    (  cartaOroC.getAngoloFronteBottomRight() == StatoAngolo.VEGETALE)) {
		                    VEGETALE++;
		                }
		            }

		            
		          
		        }else if (idC != 0 && idC!= player.getCartaIniziale().getId()&&idC<40) {
		            cartaRisorsa = Partita.prendiCartaRisorsaConID(idC);
		            System.out.println(cartaRisorsa.getId()) ;
		            if (condizioneA != 0) {
		                if (( cartaRisorsa.getAngoloFronteTopLeft() == StatoAngolo.ANIMALE) ||
		                    (cartaRisorsa.getAngoloFronteTopRight() == StatoAngolo.ANIMALE) ||
		                    (cartaRisorsa.getAngoloFronteBottomLeft() == StatoAngolo.ANIMALE) ||
		                    ( cartaRisorsa.getAngoloFronteBottomRight() == StatoAngolo.ANIMALE)) {
		                    ANIMALE++;
		                }
		            }
		            
		            if (condizioneF != 0) {
		                if ((cartaRisorsa.getAngoloFronteTopLeft() == StatoAngolo.FUNGHI) ||
		                    ( cartaRisorsa.getAngoloFronteTopRight() == StatoAngolo.FUNGHI) ||
		                    ( cartaRisorsa.getAngoloFronteBottomLeft() == StatoAngolo.FUNGHI) ||
		                    ( cartaRisorsa.getAngoloFronteBottomRight() == StatoAngolo.FUNGHI)) {
		                    FUNGHI++;
		                }
		            }
		            
		            if (condizioneI != 0) {
		                if (( cartaRisorsa.getAngoloFronteTopLeft() == StatoAngolo.INSETTI) ||
		                    ( cartaRisorsa.getAngoloFronteTopRight() == StatoAngolo.INSETTI) ||
		                    ( cartaRisorsa.getAngoloFronteBottomLeft() == StatoAngolo.INSETTI) ||
		                    ( cartaRisorsa.getAngoloFronteBottomRight() == StatoAngolo.INSETTI)) {
		                    INSETTI++;
		                }
		            }
		            
		            if (condizioneV != 0) {
		                if (( cartaRisorsa.getAngoloFronteTopLeft() == StatoAngolo.VEGETALE) ||
		                    ( cartaRisorsa.getAngoloFronteTopRight() == StatoAngolo.VEGETALE) ||
		                    ( cartaRisorsa.getAngoloFronteBottomLeft() == StatoAngolo.VEGETALE) ||
		                    (  cartaRisorsa.getAngoloFronteBottomRight() == StatoAngolo.VEGETALE)) {
		                    VEGETALE++;
		                }
		            }

		        	
		        }
		        
		        
		          if (ANIMALE == condizioneA && FUNGHI == condizioneF && INSETTI == condizioneI && VEGETALE == condizioneV) {
		                requisiti = true;
		            }
		        
		        
		        
		        
		        
		        
		    }
		}
		
		 
        if (condizioneA != 0) {
            if ((player.getCartaIniziale().getAngoloFronteTopLeft() == StatoAngolo.ANIMALE) ||
                (player.getCartaIniziale().getAngoloFronteTopRight() == StatoAngolo.ANIMALE) ||
                (player.getCartaIniziale().getAngoloFronteBottomLeft() == StatoAngolo.ANIMALE) ||
                (player.getCartaIniziale().getAngoloFronteBottomRight() == StatoAngolo.ANIMALE)) {
                ANIMALE++;
            }
        }

        if (condizioneF != 0) {
            if ((player.getCartaIniziale().getAngoloFronteTopLeft() == StatoAngolo.FUNGHI) ||
                (player.getCartaIniziale().getAngoloFronteTopRight() == StatoAngolo.FUNGHI) ||
                (player.getCartaIniziale().getAngoloFronteBottomLeft() == StatoAngolo.FUNGHI) ||
                (player.getCartaIniziale().getAngoloFronteBottomRight() == StatoAngolo.FUNGHI)) {
                FUNGHI++;
            }
        }

        if (condizioneI != 0) {
            if ((player.getCartaIniziale().getAngoloFronteTopLeft() == StatoAngolo.INSETTI) ||
                (player.getCartaIniziale().getAngoloFronteTopRight() == StatoAngolo.INSETTI) ||
                (player.getCartaIniziale().getAngoloFronteBottomLeft() == StatoAngolo.INSETTI) ||
                (player.getCartaIniziale().getAngoloFronteBottomRight() == StatoAngolo.INSETTI)) {
                INSETTI++;
            }
        }

        if (condizioneV != 0) {
            if ((player.getCartaIniziale().getAngoloFronteTopLeft() == StatoAngolo.VEGETALE) ||
                (player.getCartaIniziale().getAngoloFronteTopRight() == StatoAngolo.VEGETALE) ||
                (player.getCartaIniziale().getAngoloFronteBottomLeft() == StatoAngolo.VEGETALE) ||
                (player.getCartaIniziale().getAngoloFronteBottomRight() == StatoAngolo.VEGETALE)) {
                VEGETALE++;
            }
        }
        if(requisiti== false) {
        	 System.out.println("i requisiti della carta oro sono: numero animali = "+cartaOro.getNumeroAnimali()+"numero insetti = "+cartaOro.getNumeroInsetti()+"numero funghi = "+cartaOro.getNumeroFunghi()+"numero vegetale ="+cartaOro.getNumeroVegetale());
     		
             System.out.println("al momento il numero di  regni tra quelli richiesti  è numero nimali = "+ ANIMALE +"numero insetti = "+INSETTI+"numero funghi = "+FUNGHI+"numero vegetale = "+VEGETALE);
     		
        }
       

		 
	}
	return requisiti;
	
		
	}

public int controllaCarteObbiettivo(Giocatore giocatore, CartaObiettivo cartaObiettivo) {
	int piuma=0, inchistro=0, pergamena=0, animali=0, vegetali=0, insetti=0, funghi=0;
	int piunti=0;
	int id=cartaObiettivo.getId();
	StatoAngolo[] angoli= new StatoAngolo[4];
	for (int i = 0; (i < SIZE); i++) {
	    for (int j = 0; (j < SIZE); j++) {
	    	
	    if (id !=0) {
	    		 
	    	 angoli=tabella[i][j].getAngoli();
	    	switch (id){
	    	case 87:
	    		if (angoli[0] == StatoAngolo.INCHIOSTRO) {
	    		    inchistro += 1;
	    		}
	    		if (angoli[1] == StatoAngolo.INCHIOSTRO) {
	    		    inchistro += 1;
	    		}
	    		if (angoli[2] == StatoAngolo.INCHIOSTRO) {
	    		    inchistro += 1;
	    		}
	    		if (angoli[3] == StatoAngolo.INCHIOSTRO) {
	    		    inchistro += 1;
	    		}
	    		if (angoli[0] == StatoAngolo.PERGAMENA) {
	    		    pergamena += 1;
	    		}
	    		if (angoli[1] == StatoAngolo.PERGAMENA) {
	    		    pergamena += 1;
	    		}
	    		if (angoli[2] == StatoAngolo.PERGAMENA) {
	    		    pergamena += 1;
	    		}
	    		if (angoli[3] == StatoAngolo.PERGAMENA) {
	    		    pergamena += 1;
	    		}

	    		if (angoli[0] == StatoAngolo.PIUMA) {
	    		    piuma += 1;
	    		}
	    		if (angoli[1] == StatoAngolo.PIUMA) {
	    		    piuma += 1;
	    		}
	    		if (angoli[2] == StatoAngolo.PIUMA) {
	    		    piuma += 1;
	    		}
	    		if (angoli[3] == StatoAngolo.PIUMA) {
	    		    piuma += 1;
	    		}

	    		
	    		if(piuma>0&& inchistro>0&&piuma>0) {
	    			piunti+=3;
	    			piuma-=1;
	    			pergamena-=1;
	    			piuma-=1;
	    		}
	    		break;
	    		case 88:
	    		
	    		
	    			if (angoli[0] == StatoAngolo.PIUMA) {
		    		    piuma += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.PIUMA) {
		    		    piuma += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.PIUMA) {
		    		    piuma += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.PIUMA) {
		    		    piuma += 1;
		    		}
	    		
	    		if(piuma>1) {
	    			piunti+=2;
	    			piuma-=2;
	    			
	    		}
	    		break;
	    		
	    		case 89:
	    			if (angoli[0] == StatoAngolo.INCHIOSTRO) {
		    		    inchistro += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.INCHIOSTRO) {
		    		    inchistro += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.INCHIOSTRO) {
		    		    inchistro += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.INCHIOSTRO) {
		    		    inchistro += 1;
		    		}
		    		if(inchistro>1) {
		    			piunti+=2;
		    			inchistro-=2;
		    			
		    		}
	    		break;
	    		case 90:
	    			if (angoli[0] == StatoAngolo.PERGAMENA) {
		    		    pergamena += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.PERGAMENA) {
		    		    pergamena += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.PERGAMENA) {
		    		    pergamena += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.PERGAMENA) {
		    		   
		    			 pergamena += 1;
	    		
		    		}
		    		if(pergamena>1) {
			    			piunti+=2;
			    			pergamena-=2;
			    			
			    		}
		    		break;
	    		case 91:
	    			if (angoli[0] == StatoAngolo.VEGETALE) {
	    				vegetali += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.VEGETALE) {
		    			vegetali += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.VEGETALE) {
		    			vegetali += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.VEGETALE) {
		    		   
		    			vegetali += 1;
	    		
		    		}
		    		if(vegetali>2) {
			    			piunti+=2;
			    			vegetali-=3;
			    			
			    		}
		    		break;
	    		case 92:
	    			if (tabella[i][j].getId() != 0&&tabella[i+1][j+1].getId() != 0&&tabella[i+1][j+1].getId() != 0) {

	    			if (tabella[i][j].getColore()== Colore.VERDE&&tabella[i+1][j+1].getColore()== Colore.VERDE&&tabella[i+2][j+2].getColore()== Colore.VERDE) {
	    				piunti+=2;
	    			}
	    			}
	    			break;
	    		case 93:
	    			if (tabella[i][j].getId() != 0&&tabella[i][j+2].getId() != 0&&tabella[i-1][j+3].getId() != 0) {

	    			if (tabella[i][j].getColore()== Colore.VERDE&&tabella[i][j+2].getColore()== Colore.VERDE&&tabella[i-1][j+3].getColore()== Colore.VIOLA) {
	    				piunti+=3;
	    			}
	    			}
	    			break;
	    		case 94:
	    			if (angoli[0] == StatoAngolo.ANIMALE) {
	    				animali += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.ANIMALE) {
		    			animali += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.ANIMALE) {
		    			animali += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.ANIMALE) {
		    		   
		    			animali += 1;
	    		
		    		}
		    		if(animali>2) {
			    			piunti+=2;
			    			animali-=3;
			    			
			    		}
		    		break;
	    		case 95:
	    			if (tabella[i][j].getId() != 0&&tabella[i-1][j+1].getId() != 0&&tabella[i-2][j+2].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.BLU &&tabella[i-1][j+1].getColore()== Colore.BLU&&tabella[i-2][j+2].getColore()== Colore.BLU) {
		    				piunti+=2;
		    			}
		    			}
		    		break;
	    		case 96:
	    			if (tabella[i][j].getId() != 0&&tabella[i][j-2].getId() != 0&&tabella[i+1][j+1].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.BLU &&tabella[i][j-2].getColore()== Colore.BLU&&tabella[+1][j+1].getColore()== Colore.ROSSO) {
		    				piunti+=3;
		    			}
		    			}
		    		break;
	    		case 97:
	    			if (angoli[0] == StatoAngolo.FUNGHI) {
	    				funghi += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.FUNGHI) {
		    			funghi += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.FUNGHI) {
		    			funghi += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.FUNGHI) {
		    		   
		    			funghi += 1;
	    		
		    		}
		    		if(funghi>2) {
			    			piunti+=2;
			    			funghi-=3;
			    			
			    		}
		    		break;
	    		case 98:
	    			if (tabella[i][j].getId() != 0&&tabella[i-1][j+1].getId() != 0&&tabella[i-2][j+2].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.ROSSO &&tabella[i-1][j+1].getColore()== Colore.ROSSO&&tabella[i-2][j+2].getColore()== Colore.ROSSO) {
		    				piunti+=2;
		    			}
		    			}
		    		break;
	    		case 99:
	    			if (tabella[i][j].getId() != 0&&tabella[i][j+2].getId() != 0&&tabella[i+1][j+3].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.ROSSO &&tabella[i][j+2].getColore()== Colore.ROSSO&&tabella[i+1][j+3].getColore()== Colore.VERDE) {
		    				piunti+=3;
		    			}
		    			}
		    		break;
	    		case 100:
	    			if (angoli[0] == StatoAngolo.INSETTI) {
	    				insetti += 1;
		    		}
		    		if (angoli[1] == StatoAngolo.INSETTI) {
		    			insetti += 1;
		    		}
		    		if (angoli[2] == StatoAngolo.INSETTI) {
		    			insetti += 1;
		    		}
		    		if (angoli[3] == StatoAngolo.INSETTI) {
		    		   
		    			insetti += 1;
	    		
		    		}
		    		if(insetti>2) {
			    			piunti+=2;
			    			insetti-=3;
			    			
			    		}
		    		break;
	    		case 101:
	    			if (tabella[i][j].getId() != 0&&tabella[i-1][j+1].getId() != 0&&tabella[i-2][j+2].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.VIOLA &&tabella[i-1][j+1].getColore()== Colore.VIOLA&&tabella[i-2][j+2].getColore()== Colore.VIOLA) {
		    				piunti+=2;
		    			}
		    			}
		    		break;
	    		case 102:
	    			if (tabella[i][j].getId() != 0&&tabella[i-1][j-1].getId() != 0&&tabella[i-2][j+2].getId() != 0) {

		    			if (tabella[i][j].getColore()== Colore.VIOLA &&tabella[i-1][j-1].getColore()== Colore.BLU &&tabella[i][j+2].getColore()== Colore.VIOLA) {
		    				piunti+=3;
		    			}
		    			}
		    		break;
	    			
	    	}
	    	
	    }
	    }
	}
	return piunti;

}
	
	/*
	public void inizia() {
		MazzoCarteRisorsa mazzoRisorsa = new MazzoCarteRisorsa();
		MazzoCarteOro mazzoOro = new MazzoCarteOro();
		Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Pesca una carta dal Mazzo Risorsa");
            System.out.println("2. Pesca una carta dal Mazzo Oro");
            System.out.println("3. Pesca una carta dal Campo");
            System.out.println("4. Esci");

            int scelta = scanner.nextInt();

            switch (scelta) {
                case 1:
                     pescaDalMazzo (mazzoRisorsa);
                    break;
                case 2:
                     pescaDalMazzo (mazzoOro);
                    break;
                case 3:
                     pescaDalCampo ();
                    break;
                case 4:
                    System.out.println("Grazie per aver giocato!");
                    return;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }
    }
    */

	



}
