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

    public static void main(String[] args) {
    	acquisisciDatiInput();
    	System.out.println("numero righe: " + datiProblema[0]);
    	System.out.println("numero colonne: " + datiProblema[1]);
    	System.out.println("numero minimo ingredienti per fetta: " + datiProblema[2]);
    	System.out.println("numero massimo celle per fetta: " + datiProblema[3]);
    }

    public static void acquisisciDatiInput() {
    	try {
            System.out.print("Enter the file name with extension (e.g.: example-input.in): ");
            Scanner input = new Scanner(System.in);
            File file = new File(input.nextLine());
            input = new Scanner(file);

            boolean haScansionatoPrimaRiga = false;
            while (input.hasNextLine()) {
            	String line = input.nextLine();

            	if (haScansionatoPrimaRiga == false) {
            		datiProblema = stringArrayToIntArray(line);
            		haScansionatoPrimaRiga = true;
            	}

                System.out.println(line);
            }

            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
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
