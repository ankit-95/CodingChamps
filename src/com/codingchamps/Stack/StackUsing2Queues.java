package com.codingchamps.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queues {

    Queue<Integer> q1;
    Queue<Integer> q2;

    StackUsing2Queues(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int data){

        q2.add(data);

        while(!q1.isEmpty()){
            q2.add(q1.peek());
            q1.remove();
        }

        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    public int pop(){
        if(q1.isEmpty())
            return -1;
        int remove = q1.peek();
        q1.remove();
        return remove;
    }

    public int top(){
        return q1.peek();
    }
    public static void main(String args[]){

        StackUsing2Queues stack = new StackUsing2Queues();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top is : "+ stack.top());
        stack.pop();
        System.out.println("Top is : "+ stack.top());

    }
}
