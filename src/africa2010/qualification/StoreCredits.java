package africa2010.qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Google Code Jam, StoreCredits solution created by Timothy on 7/4/2014.
 */
public class StoreCredits {

    public static final String INPUT_FILES_PATH = "InputFiles\\2010\\Africa\\Qualification\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\2010\\Africa\\Qualification\\";

    public void solve(Scanner inputFile, PrintWriter outputFile) {
        int credit = inputFile.nextInt();
        int items = inputFile.nextInt();
        int[] prices = new int[items];
        for(int i = 0; i < items; i++){
            prices[i] = inputFile.nextInt();
        }
        outerloop:
        for(int i = 0; i < prices.length; i++){
            for(int j = 1; j < prices.length; j++){
                if(prices[i] + prices[j] == credit && i != j){
                    System.out.println((i + 1) + " " + (j + 1));
                    outputFile.println((i + 1) + " " + (j + 1));
                    break outerloop;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Check input and output directories
        File inputDirectory = new File(INPUT_FILES_PATH);
        if(!inputDirectory.exists()){
            inputDirectory.mkdirs();
        }
        System.out.println(inputDirectory.getAbsolutePath());
        File outputDirectory = new File(OUTPUT_FILES_PATH);
        if(!outputDirectory.exists()){
            outputDirectory.mkdirs();
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();

        Scanner inputFile = new Scanner(new File(INPUT_FILES_PATH + filename));
        PrintWriter outputFile = new PrintWriter(OUTPUT_FILES_PATH + filename.substring(0, filename.length() - 2) + "out");

        int testCases = inputFile.nextInt();
        for (int testCount = 1; testCount <= testCases; testCount++) {
            System.out.print("Case #" + testCount + ": ");
            outputFile.print("Case #" + testCount + ": ");
            new StoreCredits().solve(inputFile, outputFile);
        }
        outputFile.flush();
        outputFile.close();
        inputFile.close();
    }
}