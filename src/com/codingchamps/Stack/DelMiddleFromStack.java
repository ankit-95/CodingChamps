package com.codingchamps.Stack;

import java.util.Stack;

public class DelMiddleFromStack {

    public static void deleteMiddleElement(Stack<Integer> s,int size,int current){
        if(s.empty()){
            return;
        }
        int x = s.pop();
        deleteMiddleElement(s,size,current+1);
        if(current != size/2){
            s.push(x);
        }
    }
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        deleteMiddleElement(stack, stack.size(),0);

        System.out.println(stack);

    }
}
