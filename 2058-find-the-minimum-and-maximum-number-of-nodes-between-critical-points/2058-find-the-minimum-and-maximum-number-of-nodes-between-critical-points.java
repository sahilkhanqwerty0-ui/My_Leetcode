class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;

        while (curr.next != null) {

            ListNode next = curr.next;

            // Check if current is a critical point
            boolean isCritical =
                (curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = index;
                }

                // Another critical point
                if (prevCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        index - prevCritical
                    );
                }

                prevCritical = index;
            }

            prev = curr;
            curr = next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        // Distance between first and last
        maxDistance = prevCritical - first;

        return new int[]{minDistance, maxDistance};
    }
}