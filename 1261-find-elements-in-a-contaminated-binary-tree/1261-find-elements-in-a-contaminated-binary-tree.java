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
    
    public FindElements(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        root.val = 0;
        while(!q.isEmpty()){
            TreeNode t = q.remove();
            if(t.left!=null){
                t.left.val = 2 * t.val + 1;
                q.add(t.left);
            }
            if(t.right!=null){
                t.right.val = 2 * t.val + 2;
                q.add(t.right);
            }
        }
        this.root = root;
    }
    
    public boolean find(int target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(this.root);
        while(!q.isEmpty()){
            TreeNode t = q.remove();
            if(t.val==target)
                return true;
            if(t.left!=null){
                q.add(t.left);
            }
            if(t.right!=null){
                q.add(t.right);
            }
        }
        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */