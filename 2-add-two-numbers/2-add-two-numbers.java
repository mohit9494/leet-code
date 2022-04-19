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
        int digit = 0;
        int sum = 0;
        
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
      while (l1 != null || l2 != null) {
          
          if(l1 != null) {
              sum += l1.val;
              l1 = l1.next;
          }
          
          if(l2 != null) {
              sum += l2.val;
              l2 = l2.next;
          }
          
          sum += carry;
          
          carry = 0;
          
          if(sum >= 10) {
              carry = sum/10;
              digit = sum % 10;
          } else {
              digit = sum;
          }
          
          sum = 0;
          // crete new node
          ListNode nn = new ListNode(digit);
          temp.next = nn;
          temp = temp.next;
      }
        
        if(carry > 0)  temp.next = new ListNode(carry);
        return dummy.next;
        
    }
}