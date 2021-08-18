package com.codingchamps.LinkedList;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class CircularLInkedList {

    Node head;
    CircularLInkedList(){
        head=null;
    }
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    public void insertIntoCLL(int data){
        Node newNode = new Node(data);
        Node temp = head;
        newNode.next = head;
        if(head == null){
            newNode.next = newNode;
        } else {
            while(temp.next != head)
                temp = temp.next;
            temp.next = newNode;
        }
        head = newNode;
    }

    public void displayCLL(){
        Node temp = head;
        if(head!=null){
            do {
                System.out.print(temp.data + "-> ");
                temp = temp.next;
            } while(temp!=head);
        }
    }

    public int countNodesIterative(){
        Node temp = head;
        int count=0;
        if(head!=null){
            do{
                ++count;
                temp = temp.next;
            }while(temp!=head);
        }
        return count;
    }

    public static void main(String args[]){
        CircularLInkedList clist = new CircularLInkedList();
        clist.insertIntoCLL(1);
        clist.insertIntoCLL(2);
        clist.insertIntoCLL(3);
        clist.insertIntoCLL(4);

        clist.displayCLL();
        System.out.print("\nCount of Nodes is : "+clist.countNodesIterative());
    }
}
