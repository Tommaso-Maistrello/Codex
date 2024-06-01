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

public class Campo {

	// Se l'utente dovesse posizionare tutte le carte in diagonale, la grandezza
	// massima sarebbe di 41 caselle occupate ma bisgona considerare ogni direzione
	private final Casella[][] tabella;
	private static final int SIZE = 21;

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
		        	//faccio passare tutta la tabella per cercare la cella con l'id richiestoo
		        	for(int i=0; i<SIZE; i++) {
		        		for(int j=0; j<SIZE; j++) {
		        			if(tabella[i][j].getId()==idCercato) {
		        				System.out.println("Visualizzazione della casella specificata...");
		        				tabella[i][j].visualizzaCasella();
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
		System.out.print( "  ");
		for(int i=0; i<SIZE-1; i++) {
		System.out.print(" "+i+" ");
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
				System.out.print(tabella[j][i].getIdColored());
				System.out.print("│");
			}
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
		
		System.out.println();
		System.out.print("  └─");
		for(int i=0; i<SIZE-1; i++) {
			System.out.print("─┴─");
		}
		System.out.print("─┘");
		System.out.println();
		
		//casellaSpecifica();
	}

	public void posizionaCartaIniziale(Giocatore giocatore) {
	        int centroX = SIZE/2-1;
	        int centroY = SIZE/2-1;
	        int k =  SIZE/2-1;
	        System.out.println("la posizion della carta centrale è:"+k);
	        tabella[centroX][centroY].setCartaIniziale(giocatore.getCartaIniziale());
	    }

	public int getSize() {
		return SIZE;
	}	
	
	public void giocaCarta(Giocatore player) {
		boolean esiste= false;
		int x,y;
		
		int id =esisteCarta(player);// controlla che il giocatore abbia fornito id di una carta che ha in mano
		
		Scanner sc = new Scanner(System.in);
		esiste= false;
		do {

		esiste= false;
		int coordinata[]=getCoordinata(sc);// controlla che la cordinata esiste
		x= coordinata[0];
		y= coordinata[1];
		System.out.println("x:"+coordinata[0]+"y:"+coordinata[1]);
		if(tabella[x][y].getId()==0) {//contrtolla che la posizione in qui si vuole giocare è libera
			System.out.println("si può giocare la carta");
			esiste= true;
		}else {
			System.out.println("la carta non si può giocare");
		}
		
		}while(esiste== false);// il ciclo finisce se la cella di coordinata x y esiste ed è libera
		StatoAngolo[] angoli=null;
		StatoAngolo[] nuoviAngoli=new StatoAngolo[4];
		
		/*
		 * nuoviAngolo è l'angolo che si andrà a creare controllando gli angoli che toccano o potrebbero toccare la carta da giocare
		 */
		//il ciclo for deve controlalre se attorno alla casella x y ci sono altre carte con angoli liberi
		
		
			if (tabella[x-1][y-1].getId()!=0) {// controlla la casella in alto a sinistra
				angoli=tabella[x-1][y-1].getAngoli();
				nuoviAngoli[3]=angoli[3];
				//System.out.println(angoli[3]);// controlla l'angolo in basso a destra
			}else if(tabella[x-1][y+1].getId()!=0) {// controlla la casella in alto a destra
				angoli=tabella[x-1][y+1].getAngoli();
				nuoviAngoli[2]=angoli[2];
				//System.out.println(angoli[2]);// controlla l'angolo in basso a sinistra
			}else if(tabella[x+1][y-1].getId()!=0) {// controlla la casella in basso a sinistra
				nuoviAngoli[1]=angoli[1];
				angoli=tabella[x+1][y-1].getAngoli();
				//System.out.println(angoli[1]);// controlla l'angolo in alto a destra
			}else if(tabella[x+1][y+1].getId()!=0){// controlla la casella in basso a destra
				angoli=tabella[x+1][y+1].getAngoli();
				nuoviAngoli[0]=angoli[0];
				//System.out.println(angoli[0]);// controlla l'angolo in alto a sinistra
			}
			System.out.println("stampa nuovi angoli");
			
			 
			for(StatoAngolo angol: nuoviAngoli ) {
				if(angol!=null) {
					System.out.println(angol);
				}
				
			}
			 
			
			
			 	
			
		
		sc.close();
		if (id <41) {
			CartaRisorsa carta= Mano.prendiCartaRisorsaConID(id, player);
			 tabella[x][y].setCartaRisorsa(carta);
			 System.out.println("hai giocato la carta risorsa");
		}else {
			CartaOro carta= Mano.prendiCartaOroConID(id, player);
			 tabella[x][y].setCartaOro(carta);
			 System.out.println("hai giocato la carta oro");
		}
		System.out.println("hai giocato la carta");
		
	}
	public int esisteCarta(Giocatore player) {
		boolean esiste= false;
		Scanner sc = new Scanner(System.in);
		int id;
		do {
			System.out.println("\n-------------------------------------------------------------\n"  );
			System.out.println("qual'è l'id della carta che vuoi giocare?");
			id = sc.nextInt();
			System.out.println("hai scalto la carta con id : "+id);
			esiste = player.getMano().haCartaConId(player, id);
		if (esiste == true) {
			System.out.println("il giocatore ha la carta in mano con id "+id);
			
		}else {
			System.out.println("il giocatore non ha la carta in mano "+id);
		}
		}while(esiste== false);// controlla che il giocatore abbia in mana la corta che si vuole giocare
		return id;
	}
	public int[] getCoordinata(Scanner sc) {
		boolean esiste= false;
		 
		int x,y;
		do {
			System.out.println("qual'è la coordinata x in qui voi giocare la carta");
			x = sc.nextInt();
			System.out.println("qual'è la coordinata y in qui voi giocare la carta");
			y = sc.nextInt();
		
		if (x <SIZE-2 && y <SIZE-2) {
			System.out.println("la coordinata esiste");
			esiste= true;
		}else {
			System.out.println("la coordinata non esiste");
		}
		
		}while(esiste== false);// controlla se la coordinata è valida
	 
		return new int[]{x, y};
	}



}
