import java.util.*;

class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {

            for (int c = 0; c < 9; c++) {

                char num = board[r][c];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Find which 3x3 box
                int box = (r / 3) * 3 + (c / 3);

                // Duplicate in row
                if (!rows[r].add(num)) {
                    return false;
                }

                // Duplicate in column
                if (!cols[c].add(num)) {
                    return false;
                }

                // Duplicate in box
                if (!boxes[box].add(num)) {
                    return false;
                }
            }
        }

        return true;
    }
}