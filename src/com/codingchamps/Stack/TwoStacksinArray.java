package com.codingchamps.Stack;

/*
Create a data structure twoStacks that represents two stacks. Implementation of twoStacks should use only one array, i.e., both stacks should use the same array for storing elements. Following functions must be supported by twoStacks.
push1(int x) –> pushes x to first stack
push2(int x) –> pushes x to second stack
pop1() –> pops an element from first stack and return the popped element
pop2() –> pops an element from second stack and return the popped element
Implementation of twoStack should be space efficient.

Approach : Divide and Conquer
 */
public class TwoStacksinArray {

    int arr[];
    int len1;
    int len2;
    TwoStacksinArray(int size){
        arr = new int[size];
        len1 = 0;
        len2 = size/2;
    }

    public void push1(int data){
        if(len1 == (arr.length/2)){
            System.out.println("Overflow");
            return;
        }
        arr[len1] = data;
        len1++;
    }
    public void push2(int data){
        if(len2 == (arr.length)){
            System.out.println("Overflow");
            return;
        }
        arr[len2] = data;
        len2++;
    }

    public int pop1(){
        if(len1<0){
            System.out.println("UnderFlow");
            return -1;
        }
        len1 = len1 -1;
        int remove = arr[len1];
        return remove;
    }

    public int pop2(){
        if(len2<(arr.length/2)){
            System.out.println("UnderFlow");
            return -1;
        }
        len2 = len2 -1;
        int remove = arr[len2];
        return remove;
    }

    public void display1(){
        for(int i=0;i<len1;i++){
            System.out.print(arr[i]+"-> ");
        }
    }
    public void display2(){
        for(int i=arr.length/2;i<len2;i++){
            System.out.print(arr[i]+"-> ");
        }
    }
    public static void main(String args[]){
        TwoStacksinArray stacks = new TwoStacksinArray(5);
        stacks.push1(1);
        stacks.push1(2);
        stacks.push2(3);
        stacks.push2(4);
        stacks.push2(5);
        stacks.pop1();
        stacks.pop2();
        System.out.println(" Len1 "+ stacks.len1 +" and Len2 "+ stacks.len2);
        System.out.print("\nStack1 :");
        stacks.display1();
        System.out.print("\nStack2 :");
        stacks.display2();
    }
}
