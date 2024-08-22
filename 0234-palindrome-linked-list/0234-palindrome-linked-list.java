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
    ListNode reverseRursice(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseRursice(head.next);
        ListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;

    }
    
    public ListNode middle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode middleNode = middle(head);
        ListNode second = reverseRursice(middleNode);
        while(second!=null){
            if(first.val!=second.val) return false;
            first = first.next;
            second = second.next;
            
        }
        return true;
    }
}