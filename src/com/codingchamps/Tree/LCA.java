package com.codingchamps.Tree;

import java.util.ArrayList;

public class LCA {
    Node root;
    ArrayList<Integer> path1;
    ArrayList<Integer> path2;
    boolean v1, v2;

    public LCA() {
        root = null;
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public boolean findPath(Node root, int k, ArrayList<Integer> path) {
        if (root == null)
            return false;
        path.add(root.data);
        if (root.data == k)
            return true;
        if (root.left != null && findPath(root.left, k, path)) {
            return true;
        }
        if (root.right != null && findPath(root.right, k, path)) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    public Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return null;

        if (root.data == n1 || root.data == n2)
            return root;

        Node left_lca = findLCA(root.left, n1, n2);
        Node right_lca = findLCA(root.right, n1, n2);

        if (left_lca != null && right_lca != null)
            return root;

        return left_lca != null ? left_lca : right_lca;
    }

    public Node findLCAUtil(Node root, int n1, int n2) {
        if (root == null)
            return null;

        Node temp = null;
        if (root.data == n1) {
            v1 = true;
            temp = root;
        }
        if (root.data == n2) {
            v2 = true;
            temp = root;
        }


        Node left_lca = findLCAUtil(root.left, n1, n2);
        Node right_lca = findLCAUtil(root.right, n1, n2);

        if (temp != null)
            return temp;

        if (left_lca != null && right_lca != null)
            return root;

        return left_lca != null ? left_lca : right_lca;
    }

    public Node findLCAHandleNullChild(Node root, int n1, int n2) {
        v1 = v2 = false;
        Node temp = findLCAUtil(root, n1, n2);

        if (v1 && v2)
            return temp;
        else
            return null;
    }

    public static void main(String args[]) {
        LCA t = new LCA();
        t.root = new Node(1);
        t.root.left = new Node(2);
        t.root.right = new Node(3);
        t.root.left.left = new Node(4);
        t.root.left.right = new Node(5);
        t.root.right.left = new Node(6);
        t.root.right.right = new Node(7);

        t.inOrder(t.root);

        System.out.println("\n" + t.findPath(t.root, 6, t.path1));
        System.out.println("\n" + t.findPath(t.root, 4, t.path2));
        System.out.println("\n" + t.path1);

        System.out.println("\n" + t.path2);
        int i = 0;
        for (i = 0; i < t.path1.size() && i < t.path2.size(); i++) {
            if (!(t.path1.get(i) == t.path2.get(i)))
                break;
        }
        System.out.println("\nLCA : "+t.path1.get(i-1));

        System.out.println("\nLCA : "+t.findLCA(t.root,4,7).data);
        Node temp = t.findLCAHandleNullChild(t.root, 4, 9);
        System.out.println("\nLCA : " + (temp != null ? temp.data : "null"));
    }
}
