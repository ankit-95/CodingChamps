package com.codingchamps.Tree;

public class TreeTemplate {

    Node root;
    TreeTemplate(){
        root = null;
    }
    public static  class Node{
        int data;
        Node right;
        Node left;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
}
