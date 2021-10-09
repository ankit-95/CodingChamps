package com.codingchamps.Tree;

public class ViewOfTree {

    Node root;
    static int maxLevel;

    ViewOfTree(){
        this.maxLevel = 0;
    }
    public static class Node {
        int data;
        Node left,right;

        Node(int data){
            this.data = data;
            left=right=null;
        }
    }

    public static void leftView(Node root, int level){
        if(root==null)
            return;
        else {
            if(maxLevel < level){
                System.out.print(root.data+"->");
                maxLevel = level;
            }
            leftView(root.left, level+1);
            leftView(root.right, level+1);
        }
    }

    public static void rightView(Node root, int level){
        if(root==null)
            return;
        else {
            if(maxLevel < level){
                System.out.print(root.data+"->");
                maxLevel = level;
            }
            rightView(root.right, level+1);
            rightView(root.left, level+1);
        }
    }

    public static void main(String[] args) {

        ViewOfTree tree1 = new ViewOfTree();

        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);
        tree1.root.right.right = new Node(6);

        System.out.print("Left View of Tree : ");
        leftView(tree1.root,1);

        ViewOfTree tree2 = new ViewOfTree();

        tree2.root = new Node(1);
        tree2.root.left = new Node(2);
        tree2.root.right = new Node(3);
        tree2.root.left.left = new Node(4);
        tree2.root.left.right = new Node(5);
        tree2.root.right.right = new Node(6);

        System.out.print("\nRight View of Tree : ");
        rightView(tree2.root,1);
    }
}
