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
    public boolean helper(TreeNode root, int k,Set<Integer> set){
        if(root==null)
            return false;
        boolean left = helper(root.left,k,set);
        if(left)
            return true;
        if(set.contains(k-root.val)){
            return true;
        } 
        set.add(root.val);
        boolean right = helper(root.right,k,set);
        if(right)
            return true;
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root,k,set);
    }
}