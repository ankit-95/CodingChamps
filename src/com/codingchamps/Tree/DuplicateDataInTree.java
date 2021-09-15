package com.codingchamps.Tree;

public class DuplicateDataInTree {

    Node root;
    DuplicateDataInTree(){
        root= null;
    }
    static class Node
    {
        int key;
        int count;
        Node left, right;
        Node(int data){
            this.key = data;
            left = right = null;
        }
    }

    public static Node insertIntoTree(Node node,int data){
        if(node == null){
            node = new Node(data);
            node.count=1;
            return node;
        }
        if(node.key == data){
            node.count++;
            return node;
        }
        if( data < node.key){
            node.left = insertIntoTree(node.left, data);
        } else {
            node.right = insertIntoTree(node.right, data);
        }
        return node;
    }

    static void inorder(Node root)
    {
        if (root != null)
        {
            inorder(root.left);
            System.out.print(root.key + "(" +
                    root.count + ") ");
            inorder(root.right);
        }
    }
    public static void main(String args[]){
        Node root = null;
        root = insertIntoTree(root, 12);
        root = insertIntoTree(root, 10);
        root = insertIntoTree(root, 20);
        root = insertIntoTree(root, 9);
        root = insertIntoTree(root, 11);
        root = insertIntoTree(root, 10);
        root = insertIntoTree(root, 12);
        root = insertIntoTree(root, 12);

        System.out.print("Inorder traversal of " +
                "the given tree " + "\n");
        inorder(root);
    }
}
