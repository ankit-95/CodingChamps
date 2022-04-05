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
    
    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        while(fast!=null && fast.next!=null){
            prev= slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return prev;
    }
    
    public ListNode reverseLL(ListNode head){
        ListNode current = head;
        ListNode prev = null;
        ListNode next = current;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode secondHalf =  middle.next;
        secondHalf = reverseLL(secondHalf);
        middle.next = null;
        int max = 0;
        while(head!=null && secondHalf!=null){
            max = Math.max(max, head.val + secondHalf.val);
            head = head.next;
            secondHalf = secondHalf.next;
        }
        return max;
    }
}