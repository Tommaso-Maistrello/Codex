package Carte;

import Enum.Colore;
import Enum.Risorsa;

public class CartaRisorsa extends Carta {

	private Colore colore;
	private int punti;

	
	public CartaRisorsa(String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, Risorsa[] risorseRetroCentrali, Colore colore,
			int punti) {
		super(angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight,
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight,
				risorseRetroCentrali);
		this.colore = colore;
		this.punti = punti;
	}

	public Colore getColore() {
		return colore;
	}
	
	
	public int getPunti() {
		return punti;
	}
}
