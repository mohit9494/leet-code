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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        // Create dummy and connect to head;1 -> 2 -> 3 -> 4 -> 5
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // first part
        ListNode prev1 = null;
        ListNode curr1 = dummy;
        
        for(int i = 0; i < left; i++) {
            prev1 = curr1;
            curr1 = curr1.next;
        }
        
        // Reverse
        ListNode curr2 = curr1;
        ListNode prev2 = prev1;
        
        for(int i = left; i <= right; i++) {
            
            ListNode next = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = next;
            
        }
        
        // connect
        prev1.next = prev2;
        curr1.next = curr2;
        
        //return
        return dummy.next;
        
    }
}