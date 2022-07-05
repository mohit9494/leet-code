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
    
    private ListNode merge(ListNode h1, ListNode h2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while (h1 != null && h2 != null) {
            
            if (h1.val < h2.val) {
                curr.next = h1;
                h1 = h1.next;
            } else {
                curr.next = h2;
                h2 = h2.next;
            }
            
            curr = curr.next;
        }
        
        // either h1 or h2 is null
        if(h1 == null) {
            curr.next = h2;
        } else {
            curr.next = h1;
        }
        
        return dummy.next;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        
        // Merge the 2 lists and go till the end 
        // Merge in Pairs
        
        for(ListNode head : lists) {
            
            curr = merge(head, curr);
            
        }
        
        return dummy.next;
    }
}