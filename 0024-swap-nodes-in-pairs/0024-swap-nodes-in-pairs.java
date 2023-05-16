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
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return head;
        if(head!=null && head.next==null)
            return head;
        ListNode prev = head;
        ListNode nextNode = head.next;
        ListNode temp = null;
        ListNode newHead = head.next;
        while(nextNode!=null){
           prev.next = nextNode.next;
           nextNode.next = prev;
           if(temp!=null) 
            temp.next = nextNode; 
           temp = prev;
           prev = prev.next; 
           nextNode = (prev!=null) ? prev.next : null;
        }
        return newHead;
    }
}