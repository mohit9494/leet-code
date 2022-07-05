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
    public ListNode mergeKLists(ListNode[] lists) {
        
        // we are given en K linkedlist heads
        // we will arrange them in PriorityQueue Min 
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) pq.add(node);
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        
        while(!pq.isEmpty()) {
            
            // This is the smallest head
            ListNode node = pq.poll();
            // Attach
            curr.next = node;
            
            // Move forward
            curr = curr.next;
            
            if(node.next != null) pq.add(node.next);
            
        }
        
        return dummy.next;        
    }
}