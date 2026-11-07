class Solution {
    public int thirdMax(int[] nums) {
        long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;

        for (int n : nums) {
            if (n == a || n == b || n == c) continue;

            if (n > a) {
                c = b;
                b = a;
                a = n;
            } else if (n > b) {
                c = b;
                b = n;
            } else if (n > c) {
                c = n;
            }
        }

        return (int)(c == Long.MIN_VALUE ? a : c);
    }
}