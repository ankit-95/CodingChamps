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
    public int totalSum(TreeNode root){
        TreeNode cur = root;
        int sum=0;
        while(cur!=null){
            if(cur.left==null){
                sum+=cur.val;
                cur= cur.right;
            }
            else {
                TreeNode prev= cur.left;
                while(prev.right!=null && prev.right!=cur){
                    prev = prev.right;
                }
                if(prev.right==null){
                    prev.right=cur;
                    cur = cur.left;
                } else{
                    sum+=cur.val;
                    prev.right=null;
                    cur = cur.right;
                }
            }
        }
        return sum;
    }
    long maxi = Long.MIN_VALUE;
    public int helper(TreeNode root,long sum){
        if(root==null)
            return 0;
        int left = helper(root.left,sum);
        int right = helper(root.right,sum);
        int subTree = Math.max(left,right);
        maxi = Math.max(maxi,(sum-subTree)*subTree);
        return root.val + left+ right;
    }
    public int maxProduct(TreeNode root) {
        long sum = totalSum(root);
        helper(root,sum);
        return (int)(maxi % ((int)Math.pow(10, 9) + 7));
    }
}