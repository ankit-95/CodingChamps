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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ListNode middle(ListNode head,ListNode tail){
        ListNode slow = head;
        ListNode fast = head;       
        while(fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public TreeNode helper(ListNode head,ListNode tail){
        if(head==null || head==tail)
            return null;
        if(head.next==tail)
            return new TreeNode(head.val);
        ListNode middleNode = middle(head,tail);
        TreeNode root = new TreeNode(middleNode.val);
        root.left = helper(head,middleNode);
        root.right = helper(middleNode.next, tail);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head,null);
    }
}