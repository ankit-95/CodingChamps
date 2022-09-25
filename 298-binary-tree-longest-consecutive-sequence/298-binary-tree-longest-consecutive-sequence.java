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
    int maxLength = 0;
    public void helper(TreeNode root,int length,TreeNode parent){
        if(root==null)
            return;
        
        length = (parent!=null && parent.val+1==root.val) ? length+1:1;
        maxLength = Math.max(length,maxLength);
        
        helper(root.left,length,root);
        helper(root.right,length,root);
    }
    public int longestConsecutive(TreeNode root) {
        helper(root,0,null);
        return maxLength;
    }
}