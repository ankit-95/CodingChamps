package com.codingchamps.LinkedList;

import java.util.Iterator;
import java.util.Stack;

public class QueueUsingStack {
    Stack s1 = new Stack();
    Stack s2 = new Stack();

    public void enqueue(int data){
            s1.push(data);
    }

    public int dequeue(){
        if(s1.isEmpty()){
            return -1;
        }
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        int remove = (int)s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return remove;
    }

    public void display(){
        Iterator itr = s1.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+"->");
        }
    }
    public static void main(String args[]) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.enqueue(2);
        queue.enqueue(4);
        queue.enqueue(6);
        queue.enqueue(8);

        queue.display();
        System.out.print("\nDequeue : " + queue.dequeue());
        System.out.print("\nDequeue : " + queue.dequeue());
        System.out.print("\nDequeue : " + queue.dequeue());
        System.out.print("\nDequeue : " + queue.dequeue());
        System.out.print("\nDequeue : " + queue.dequeue());

    }
}
