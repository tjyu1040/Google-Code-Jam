package codejam2013.qualification;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Google Code Jam, TicTacTomek solution created by Timothy on 7/4/2014.
 */
public class TicTacTomek {

    public static final String INPUT_FILES_PATH = "InputFiles\\2013\\Qualification\\";
    public static final String OUTPUT_FILES_PATH = "OutputFiles\\2013\\Qualification\\";

    public static final String X_WIN_MESSAGE = "X won";
    public static final String O_WIN_MESSAGE = "O won";
    public static final String DRAW_MESSAGE = "Draw";
    public static final String NOT_COMPLETED_MESSAGE = "Game has not completed";

    public void solve(Scanner inputFile, PrintWriter outputFile) {
        String[] board = new String[4];
        for (int i = 0; i < 4; i++) {
            board[i] = inputFile.nextLine();
        }
        String result = checkBoard(board);
        System.out.println(result);
        outputFile.println(result);
        if (inputFile.hasNext()) {
            inputFile.nextLine();   // Consume empty line
        }
    }

    /**
     * Check the board's results.
     *
     * @param board 4 x 4 square board
     * @return Result message
     */
    public String checkBoard(String[] board) {
        int dotCount = 0;               // Hold the count of dots

        int[] xRowCount = new int[4];   // Hold the count of X's in each row
        int[] xColCount = new int[4];   // Hold the count of X's in each column
        int[] xDiaCount = new int[2];   // Hold the count of X's in each diagonal

        int[] oRowCount = new int[4];   // Hold the count of O's in each row
        int[] oColCount = new int[4];   // Hold the count of O's in each column
        int[] oDiaCount = new int[2];   // Hold the count of O's in each diagonal

        for (int rowCount = 0; rowCount < board.length; rowCount++) {
            String row = board[rowCount];

            for (int colCount = 0; colCount < row.length(); colCount++) {
                char square = row.charAt(colCount);

                if (square == 'X' || square == 'T') {
                    xRowCount[rowCount]++;     // Increase count of X's in this row
                    xColCount[colCount]++;     // Increase count of X's in this column
                    if (isInDiagonalPosition(rowCount, colCount)) {
                        if ((rowCount == 0 && colCount == 0)
                                || (rowCount == 1 && colCount == 1)
                                || (rowCount == 2 && colCount == 2)
                                || (rowCount == 3 && colCount == 3)) {
                            xDiaCount[0]++;     // Increase count of X's in this diagonal from upper left to lower right
                        } else {
                            xDiaCount[1]++;     // Increase count of X's in this diagonal from lower left to upper right
                        }
                    }
                }

                if (square == 'O' || square == 'T') {
                    oRowCount[rowCount]++;     // Increase count of O's in this row
                    oColCount[colCount]++;     // Increase count of O's in this column
                    if (isInDiagonalPosition(rowCount, colCount)) {
                        if ((rowCount == 0 && colCount == 0)
                                || (rowCount == 1 && colCount == 1)
                                || (rowCount == 2 && colCount == 2)
                                || (rowCount == 3 && colCount == 3)) {
                            oDiaCount[0]++;     // Increase count of O's in this diagonal from upper left to lower right
                        } else {
                            oDiaCount[1]++;     // Increase count of O's in this diagonal from lower left to upper right
                        }
                    }
                }

                if (square == '.') {
                    dotCount++;     // Increase count of dots in board
                }
            }
        }

        boolean xWin = checkResults(xRowCount) || checkResults(xColCount) || checkResults(xDiaCount);
        boolean oWin = checkResults(oRowCount) || checkResults(oColCount) || checkResults(oDiaCount);

        if (xWin) {
            return X_WIN_MESSAGE;
        } else if (oWin) {
            return O_WIN_MESSAGE;
        } else if (dotCount == 0) {
            return DRAW_MESSAGE;
        } else {
            return NOT_COMPLETED_MESSAGE;
        }
    }

    /**
     * Check if indices are in a diagonal position.
     * D..D
     * .DD.
     * D..D
     *
     * @param i Index of row
     * @param j Index of column
     * @return True if given indices are in a diagonal position, False otherwise
     */
    public boolean isInDiagonalPosition(int i, int j) {
        boolean row1 = (i == 0 && j == 0) || (i == 0 && j == 3);    // D..D
        boolean row2 = (i == 1 && j == 1) || (i == 1 && j == 2);    // .DD.
        boolean row3 = (i == 2 && j == 1) || (i == 2 && j == 2);    // .DD.
        boolean row4 = (i == 3 && j == 0) || (i == 3 && j == 3);    // D..D
        return row1 || row2 || row3 || row4;
    }

    /**
     * Check if any count is equal to 4, as it means a win.
     *
     * @param countArray Array holding counts of characters
     * @return True if any count is equal to 4, False otherwise.
     */
    public boolean checkResults(int[] countArray) {
        for (int count : countArray) {
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        // Check input and output directories
        File inputDirectory = new File(INPUT_FILES_PATH);
        if (!inputDirectory.exists()) {
            if(!inputDirectory.mkdirs()){
                System.out.println("Failed to create input directory.");
            }
        }
        System.out.println(inputDirectory.getAbsolutePath());
        File outputDirectory = new File(OUTPUT_FILES_PATH);
        if (!outputDirectory.exists()) {
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
            new TicTacTomek().solve(inputFile, outputFile);
        }
        outputFile.flush();
        outputFile.close();
        inputFile.close();
    }
}