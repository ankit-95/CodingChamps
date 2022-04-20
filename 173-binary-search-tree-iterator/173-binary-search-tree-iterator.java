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
class BSTIterator {

    Stack<TreeNode> s = new Stack(); 
    ArrayList<Integer> ar = new ArrayList<>();
    public BSTIterator(TreeNode root) {
        while(root!=null || s.size()>0){
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            ar.add(root.val);
            root = root.right;
        }
    }
    
    public int next() {
        int key = ar.get(0);
        ar.remove(0);
        return key;
    }
    
    public boolean hasNext() {
        return ar.size()>0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */