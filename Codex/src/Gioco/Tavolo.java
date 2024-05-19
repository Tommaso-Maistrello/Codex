package Gioco;

import Carte.CartaObiettivo;

public class Tavolo {

	private static CartaObiettivo[] obiettiviComuni = new CartaObiettivo[2];
	
	public Tavolo(CartaObiettivo[] carteObiettivoEstratte) {
		for(int i=0; i<2; i++) {
			Tavolo.obiettiviComuni[i] = carteObiettivoEstratte[i];			
		}
	}
	
	
	private static void visualizzaCaso(int id) {
		      
		switch (id) {
	        case 87:
	            System.out.println("3 punti per ogni combinazione di: 1 piuma, 1 inchiostro e 1 pergamena.");
	            break;
	        case 88:
	            System.out.println("2 punti per ogni 2 piume.");
	            break;
	        case 89:
	            System.out.println("2 punti per ogni 2 inchiostri.");
	            break;
	        case 90:
	            System.out.println("2 punti per ogni 2 pergamene.");
	            break;
	        case 91:
	            System.out.println("2 punti per ogni 3 vegetali.");
	            break;
	        case 92:
	        	String trisVerde="\u001B[32m▀■▄\u001B[0m";
	            System.out.println("2 punti ogni "+trisVerde+".");
	            break;
	        case 93:
	        	String unIns="\u001B[35m▀\u001B[0m";
	        	String dueVeg="\u001B[32m█\u001B[0m";
	            System.out.println("3 punti ogni  "+dueVeg);
	            System.out.println("\t     "+unIns);
	            break;
	        case 94:
	            System.out.println("2 punti per ogni 3 animali");
	            break;
	        case 95:
	        	String trisBlu="\u001B[36m▄■▀\u001B[0m";
	            System.out.println("2 punti ogni "+trisBlu+".");
	            break;
	        case 96:
	        	String unAnimUnFung="\u001B[36m▄\u001B[31m■\u001B[0m";
	        	String unAnim="\u001B[36m▀\u001B[0m";
	            System.out.println("3 punti ogni "+unAnimUnFung);
	            System.out.println("\t     "+unAnim);
	            break;
	        case 97:
	            System.out.println("2 punti per ogni 3 funghi.");
	            break;
	        case 98:
	        	String trisRosso="\u001B[31m▄■▀\u001B[0m";
	            System.out.println("2 punti ogni "+trisRosso+".");
	            break;
	        case 99:
	        	String unVeg="\u001B[32m▀\u001B[0m";
	        	String dueFung="\u001B[31m█\u001B[0m";
	            System.out.println("3 punti ogni "+dueFung);
	            System.out.println("\t      "+unVeg);
	            break;
	        case 100:
	            System.out.println("2 punti per ogni 3 insetti.");
	            break;
	        case 101:
	        	String trisViola="\u001B[35m▀■▄\u001B[0m";
	            System.out.println("2 punti ogni "+trisViola+".");
	            break;
	        case 102:
	        	String unAnhimUnFung="\u001B[36m■\u001B[35m▄\u001B[0m";
	        	String unAnhim="\u001B[35m▀\u001B[0m";
	            System.out.println("3 punti ogni "+unAnhimUnFung);
	            System.out.println("\t      "+unAnhim);
	            break;
	        default:
	            System.out.println("Id0 non corrisponde a nessun caso");
		}
	}
	
	public static void visualizzaObiettiviComuni() {
        
        int id0 = obiettiviComuni[0].getId();
        System.out.println("Primo obiettivo comune: ");
        visualizzaCaso(id0);
        System.out.println();
        int id1 = obiettiviComuni[1].getId();
        System.out.println("Secondo obiettivo comune: ");
        visualizzaCaso(id1);
        
        
        /*
        Scanner leggi = new Scanner(id0);
	    leggi.useDelimiter("x");
	    leggi.hasNextLine();
	    int punti=leggi.nextInt();
	    System.out.println(punti);
        String stringa=leggi.next();
        System.out.println(stringa);
        System.out.println("Primo obiettivo comune: " + RequisitiPunti0);
	
        String RequisitiPunti1 = obiettiviComuni[1].getRequisitiPunti();
        System.out.println("Secondo obiettivo comune: " + RequisitiPunti1);		*/
    }
	
		/*
	public static void main(String[] args) throws FileNotFoundException {
		
		CartaObiettivo[] estratte = CartaObiettivo.carteObiettivoEstratte(CartaObiettivo.mescolaMazzo());
		Tavolo tavolo = new Tavolo(estratte);
		tavolo.visualizzaObiettiviComuni();
		
	}*/

}
