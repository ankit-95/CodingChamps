package com.codingchamps.Tree;

// { Driver Code Starts

import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    String data;
    Node left, right;

    Node(String d) {
        data = d;
        left = null;
        right = null;
    }
}

class ExpressionEvaluation {
    static Node root;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int t = sc.nextInt();
        int t = 1;

        while (t-- > 0) {
            //int n = sc.nextInt();
            int n = 7;
            /*String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = sc.next();
            }*/
            String[] s = {"+", "*", "-", "5", "4", "100", "20"};
            Solution g = new Solution();
            makeTree(s, n);
            System.out.println();
            inOrder(root);
            System.out.println("\nEvaluation is : " + g.evalTree(root));
        }
    }

    public static boolean isExpression(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }

    public static void inOrder(Node temp) {
        if (temp == null)
            return;
        inOrder(temp.left);
        System.out.print(temp.data + " ");
        inOrder(temp.right);
    }

    public static void makeTree(String[] s, int n) {
        int p = 0;
        root = new Node(s[p++]);
        Queue<Node> qq = new LinkedList<Node>();
        qq.add(root);
        while (!qq.isEmpty()) {
            Node f = qq.poll();
            Node l = null, r = null;
            if (isExpression(f.data)) {
                l = new Node(s[p++]);
                r = new Node(s[p++]);
                f.left = l;
                f.right = r;
                qq.add(l);
                qq.add(r);
            }
        }
    }
}

class Solution {
    private int toInt(String s) {
        int num = 0;

        // Check if the integral value is
        // negative or not
        // If it is not negative, generate the number
        // normally
        if (s.charAt(0) != '-')
            for (int i = 0; i < s.length(); i++)
                num = num * 10 + ((int) s.charAt(i) - 48);
            // If it is negative, calculate the +ve number
            // first ignoring the sign and invert the
            // sign at the end
        else
            for (int i = 1; i < s.length(); i++) {
                num = num * 10 + ((int) (s.charAt(i)) - 48);
                num = num * -1;
            }

        return num;
    }

    public int evalTree(Node root) {
        // empty tree
        if (root == null)
            return 0;

        // leaf node i.e, an integer
        if (root.left == null && root.right == null)
            return toInt(root.data);

        // Evaluate left subtree
        int leftEval = evalTree(root.left);

        // Evaluate right subtree
        int rightEval = evalTree(root.right);

        // Check which operator to apply
        if (root.data.equals("+"))
            return leftEval + rightEval;

        if (root.data.equals("-"))
            return leftEval - rightEval;

        if (root.data.equals("*"))
            return leftEval * rightEval;

        return leftEval / rightEval;
    }
}