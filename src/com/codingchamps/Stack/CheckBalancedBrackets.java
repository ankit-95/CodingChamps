package com.codingchamps.Stack;

import java.util.Stack;

public class CheckBalancedBrackets {

    public static void main(String args[]){

        String exp = "[()]{}{[()()]()}";

        System.out.println("Balanced or Not : " + checkBalancedOrNot(exp));
    }

    private static boolean checkBalancedOrNot(String exp) {

        Stack<Character> s = new Stack<>();
        for(int i=0;i<exp.length();i++){
            if(exp.charAt(i) == '(' || exp.charAt(i) == '{' || exp.charAt(i) == '['){
                s.push(exp.charAt(i));
                continue;
            } else if (s.empty()){
                return false;
            }
            else {
                char x = exp.charAt(i);
                switch (x){
                    case '}' : if(s.peek()!='{') return false; else s.pop(); break;
                    case ']' : if(s.peek()!='[') return false; else s.pop(); break;
                    case ')' : if(s.peek()!='(') return false; else s.pop(); break;
                }
            }
        }
        return s.empty();
    }
}
