class Solution {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        int k = Math.min(m - 1, n - 1);
        int N = m + n - 2;

        for (int i = 1; i <= k; i++) {
            ans = ans * (N - k + i) / i;
        }

        return (int) ans;
    }
}