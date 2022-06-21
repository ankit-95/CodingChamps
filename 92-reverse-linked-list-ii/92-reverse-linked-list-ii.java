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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null)
            return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode prev = dummy;
        int k = 0;
        while(++k<left){
            if(cur!=null){
                prev = prev.next;
                cur = cur.next;
            }
        }
        ListNode node = prev;
        while(k++<= right){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        node.next.next = cur;
        node.next = prev;
        return dummy.next;
    }
}

