import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Google Code Jam, Template solution created by Timothy on 7/4/2014.
 */
public class Template {

    public static final String INPUT_FILES_PATH = "InputFiles\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\";

    public void solve(Scanner inputFile, PrintWriter outputFile) {
        // Your solution here...
    }

    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();

        Scanner inputFile = new Scanner(new File(INPUT_FILES_PATH + filename));
        PrintWriter outputFile = new PrintWriter(OUTPUT_FILES_PATH + filename.substring(0, filename.length() - 2) + "out");

        int testCases = inputFile.nextInt();
        for (int testCount = 1; testCount <= testCases; testCount++) {
            System.out.print("Case #" + testCount + ": ");
            outputFile.print("Case #" + testCount + ": ");
            new Template().solve(inputFile, outputFile);
        }
        outputFile.flush();
        outputFile.close();
        inputFile.close();
    }
}