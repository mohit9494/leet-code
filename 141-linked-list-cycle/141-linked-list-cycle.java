/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        boolean hasCycle = false;
        
        if(head == null || head.next == null) return hasCycle;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                hasCycle = true;
                break;
            }
        }
        
        return hasCycle;
        
    }
}