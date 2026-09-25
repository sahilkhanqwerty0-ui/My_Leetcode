import java.util.*;

class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = solve(expression);
        List<String> ans = new ArrayList<>(set);
        Collections.sort(ans);
        return ans;
    }

    private Set<String> solve(String s) {
        Set<String> result = new HashSet<>();

        // Find top-level comma
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') level++;
            else if (c == '}') level--;
            else if (c == ',' && level == 0) {
                result.addAll(solve(s.substring(0, i)));
                result.addAll(solve(s.substring(i + 1)));
                return result;
            }
        }

        // Find top-level concatenation
        level = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '{') level++;
            else if (c == '}') level--;

            // Split between two expressions
            if (level == 0 && i + 1 < s.length()) {
                Set<String> left = solve(s.substring(0, i + 1));
                Set<String> right = solve(s.substring(i + 1));

                for (String a : left) {
                    for (String b : right) {
                        result.add(a + b);
                    }
                }

                return result;
            }
        }

        // Remove outer braces
        if (s.length() >= 2 && s.charAt(0) == '{'
                && s.charAt(s.length() - 1) == '}') {
            return solve(s.substring(1, s.length() - 1));
        }

        // Single character
        result.add(s);
        return result;
    }
}