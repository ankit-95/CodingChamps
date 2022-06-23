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
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode helper(int is,int ie,int [] inorder,int ps,int pe,int [] postorder){
        if(is>ie || ps>pe)
            return null;
        
        TreeNode root = new TreeNode(postorder[pe]);
        int mid = map.get(postorder[pe]);
        int dist = ie - mid;
        root.left = helper(is,mid-1,inorder,ps,pe-dist-1,postorder);
        root.right = helper(mid+1,ie,inorder,pe-dist,pe-1,postorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(0,inorder.length-1,inorder,0,postorder.length-1,postorder);
    }
}