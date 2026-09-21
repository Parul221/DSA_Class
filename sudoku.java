class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] b) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (b[i][j] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (valid(b, i, j, ch)) {
                            b[i][j] = ch;

                            if (solve(b))
                                return true;

                            b[i][j] = '.';
                        }
                    }

                    return false;
                }
            }
        }
        return true;
    }

    boolean valid(char[][] b, int r, int c, char ch) {

        for (int i = 0; i < 9; i++) {
            if (b[r][i] == ch) return false;
            if (b[i][c] == ch) return false;

            int row = 3 * (r / 3) + i / 3;
            int col = 3 * (c / 3) + i % 3;

            if (b[row][col] == ch) return false;
        }

        return true;
    }
}