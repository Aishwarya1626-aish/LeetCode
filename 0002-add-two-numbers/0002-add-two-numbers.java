/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * Adds the two numbers represented by linked lists l1 and l2.
     * The digits are stored in reverse order.
     *
     * @param l1 The first linked list representing a non-negative integer.
     * @param l2 The second linked list representing a non-negative integer.
     * @return A new linked list representing the sum of the two numbers.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy head node for the result list. This simplifies handling the head.
        ListNode dummyHead = new ListNode(0);
        // 'current' will be used to build the new list. It starts at the dummy head.
        ListNode current = dummyHead;
        // 'carry' will store the carry-over to the next digit/node.
        int carry = 0;

        // Loop continues as long as there are digits in either list or a carry remains.
        while (l1 != null || l2 != null || carry != 0) {
            // Get the value of the current digit from l1, or 0 if l1 is exhausted.
            int x = (l1 != null) ? l1.val : 0;
            // Get the value of the current digit from l2, or 0 if l2 is exhausted.
            int y = (l2 != null) ? l2.val : 0;

            // Calculate the sum of the digits plus the carry-over from the previous step.
            int sum = x + y + carry;

            // The new carry is the quotient when sum is divided by 10 (e.g., 15 / 10 = 1).
            carry = sum / 10;
            
            // The digit for the new node is the remainder when sum is divided by 10 (e.g., 15 % 10 = 5).
            int digit = sum % 10;

            // Create a new node with the calculated digit and append it to the result list.
            current.next = new ListNode(digit);
            
            // Move the 'current' pointer forward to the newly created node.
            current = current.next;

            // Move the input list pointers forward if they are not null.
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // The result is the next node after the dummy head.
        // The dummy head itself was just a placeholder.
        return dummyHead.next;
    }
}