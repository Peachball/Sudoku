/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudokusolver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author s-xuch
 */
public class SudokuSolver {

    /**
     * @param args the command line arguments
     */
    static int[][] board = new int[9][9];

    public static void main(String[] args) {
        int[][] board = new int[9][9];
        System.out.println("Input the sudoku grid from left to right,");
        System.out.println("or put input the name of the text file in ");
        System.out.println("which your sudoku board is in");
        System.out.println("Make sure to seperate numbers with spaces!");
        Scanner in = new Scanner(System.in);
        if (in.hasNextInt()) {
            for (int x = 0; x < board.length * board[0].length; x++) {
                int buffer = (int) Math.floor(x / 3);
                board[(int) Math.floor((x / 3))][x % 9] = in.nextInt();
            }
        } else {
            String filename = in.nextLine();

            try {
                Scanner filereader = new Scanner(new FileInputStream(filename));
                for (int x = 0; x < board.length * board[0].length; x++) {
                    int buffer = (int) Math.floor(x / 3);
                    board[(int) Math.floor((x / 3))][x % 9] = filereader.nextInt();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        check();

        // TODO code application logic here
        //print answer
        System.out.println("answer");
    }

    public static void check() {
        for (int x = 0; x < board.length; x++) {
            lineChecker(true, x);
        }
        for (int x = 0; x < board[0].length; x++) {
            lineChecker(false, x);
        }
        for (int x = 0; x < board.length * board[0].length / 9; x++) {
            boxChecker(x);
        }
    }

    public static int lineChecker(boolean row, int num) {
        int emptyspaces = 0;
        int lastnum;
        if (row) {
            int buffer[] = new int[board[0].length];
            for (int x = 0; x < board[0].length; x++) {
                buffer[x] = board[num][x];
                if (buffer[x] == 0) {
                    emptyspaces++;
                }
            }
        } else {
            int buffer[] = new int[board[0].length];
            for (int x = 0; x < board.length; x++) {
                buffer[x] = board[x][num];
                if (buffer[x] == 0) {
                    emptyspaces++;
                }
            }
        }lastnum = 0;
        if (emptyspaces == 8 && row) {
            
            for (int x = 0; x < board.length; x++) {
                lastnum += board[num][x];
            }
            return 36-lastnum;
        } else {
            for (int x = 0; x < board.length; x++) {
                lastnum += board[x][num];
            }
            return 36-lastnum;
        }
    }

    public static void boxChecker(int boxnum) {
        int lastnum = 0;
        int emptyspaces =0;
        for(int x = 0;x<9;x++){
            
        }
    }

    public static void bestGuess() {

    }
}
