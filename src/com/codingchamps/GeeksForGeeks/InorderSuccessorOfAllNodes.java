package com.codingchamps.GeeksForGeeks;

public class InorderSuccessorOfAllNodes {

    Node root;
    public static Node next=null;
    public static class Node {
        int data;
        Node left, right,next;

        public Node(int data){
            this.data = data;
        }
    }


    public static void populateNext(Node root){
        if(root!=null){
            populateNext(root.right);
            root.next = next;
            next=root;
            populateNext(root.left);
        }
    }
    public static void main(String[] args) {

        InorderSuccessorOfAllNodes tree = new InorderSuccessorOfAllNodes();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);

        populateNext(tree.root);

        // Let us see the populated values of all the nodes 
        Node ptr = tree.root.left.left;
        while (ptr != null)
        {
            // -1 is printed if there is no successor
            int print = ptr.next != null ? ptr.next.data : -1;
            System.out.println("Next of " + ptr.data + " is: " + print);
            ptr = ptr.next;
        }
    }
}
