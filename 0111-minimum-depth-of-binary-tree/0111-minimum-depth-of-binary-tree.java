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
    // DFS
    public int minDepth(TreeNode root) {
       if(root==null)
            return 0;
       Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                TreeNode temp = q.remove();
                if(temp.left == null && temp.right==null)
                    return level;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            level++;
        }
        return level;
    }
}