/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean found = false;
        while(root!=null || stack.size()>0){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            
            if(found)
                return root;
            if(root.val == p.val)
                found = true;
            
            root = root.right;
        }
        return null;
    }
}