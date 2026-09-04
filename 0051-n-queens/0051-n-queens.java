import java.util.*;

class Solution {
    private List<List<String>> result = new ArrayList<>();
    private boolean[] cols;
    private boolean[] diag1; // row - col + n - 1
    private boolean[] diag2; // row + col

    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backtrack(0, n, board);
        return result;
    }

    private void backtrack(int row, int n, char[][] board) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue; // Queen can attack here
            }

            // Place Queen
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;

            backtrack(row + 1, n, board);

            // Backtrack / Remove Queen
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }
}