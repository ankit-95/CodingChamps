package com.codingchamps.Tree;

import java.util.*;

public class TreeTraversal {

    Node root;
    TreeTraversal(){
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

//  Using Recursion
    public void inOrderTraversal(Node temp){
        if(temp==null)
            return;
        inOrderTraversal(temp.left);
        System.out.print(temp.data+" ");
        inOrderTraversal(temp.right);
    }
//  Using without Recursion
    public void inOrderTraversalWithRecursion(Node temp){
        Stack<Node> s = new Stack<>();
        while(temp!=null || s.size() >0){
            while(temp!=null){
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            System.out.print(temp.data + " ");
            temp = temp.right;
        }
    }

    // Using Recursion
    public void preOrderTraversal(Node temp){
        if(temp==null)
            return;
        System.out.print(temp.data+" ");
        preOrderTraversal(temp.left);
        preOrderTraversal(temp.right);
    }

    //  Using without Recursion
    public void preOrderTraversalWithRecursion(Node temp){
        Stack<Node> s = new Stack<>();
        while(temp!=null || s.size() >0){
            while(temp!=null){
                System.out.print(temp.data+" ");
                s.push(temp);
                temp = temp.left;
            }
            temp = s.pop();
            temp = temp.right;
        }
    }
    // Using Recursion
    public void postOrderTraversal(Node temp){
        if(temp==null)
            return;
        postOrderTraversal(temp.left);
        postOrderTraversal(temp.right);
        System.out.print(temp.data+" ");
    }

    // Using without Recursion
    public void postOrderTraversalWithoutRecursion(Node temp){
       Stack<Node> s1 = new Stack<>();
       Stack<Node> s2 = new Stack<>();
       s1.push(temp);
       while(!s1.empty()){
           Node tmp = s1.pop();
           s2.push(tmp);
           if(tmp.left!=null)
            s1.push(tmp.left);
           if(tmp.right!=null)
            s1.push(tmp.right);
       }

       while(!s2.empty()){
           System.out.print(s2.pop().data +" ");
       }
    }

    public static int totalNodes(Node temp){
        if(temp==null){
            return 0;
        }
        return 1 + totalNodes(temp.left) + totalNodes(temp.right);
    }

    public static int heightOfTree(Node temp){
        if(temp==null){
            return 0;
        }
        int max1 = 1+ heightOfTree(temp.left);
        int max2 = 1+ heightOfTree(temp.right);
        return Math.max(max1,max2);
    }

    public static void printLevelOrderTraversal(Node temp){
        Queue<Node> queue = new LinkedList<>();
        queue.add(temp);
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            System.out.print(tempNode.data+" ");
            if(tempNode.left!=null)
                queue.add(tempNode.left);
            if(tempNode.right!=null)
                queue.add(tempNode.right);
        }
    }

    public static void reverseLevelOrder(Node node)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Stack<Integer> s = new Stack();
        while(!q.isEmpty()){

            Node temp = q.remove();
            // System.out.print(temp.data+"->");
            s.push(temp.data);
            if(temp.right!=null)
                q.add(temp.right);
            if(temp.left!=null)
                q.add(temp.left);
        }

        Iterator itr = s.iterator();
        while(itr.hasNext()){
            System.out.print(s.peek()+"->");
            s.pop();
        }
    }
    public static void main(String args[]){

        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(5);
        tree.root.left = new Node(4);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(2);
        tree.root.left.right = new Node(3);

        tree.root.left.left.right = new Node(8);

       /* System.out.print("Inorder : ");
        tree.inOrderTraversal(tree.root);
        System.out.print("\nPreorder : ");
        tree.preOrderTraversal(tree.root);
        System.out.print("\nPostorder : ");
        tree.postOrderTraversal(tree.root);*/

        System.out.print("Inorder : ");
        tree.inOrderTraversalWithRecursion(tree.root);
        System.out.print("\nPreorder : ");
        tree.preOrderTraversalWithRecursion(tree.root);
        System.out.print("\nPostorder : ");
        tree.postOrderTraversalWithoutRecursion(tree.root);

        System.out.print("\nTotal Nodes : "+totalNodes(tree.root));
        TreeTraversal tree1 = new TreeTraversal();
        tree1.root = new Node(2);
       // tree.root.left = new Node(4);
        tree1.root.right = new Node(1);
        tree1.root.right.left = new Node(3);
        //tree.root.left.right = new Node(3);
        System.out.print("\nHeight Of Tree : "+heightOfTree(tree1.root));
        System.out.print("\nLevel Order Traversal of Tree : ");
        printLevelOrderTraversal(tree.root);
        System.out.print("\nReverse Level Order Traversal of Tree : ");
        reverseLevelOrder(tree.root);
    }
}
