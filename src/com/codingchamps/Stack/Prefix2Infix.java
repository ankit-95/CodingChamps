package com.codingchamps.Stack;

import java.util.Stack;

public class Prefix2Infix {

    public static boolean isOperator(char c){
        switch (c){
            case '+' : return true;
            case '-' : return true;
            case '/' : return true;
            case '*' : return true;
            case '^' : return true;
        }
        return  false;
    }
    public static void main(String args[]){
        Stack<String> stack = new Stack<>();
        String s = "++a*bcd";

        for(int i=s.length()-1;i>=0;i--){
            if(Character.isLetterOrDigit(s.charAt(i))){
                stack.push(String.valueOf(s.charAt(i)));
            } else if(isOperator(s.charAt(i))){
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push( op1 + String.valueOf(s.charAt(i)) + op2);
            }
        }

        System.out.println("Prefix to Infix : " + stack.peek());
    }
}
