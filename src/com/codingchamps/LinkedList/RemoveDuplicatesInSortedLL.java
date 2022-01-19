package com.codingchamps.LinkedList;

public class RemoveDuplicatesInSortedLL {
    Node head;
    static int count;
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

    public void displayList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
    }

    Node removeDuplicates(Node head)
    {
        Node start = head;
        Node temp = head;
        while(temp!=null){
            if(temp.data==start.data){
                temp = temp.next;
            } else {
                start.next = temp;
                start = temp;
            }
        }
        start.next = temp;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedLL list = new RemoveDuplicatesInSortedLL();
        list.insertNodeAtFront(5);
        list.insertNodeAtFront(4);
        list.insertNodeAtFront(2);
        list.insertNodeAtFront(2);
        list.displayList();
        list.head = list.removeDuplicates(list.head);
        System.out.print("\nList After Deletion : ");
        list.displayList();

    }
}

