package com.codingchamps.Stack;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.Stack;

/*
Question: Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(), isFull()
and an additional operation getMin() which should return minimum element from the SpecialStack. All these operations of SpecialStack
must be O(1). To implement SpecialStack, you should only use standard Stack data structure and no other data structure like arrays,
list, . etc.
* *
Time Complexity - O(1) for each operation i.e push,pop and getMin

Aux Space Complexity - O(1)

Push Approach (x):
 1. if stack is empty,
    minEle = x, push(x)
    if stack is not Empty,
        1. if x < minEle , push(2 * x - minEle) , minEle = x
        2. if x > minEle , push (x)
Pop Approach (y):
1. if y < minEle, original Element is minEle , minEle = (2 * minEle - y);
2. if y > minEle , pop(y)

Note : minEle always contains minElement
/
 */
public class SpecialStackApproach2 extends Stack<Integer> {

    Integer minEle = Integer.MAX_VALUE;
    SpecialStackApproach2(){
        super();
        minEle =0;
    }
    public void push(int data){
        if(isEmpty()){
            super.push(data);
            minEle = data;
        } else {
            if( data < minEle){
                super.push( (2 * data) - minEle);
                minEle = data;
            } else {
                super.push(data);
            }
        }
    }

    public Integer pop(){
        int y = super.peek();
        int remove = 0;
        if(y < minEle){
            remove = minEle;
            minEle = (2 * minEle) - y;
        } else {
            remove = y;
        }
        super.pop();
        return remove;
    }

    public int getMin(){
        return minEle;
    }

    public void displayStack(){
        Iterator itr = super.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next()+"-> ");
        }

    }
    public static void main(String args[]){

        SpecialStackApproach2 stack = new SpecialStackApproach2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.displayStack();

        System.out.print("\nPopped Element : "+ stack.pop());

        System.out.print("\nMinimum Element : "+ stack.getMin());

    }
}
