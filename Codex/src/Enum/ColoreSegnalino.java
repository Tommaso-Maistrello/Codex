package Enum;

public enum ColoreSegnalino {
	
	ROSSO, BLU, VERDE, GIALLO, NERO;

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
            case 5:
            	conta++;
            	return NERO;
            default:
                return null;
        }
       } 
    /*
   public static void main(String[] args) {
	   for(int i=1; i <= 4; i++) {
		   ColoreSegnalino colore = ColoreSegnalino.getColore();
		   System.out.println("Giocatore "+i+": "+colore);
	   }
   }*/
    
    }

