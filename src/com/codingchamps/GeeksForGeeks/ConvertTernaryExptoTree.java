package com.codingchamps.GeeksForGeeks;

import java.util.Stack;


/*Given a string that contains ternary expressions. The expressions may be nested. You need to convert the given ternary expression to a binary Tree and return the root.

        Example 1:

        Input: a?b:c
        Output: a b c
        Explanation:
        string expression = a?b:c
        So the binary tree for the above expression is:
        a
        /   \
        b     c
        Example 2:

        Input: a?b?c:d:e
        Output: a b c d e
        Explanation:
        string expression =  a?b?c:d:e
        So the binary tree for the above expression is:
        a
        /   \
        b     e
        /   \
        c     d
        */
public class ConvertTernaryExptoTree {

    Node root;

    public static class Node {
        char data;
        Node left, right;

        Node(char key) {
            data = key;
            left = right = null;
        }

        public static void preOrder(Node temp) {
            if (temp == null)
                return;
            System.out.print(temp.data + " ");
            preOrder(temp.left);
            preOrder(temp.right);
        }

        public static Node convertExp(String s, int i)
        {
            if(i>=s.length())
                return null;
            Node root = new Node(s.charAt(i));
            ++i;
            if(i<s.length() && s.charAt(i)=='?')
                root.left = convertExp(s,i+1);
            else
                root.right = convertExp(s,i+1);
            return root;
        }

        public static void main(String args[]) {

            String s = "w?l?r?b?b:m:q?b:h:c?d?a:r:z?o:w:k?k?y?h:i:d?d:q:s?c?d:x:r?j:m";

            Node root = convertExp(s, 0);

            preOrder(root);

        }
    }
}
