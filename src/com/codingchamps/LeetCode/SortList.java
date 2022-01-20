package com.codingchamps.LeetCode;
public class SortList {
    Node head;
    public static class Node {
        int data;
        Node next;
        Node(int data){
          this.data = data;
          next = null;
        }
    }

    SortList(){
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
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


    public Node getMiddle(Node head){
          Node midPrev = null;
          while(head!=null && head.next!=null){
              midPrev = (midPrev==null)?head:midPrev.next;
              head = head.next.next;
          }
          Node mid = midPrev.next;
          midPrev.next = null;
          return mid;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next==null)
            return head;

        Node middle = getMiddle(head);
        Node left = mergeSort(head);
        Node right = mergeSort(middle);
        return mergeLL(left,right);
    }
    public Node mergeLL(Node l1, Node l2){
        Node dummy = new Node(0);
        Node tail = dummy;
        while(l1!=null && l2!=null){
            if(l1.data< l2.data){
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1!=null) ? l1 : l2;
        return dummy.next;
    }
    public static void main(String[] args) {
        SortList list = new SortList();
        list.insertFront(3);
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(4);

        //list.display();
        //System.out.println("\nMiddle is :" + list.getMiddle(list.head).data);
        list.head = list.mergeSort(list.head);
        list.display();

    }

}
