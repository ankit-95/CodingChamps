package com.codingchamps.LinkedList;

public class MergeLL {
    Node head;

    MergeLL() {
        head = null;
    }

    public class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public void insertIntoLL(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }
    }

    public void displayLL(Node temp) {
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }

    public MergeLL naiveMerge(Node list1, Node list2) {
        Node l1 = list1;
        Node l2 = list2;
        MergeLL result = new MergeLL();
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                result.insertIntoLL(l1.data);
                l1 = l1.next;
            } else {
                result.insertIntoLL(l2.data);
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            result.insertIntoLL(l1.data);
            l1 = l1.next;
        }
        if (l2 != null) {
            result.insertIntoLL(l2.data);
            l2 = l2.next;
        }

        return result;
    }

    public Node mergeLL(Node list2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        Node l1 = this.head;
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

    public Node SortedMerge(Node A, Node B) {

        if (A == null) return B;
        if (B == null) return A;

        if (A.data < B.data) {
            A.next = SortedMerge(A.next, B);
            return A;
        } else {
            B.next = SortedMerge(A, B.next);
            return B;
        }
    }

    public static void main(String args[]) {
        MergeLL list1 = new MergeLL();
        list1.insertIntoLL(15);
        list1.insertIntoLL(10);
        list1.insertIntoLL(5);

        System.out.println("List1 is : ");
        list1.displayLL(list1.head);

        MergeLL list2 = new MergeLL();
        list2.insertIntoLL(20);
        list2.insertIntoLL(3);
        list2.insertIntoLL(2);

        System.out.println("\nList2 is : ");
        list2.displayLL(list2.head);

        /*MergeLL result = list1.naiveMerge(list1.head,list2.head);

        System.out.println("\nMerged is : ");
        result.displayLL(result.head);*/

        /*list1.head = list1.mergeLL(list2.head);
        System.out.println("\nMerged(Imporved) is : ");
        list1.displayLL(list1.head);*/

        list1.head = list1.SortedMerge(list1.head,list2.head);
        System.out.println("\nMerged(Imporved) is : ");
        list1.displayLL(list1.head);
    }
}
