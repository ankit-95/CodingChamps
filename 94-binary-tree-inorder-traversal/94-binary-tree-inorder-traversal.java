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
    
    public void inorder(List<Integer> list, TreeNode root){
        if(root==null){
            return;
        }
        inorder(list,root.left);
        list.add(root.val);
        inorder(list,root.right);
    }
    
    public List<Integer> inorderTraversal(TreeNode root) {
        // if(root==null)
        //     return new ArrayList();
        List<Integer> list = new ArrayList<>();
        //inorder(list,root);
        
        Stack<TreeNode> st = new Stack<>();
        while(root!=null || st.size()>0){
            while(root!=null){
                st.push(root);
                root = root.left;
            }
               
            root = st.pop();
            list.add(root.val);    
            root = root.right;
        }
        return list;
    }
    
}