import java.io.File;
import java.util.Scanner;

/*

ESEMPIO INPUT: 

3 5 1 6
TTTTT
TMMMT
TTTTT


SPIEGAZIONE:
3 -----> righe
5 -----> colonne
1 -----> min X ingredienti per fetta
6 -----> massimo celle per fetta
*/


public class AlgoritmoPizza {

	static int[] datiProblema = new int[4];
	static Scanner input = new Scanner(System.in);;

    public static void main(String[] args) {
    	leggiDaFile();
    	leggiDatiNumerici();

    	System.out.println("-----------------------");
    	acquisisciDatiInput();

    	int numeroRighe = datiProblema[0];
    	int numeroColonne = datiProblema[1];
    	System.out.println("Numero righe: " + numeroRighe);
    	System.out.println("Numero colonne: " + numeroColonne);

    	System.out.println("Numero minimo ingredienti per fetta: " + datiProblema[2]);
    	System.out.println("Numero massimo celle per fetta: " + datiProblema[3]);
    	System.out.println("-----------------------");

    	String[][] cellePizza = new String[numeroRighe][numeroColonne];

    }

    public static void leggiDaFile() {
    	try {
            File file = new File("example-input.in");
            input = new Scanner(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void leggiDatiNumerici() {
    	String stringa = input.nextLine();
        datiProblema = stringArrayToIntArray(stringa);
    }

    // CONVERTE STRINGA IN ARRAY INTERI. ES: "3 4 5 2" in [3, 4, 5, 2]
    public static int[] stringArrayToIntArray(String intString) {
    	String[] intStringSplit = intString.split(" "); //Split by spaces
    	int[] result = new int[intStringSplit.length]; //Used to store our ints

    	for (int i = 0; i < intStringSplit.length; i++) {
        	//parse and store each value into int[] to be returned
        	result[i] = Integer.parseInt(intStringSplit[i]); 
    	}
    	return result;
	}
}
