package com.codingchamps.LinkedList;

import java.util.HashSet;
import java.util.LinkedList;

public class DetectLoopInLL {

    Node head;
    public class Node{
        int data;
        Node next;
        int flag;
        Node(int data){
            this.data = data;
            next = null;
            flag=0;
        }
    }

    public void insertIntoList(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void displayList(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+ "-> ");
            temp =temp.next;
        }
    }

    /*
     * Detect Loop in LL
     * 1. Using Two Pointer Approach , T.C=O(n), A.S.C = O(1) (Floyd’s Cycle-Finding Algorithm )
     * 2. Using Extra Info in Linked List, T.C = O(n)
     * 3. Using HashSet,T.C=O(n), A.S.C = O(n)
     * */

    public boolean detectLoop2Pointer(){
        Node slow = head;
        Node fast = head;
        int flag = 0;
        while(slow!=null && fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = 1;
                break;
            }
        }
        return (flag ==1);
    }

    public boolean detectLoopinLLUsingExtrainfo(){
        Node temp = head;
        while(temp!=null){
            // If this node is already traverse
            // it means there is a cycle
            // (Because you we encountering the
            // node for the second time).
            if(temp.flag==1)
                return true;
            // If we are seeing the node for
            // the first time, mark its flag as 1
            temp.flag=1;
            temp = temp.next;
        }
        return false;
    }

    public boolean detectLoopUsingHashSet(){
        HashSet<Node> set = new HashSet<>();
        Node temp = head;
        while(temp!=null){
            // If we have already has this node
            // in hashmap it means their is a cycle
            // (Because you we encountering the
            // node second time).
            if(set.contains(temp)){
                return true;
            }
            // If we are seeing the node for
            // the first time, insert it in hash
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
    public static void main(String args[]){
        DetectLoopInLL list =  new DetectLoopInLL();
        list.insertIntoList(20);
        list.insertIntoList(4);
        list.insertIntoList(15);
        list.insertIntoList(10);
        list.displayList();
        list.head.next.next.next.next = list.head;
        System.out.println("\nDetect Loop (2 pointer Approach) : "+ list.detectLoop2Pointer());
        System.out.println("\nDetect Loop (Extra Info) : "+ list.detectLoopinLLUsingExtrainfo());
        System.out.println("\nDetect Loop (HashSet) : "+ list.detectLoopUsingHashSet());
    }
}
