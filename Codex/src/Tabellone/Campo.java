package Tabellone;

import java.io.FileNotFoundException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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

	public void visualizzaCampo() {
		//PRIMA RIGA
		//Sopra
		System.out.print("┌─");
		for(int i=0; i<20; i++) {
			System.out.print("─┬─");
		}
		System.out.print("─┐");
		//Mezzo
		System.out.println();
		System.out.print("│");
		for(int i=0; i<21; i++) {
			System.out.print(tabella[i][i].getIdColored());
			System.out.print("│");
		}
		//Sotto
		System.out.println();
		System.out.print("├─");
		for(int i=0; i<20; i++) {
			System.out.print("─┼─");
		}
		System.out.print("─┤");
		//RIGHE IN MEZZO
		for(int j=1; j<20; j++) {
			System.out.println();
			System.out.print("│");
			for(int i=0; i<21; i++) {
				System.out.print(tabella[i][i].getIdColored());
				System.out.print("│");
			}
			//Sotto
			System.out.println();
			System.out.print("├─");
			for(int i=0; i<20; i++) {
				System.out.print("─┼─");
			}
			System.out.print("─┤");
		}
		//RIGA IN MEZZO CON CARTA INIZIALE
		//ULTIMA RIGA
		System.out.println();
		System.out.print("│");
		for(int i=0; i<21; i++) {
			System.out.print(tabella[i][i].getIdColored());
			System.out.print("│");
		}
		
		System.out.println();
		System.out.print("└─");
		for(int i=0; i<20; i++) {
			System.out.print("─┴─");
		}
		System.out.print("─┘");
		System.out.println();
		
		
		
		
		
		
		
		//tabella[1][1].visualizzaCasella();
		
	}

}
