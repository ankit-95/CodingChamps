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
    public int maxDepth(TreeNode root) {
        // if(root==null)
        //     return 0;
        // int l = maxDepth(root.left);
        // int r = maxDepth(root.right);
        // return  1 + Math.max(l,r);
        if(root==null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode top = q.remove();
                if(top.left!=null){
                    q.add(top.left);
                }
                if(top.right!=null){
                    q.add(top.right);
                }    
            }
           level++;
        }
        return level;
    }
}