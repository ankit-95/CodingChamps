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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        int level = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> list = new ArrayList<>();
            if(level%2==0){
                while(!s1.isEmpty()){
                    TreeNode top = s1.pop();
                    list.add(top.val);
                    if(top.left!=null){
                        s2.push(top.left);
                    }
                    if(top.right!=null){
                        s2.push(top.right);
                    }
                }
            }
            else {
                while(!s2.isEmpty()){
                    TreeNode top = s2.pop();
                    list.add(top.val);
                    if(top.right!=null){
                        s1.push(top.right);
                    }
                    if(top.left!=null){
                        s1.push(top.left);
                    }
                }   
            }
            ans.add(new ArrayList<>(list));
            level++;
        }
        return ans;
    }
}