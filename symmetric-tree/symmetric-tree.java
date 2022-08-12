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
    public boolean helper(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if((root1==null && root2!=null) || (root1!=null && root2==null))
            return false;
        return root1.val== root2.val && helper(root1.left,root2.right) && helper(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root!=null && root.left==null && root.right==null)
            return true;
        if(root.left==null || root.right==null)
            return false;
        return helper(root.left, root.right);
    }
}