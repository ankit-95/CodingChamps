package com.codingchamps.Stack;

import java.util.Stack;

public class ReverseIndividualWords {

    public static String reverseIndividualWords(String s){
        Stack<Character> stack = new Stack<>();
        String result ="";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if(s.charAt(i)==' '){
                while(!stack.isEmpty()){
                    result += stack.pop();
                }
                result +=' ';
                continue;
            }
        }
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
    public static void main(String args[]){
        String s = "Hello World";
        System.out.println(reverseIndividualWords(s));
    }
}
