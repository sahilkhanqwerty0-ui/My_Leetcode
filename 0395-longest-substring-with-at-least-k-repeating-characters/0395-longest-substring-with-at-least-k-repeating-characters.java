class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;

        for (int target = 1; target <= 26; target++) {
            int[] count = new int[26];
            int left = 0, unique = 0, valid = 0;

            for (int right = 0; right < s.length(); right++) {
                int c = s.charAt(right) - 'a';

                if (count[c]++ == 0) unique++;
                if (count[c] == k) valid++;

                while (unique > target) {
                    int x = s.charAt(left++) - 'a';

                    if (count[x] == k) valid--;
                    if (--count[x] == 0) unique--;
                }

                if (unique == target && valid == target)
                    ans = Math.max(ans, right - left + 1);
            }
        }

        return ans;
    }
}