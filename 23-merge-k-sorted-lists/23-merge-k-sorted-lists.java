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
    
    private ListNode divideAndConcur(ListNode[] lists, int lo, int hi){
        
        if (hi < lo) return null;
        
        // only one list
        if (lo == hi) return lists[lo];
        
        int mid = lo + (hi - lo)/2;
        
        ListNode left = divideAndConcur(lists, lo, mid);
        ListNode right = divideAndConcur(lists, mid + 1, hi);
        
        // we have left and right merged
        // Just merge  them and return new head;
        return merge(left, right);
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists == null || lists.length == 0) return null;
       
        return divideAndConcur(lists, 0, lists.length - 1);
    }
}