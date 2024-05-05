package Enum;

public enum ColoreSegnalino {
	
	ROSSO, BLU, VERDE, GIALLO;

	//variabile per contare quanti giocatori sono stati costruiti e sapere il numero del giocatore corrente
    private static int conta=1;

    /**
     * Ad ogni nuovo giocatore viene assegnato un colore e la variabile conta viene incrementata. 
     * Ogni volta che viene richiamato il metodo getColore(), conta viene incrementato cosicchè il giocatore successivo riceva un nuovo colore
     * 
     * @return Colore del segnalino in base al numero di giocatore
     */
    public static ColoreSegnalino getColore() {
        switch (conta) {
            case 1:
                conta++;
                return ROSSO;
            case 2:
                conta++;
                return BLU;
            case 3:
                conta++;
                return VERDE;
            case 4:
                conta++;
                return GIALLO;
            default:
                return null;
        }
    }
}
