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
    public TreeNode helper(int is,int ie, int [] inorder, int ps,int pe, int [] preorder){
        
        if(is > ie || ps > pe)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int mid = map.get(preorder[ps]);
        int dist = mid - is;
        root.left = helper(is, mid-1,inorder,ps+1,ps+dist,preorder);
        root.right = helper(mid+1,ie,inorder,ps+dist+1,pe,preorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(0,inorder.length-1,inorder,0,preorder.length-1,preorder);
    }
}