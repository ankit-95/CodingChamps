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
    public int sumEvenGrandparent(TreeNode root) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        parent.put(root,null);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.left!=null){
                parent.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right!=null){
                parent.put(temp.right,temp);
                q.add(temp.right);
            }
        }
        Map<TreeNode,TreeNode> gParent = new HashMap<>();
        for(Map.Entry<TreeNode,TreeNode> pair : parent.entrySet()){
            gParent.put(pair.getKey(),parent.get(pair.getValue()));
        }
        
        q = new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(gParent.containsKey(temp) && gParent.get(temp)!=null && gParent.get(temp).val%2==0){
                sum+=temp.val;
            }
            if(temp.left!=null){
                q.add(temp.left);
            }
            if(temp.right!=null){
                q.add(temp.right);
            }
        }
        
        return sum;
    }
}