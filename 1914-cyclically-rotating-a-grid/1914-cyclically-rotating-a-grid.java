class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            int top = layer, left = layer;
            int bottom = m - 1 - layer, right = n - 1 - layer;

            int len = 2 * (bottom - top + right - left);
            int rot = k % len;

            while (rot-- > 0) {
                int temp = grid[top][left];

                // top row
                for (int j = left; j < right; j++)
                    grid[top][j] = grid[top][j + 1];

                // right column
                for (int i = top; i < bottom; i++)
                    grid[i][right] = grid[i + 1][right];

                // bottom row
                for (int j = right; j > left; j--)
                    grid[bottom][j] = grid[bottom][j - 1];

                // left column
                for (int i = bottom; i > top + 1; i--)
                    grid[i][left] = grid[i - 1][left];

                grid[top + 1][left] = temp;
            }
        }

        return grid;
    }
}