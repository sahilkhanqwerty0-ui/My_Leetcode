class Solution {
    public int myAtoi(String s) {

        int i = 0;
        int n = s.length();

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ')
            i++;

        // Sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        int result = 0;

        while (i < n && Character.isDigit(s.charAt(i))) {

            int digit = s.charAt(i) - '0';

            // Overflow check
            if (result > (Integer.MAX_VALUE - digit) / 10)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = result * 10 + digit;
            i++;
        }

        return result * sign;
    }
}