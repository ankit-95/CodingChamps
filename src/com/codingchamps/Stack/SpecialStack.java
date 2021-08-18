package com.codingchamps.Stack;

/*
Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack
must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays,
list, . etc.
* */

import java.util.Iterator;
import java.util.Stack;

public class SpecialStack extends Stack<Integer> {

    Stack<Integer> aux;

    SpecialStack(){
        super();
        aux = new Stack<>();
    }
    void push(int data){
        if(super.isEmpty()){
            super.push(data);
            aux.push(data);
        } else {
            int temp = aux.peek();
            if(temp <= data){
                aux.push(temp);
            } else {
                aux.push(data);
            }
            super.push(data);
        }
    }

    public Integer pop(){
        int remove =  super.pop();
        aux.pop();
        return remove;
    }

    public int getMin(){
        int min = aux.peek();
        return min;
    }

    public void display(){
        Iterator itr = super.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+"-> ");
        }
    }
    public static void main(String args[]){
        SpecialStack stack = new SpecialStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        System.out.print("Stack : ");
        stack.display();
        System.out.print("\nAux Stack : ");
        Iterator itr = stack.aux.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+"-> ");
        }

        System.out.print("\nPopped Element : "+ stack.pop());
        System.out.print("\nMinimum Element : "+ stack.getMin());
    }
}
