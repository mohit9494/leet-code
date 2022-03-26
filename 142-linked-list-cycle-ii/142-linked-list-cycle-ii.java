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
    public ListNode detectCycle(ListNode head) {
        
        if(head == null || head.next == null) return null;
        
        ListNode fast= head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            
           fast = fast.next.next; 
           slow = slow.next;
           
           if (fast == slow) {
               
               // detected
               fast = head;
               
               while (slow != fast) {
                   
                   slow = slow.next;
                   fast = fast.next;
                   
               }
               
               return slow;
               
           }
            
        }
        
        return null;
        
//         // Using sets
//         Set<ListNode> s = new HashSet(); 
        
//         while(head!= null) {
          
//         if (s.contains(head)) {
//             // cycle is detected
//             return head;
//         } else {
//             s.add(head);
//         }
//             head = head.next;
//         }
        
        
        
//         return null;
        
    }
}