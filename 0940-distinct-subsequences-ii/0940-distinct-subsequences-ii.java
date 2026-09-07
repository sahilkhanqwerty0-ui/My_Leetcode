class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        // last[i] stores the number of distinct subsequences ending with character ('a' + i)
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long currentSum = 0;
            for (int i = 0; i < 26; i++) {
                currentSum = (currentSum + last[i]) % MOD;
            }
            // +1 accounts for the single-character subsequence formed by 'c' itself
            last[idx] = (currentSum + 1) % MOD;
        }

        long result = 0;
        for (int i = 0; i < 26; i++) {
            result = (result + last[i]) % MOD;
        }

        return (int) result;
    }
}