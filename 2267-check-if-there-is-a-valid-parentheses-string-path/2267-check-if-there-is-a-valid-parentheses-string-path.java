class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(')
            return false;

        if ((m + n - 1) % 2 == 1)
            return false;

        boolean[][][] dp = new boolean[m][n][m + n];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0)
                    continue;

                for (int bal = 0; bal < m + n; bal++) {

                    if (grid[i][j] == '(') {
                        if (i > 0 && bal > 0)
                            dp[i][j][bal] |= dp[i - 1][j][bal - 1];

                        if (j > 0 && bal > 0)
                            dp[i][j][bal] |= dp[i][j - 1][bal - 1];

                    } else {
                        if (i > 0 && bal + 1 < m + n)
                            dp[i][j][bal] |= dp[i - 1][j][bal + 1];

                        if (j > 0 && bal + 1 < m + n)
                            dp[i][j][bal] |= dp[i][j - 1][bal + 1];
                    }
                }
            }
        }

        return dp[m - 1][n - 1][0];
    }
}