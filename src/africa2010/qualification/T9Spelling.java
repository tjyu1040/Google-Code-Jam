package africa2010.qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Google Code Jam, T9Spelling solution created by Timothy on 7/4/2014.
 */
public class T9Spelling {

    public static final String INPUT_FILES_PATH = "InputFiles\\2010\\Africa\\Qualification\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\2010\\Africa\\Qualification\\";

    static HashMap<Character, String> keypad = new HashMap<Character, String>();

    /**
     * Build a mapping of a phone's keypad.
     * TODO: The code looks really messy, but it works perfectly so I may come back to it later to clean it up.
     */
    static void buildKeypadMap(){
        keypad.put(' ', "0");

        String presses = "";
        int count = 0;
        int pressedDigit = 2;
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++){
            for(int i = 0; i < ((count % 3) + 1); i++){
                presses += pressedDigit;
            }
            if(alphabet == 's' || alphabet == 'z'){
                presses += pressedDigit;
            }
            keypad.put(alphabet, presses);
            presses = "";
            count++;
            if(count % 3 == 0){
                pressedDigit++;
            }
            if(alphabet == 'r' || alphabet == 'y'){
                pressedDigit--;
                count--;
            }
        }
    }

    public void solve(Scanner inputFile, PrintWriter outputFile) {
        String message = inputFile.nextLine();

        String keyPresses = "";
        char prev = '.';
        for(int i = 0; i < message.length(); i++){
            String press = keypad.get(message.charAt(i));
            char next = press.charAt(0);
            if(prev == next){
                keyPresses += " ";
            }
            prev = press.charAt(0);
            keyPresses += press;
        }
        System.out.println(keyPresses);
        outputFile.println(keyPresses);
    }

    public static void main(String[] args) throws IOException {
        buildKeypadMap();

        // Check input and output directories
        File inputDirectory = new File(INPUT_FILES_PATH);
        if(!inputDirectory.exists()){
            if(!inputDirectory.mkdirs()){
                System.out.println("Failed to create input directory.");
            }
        }
        System.out.println(inputDirectory.getAbsolutePath());
        File outputDirectory = new File(OUTPUT_FILES_PATH);
        if(!outputDirectory.exists()){
            if(!outputDirectory.mkdirs()){
                System.out.println("Failed to create output directory.");
            }
        }

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String filename = keyboard.nextLine();

        Scanner inputFile = new Scanner(new File(INPUT_FILES_PATH + filename));
        PrintWriter outputFile = new PrintWriter(OUTPUT_FILES_PATH + filename.substring(0, filename.length() - 2) + "out");

        int testCases = inputFile.nextInt();
        inputFile.nextLine();   // Consume leftover newline
        for (int testCount = 1; testCount <= testCases; testCount++) {
            System.out.print("Case #" + testCount + ": ");
            // System.out.println();
            outputFile.print("Case #" + testCount + ": ");
            new T9Spelling().solve(inputFile, outputFile);
        }
        outputFile.flush();
        outputFile.close();
        inputFile.close();
    }
}