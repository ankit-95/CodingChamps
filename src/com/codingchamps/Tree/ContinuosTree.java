package com.codingchamps.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ContinuosTree {

    Node root;

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    ContinuosTree(){
        root = null;
    }

    public void insertIntoTree(int data){
        if(root == null){
            root = new Node(data);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left==null){
                temp.left = new Node(data);
                return;
            } else {
                q.add(temp.left);
            }
            if(temp.right==null){
                temp.right = new Node(data);
                return;
            } else {
                q.add(temp.right);
            }
        }
    }

    public void inOrder(Node temp){
        if(temp == null)
            return;
        inOrder(temp.left);
        System.out.print(temp.data+" ");
        inOrder(temp.right);
    }

    public String checkContinuosTree(){
        // if next node is empty then return true
        if (root == null)
            return "Yes";
        // if current node is leaf node then return true
        // because it is end of root to leaf path
        if (root.left == null && root.right == null)
            return "Yes";

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left!=null){
                if(Math.abs(temp.data - temp.left.data) ==1)
                    q.add(temp.left);
                else
                    return "No";
            }
            if(temp.right!=null){
                if(Math.abs(temp.data - temp.right.data) ==1)
                    q.add(temp.right);
                else
                    return "No";
            }
        }
        return "Yes";
    }
    public static void main(String args[]) {
        ContinuosTree tree = new ContinuosTree();
        tree.insertIntoTree(7);
        tree.insertIntoTree(5);
        tree.insertIntoTree(8);
        tree.insertIntoTree(6);
        tree.insertIntoTree(4);
        tree.insertIntoTree(10);

        tree.inOrder(tree.root);

        System.out.println("\nCheck for Continuos Tree : " + tree.checkContinuosTree());
    }
}
