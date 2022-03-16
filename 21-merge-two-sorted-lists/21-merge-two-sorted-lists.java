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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        //Create Dummy Node
        ListNode prehead = new ListNode(-1);
        
        ListNode temp = prehead;
        
        while(list1 != null && list2 != null) {
            
            if(list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            
            temp = temp.next;
            
        }
        
        // one has to be remaining
        temp.next = list1 == null ? list2 : list1;
        
        return prehead.next;
        // // Recursive
        // if(list1 == null) return list2;
        // if(list2 == null) return list1;        
        // if(list1.val < list2.val) {
        //     list1.next = mergeTwoLists(list1.next, list2);
        //     return list1;
        // }else {
        //     list2.next = mergeTwoLists(list1, list2.next);
        //     return list2;
        // }     
}
}