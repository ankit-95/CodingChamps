package com.codingchamps.LinkedList;

public class LengthOfLoopLL {

    Node head;
    LengthOfLoopLL(){
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
    public void insertIntoList(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void displayLiat(){
        Node temp = this.head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
    }
    public  int findCount(Node n){
        int count=1;
        Node temp = n;
        while(temp.next!=n){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int detectLoop(){
        Node slow = this.head;
        Node fast = this.head;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                return findCount(slow);
            }
        }
        return 0;
    }
    public static void main(String args[]){
        LengthOfLoopLL list =  new LengthOfLoopLL();
        list.insertIntoList(20);
        list.insertIntoList(4);
        list.insertIntoList(15);
        list.insertIntoList(10);
        list.displayLiat();
        list.head.next.next.next.next = list.head;
        System.out.println("\nDetect Loop (2 pointer Approach) : "+ list.detectLoop());
    }
}
