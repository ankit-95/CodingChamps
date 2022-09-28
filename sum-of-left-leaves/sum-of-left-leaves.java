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
    int leftSum =0;
    public int helper(TreeNode root){
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.val;
        int l = helper(root.left);    
        int r = helper(root.right);    
        if(l!=0){
            leftSum+=l;
        }
        return 0;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root);
        return leftSum;
    }
}