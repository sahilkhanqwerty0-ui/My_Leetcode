import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n];
        int ans = 0;

        for (char[] row : matrix) {
            for (int j = 0; j < n; j++) {
                heights[j] = row[j] == '1' ? heights[j] + 1 : 0;
            }

            ans = Math.max(ans, largestRectangle(heights));
        }

        return ans;
    }

    private int largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= h.length; i++) {
            int curr = i == h.length ? 0 : h[i];

            while (!stack.isEmpty() && h[stack.peek()] > curr) {
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                ans = Math.max(ans, height * width);
            }

            stack.push(i);
        }

        return ans;
    }

    int ans = 0;
}