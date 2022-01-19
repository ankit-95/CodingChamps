package com.codingchamps.LinkedList;

public class Add1toNumberInLL {
    Node head;
    static int count;
    public static class Node {
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

    public static Node reverseLL(Node head){
        Node current=head;
        Node next;
        Node prev=null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    public static Node addOne(Node head)
    {
        head = reverseLL(head); // O(n)
        Node temp = head;
        int carry = 1;
        int value = 0;
        while(temp.next!=null){
            value = temp.data + carry;
            if(value>=10){
                temp.data = value%10;
                carry = value/10;
            } else {
                temp.data = value;
                carry = 0;
                break;
            }
            temp = temp.next;
        }
        value = temp.data + carry;
        if(value<10){
            temp.data = value%10;
            carry = value/10;
        }
        else{
            temp.data = value%10;
            carry = value/10;
            Node newNode = new Node(carry);
            temp.next = newNode;
        }
        head = reverseLL(head); // O(n)
        return head;
    }
    public static void main(String[] args) {
        Add1toNumberInLL list = new Add1toNumberInLL();
        list.insertNodeAtFront(6);
        list.insertNodeAtFront(5);
        list.insertNodeAtFront(4);

        list.displayList();
        addOne(list.head);
        System.out.print("\nNumber after adding 1 : ");
        list.displayList();

        Add1toNumberInLL list2 = new Add1toNumberInLL();
        list2.insertNodeAtFront(9);
        list2.insertNodeAtFront(9);
        list2.insertNodeAtFront(1);
        System.out.print("\n");
        list2.displayList();
        addOne(list2.head);
        System.out.print("\nNumber after adding 1 : ");
        list2.displayList();
    }
}
