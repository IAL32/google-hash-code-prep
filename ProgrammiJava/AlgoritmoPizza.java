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
1 -----> min tot di ciascuno ingrediente per fetta
6 -----> massimo celle per fetta

T -----> tomato
M -----> mushroom

GOAL: trovare il numero maggiore di fette possibili (rettangolari).
*/


public class AlgoritmoPizza {

	static int[] datiProblema = new int[4];
	static Scanner input = new Scanner(System.in);
	static char[][] cellePizza = new char[1000][1000];

    public static void main(String[] args) {
    	processaFileInput();
    	leggiDatiNumericiDaFileInput();
    	leggiCellePizzaDaFileInput();
    	leggiPizza();
    	determinaFettePizza();

    	int numeroRighe = datiProblema[0];
    	int numeroColonne = datiProblema[1];
    	System.out.println("Numero righe: " + numeroRighe);
    	System.out.println("Numero colonne: " + numeroColonne);

    	System.out.println("Numero minimo ingredienti per fetta: " + datiProblema[2]);
    	System.out.println("Numero massimo celle per fetta: " + datiProblema[3]);

    }

    // MARK: - ALGORITMO
    public static void determinaFettePizza() {
    	int numeroMushrooms = 0, numeroPomodori = 0;
    	for (int j = 0; j < datiProblema[0]; j++) {
    		for (int i = 0; i < datiProblema[1]; i++) {
    			// cerca fette nell'intera pizza...
    			if (cellePizza[j][i] == 'T') {
    				numeroPomodori++;
    			} else if (cellePizza[j][i] == 'M') {
    				numeroMushrooms++;
    			}
    		}
    	}
    	System.out.println("numero pomodori: " + numeroPomodori);
    	System.out.println("numero funghi: " + numeroMushrooms);
    }

    // MARK: - INPUT

    public static void processaFileInput() {
    	try {
            File file = new File("big.in");
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
    	for (int j = 0; j < datiProblema[0]; j++) {
    		for (int i = 0; i < datiProblema[1]; i++) {
    			System.out.print(cellePizza[j][i]);
    		}
    		System.out.println();
    	}
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
