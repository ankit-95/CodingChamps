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
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode current = head;
        ListNode prev= null;
        ListNode next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public void display(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
    public void reorderList(ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode first = head;
        ListNode second = reverse(middle.next);
        middle.next = null;
        
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        int count=0;
        
        // display(first);
        // System.out.print("\n");
        // display(second);
        while(first!=null && second!=null){
            if(count%2==0){
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
            count++;
        }
        temp.next = first!=null ? first : second;
        head = dummy.next;
    }
}