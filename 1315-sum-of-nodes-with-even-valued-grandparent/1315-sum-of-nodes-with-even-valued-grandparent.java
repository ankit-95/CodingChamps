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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum=0;
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp.left!=null){
                q.add(temp.left);
                if(temp.val%2==0){
                    if(temp.left.left!=null){
                        sum+=temp.left.left.val;
                    }
                    if(temp.left.right!=null){
                        sum+=temp.left.right.val;
                    }
                }   
            }
            if(temp.right!=null){
                q.add(temp.right);
                if(temp.val%2==0){
                    if(temp.right.left!=null){
                        sum+=temp.right.left.val;
                    }
                    if(temp.right.right!=null){
                        sum+=temp.right.right.val;
                    }   
                }
            }
        }
        
        return sum;
    }
}