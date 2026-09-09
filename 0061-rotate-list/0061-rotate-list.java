/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Find the length and the tail node
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Step 2: Compute effective rotations needed
        k = k % length;
        if (k == 0) {
            return head;
        }

        // Step 3: Connect tail to head to form a circular list
        tail.next = head;

        // Step 4: Find the new tail at (length - k) steps
        int stepsToNewTail = length - k;
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // Step 5: Break the ring and establish new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}