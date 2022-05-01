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
        
        // edge case
        if(head == null || head.next == null || k == 0) return head;
        
        // cal length of LL
        int len = 1;
        ListNode curr = head;
        
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        // connect with head
        curr.next = head;
        
        // update k
        k = k % len;
        k = len - k;
        
        while(k > 0) {
            curr = curr.next;
            k--;
        }
        
        // move head and break circular LL       
        head = curr.next;
        curr.next = null;
        
        return head;
        
    }
}