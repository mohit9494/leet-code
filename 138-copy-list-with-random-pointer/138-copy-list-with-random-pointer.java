/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // first round: Make a copy of each node and add them in single LL
        // side-by-side
        
        Node curr = head;
        while(curr != null) {
            
           Node next = curr.next; 
           
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            
            curr = next;
            
        }
        
        // Second Round:: Deal with the random pointer for each copy node
        curr = head;
        while(curr != null) {
            
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Third Round: Restore the original and deep copy LL and 
        //return head of deep copy
        
        Node dummy = new Node(0);
        Node copy = dummy;
        
        curr = head;
        
        while(curr != null) {
         
            Node next = curr.next.next;
            
            // Deep Copy LL
            copy.next = curr.next;
            copy = copy.next;
            
            // Original
            curr.next = next;
            curr = curr.next;
        }
        
        return dummy.next;
        
        
    }
}