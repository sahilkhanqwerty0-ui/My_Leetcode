import java.util.*;
//import java.util.ArrayList;
//import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // 1. Sort intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // 2. Iterate through intervals and merge overlapping ones
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (nextStart <= currentEnd) {
                // Overlap detected: extend the end of current interval if needed
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // No overlap: add the new interval to the list
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}