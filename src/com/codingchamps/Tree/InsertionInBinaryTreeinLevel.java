package com.codingchamps.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertionInBinaryTreeinLevel {

    public static void insertInLevelOrder(TreeTemplate.Node temp, int data){
        Queue<TreeTemplate.Node> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            TreeTemplate.Node tempNode = q.poll();
            if(tempNode.left==null){
                tempNode.left = new TreeTemplate.Node(data);
                break;
            } else {
                q.add(tempNode.left);
            }
            if(tempNode.right==null){
                tempNode.right = new TreeTemplate.Node(data);
                break;
            } else {
                q.add(tempNode.right);
            }
        }
    }

    public static void inOrder(TreeTemplate.Node temp){
        if(temp==null)
            return;
        inOrder(temp.left);
        System.out.print(temp.data+" ");
        inOrder(temp.right);
    }
    public static void main(String args[]){
        TreeTemplate tree = new TreeTemplate();
        tree.root = new TreeTemplate.Node(10);
        tree.root.left = new TreeTemplate.Node(11);
        tree.root.right = new TreeTemplate.Node(9);
        tree.root.left.left = new TreeTemplate.Node(7);
        tree.root.right.left = new TreeTemplate.Node(15);
        tree.root.right.right = new TreeTemplate.Node(8);

        System.out.print(" :: Level Order Insertion :: \n");
        System.out.print("Before Insertion : ");
        inOrder(tree.root);

        insertInLevelOrder(tree.root,12);
        System.out.print("\nAfter Insertion : ");
        inOrder(tree.root);
    }
}
