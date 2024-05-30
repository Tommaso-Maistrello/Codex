package Carte;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

import Enum.Colore;
import Enum.StatoAngolo;
import Gioco.Partita;



public class CartaOro extends Carta {
	
	private final Colore colore;
	private final String condizioneA, condizioneF, condizioneI, condizioneV, punti;
	private final int numeroAnimale, numeroFunghi, numeroInsetti, numeroVegetale;
	
	
	
	public CartaOro(int id, StatoAngolo angoloFronteTopLeft, StatoAngolo angoloFronteTopRight, StatoAngolo angoloFronteBottomLeft, StatoAngolo angoloFronteBottomRight, 
			StatoAngolo angoloRetroTopLeft, StatoAngolo angoloRetroTopRight, StatoAngolo angoloRetroBottomLeft, StatoAngolo angoloRetroBottomRight, StatoAngolo risorsaRetroCentrale, 
			Colore colore,String punti, String condizioneA, int numeroAnimale, String condizioneF, int numeroFunghi, String condizioneI, int numeroInsetti, String condizioneV, int numeroVegetale ) {
		super(id, angoloFronteTopLeft, angoloFronteTopRight, angoloFronteBottomLeft, angoloFronteBottomRight, 
				angoloRetroTopLeft, angoloRetroTopRight, angoloRetroBottomLeft, angoloRetroBottomRight, risorsaRetroCentrale ); 
			
		
		this.colore = colore;
		this.condizioneA = condizioneA;
		this.condizioneF = condizioneF;
		this.condizioneI = condizioneI;
		this.condizioneV = condizioneV;
		this.numeroAnimale = numeroAnimale;
		this.numeroFunghi = numeroFunghi;
		this.numeroInsetti = numeroInsetti;
		this.numeroVegetale = numeroVegetale;
		this.punti = punti;
		}
		
	
	public Colore getColore() {
		return colore;
	}	
	public String getCondizione() {
		return punti;
	}
	
	public String getCondizioneAnimali() {
		return condizioneA;
	}
	public int getNumeroAnimali() {
		return numeroAnimale;
	}
	public String getCondizioneFunghi() {
		return condizioneF;
	}
	public int getNumeroFunghi() {
		return numeroFunghi;
	}
	public String getCondizioneInsetti() {
		return condizioneI;
	}
	public int getNumeroInsetti() {
		return numeroInsetti;
	}
	public String getCondizioneVegetale() {
		return condizioneV;
	}
	public int getNumeroVegetale() {
		return numeroVegetale;
	}
}