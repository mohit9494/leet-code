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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
      int carry = 0;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
      while (l1 != null || l2 != null) {
          
          int sum = 0;
          
          if(l1 != null) {
              sum += l1.val;
              l1 = l1.next;
          }
          
          if(l2 != null) {
              sum += l2.val;
              l2 = l2.next;
          }
          
          sum += carry;
          
          carry = sum/10;
          // crete new node
          ListNode nn = new ListNode(sum % 10);
          temp.next = nn;
          temp = temp.next;
      }
        
        // Edge Case
        if(carry > 0)  temp.next = new ListNode(carry);
        
        return dummy.next;
        
    }
}