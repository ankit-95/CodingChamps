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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
           TreeNode newRoot = new TreeNode(val);
           newRoot.left = root;
           return newRoot;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                if(level == depth-1){
                    while(!q.isEmpty()){
                        TreeNode parent = q.remove();
                        TreeNode n1 = new TreeNode(val);
                        TreeNode n2 = new TreeNode(val);
                        if(parent.left!=null){
                            n1.left = parent.left;
                        }
                        if(parent.right!=null){
                            n2.right = parent.right;
                        }
                        parent.left = n1;
                        parent.right = n2;
                            
                    }
                    break;
                }
                TreeNode top = q.remove();
                if(top.left!=null)
                    q.add(top.left);
                if(top.right!=null)
                    q.add(top.right);
            }
            level++;
        }
        return root;
    }
}