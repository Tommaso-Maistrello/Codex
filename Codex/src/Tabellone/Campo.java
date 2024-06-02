package Tabellone;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import Carte.Carta;
import Carte.CartaIniziale;
import Carte.CartaOro;
import Carte.CartaRisorsa;
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
		String red = "\033[31m";
		 String reset = "\033[0m";
		int x,y;
		
		int id =esisteCarta(player);// controlla che il giocatore abbia fornito id di una carta che ha in mano
		
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
				esiste = posizioneGiocabile(x,y);// controlla se la coordintata è in un punto giocabile cioè se uno dei 4 angoli tocca un'altra carta
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
		if (id <41) {
			CartaRisorsa carta= Mano.prendiCartaRisorsaConID(id, player);
			if (verso==2) {
				carta.setAngoloFronteBottomLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteBottomRight(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopLeft(StatoAngolo.VUOTO);
				carta.setAngoloFronteTopRight(StatoAngolo.VUOTO);
				carta.setPunti(0);
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
			}
			 tabella[x][y].setCartaOro(carta);
			 System.out.println("\nHai giocato la carta oro");
		}
		//System.out.println("hai giocato la carta");
		
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
	public boolean posizioneGiocabile(int x, int y) {
		boolean esiste = false;
		String red = "\033[31m";
		 String reset = "\033[0m";
		StatoAngolo[] angoli=null;
		//boolean topRight, topLeft,boottomRight, boottomLeft = false;
		//for (int i=0; i<4;i++) {
		if ((tabella[x-1][y-1].getId()!=0  )||tabella[x-1][y+1].getId()!=0 ||tabella[x+1][y-1].getId()!=0||tabella[x+1][y+1].getId()!=0) {
			esiste = true;
		}
		if (tabella[x-1][y-1].getId()!=0) {
		angoli=tabella[x-1][y-1].getAngoli();// carta in alto a sinistra rispetto alla coordinata
			if(angoli[3]==StatoAngolo.NULLO||angoli[3]==StatoAngolo.COPERTO) {//controlla angol bottom right
			esiste = false;
			System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti"+ reset);
			}	
		}
		if (tabella[x-1][y+1].getId()!=0) {
			angoli=tabella[x-1][y+1].getAngoli();// carta in basso a sinistra rispetto alla coordinata
			if(angoli[1]==StatoAngolo.NULLO||angoli[1]==StatoAngolo.COPERTO) {//controlla angolo top right
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti"+ reset);
			}	
			}
		if (tabella[x+1][y-1].getId()!=0) {
			angoli=tabella[x+1][y-1].getAngoli();// carta in alto a destra rispetto alla coordinata
			if(angoli[2]==StatoAngolo.NULLO||angoli[2]==StatoAngolo.COPERTO) {//controlla angolo bottom left
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti"+ reset);
			}	
			}
		if (tabella[x+1][y+1].getId()!=0) {
			angoli=tabella[x+1][y+1].getAngoli();// carta in basso a destra rispetto alla coordinata
			if(angoli[0]==StatoAngolo.NULLO||angoli[0]==StatoAngolo.COPERTO) {//controlla angolo top left
				esiste = false;
				System.out.println(red+"non è possibile giocare la carta su angoli nulli o coperti"+ reset);
				
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
