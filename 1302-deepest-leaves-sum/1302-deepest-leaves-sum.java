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
    
    public int deepestLeavesSum(TreeNode root) {
        
        Map<Integer,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level =0;
        int sum=0;
        while(!q.isEmpty()){
            int size = q.size();
            sum=0;
            while(size-->0){
                TreeNode temp = q.remove();
                // if(temp.left==null && temp.right==null){
                //      map.put(level, map.getOrDefault(level,0)+temp.val);
                //     continue;
                // }
                sum+=temp.val;
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            level++;
        }
        //return (int) map.get(level-1);
        return sum;
    }
}