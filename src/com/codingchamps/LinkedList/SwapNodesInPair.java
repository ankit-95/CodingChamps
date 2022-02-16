package com.codingchamps.LinkedList;


// Lik : https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPair {

    Node head;

    public static class  Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    SwapNodesInPair(){
        head = null;
    }

    public void insert(int data){
        Node newNode = new Node(data);
        if(head == null)
             head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public Node swapPairs(Node head) {
        if(head==null)
            return head;
        if(head!=null && head.next==null)
            return head;
        Node prev = head;
        Node nextNode = head.next;
        Node temp = null;
        Node newHead = head.next;
        while(nextNode!=null){
            prev.next = nextNode.next;
            nextNode.next = prev;
            if(temp!=null)
                temp.next = nextNode;
            temp = prev;
            prev = prev.next;
            nextNode = (prev!=null) ? prev.next : null;
        }
        return newHead;
    }

    public static void main(String[] args) {
        SwapNodesInPair list = new SwapNodesInPair();
        list.insert(6);
        list.insert(5);
        list.insert(4);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        list.display();

        list.head = list.swapPairs(list.head);
        System.out.println("\nSwapped List is : ");
        list.display();
    }
}
