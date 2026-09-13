import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {

        int n = img1.length;

        List<int[]> a = new ArrayList<>();
        List<int[]> b = new ArrayList<>();

        // Store positions of 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {

                if (img1[r][c] == 1)
                    a.add(new int[]{r, c});

                if (img2[r][c] == 1)
                    b.add(new int[]{r, c});
            }
        }

        Map<String, Integer> map = new HashMap<>();
        int answer = 0;

        for (int[] x : a) {
            for (int[] y : b) {

                int dr = x[0] - y[0];
                int dc = x[1] - y[1];

                String key = dr + "," + dc;

                int count = map.getOrDefault(key, 0) + 1;

                map.put(key, count);

                answer = Math.max(answer, count);
            }
        }

        return answer;
    }
}