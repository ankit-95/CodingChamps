package com.codingchamps.LinkedList;

public class RotateList {
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

    private Node rotate(Node head, int k) {
        if(k<=0 || head==null || head.next==null)
            return null;
        Node last = head;
        int length = 1;
        while(last.next!=null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length-rotations;
        Node newLast = head;
        for(int i=0;newLast!=null && i<skip-1;i++){
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;
        return head;
    }
    public static void main(String[] args) {
        RotateList list = new RotateList();
        list.insertNodeAtFront(5);
        list.insertNodeAtFront(4);
        list.insertNodeAtFront(3);
        list.insertNodeAtFront(2);
        list.insertNodeAtFront(1);
        list.displayList();

        list.head = list.rotate(list.head,3);
        System.out.println();
        list.displayList();
    }


}
