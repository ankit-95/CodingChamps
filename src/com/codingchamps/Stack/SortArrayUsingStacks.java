package com.codingchamps.Stack;

import java.util.Arrays;
import java.util.Stack;

/*Given an array of elements, the task is to sort these elements using a stack.
        Prerequisites: Stacks

        Examples:

        Input :  8 5 7 1 9 12 10
        Output : 1 5 7 8 9 10 12
        Explanation :
        Output is sorted element set

        Input :  7 4 10 20 2 5 9 1
        Output : 1 2 4 5 7 9 10 20*/

/*
* Time Complexity : O(n * n)
* */
public class SortArrayUsingStacks {

    public static Stack<Integer> sortStack(Stack<Integer> s){
        Stack<Integer> tmpStack = new Stack<>();
        while(!s.empty()){
            int temp = s.pop();
            while(!tmpStack.empty() && tmpStack.peek() > temp){
                s.push(tmpStack.pop());
            }
            tmpStack.push(temp);
        }
        return tmpStack;
    }
    public static int[] sortArrayUsingStacks(int ar[]){
        Stack<Integer> input = new Stack<>();
        for(int i=0;i<ar.length;i++){
            input.push(ar[i]);
        }

        Stack<Integer> tmpStack = sortStack(input);
        for(int i=ar.length-1;i>=0;i--){
            ar[i] = tmpStack.pop();
        }
        return ar;
    }
    public static void main(String args[]){
        int arr[] = {8,5,7,1,9,12,10};
        sortArrayUsingStacks(arr);

        Arrays.stream(arr).forEach(e -> System.out.print(e+" "));
    }
}
