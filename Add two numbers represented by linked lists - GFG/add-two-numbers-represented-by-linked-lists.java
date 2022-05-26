// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node reverse(Node head){
        Node current = head;
        Node prev = null;
        Node next = null;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        
        Node firstR = reverse(first);
        Node secondR = reverse(second);
        Node dummy = new Node(-1);
        Node temp = dummy;
        
        // display(firstR);
        // System.out.print("\n");
        // display(secondR);
        
        int carry = 0;
        while(firstR!=null && secondR!=null){
            
            int sum = firstR.data + secondR.data + carry;
            
            carry = sum / 10;
            
            Node newNode = new Node(sum%10);
            temp.next = newNode;
            temp = temp.next;
            firstR = firstR.next;
            secondR = secondR.next;
        }
        
        while(firstR!=null){
            int sum = firstR.data + carry;
            carry = sum/10;
            Node newNode = new Node(sum%10);
            temp.next = newNode;
            temp = temp.next;
            firstR = firstR.next;
            
        }
        
        while(secondR!=null){
            int sum = secondR.data + carry;
            carry = sum/10;
            Node newNode = new Node(sum%10);
            temp.next = newNode;
            temp = temp.next;
            secondR = secondR.next;
        }       
        
        if(carry!=0){
            Node newNode = new Node(carry);
            temp.next = newNode;
            temp = temp.next;
        }
        Node result = dummy.next;
        
        result = reverse(result);
         // System.out.print("\n");
        return result;
    }
}