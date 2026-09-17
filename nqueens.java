import java.util.*;

public class NQueens {

    static boolean isSafe(char[][] board, int row, int col, int n) {

        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    static void solve(char[][] board, int row, int n) {

        // All queens placed
        if (row == n) {
            printBoard(board);
            return;
        }

        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                solve(board, row + 1, n);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    static void printBoard(char[][] board) {
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 4;

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(board, 0, n);
    }
}