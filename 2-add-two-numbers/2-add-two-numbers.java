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
    
    public void add(ListNode l1,ListNode l2,ListNode tail,int carry){
       while(l1!=null || l2!=null || carry!=0){
           int x = (l1!=null) ? l1.val : 0;
           int y = (l2!=null) ? l2.val : 0;
           int val = x + y + carry;
           carry = val/10;
           tail.next = new ListNode(val%10);
           if(l1!=null) l1 = l1.next;
           if(l2!=null) l2 = l2.next;
           tail = tail.next;
       }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        add(l1,l2,tail,0);
        return dummy.next;
    }
}