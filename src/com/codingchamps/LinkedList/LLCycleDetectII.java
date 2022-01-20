package com.codingchamps.LinkedList;

import com.codingchamps.Practice.LL;

// Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
// Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed).
// It is -1 if there is no cycle. Note that pos is not passed as a parameter.
//Do not modify the linked list.
// Link : https://leetcode.com/problems/linked-list-cycle-ii/

public class LLCycleDetectII {
    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
        }
    }

    LLCycleDetectII(){
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

    public void insertAtIndex(int data,int index){
        Node temp = head;
        int count=1;
        while(temp!=null && count<index){
            count++;
            temp  = temp.next;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public Node insertRec(Node temp, int data, int index){
        if(index==0){
            Node newNode = new Node(data);
            newNode.next = temp;
            return newNode;
        }
        temp.next = insertRec(temp.next,data,index-1);
        return temp;
    }

    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
    }

    public void makeCyle(){
        Node last = head;
        while(last.next!=null){
            last = last.next;
        }
        Node temp = head.next.next.next;
        //System.out.println(temp.data);
        last.next = temp;
    }

    private int length(Node n){
        int count=1;
        Node temp = n.next;
        while(temp!=n){
            count++;
            temp = temp.next;
        }
        return count;
    }

    private Node detectCycle() {
        Node slow = head;
        Node fast = head;
        int len = 0;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                len = length(slow);
                break;
            }
        }

        if(len==0)
            return null;

        Node first = head;
        Node second = head;
        while(len >0){
            len--;
            second = second.next;
        }

        while(second!=first){
            second = second.next;
            first = first.next;
        }
        return first;
    }
    public static void main(String[] args) {
        LLCycleDetectII list = new LLCycleDetectII();
        list.insertFront(8);
        list.insertFront(7);
        list.insertFront(6);
        list.insertFront(5);
        list.insertFront(4);
        list.insertFront(3);
        list.insertFront(2);
        list.insertFront(1);

        //list.insertAtIndex(10,3);
        //list.insertRec(list.head,11,2);
        list.makeCyle();
        System.out.println(list.detectCycle().data);
        //list.display();
    }
}
