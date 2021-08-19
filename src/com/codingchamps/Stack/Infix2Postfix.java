package com.codingchamps.Stack;

import java.util.Stack;

/*
* Input :  a + (b * d) + c
* Output : abc*+d+
* */
public class Infix2Postfix {

    public static int  getPrecedence(char operator){
        int precedence;
        switch(operator){
            case '^' : precedence = 3; break;
            case '/' : precedence = 2; break;
            case '*' : precedence = 2; break;
            case '+' : precedence = 1; break;
            case '-' : precedence = 1; break;
            default: precedence = -1;
        }
        return  precedence;
    }
    public static void main(String args[]){

        Stack<Character> s = new Stack<>();
        //String infix = "a+(b*c)+d";
        String infix = "A*(B+C)/D";

        for(int i=0;i<infix.length();i++){
            if(Character.isLetterOrDigit(infix.charAt(i))){
                System.out.print(infix.charAt(i));
            }
            else if(infix.charAt(i)=='('){
                s.push('(');
            } else if (infix.charAt(i)==')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    System.out.print(s.pop());
                }
                s.pop();
            }
            else {
                while(!s.isEmpty() && getPrecedence(infix.charAt(i)) <= getPrecedence(s.peek())){
                    System.out.print(s.pop());
                }
                s.push(infix.charAt(i));
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop());
        }
    }
}
