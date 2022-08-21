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
    Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
    
    public int helper(TreeNode root){
        if(root==null)
            return -1;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int height = Math.max(left,right)+1;
        
        map.putIfAbsent(height,new ArrayList<>());
        map.get(height).add(root.val);
        
        return height;
    }
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root);
        for(int key : map.keySet()){
            ans.add(new ArrayList<>(map.get(key)));
        }
        return ans;
    }
}