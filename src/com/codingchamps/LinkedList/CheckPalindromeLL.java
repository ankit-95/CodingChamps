package com.codingchamps.LinkedList;

import java.util.Stack;

public class CheckPalindromeLL {
    Stack stack = null;
    Node head;
    Node left;
    CheckPalindromeLL(){
        head=null;
    }
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }
    public void insertIntoLL(int data){
        Node newNode = new Node(data);
        if(head==null){
            head= newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void displayList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"-> ");
            temp = temp.next;
        }
    }
    /*
    T.C = O(n)
    S.C = O(n)
    * */
    public boolean checkPalindromeinLLUsingStack(){
        stack = new Stack();
        Node temp = head;
        while(temp!=null){
            stack.push(temp.data);
            temp = temp.next;
        }
        Node nextNode = head;
        boolean isPalim = false;
        while(nextNode!=null){
            if(nextNode.data == (int)stack.peek()){
                isPalim = true;
            } else {
                isPalim = false;
            }
            stack.pop();
            nextNode = nextNode.next;
        }
        return isPalim;
    }

    public boolean palindromeCheckUsingRec(){
        boolean result = isPalindrome(head);
        return result;
    }

    public boolean isPalindrome(Node right){
        left = head;
        if(right == null)
            return true;
        boolean isp = isPalindrome(right.next);
        if(isp==false){
            return false;
        }
        boolean isp1= (right.data == left.data);

        left= left.next;
        return isp1;
    }

    public static void main(String args[]){
        CheckPalindromeLL list = new CheckPalindromeLL();
        list.insertIntoLL(1);
        list.insertIntoLL(2);
        list.insertIntoLL(2);
        list.insertIntoLL(1);
        list.displayList();

        System.out.println("\nCheck Palindrome or Not (Stack Approach) : "+list.checkPalindromeinLLUsingStack());
        System.out.println("\nCheck Palindrome or Not (Recursive Approach): "+list.palindromeCheckUsingRec());
    }
}
