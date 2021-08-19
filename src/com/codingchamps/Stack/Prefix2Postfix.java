package com.codingchamps.Stack;

import java.util.Stack;

public class Prefix2Postfix {
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

        String s = "++a*bcd";

        Stack<String> stack = new Stack<>();

        for(int i = s.length()-1;i >=0;i--){
            if(Character.isLetterOrDigit(s.charAt(i))){
                stack.push(String.valueOf(s.charAt(i)));
            } else if(isOperator(s.charAt(i))){
                String op1 = stack.pop();
                String op2 = stack.pop();

                stack.push( op1 + op2 + String.valueOf(s.charAt(i)));
            }
        }

        System.out.println("Prefix to Postfix : " + stack.peek());
    }
}
