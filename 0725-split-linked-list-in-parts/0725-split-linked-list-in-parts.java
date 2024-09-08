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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int currentSize = len / k;
        int firstParts = len % k;
        ListNode ans[] = new ListNode[k];
        temp = head;
        for(int i=0;i<k;i++){
            ListNode newPart = new ListNode(0);
            ListNode tail = newPart;
            
            int size = currentSize;
            if(firstParts>0){
                firstParts--;
                size++;
            }
            int j =0;
            while(j<size){
                tail.next = new ListNode(temp.val);
                tail = tail.next;
                j++;
                temp = temp.next;
            }
            ans[i] = newPart.next;
        }
        return ans;
    }
}