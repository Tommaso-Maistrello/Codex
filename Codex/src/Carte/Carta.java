package Carte;

import Enum.Risorsa;

public abstract class Carta {


	private String angoloFronteTopLeft;
	private String angoloFronteTopRight;
	private String angoloFronteBottomLeft;
	private String angoloFronteBottomRight;
	private String angoloRetroTopLeft;
	private String angoloRetroTopRight;
	private String angoloRetroBottomLeft;
	private String angoloRetroBottomRight;
	private Risorsa risorseRetroCentrali[];

	public Carta(String angoloFronteTopLeft, String angoloFronteTopRight, String angoloFronteBottomLeft,
			String angoloFronteBottomRight, String angoloRetroTopLeft, String angoloRetroTopRight,
			String angoloRetroBottomLeft, String angoloRetroBottomRight, Risorsa[] risorseRetroCentrali) {

		this.angoloFronteTopLeft = angoloFronteTopLeft;
		this.angoloFronteTopRight = angoloFronteTopRight;
		this.angoloFronteBottomLeft = angoloFronteBottomLeft;
		this.angoloFronteBottomRight = angoloFronteBottomRight;
		this.angoloRetroTopLeft = angoloRetroTopLeft;
		this.angoloRetroTopRight = angoloRetroTopRight;
		this.angoloRetroBottomLeft = angoloRetroBottomLeft;
		this.angoloRetroBottomRight = angoloRetroBottomRight;
		this.risorseRetroCentrali = risorseRetroCentrali;
	}

	
	public String getAngoloFronteTopLeft() {
		return angoloFronteTopLeft;
	}
	
	public void setAngoloFronteTopLeft(String angoloFronteTopLeft) {
		this.angoloFronteTopLeft = angoloFronteTopLeft;
	}
	
	public String getAngoloFronteTopRight() {
		return angoloFronteTopRight;
	}
	
	public void setAngoloFronteTopRight(String angoloFronteTopRight) {
		this.angoloFronteTopRight = angoloFronteTopRight;
	}
	
	public String getAngoloFronteBottomLeft() {
		return angoloFronteBottomLeft;
	}
	
	public void setAngoloFronteBottomLeft(String angoloFronteBottomLeft) {
		this.angoloFronteBottomLeft = angoloFronteBottomLeft;
	}
	
	public String getAngoloFronteBottomRight() {
		return angoloFronteBottomRight;
	}
	
	public void setAngoloFronteBottomRight(String angoloFronteBottomRight) {
		this.angoloFronteBottomRight = angoloFronteBottomRight;
	}
	
	public String getAngoloRetroTopLeft() {
		return angoloRetroTopLeft;
	}
	
	public void setAngoloRetroTopLeft(String angoloRetroTopLeft) {
		this.angoloRetroTopLeft = angoloRetroTopLeft;
	}
	
	public String getAngoloRetroTopRight() {
		return angoloRetroTopRight;
	}
	
	public void setAngoloRetroTopRight(String angoloRetroTopRight) {
		this.angoloRetroTopRight = angoloRetroTopRight;
	}
	
	public String getAngoloRetroBottomLeft() {
		return angoloRetroBottomLeft;
	}
	
	public void setAngoloRetroBottomLeft(String angoloRetroBottomLeft) {
		this.angoloRetroBottomLeft = angoloRetroBottomLeft;
	}
	
	public String getAngoloRetroBottomRight() {
		return angoloRetroBottomRight;
	}
	
	public void setAngoloRetroBottomRight(String angoloRetroBottomRight) {
		this.angoloRetroBottomRight = angoloRetroBottomRight;
	}
	
	public Risorsa[] getRisorseRetroCentrali() {
		return risorseRetroCentrali;
	}
	
	public void setRisorseRetroCentrali(Risorsa[] risorseRetroCentrali) {
		this.risorseRetroCentrali = risorseRetroCentrali;
	}
}
