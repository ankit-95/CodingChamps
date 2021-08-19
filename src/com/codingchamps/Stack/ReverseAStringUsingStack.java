package com.codingchamps.Stack;

import java.util.Stack;

public class ReverseAStringUsingStack {
    Stack<Character> s;
    public void reverse(Stack s, String input){
        if(input.equals("")){
            return;
        } else{
            s.push(input.substring(0,1));
            reverse(s,input.substring(1));
        }
    }
    public String reverseStringUsingStack(String input){
       s  = new Stack<>();
       reverse(s,input);
       input="";
       while (!s.empty()){
           input +=s.pop();
       }
        return input;
    }
    public static void main(String args[]){

        ReverseAStringUsingStack revString = new ReverseAStringUsingStack();
        System.out.println("Reverse String using Stack : " + revString.reverseStringUsingStack("ankit"));

    }
}
