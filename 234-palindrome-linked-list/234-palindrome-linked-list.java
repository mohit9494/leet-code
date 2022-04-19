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
    
    public ListNode reverseList(ListNode head) {
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
            
        }
        
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        
        // Find the middle of LinkedList - If even find the first middle
        // Reverse the other half
        // Check each node
        if(head == null || head.next == null) return true;
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        slow.next = reverseList(slow.next);
        
        // Move to the End and Start
        slow = slow.next;
        fast = head;
        
        // Checking Each Node 
        while (slow != null) {
            if(slow.val != fast.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        
        return true;
    }
}