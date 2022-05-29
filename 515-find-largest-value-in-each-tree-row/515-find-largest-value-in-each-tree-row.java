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
    // BFS 
//     public List<Integer> largestValues(TreeNode root) {
//         List<Integer> ans = new ArrayList<>();
//         if(root==null)
//             return ans;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
        
        
//         while(!q.isEmpty()){
//             int size = q.size();
//             int max = Integer.MIN_VALUE;
//             while(size-->0){
//                 TreeNode temp = q.remove();
//                 max = Math.max(max, temp.val);
//                 if(temp.left!=null)
//                     q.add(temp.left);
//                 if(temp.right!=null)
//                     q.add(temp.right);
//             }
//             ans.add(max);
//         }
//         return ans;
//     }
    
    //DFS
     public List<Integer> largestValues(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
         helper(root,ans,0);
         return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans,int level){
        if(root==null)
            return;
        if(level == ans.size()){
            ans.add(root.val);
        } else {
            ans.set(level, Math.max(ans.get(level),root.val));
        }
        helper(root.left,ans,level+1);
        helper(root.right,ans,level+1);
    }
}