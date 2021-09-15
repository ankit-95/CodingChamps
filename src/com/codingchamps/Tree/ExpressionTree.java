package com.codingchamps.Tree;

import java.util.Stack;

public class ExpressionTree {

    public class Node {
        Character data;
        Node left, right;

        Node(Character data) {
            this.data = data;
            left = right = null;
        }
    }

    public void inorder(Node temp){
        if(temp == null)
            return;
        inorder(temp.left);
        System.out.print(temp.data+" ");
        inorder(temp.right);
    }
    
    
    public static void main(String args[]) {

        ExpressionTree et = new ExpressionTree();
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        Node root = et.constructTree(charArray);
        System.out.println("infix expression is");
        et.inorder(root);

    }

    private boolean isOperator(Character c){
        if( c=='+' || c=='-' || c=='/' || c=='*' || c=='^')
            return true;
        else return false;
    }

    private Node constructTree(char[] charArray) {
        Stack<Node> s = new Stack<>();
        Node t =null;
        for(int i=0;i<charArray.length;i++){
            if(!isOperator(charArray[i])){
                t = new Node(charArray[i]);
                s.push(t);
            } else {

                t = new Node(charArray[i]);
                Node t1 = s.pop();
                Node t2 = s.pop();

                t.right = t1;
                t.left = t2;

                s.push(t);
            }
        }
        t = s.pop();
        return t;
    }
}
