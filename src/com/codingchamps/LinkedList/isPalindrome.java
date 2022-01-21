package com.codingchamps.LinkedList;

import com.codingchamps.Practice.LL;

public class isPalindrome {
    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data){
          this.data = data;
          next = null;
        }
    }

    isPalindrome(){
        head=null;
    }

    public void insertFront(int data){
        Node newNode = new Node(data);
        if(head==null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }
    public Node reverseLL(Node head){
        Node current = head;
        Node prev = null;
        Node next = current;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    public Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast= fast.next.next;
        }
        if(fast!=null)
            slow = slow.next;
        return slow;
    }
    public boolean isPalindrome(Node head) {

        Node temp = head;
        Node middle = getMiddle(head);
        Node newHead = reverseLL(middle.next);
        middle.next = newHead;

        while(temp!=null && newHead!=null){
            if(temp.data!=newHead.data)
                return false;
            temp = temp.next;
            newHead = newHead.next;
        }
        Node lastHead = reverseLL(middle.next);
        middle.next = lastHead;
        //display();
        return true;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        isPalindrome list = new isPalindrome();
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);
        list.display();
        System.out.println();

        System.out.println(list.isPalindrome(list.head));
    }

}
