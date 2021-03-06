package com.codingchamps.LinkedList;


public class LinkedListDemo {
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
    public void insertNodeAtLast(int data) {
        Node newNode = new Node(data);
        Node temp=this.head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=newNode;
    }

    /*
    To Delete a Given Key, Use two pointer approach .. Iterative Approach
     */
    public void deleteGivenKeyIterative(int data){
        Node temp = this.head;
        Node prev = this.head;
        while(temp!=null && temp.data!=data){
            prev = temp;
            temp=temp.next;
        }
        if(temp==null){
            System.out.print("\nKey Not Found.\n");
        } else {
            prev.next = temp.next;
        }
    }
    /*
    To Delete from given position, Use two pointer approach
     */
    public void deleteFromGivenPosition(int position){
        Node temp = this.head;
        int count=0;
        if(temp!=null && count!=position && position>=0){
            temp = temp.next;
            count++;
        } else {
            System.out.print("\nKey Not Found.\n");
        }
        count++;
        if(count==position)
            temp.next = temp.next.next;
        else
            System.out.print("\nKey Not Found.\n");
    }
    public void deleteLinkedList(){
        if(this.head!=null){
            this.head=null;
        }
    }
    public void displayList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
    }

    /*
    Find Length of LL : Two ways
    1. Iterative
    2. Recursive
    * */

    public int lengthOfLLIterative(){
        int count=0;
        Node temp = this.head;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public int lengthOfLLRecursive(Node temp){
        if(temp==null){
            return 0;
        }
        return 1 + lengthOfLLRecursive(temp.next);
    }

    /*
    Search Element in LL : Two ways
    1. Iterative
    2. Recursive
    * */

    public boolean searchEleIterative(int element){
        Node temp = this.head;
        while(temp!=null){
            if(temp.data == element){
                return  true;
            } else
                temp = temp.next;
        }
        return false;
    }
    public Node searchEleNode(int element){
        Node temp = this.head;
        while(temp!=null){
            if(temp.data == element){
                return  temp;
            } else
                temp = temp.next;
        }
        return null;
    }
    public boolean searchEleRecursive(Node temp,int element){
        if(temp!=null && temp.data == element){
            return true;
        } else if(temp==null){
            return false;
        } else
            return searchEleRecursive(temp.next,element);
    }

    /*
    * Print Middle Element in LL*/

    public int getMiddleElement(){
        Node fast = this.head;
        if(this.head==null)
            return -1;
        Node slow = this.head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    /*
    * Reverse a Linked List*/

    public void reverseLinkedList(){
        Node current = head;
        Node next;
        Node prev = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current = prev;
        head = current;
    }

    static void deleteNode(Node del)
    {
        del.data = del.next.data;
        del.next = del.next.next;
    }

    /*
    Find the Nth Node from the end of LL :
    1. Recursion - T.C - O(n) , Aux Space Complexity - O(n)
    2. Two pointer approach - T.C - O(n) , Aux Space Complexity - O(1)
    * */
    public static void getNthNodeFromEnd(Node right, int position){
       count=0;
        if(right==null){
            return;
        }
        getNthNodeFromEnd(right.next,position);
        if(++count == position){
            System.out.print(right.data);
        }
    }
    public void getNthNodeFromEnd2Pointer(int position){
        int count=0;
        Node mark = head;
        Node ref = head;
        if(head!=null) {
            while (count < position) {
                if (count == position) {
                    break;
                }
                ref = ref.next;
                count++;
            }
            if (ref == null) {
                if (head != null) {
                    System.out.print("\nNode is : " + head.data);
                }
            } else {
                while (ref != null) {
                    mark = mark.next;
                    ref = ref.next;
                }
                System.out.print("\nNode is : " + mark.data);
            }
        }
    }
    /*
    Move Last Element to Front in LL
    1. Iterative Approach
    * */
    public void moveLast2FrontIterative(){
        Node temp = head;
        Node prev = head;
        while(temp!=null && temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        temp.next = head;
        head = temp;
        prev.next = null;
    }

    /*
    * Swap nodes in LL without swapping data*/

    public void swapNodesInLL(int x,int y){
        if(x==y){
            return;
        }
        // Search for x (keep track of prevX and CurrX)
        Node prevX=null,currX=head;
        while(currX!=null && currX.data !=x){
           prevX = currX;
           currX = currX.next;
        }
        // Search for y (keep track of prevY and currY)
        Node prevY=null,currY=head;
        while(currY!=null && currY.data !=y){
            prevY = currY;
            currY = currY.next;
        }
        // If either x or y is not present, nothing to do
        if(currX==null || currY==null)
            return;

        // If x is not head of linked list
        if(prevX!=null){
            prevX.next = currY;
        } else{ //make y as new head
            head = currY;
        }
        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    public static Node findMiddleElement(Node temp){
        Node slow = temp;
        Node fast = temp;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    Node deleteMid(Node head) {
        // This is method only submission.
        // You only need to complete the method.
        if(head ==null)
            return null;
        if(head.next!=null && head.next.next==null){
            head.next = null;
            return head;
        }
        Node middle = findMiddleElement(head);
        if(middle!=null && middle.next!=null){
            middle.data = middle.next.data;
            middle.next = middle.next.next;
        } else {
            head=null;
        }
        return head;
    }

    public static void main(String args[]) {
        LinkedListDemo list = new LinkedListDemo();
        list.insertNodeAtFront(5);
        list.insertNodeAtFront(6);
        list.insertNodeAtFront(7);
        list.insertNodeAtFront(8);
        list.insertNodeAtLast(1);
        list.insertNodeAtFront(6);
        list.insertNodeAtFront(10);
        list.insertNodeAtFront(11);
        list.displayList();
        System.out.print("\n");
        list.deleteGivenKeyIterative(7);
        list.displayList();
        System.out.print("\n deleteFromGivenPosition : ");
        list.deleteFromGivenPosition(2);
        list.displayList();
        System.out.print("\n");
        list.deleteFromGivenPosition(10);
        list.displayList();
        System.out.print("\nLinkedList Length (Iterative) : "+list.lengthOfLLIterative());
        System.out.print("\nLinkedList Length (Recursive) : "+list.lengthOfLLRecursive(list.head));
        System.out.print("\nSearch Element in LinkedList (Iterative) : "+list.searchEleIterative(1));
        System.out.print("\nSearch Element in LinkedList (Recursive) : "+list.searchEleRecursive(list.head,6));
        System.out.print("\nMiddle Element in LinkedList : "+list.getMiddleElement());
        /*System.out.print("\nLinkedList After Deletion : ");
        list.deleteLinkedList();
        list.displayList();*/
        list.reverseLinkedList();
        System.out.print("\nReversed Linked List :");
        list.displayList();
        System.out.print("\nFind Element from End :");
        list.getNthNodeFromEnd(list.head,2);
        list.getNthNodeFromEnd2Pointer(2);
        System.out.print("\nList : ");
        list.displayList();
        list.moveLast2FrontIterative();
        System.out.print("\nList : ");
        list.displayList();
        list.swapNodesInLL(1,8);
        System.out.print("\nAfter Swapping List is  : ");
        list.displayList();

        Node delete = list.searchEleNode(8);
        list.deleteNode(delete);
        System.out.print("\nList After deleting 8  is  : ");
        list.displayList();

        list.deleteMid(list.head);
        System.out.print("\nList After deleting middle element is  : ");
        list.displayList();
    }
}
