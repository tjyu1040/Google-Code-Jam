package africa2010.qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * GoogleCodeJam created by Timothy on 7/3/2014.
 */
public class ReverseWords {

    public static final String INPUT_FILES_PATH = "InputFiles\\2010\\Africa\\Qualification\\ReverseWords\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\2010\\Africa\\Qualification\\ReverseWords\\";

    public ReverseWords() throws IOException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();

        Scanner file = new Scanner(new File(INPUT_FILES_PATH + filename));
        PrintWriter outputFile = new PrintWriter(OUTPUT_FILES_PATH + filename.substring(0, filename.length() - 2) + "out");

        int testCases = file.nextInt();
        file.nextLine();
        for(int testCount = 1; testCount <= testCases; testCount++){
            String line = file.nextLine();
            String[] words = line.split(" ");

            outputFile.print("Case #" + testCount + ": ");
            for(int i = words.length - 1; i > -1; i--){
                System.out.print(words[i] + " ");
                outputFile.print(words[i] + " ");
            }
            System.out.println();
            outputFile.println();
        }
        outputFile.close();
    }

    public static void main(String[] args) throws IOException {
        new ReverseWords();
    }
}
