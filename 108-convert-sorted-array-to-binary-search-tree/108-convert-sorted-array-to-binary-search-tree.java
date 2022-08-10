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
    
    public TreeNode helper(int p,int r,int nums[]){
        if(p<=r){
            int mid = (p+r)/2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(p,mid-1,nums);
            root.right = helper(mid+1,r,nums);
            return root;    
        }
        return null;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return  helper(0,nums.length-1,nums);  
    }
}