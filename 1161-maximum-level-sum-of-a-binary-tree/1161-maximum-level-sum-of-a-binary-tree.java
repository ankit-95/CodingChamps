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
    public int maxLevelSum(TreeNode root) {
        if(root!=null){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        int maxLevel = -1;
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int size = q.size();
            int sum=0;
            while(size-->0){
                TreeNode temp = q.remove();
                sum+=temp.val;
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(max < sum){
               max = sum;
               maxLevel = level;
            }           
            level++;
        }
        return maxLevel;
        } else
            return -1;
    }
}