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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(cloned);
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.val == target.val){
                return temp;
            }
            if(temp.left!=null)
                q.add(temp.left);
            if(temp.right!=null)
                q.add(temp.right);
        }
        return null;
    }
}