package com.codingchamps.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingSingleQueue {

    Queue<Integer> queue;

    StackUsingSingleQueue() {
        queue = new LinkedList<>();
    }

    public void push(int data) {
        if (queue.isEmpty()) {
            queue.add(data);
        } else {
            int size = queue.size();
            queue.add(data);
            for (int i = 0; i < size; i++) {
                int x = queue.remove();
                queue.add(x);
            }
        }
    }

    public int pop(){
        if(queue.isEmpty()){
            return -1;
        } else {
            return queue.remove();
        }
    }

    public int top(){
        if(!queue.isEmpty())
            return queue.peek();
        else return -1;
    }

    public static void main(String args[]){
        StackUsingSingleQueue stack = new StackUsingSingleQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.println("Top Element : " + stack.top());

        stack.pop();

        System.out.println("Top Element : " + stack.top());
    }
}


