package com.codingchamps.Tree;

// Link : https://leetcode.com/problems/path-sum/
public class PathSum {

    // Using DFS
    public static boolean hasPathSum(TreeTemplate.Node root, int targetSum) {
        boolean b1= false,b2=false;
        if(root==null)
            return false;
        if(root.left == null && root.right==null){
            if((targetSum-root.data)==0)
                return true;
            return false;
        }
        if(root.left!=null)
            b1 = hasPathSum(root.left,targetSum - root.data);
        if(root.right!=null)
            b2 = hasPathSum(root.right,targetSum - root.data);
        if(b1 || b2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        TreeTemplate tree = new TreeTemplate();
        tree.root = new TreeTemplate.Node(5);
        tree.root.left = new TreeTemplate.Node(4);
        tree.root.right = new TreeTemplate.Node(8);
        tree.root.left.left = new TreeTemplate.Node(11);
        tree.root.right.left = new TreeTemplate.Node(13);
        tree.root.right.right = new TreeTemplate.Node(4);
        tree.root.right.right.right = new TreeTemplate.Node(1);
        tree.root.left.left.left = new TreeTemplate.Node(7);
        tree.root.left.left.right = new TreeTemplate.Node(2);

        System.out.println(hasPathSum(tree.root,22));
        System.out.println(hasPathSum(tree.root,17));
    }
}
