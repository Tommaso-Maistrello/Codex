package Carte;

import Enum.StatoAngolo;

public abstract class Carta {

	public int id;
	public StatoAngolo angoloFronteTopLeft;
	public StatoAngolo angoloFronteTopRight;
	public StatoAngolo angoloFronteBottomLeft;
	public StatoAngolo angoloFronteBottomRight;
	public StatoAngolo angoloRetroTopLeft;
	public StatoAngolo angoloRetroTopRight;
	public StatoAngolo angoloRetroBottomLeft;
	public StatoAngolo angoloRetroBottomRight;
	public StatoAngolo risorsaRetroCentrale;

	public  Carta(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft,
			StatoAngolo angoloFronteBottomRight, StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight,
			StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale) {

		this.id = id;
		this.angoloFronteTopLeft = angoloFronteTopLeft;
		this.angoloFronteTopRight = angoloFronteTopRight;
		this.angoloFronteBottomLeft = angoloFronteBottomLeft;
		this.angoloFronteBottomRight = angoloFronteBottomRight;
		this.angoloRetroTopLeft = angoloRetroTopLeft;
		this.angoloRetroTopRight = angoloRetroTopRight;
		this.angoloRetroBottomLeft = angoloRetroBottomLeft;
		this.angoloRetroBottomRight = angoloRetroBottomRight;
		this.risorsaRetroCentrale = risorsaRetroCentrale;
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public StatoAngolo getAngoloFronteTopLeft() {
		return angoloFronteTopLeft;
	}
	
	public void setAngoloFronteTopLeft(StatoAngolo angoloFronteTopLeft) {
		this.angoloFronteTopLeft = angoloFronteTopLeft;
	}
	
	public StatoAngolo getAngoloFronteTopRight() {
		return angoloFronteTopRight;
	}
	
	public void setAngoloFronteTopRight(StatoAngolo angoloFronteTopRight) {
		this.angoloFronteTopRight = angoloFronteTopRight;
	}
	
	public StatoAngolo getAngoloFronteBottomLeft() {
		return angoloFronteBottomLeft;
	}
	
	public void setAngoloFronteBottomLeft(StatoAngolo angoloFronteBottomLeft) {
		this.angoloFronteBottomLeft = angoloFronteBottomLeft;
	}
	
	public StatoAngolo getAngoloFronteBottomRight() {
		return angoloFronteBottomRight;
	}
	
	public void setAngoloFronteBottomRight(StatoAngolo angoloFronteBottomRight) {
		this.angoloFronteBottomRight = angoloFronteBottomRight;
	}
	
	public StatoAngolo getAngoloRetroTopLeft() {
		return angoloRetroTopLeft;
	}
	
	public void setAngoloRetroTopLeft(StatoAngolo angoloRetroTopLeft) {
		this.angoloRetroTopLeft = angoloRetroTopLeft;
	}
	
	public StatoAngolo getAngoloRetroTopRight() {
		return angoloRetroTopRight;
	}
	
	public void setAngoloRetroTopRight(StatoAngolo angoloRetroTopRight) {
		this.angoloRetroTopRight = angoloRetroTopRight;
	}
	
	public StatoAngolo getAngoloRetroBottomLeft() {
		return angoloRetroBottomLeft;
	}
	
	public void setAngoloRetroBottomLeft(StatoAngolo angoloRetroBottomLeft) {
		this.angoloRetroBottomLeft = angoloRetroBottomLeft;
	}
	
	public StatoAngolo getAngoloRetroBottomRight() {
		return angoloRetroBottomRight;
	}
	
	public void setAngoloRetroBottomRight(StatoAngolo angoloRetroBottomRight) {
		this.angoloRetroBottomRight = angoloRetroBottomRight;
	}
	
	public StatoAngolo getRisorsaRetroCentrale() {
		return risorsaRetroCentrale;
	}
	
	public void setRisorsaRetroCentrale( StatoAngolo risorsaRetroCentrale) {
		this.risorsaRetroCentrale = risorsaRetroCentrale;
	}
}
