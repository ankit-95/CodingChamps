package com.codingchamps.Stack;

import java.util.Stack;

/*Given a stack of integers, sort it in descending order using another temporary stack.

        Examples:

        Input : [34, 3, 31, 98, 92, 23]
        Output : [3, 23, 31, 34, 92, 98]

        Input : [3, 5, 1, 4, 2, 8]
        Output : [1, 2, 3, 4, 5, 8]
        */
public class SortAStackApp1 {

    public static Stack sortStack(Stack<Integer> s) {
        Stack<Integer> s2 = new Stack<>();
        while (!s.empty()) {
            int temp = s.pop();
            while (!s2.empty() && (s2.peek() > temp)) {
                s.push(s2.pop());
            }
            s2.push(temp);
        }
        return s2;
    }
    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        Stack s = sortStack(stack);
        System.out.println(s);
    }
}
