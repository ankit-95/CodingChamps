package com.codingchamps.Tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversalOfTree {

    //Function to store the zig zag order traversal of tree in a list.
    static ArrayList<Integer>  zigZagTraversal(TreeTemplate.Node root)
    {
        Stack<TreeTemplate.Node> s1 = new Stack<>();
        Stack<TreeTemplate.Node> s2 = new Stack<>();
        ArrayList<Integer> arr = new ArrayList<>();
        s1.push(root);
        int level = 0;
        while(!s1.isEmpty() || !s2.isEmpty()){
            if(level%2==0){
                while(!s1.isEmpty()){
                    TreeTemplate.Node temp = s1.pop();
                    arr.add(temp.data);
                    if(temp.left!=null){
                        s2.push(temp.left);
                    }
                    if(temp.right!=null){
                        s2.push(temp.right);
                    }
                }
            }
            else {
                while(!s2.isEmpty()){
                    TreeTemplate.Node temp = s2.pop();
                    arr.add(temp.data);
                    if(temp.right!=null){
                        s1.push(temp.right);
                    }
                    if(temp.left!=null){
                        s1.push(temp.left);
                    }
                }
            }
            level++;
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeTemplate tree = new TreeTemplate();
        tree.root = new TreeTemplate.Node(7);
        tree.root.left = new TreeTemplate.Node(9);
        tree.root.right = new TreeTemplate.Node(7);
        tree.root.left.left = new TreeTemplate.Node(8);
        tree.root.left.right = new TreeTemplate.Node(8);
        tree.root.right.left = new TreeTemplate.Node(6);
        tree.root.left.left.left = new TreeTemplate.Node(10);
        tree.root.left.left.right = new TreeTemplate.Node(9);

        System.out.println(zigZagTraversal(tree.root));
    }
}
