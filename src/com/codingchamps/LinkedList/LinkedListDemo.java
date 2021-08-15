package com.codingchamps.LinkedList;


public class LinkedListDemo {
    Node head;
    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertNodeAtFront(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }
    public void insertNodeAtLast(int data) {
        Node newNode = new Node(data);
        Node temp=this.head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=newNode;
    }

    /*
    To Delete a Given Key, Use two pointer approach .. Iterative Approach
     */
    public void deleteGivenKeyIterative(int data){
        Node temp = this.head;
        Node prev = this.head;
        while(temp!=null && temp.data!=data){
            prev = temp;
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("\nKey Not Found.");
        } else {
            prev.next = temp.next;
        }
    }
    /*
    To Delete a Given Key, Use two pointer approach .. Recursive Approach
     */
    public void deleteGivenKeyRecursive(Node temp,int data){
        if(temp!=null && temp.data == data){
            temp = temp.next;
            return;
        } else {
            System.out.println("\nKey Not Found.");
        }
        deleteGivenKeyRecursive(temp.next,data);
    }
    public void displayList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
    }

    public static void main(String args[]) {
        LinkedListDemo list = new LinkedListDemo();
        list.insertNodeAtFront(5);
        list.insertNodeAtFront(6);
        list.insertNodeAtFront(7);
        list.insertNodeAtFront(8);
        list.insertNodeAtLast(1);
        list.displayList();
        System.out.print("\n");
        list.deleteGivenKeyIterative(7);
        list.displayList();
        list.deleteGivenKeyRecursive(list.head,5);
        list.displayList();
    }
}
