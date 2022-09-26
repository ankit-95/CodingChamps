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
    
    public void helper(TreeNode root,String path,List<String> ans){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){ 
            path+=root.val+"";
            ans.add(path);
        }
        else 
            path+=root.val+"->";
        
        helper(root.left,path,ans);    
        helper(root.right,path,ans);    
        
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        helper(root,"",ans);
        return ans;
    }
}