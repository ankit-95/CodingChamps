package com.codingchamps.LinkedList;

public class MergeSortLL {

    Node head;
    MergeSortLL(){
        head=null;
    }
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }

    public void insertIntoLL(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public static void display(Node temp){
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    public static Node mergeSort(Node h){

        if(h.next == null)
            return h;

        Node middle = getMiddle(h);
        Node middleNext = middle.next;
        middle.next = null;
        Node left = mergeSort(h);
        Node right = mergeSort(middleNext);
        Node result = mergeLL(left,right);
        return result;
    }

    public static Node mergeLL(Node list1,Node list2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        Node l1 = list1;
        Node l2 = list2;
        while (true) {
            if (l1 == null) {
                tail.next = l2;
                break;
            }
            if (l2 == null) {
                tail.next = l1;
                break;
            }
            if (l1.data <= l2.data) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    private static Node getMiddle(Node h) {
        Node slow = h;
        Node fast = h.next;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]){

        Node head = new Node(7);
        Node temp = head;
        temp.next = new Node(10);
        temp = temp.next;
        temp.next = new Node(5);
        temp = temp.next;
        temp.next = new Node(20);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;

        // Apply merge Sort
        head = mergeSort(head);
        System.out.print("\nSorted Linked List is: \n");
        display(head);
    }
}
