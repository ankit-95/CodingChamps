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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)
            return null;
        if(l1==null && l2!=null)
            return l2;
        if(l1!=null && l2==null)
            return l1;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1==null)?l2:l1;
        return dummy.next;
    }
}