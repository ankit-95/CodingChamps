package com.codingchamps.Tree;

import com.codingchamps.Practice.Practice;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class isBST {

    Node root;
    Map<Integer, List<Integer>> map;
    Map<Integer,List<Integer>> verticalMap;
    public static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    isBST(){
        root=null;
        map = new TreeMap<>();
        verticalMap = new TreeMap<>();
    }

    public static void main(String[] args) {
        isBST tree = new isBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        tree.inOrder(tree.root);

        System.out.println("\nIs BST or not : "+tree.isBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    public boolean isBST(Node root, int min, int max){
        if(root==null)
            return true;
        if(root.data < min || root.data > max)
            return false;
        return (isBST(root.left,min,root.data-1) && isBST(root.right,root.data+1,max));
    }

    private void inOrder(Node root) {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
}
