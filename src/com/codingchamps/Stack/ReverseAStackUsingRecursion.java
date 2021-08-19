package com.codingchamps.Stack;

import java.util.Iterator;
import java.util.Stack;

public class ReverseAStackUsingRecursion {

    Stack<Integer> s;

    ReverseAStackUsingRecursion(){
        s = new Stack<>();
    }

    public void addEle(int data){
        s.push(data);
    }

    public void insert_at_bottom(int x){
        if(s.isEmpty()){
            s.push(x);
        } else {
            int a = s.pop();
            insert_at_bottom(x);

            s.push(a);
        }
    }

    public void reverseStack(){
        if(s.empty()){
           return;
        }
        int x = s.pop();
        reverseStack();
        insert_at_bottom(x);
    }

    public int getTop(){
        return s.peek();
    }
    public static void main(String args[]){
        ReverseAStackUsingRecursion stack = new ReverseAStackUsingRecursion();
        stack.addEle(1);
        stack.addEle(2);
        stack.addEle(3);
        stack.addEle(4);
        stack.reverseStack();

        System.out.println("Top Element : " + stack.getTop());

        Iterator itr = stack.s.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+"-->");
        }
    }
}
