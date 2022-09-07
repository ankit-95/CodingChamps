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
    public String helper(TreeNode root){
        if(root==null){
            return "";
        }
        if(root.left==null && root.right==null){
            return root.val+"";
        }
        if(root.right==null){
            return root.val+"("+helper(root.left)+")";
        }
        return root.val+"("+helper(root.left)+")("+helper(root.right)+")";
    }
    public String tree2str(TreeNode root) {
       return helper(root);
       
     
    }
}