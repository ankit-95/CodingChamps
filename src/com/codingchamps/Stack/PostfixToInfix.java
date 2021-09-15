package com.codingchamps.Stack;

import java.util.Stack;

public class PostfixToInfix {

    public static boolean isOperator(char ch){
        switch (ch){
            case '^': return true;
            case '+':return true;
            case '-':return true;
            case '/':return true;
            case '*': return true;
        }
        return false;
    }
    public static void main(String args[]){

        Stack<String>  stack = new Stack<>();

        String s = "abc*+d+";
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                stack.push(String.valueOf(s.charAt(i)));
            }
            else if(isOperator(s.charAt(i))){
                String op2 = stack.pop();
                String op1 = stack.pop();

                String result = op1 + String.valueOf(s.charAt(i)) + op2;
                stack.push(result);
            }
        }
        System.out.println("Postfix to Infix : " + stack.peek());
    }
}
