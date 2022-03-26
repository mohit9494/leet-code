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
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            
            fast = fast.next.next;
            slow = slow.next;
            
            if( fast == slow) {
                hasCycle = true;
                break;
            }
            
        }
        
        return hasCycle;
        
        
//         Set<ListNode> s = new HashSet();
        
//         boolean hasCycle = false;
        
//         while(head != null) {
            
//             if(s.contains(head)) {
//                 hasCycle = true;
//                 break;
//             } else {
//                 s.add(head); 
//             } 
            
//             head = head.next;
//         }
            
//         return hasCycle;
        
//     }
}}