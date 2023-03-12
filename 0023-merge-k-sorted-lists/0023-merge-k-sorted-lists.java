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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                q.add(lists[i]);
        }
        ListNode tail = dummy;
        while(!q.isEmpty()){
            ListNode curr = q.remove();
            tail.next = curr;
            curr = curr.next;
            tail = tail.next;
            if(curr!=null){
                q.add(curr);
            }
        }
        return dummy.next;
    }
}