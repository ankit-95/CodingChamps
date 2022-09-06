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
    
    public boolean helper(TreeNode root){
        if(root==null){
            return false;
        }
        boolean l = helper(root.left);
        boolean r = helper(root.right);
        
        if(!l){
            root.left = null;
        }
        if(!r){
            root.right = null;
        }
        return root.val==1 || l || r;
    }
    public TreeNode pruneTree(TreeNode root) {
        return helper(root) ? root : null;
    }
}