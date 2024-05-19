package Tabellone;

public class Campo {

	// Se l'utente dovesse posizionare tutte le carte in diagonale, la grandezza
	// massima sarebbe di 41 caselle occupate ma bisgona considerare ogni direzione
	private final Casella[][] tabella;
	private static final int SIZE = 8;

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
		System.out.println("Prova");
		tabella[1][1].visualizzaCasella();
		
	}

}
