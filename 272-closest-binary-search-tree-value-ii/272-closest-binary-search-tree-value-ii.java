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
    
    public class Pair{
        int node;
        double diff;
        Pair(int node,double diff){
            this.node = node;
            this.diff = diff;
        }
        
        public String toString(){
            return "["+node+","+diff+"]";
        }
    }
    
    public void helper(TreeNode root,PriorityQueue<Pair> q,double target,int k){
        if(root==null)
            return;
        helper(root.left,q,target,k);
        if(q.size()==k){
            double curDiff = Math.abs(root.val - target);
            if(q.peek().diff > curDiff){
                q.remove();
                q.add(new Pair(root.val, Math.abs(root.val - target)));
            } 
        } else {
            q.add(new Pair(root.val, Math.abs(root.val - target)));
        }
        helper(root.right,q,target,k);
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b)->{
            return Double.compare(b.diff,a.diff);
        });
        helper(root,q,target,k);
        System.out.println(q);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty() && k>0){
            ans.add(q.remove().node);
            k--;
        }
        return ans;
    }
}