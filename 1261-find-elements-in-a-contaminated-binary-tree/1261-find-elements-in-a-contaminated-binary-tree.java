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
class FindElements {
    TreeNode root;
    
    public void helper1(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null)
            root.left.val = root.val * 2 + 1;
         if(root.right!=null)
            root.right.val = root.val * 2 + 2;
        helper1(root.left);
        helper1(root.right);
    }
    public FindElements(TreeNode root) {
        root.val = 0;
        helper1(root);
        this.root = root;
    }
    
    public boolean helper(TreeNode root, int target){
        if(root==null)
            return false;
        if(root.val == target)
            return true;
        if(helper(root.left,target))
            return true;
        return helper(root.right,target);
    }
    public boolean find(int target) {
        return helper(this.root,target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */