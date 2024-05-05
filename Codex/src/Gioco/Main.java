package Gioco;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		//Pannello pannello = new Pannello();
		
		costruisciMazzo();
		Scanner sc=new Scanner(System.in);
		
		int numGiocatori=0;
				
		do {
			System.out.println("Inserisci il numero di giocatori: ");
			numGiocatori=sc.nextInt();
		}while(numGiocatori<2 || numGiocatori>4);
		
		//libera il buffer
		sc.nextLine();
		
		Giocatore[] giocatori= new Giocatore[numGiocatori];
		
		for(int i=0; i<giocatori.length; i++)
		{
			int j=i+1;
			System.out.println("Inserisci l'username "+ j +"o giocatore: ");
			String nome=sc.nextLine();
			giocatori[i]=new Giocatore(nome, j);
		}
		
		//Per verificare il corretto funzionamento del codice precedente
		for(int i=0; i<giocatori.length; i++)
		{
			int j=i+1;
			System.out.println(j+"o giocatore");
			System.out.print("Username: " + giocatori[i].getUsername());
			System.out.print("; colore segnalino: " + giocatori[i].getColoreSegnalino());
			System.out.print("; pedina nera: " + giocatori[i].isPedinaNera());
			System.out.println("; posizione: " + giocatori[i].getPosizione());
			
		}
	}

}
