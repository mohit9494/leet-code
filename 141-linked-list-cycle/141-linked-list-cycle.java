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
        
        Set<ListNode> s = new HashSet();
        
        boolean hasCycle = false;
        
        while(head != null) {
            
            if(s.contains(head)) {
                hasCycle = true;
                break;
            } else {
                s.add(head); 
            } 
            
            head = head.next;
        }
            
        return hasCycle;
        
    }
}