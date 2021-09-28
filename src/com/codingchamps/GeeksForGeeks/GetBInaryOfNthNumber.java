package com.codingchamps.GeeksForGeeks;

import java.util.Stack;

public class GetBInaryOfNthNumber {

    Stack<Integer> s;

    public void insert_at_bottom(int x){
        if(s.isEmpty()){
            s.push(x);
        } else {
            int a = s.pop();
            insert_at_bottom(x);

            s.push(a);
        }
    }
    public static void main(String[] args) {

        GetBInaryOfNthNumber g = new GetBInaryOfNthNumber();
        for(int i=1;i<=10;i++){
            int val = i;
            int n = i;
            g.s = new Stack<>();
            while(n>0){
                g.insert_at_bottom(n%2);
                n = n/2;
            }
            System.out.println(g.s);
        }
    }
}