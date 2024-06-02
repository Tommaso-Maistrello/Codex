package Carte;

import Enum.Colore;
import Enum.StatoAngolo;

public class CartaRisorsa extends Carta {
	
	private final Colore colore;
	private int punti;
	
	
	public CartaRisorsa(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft, StatoAngolo angoloFronteBottomRight, 
			StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight, StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale, 
			Colore colore, int punti) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight, 
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight, risorsaRetroCentrale);
		this.colore = colore;
		this.punti = punti;
	}
	
	
	public Colore getColore() {
		return colore;
	}
	
	
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti= punti;
	}
	
}