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
    public void preorder(List<Integer> list, TreeNode root){
        if(root==null)
            return;
        list.add(root.val);
        preorder(list,root.left);
        preorder(list,root.right);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // if(root==null)
        //     return list;
        // preorder(list,root);
        if(root==null)
            return list;
        Stack<TreeNode> st = new Stack<>();
        while(st.size()>0 || root!=null){
            while(root!=null){
                list.add(root.val);
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return list;
    }
}