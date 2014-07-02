package codejam2013.qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * GoogleCodeJam created by Timothy on 7/2/2014.
 */
public class Lawnmower {

    public static final String INPUT_FILES_PATH = "InputFiles\\2013\\Qualification\\Lawnmower\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\2013\\Qualification\\Lawnmower\\";

    public int[][] lawnPattern;

    public Lawnmower() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();

        Scanner file = new Scanner(new File(INPUT_FILES_PATH + filename));
        PrintWriter outputFile = new PrintWriter(OUTPUT_FILES_PATH + filename.substring(0, filename.length() - 2) + "out");

        int testCases = file.nextInt();
        for(int testCount = 1; testCount <= testCases; testCount++){
            int n = file.nextInt();
            int m = file.nextInt();

            lawnPattern = new int[n][m];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    lawnPattern[i][j] = file.nextInt();
                }
            }

            System.out.print("Case #" + testCount + ": ");
            outputFile.print("Case #" + testCount + ": ");

            if(cutLawn(lawnPattern, n, m)){
                System.out.println("YES");
                outputFile.println("YES");
            } else {
                System.out.println("NO");
                outputFile.println("NO");
            }
        }
        outputFile.close();
    }

    /**
     * Check if lawn pattern can be achieved.
     * @param lawnPattern 2D array to check against
     * @param n Number of rows
     * @param m Number of columns
     * @return True if lawn pattern can be achieved, False otherwise.
     */
    public boolean cutLawn(int[][] lawnPattern, int n, int m){

        int[] rowMaxHeights = new int[n];
        int[] columnMaxHeights = new int[m];

        // Find and store the max heights of each row
        for(int row = 0; row < n; row++){
            rowMaxHeights[row] = getMax(lawnPattern[row]);
        }

        // Find and store the max heights of each column
        for (int col = 0; col < m; col++){
            int[] column = getColumn(lawnPattern, col);
            columnMaxHeights[col] = getMax(column);
        }

        // Compare the max heights with the lawnPattern's heights
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                int height = lawnPattern[i][j];
                if(height != rowMaxHeights[i] && height != columnMaxHeights[j]){
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Generate a column array from a specified column of a 2D array.
     * @param array 2D array
     * @param columnIndex Column index of 2D array
     * @return Column array of original 2D array
     */
    public int[] getColumn(int[][] array, int columnIndex){
        int[] column = new int[array.length];
        for(int row = 0; row < array.length; row++){
            column[row] = array[row][columnIndex];
        }
        return column;
    }

    /**
     * Get the maximum value in an array.
     * @param array Array to search through.
     * @return Maximum value in the array.
     */
    public int getMax(int[] array){
        int max = array[0];
        for (int value : array) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        new Lawnmower();
    }
}
