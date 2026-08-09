class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {

        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // Suffix sum
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(0, 1);
    }

    private int solve(int i, int M) {

        if (i >= suffix.length - 1)
            return 0;

        if (dp[i][M] != 0)
            return dp[i][M];

        int best = 0;

        int n = suffix.length - 1;

        for (int x = 1; x <= 2 * M && i + x <= n; x++) {

            int opponent = solve(
                i + x,
                Math.max(M, x)
            );

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        return dp[i][M] = best;
    }
}