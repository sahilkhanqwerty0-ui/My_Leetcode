class Solution {
    public int maxLength(int[] nums) {
        int ans = 0, n = nums.length;

        for (int i = 0; i < n; i++) {
            int p = 1, g = 0, l = 1;

            for (int j = i; j < n; j++) {
                int x = nums[j];
                p *= x;
                g = gcd(g, x);
                l = l / gcd(l, x) * x;

                if (p == g * l) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}