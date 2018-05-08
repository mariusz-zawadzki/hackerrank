import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {


    public static final String MOUSE = "Mouse C";
    public static final String ACAT = "Cat A";
    public static final String BCAT = "Cat B";


    /*
     * Complete the catAndMouse function below.
     */
    static String catAndMouse(int aCat, int bCat, int cMouse) {
        /*
         * Write your code here.
         */
        int aDistance = Math.abs(cMouse - aCat);
        int bDistance = Math.abs(cMouse - bCat);
        if (aDistance == bDistance) {
            return MOUSE;
        } else if (aDistance > bDistance) {
            return BCAT;
        } else {
            return ACAT;
        }

    }


    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scan.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scan.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0].trim());

            int y = Integer.parseInt(xyz[1].trim());

            int z = Integer.parseInt(xyz[2].trim());

            String result = catAndMouse(x, y, z);

            bw.write(result);
            bw.newLine();
        }

        bw.close();
    }
}
