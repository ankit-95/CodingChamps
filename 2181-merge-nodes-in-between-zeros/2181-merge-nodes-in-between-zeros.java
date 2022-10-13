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
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        
        ListNode start = head;
        ListNode next = head.next;
        int sum = 0;
        while(next!=null){
            if(next.val!=0){
                sum+=next.val;
                next = next.next;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
                start = next;
                sum = 0;
                next = next.next;
            }
        }
        
        return dummy.next;
    }
}