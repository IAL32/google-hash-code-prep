import java.io.File;
import java.util.Scanner;

/*

ESEMPIO INPUT: 

3 5 1 6
TTTTT
TMMMT
TTTTT


SPIEGAZIONE:
3 -----> righe pizza
5 -----> colonne pizza
1 -----> min X ingredienti per fetta
6 -----> massimo celle per fetta

T -----> tomato
M -----> mushroom
*/


public class AlgoritmoPizza {

	static int[] datiProblema = new int[4];
	static Scanner input = new Scanner(System.in);
	static char[][] cellePizza = new char[1000][1000];

    public static void main(String[] args) {
    	processaFileInput();
    	leggiDatiNumericiDaFileInput();
    	leggiCellePizzaDaFileInput();

    	int numeroRighe = datiProblema[0];
    	int numeroColonne = datiProblema[1];
    	System.out.println("Numero righe: " + numeroRighe);
    	System.out.println("Numero colonne: " + numeroColonne);

    	System.out.println("Numero minimo ingredienti per fetta: " + datiProblema[2]);
    	System.out.println("Numero massimo celle per fetta: " + datiProblema[3]);

    }

    public static void processaFileInput() {
    	try {
            File file = new File("example-input.in");
            input = new Scanner(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void leggiDatiNumericiDaFileInput() {
    	String stringa = input.nextLine();
        datiProblema = stringArrayToIntArray(stringa);
    }

    public static void leggiCellePizzaDaFileInput() {
    	for (int j = 0; input.hasNextLine(); j++) {
    		String line = input.nextLine();
    		for (int i = 0; i < line.length(); i++) {
    			cellePizza[j][i] = line.charAt(i); 
    		}
    	}
    }

    public static void leggiPizza() {
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
