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
    
    public int helper(TreeNode curr,TreeNode parent,TreeNode gp){
        int sum=0;
        if(curr==null)
            return 0;
        if(gp!=null && gp.val%2==0){
            sum+=curr.val;
        }
        sum+=helper(curr.left,curr,parent);
        sum+=helper(curr.right,curr,parent);
        return sum;
    }
    public int sumEvenGrandparent(TreeNode root) {
        int sum = helper(root,null,null);
        
        return sum;
    }
}