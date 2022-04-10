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
    HashSet<Integer> set;
    public void helper1(TreeNode root, int val,HashSet<Integer> set){
        if(root==null)
            return;
        root.val = val;
        set.add(root.val);
        helper1(root.left, 2 * val + 1,set);
        helper1(root.right , 2 * val + 2,set);
    }
    public FindElements(TreeNode root) {
        set = new HashSet<>();
        helper1(root,0,set);
        this.root = root;   
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */