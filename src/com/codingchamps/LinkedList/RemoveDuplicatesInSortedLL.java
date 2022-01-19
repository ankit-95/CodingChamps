package com.codingchamps.LinkedList;

//Remove duplicate element from sorted Linked List
//        Given a singly linked list consisting of N nodes. The task is to remove duplicates (nodes with duplicate values) from the
//        given list (if exists).
//        Note: Try not to use extra space. Expected time complexity is O(N). The nodes are arranged in a sorted way.
// Link : https://practice.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1

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

