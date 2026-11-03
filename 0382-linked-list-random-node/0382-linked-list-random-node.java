class Solution {
    ListNode head;
    Random rand = new Random();

    public Solution(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        ListNode curr = head;
        int ans = 0, count = 0;

        while (curr != null) {
            count++;

            if (rand.nextInt(count) == 0)
                ans = curr.val;

            curr = curr.next;
        }

        return ans;
    }
}