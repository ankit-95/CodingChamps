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
    public ListNode insertionSortList(ListNode head) {
        
        ListNode cur = head;
        ListNode next = null;
        ListNode helper = new ListNode(0);
        ListNode prev = helper;
        while(cur!=null){
            next = cur.next;
            while(prev.next!=null && prev.next.val < cur.val){
                prev = prev.next;
            }
            cur.next = prev.next;
            prev.next = cur;
            cur = next; 
            prev = helper;
        }
        return helper.next;
    }
}