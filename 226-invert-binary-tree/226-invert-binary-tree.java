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
    
    //Recursive Solution
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return null;
        final TreeNode left = root.left, right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;    
    }
    
    // BFS Solution
    // public TreeNode invertTree(TreeNode root) {
    //     if(root==null)
    //         return root;
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         TreeNode temp = q.remove();
    //         TreeNode left = temp.left;
    //         temp.left = temp.right;
    //         temp.right = left;
    //         if(temp.left!=null)
    //             q.add(temp.left);
    //         if(temp.right!=null)
    //             q.add(temp.right);
    //     }
    //     return root;
    // }
}