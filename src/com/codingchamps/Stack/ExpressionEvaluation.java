package com.codingchamps.Stack;

import java.util.Stack;

public class ExpressionEvaluation {

    Stack<Integer> operands;
    Stack<Character> operators;
    public int getPrecedence(Character c){
        switch(c){
            case '^' : return 3;
            case '/' : return 2;
            case '*' : return 2;
            case '+' : return 1;
            case '-' : return 1;
        }
        return -1;
    }

    public int applyOp(Character op, int a,int b){
        switch(op){
            case '^' : return  a ^ b;
            case '/' : return a/b;
            case '*' : return a*b;
            case '+' : return a+b;
            case '-' : return a-b;
        }
        return 0;
    }
    public void evaluateExpression(String s){
        operators = new Stack<>();
        operands = new Stack<>();
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==' '){ // Handle spaces
                continue;
            }
            if(Character.isLetterOrDigit(s.charAt(i))){ // Letter or Digit Case
                StringBuffer sbuf = new
                        StringBuffer();
                while(i<s.length() && Character.isLetterOrDigit(s.charAt(i))){
                    sbuf.append(s.charAt(i));
                    i++;
                }
                i--;
                operands.push(Integer.parseInt(sbuf.toString()));
            } else if(s.charAt(i)=='('){ // Open Bracket Case
                operators.push(s.charAt(i));
            }else if (s.charAt(i)==')'){ // Close Bracket Case
                while(!operators.empty() && operators.peek()!='('){
                    Integer op2 = operands.pop();
                    Integer op1 = operands.pop();
                    Integer result = applyOp(operators.pop(),op1,op2);
                    operands.push(result);
                }
                operators.pop();
            } else { // Decide Precedence of Operators
                while(!operators.empty() && getPrecedence(s.charAt(i)) <=getPrecedence(operators.peek())){
                    Integer op2 = operands.pop();
                    Integer op1 = operands.pop();
                    Integer result = applyOp(operators.pop(),op1,op2);
                    operands.push(result);
                }
                operators.push(s.charAt(i));
            }
        }

        while(!operators.empty()){
            Integer op2 = operands.pop();
            Integer op1 = operands.pop();
            Integer result = applyOp(operators.pop(),op1,op2);
            operands.push(result);
        }
    }
    public static void main(String args[]){
        String s1 = "10 + 2 * 6";
        String s2 = "100 * 2 + 12";
        String s3 = "100 * ( 2 + 12 )";
        String s4 = "100 * ( 2 + 12 ) / 14";

        ExpressionEvaluation exp = new ExpressionEvaluation();
        exp.evaluateExpression(s1);
        System.out.println(exp.operands.peek());
        exp.evaluateExpression(s2);
        System.out.println(exp.operands.peek());
        exp.evaluateExpression(s3);
        System.out.println(exp.operands.peek());
        exp.evaluateExpression(s4);
        System.out.println(exp.operands.peek());

    }
}
