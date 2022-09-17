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
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddTemp = odd;
        ListNode even = new ListNode(0);
        ListNode evenTemp = even;
        boolean flag = false;
        while(head!=null){
            if(flag){
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            }
            else {
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            }
            head = head.next;
            flag = !flag;
        }
        oddTemp.next = null;
        evenTemp.next = odd.next;
        return even.next;
    }
}