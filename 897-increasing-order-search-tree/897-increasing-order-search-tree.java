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
    
    TreeNode result;
    TreeNode prev;
    public void helper(TreeNode root){
        if(root==null)
            return;
        helper(root.left);
        if(result==null){
            result=root;
        } else {
            prev.right = root;
        }
        prev=root;
        root.left=null;
        helper(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        helper(root);
        return result;
    }
}