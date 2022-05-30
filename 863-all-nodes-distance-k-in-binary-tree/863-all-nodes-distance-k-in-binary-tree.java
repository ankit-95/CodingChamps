/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public void markParents(TreeNode root,Map<TreeNode,TreeNode> map){
       Queue<TreeNode> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
           TreeNode u = q.remove();
           if(u.left!=null){
               map.put(u.left,u);
               q.add(u.left);
           }
           if(u.right!=null){
               map.put(u.right,u);
               q.add(u.right);
           }
       }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        markParents(root,map);
        
        List<Integer> ans = new ArrayList<>();
        HashSet<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                 TreeNode u = q.remove();
                 if(visited.contains(u)) continue;
                 visited.add(u);
                 if(k==0){
                     ans.add(u.val);
                 }
                 if(u.left!=null){
                     q.add(u.left);
                 }
                 if(u.right!=null){
                     q.add(u.right);
                 }
                 if(map.containsKey(u)){
                    q.add(map.get(u)); 
                 }
            }
            k--;
        }
        return ans;
    }
}