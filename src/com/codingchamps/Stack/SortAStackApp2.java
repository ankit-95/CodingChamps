package com.codingchamps.Stack;

import java.util.Stack;

public class SortAStackApp2 {
    static Stack<Integer> s;
    SortAStackApp2(){
        s = new Stack<>();
    }
    public static void insert_at_bottom(int x){
        if(s.empty()){
            s.push(x);
        } else {
            int a = s.pop();
            if(a < x){
                insert_at_bottom(a);
                s.push(x);
            } else {
                insert_at_bottom(x);
                s.push(a);
            }
        }
    }
    public static void sortStackAsc(){
        if(s.empty())
            return;
        int x = s.pop();
        sortStackAsc();
        insert_at_bottom(x);
    }
    public static void main(String args[]) {
        SortAStackApp2  c = new SortAStackApp2();
        c.s.push(-3);
        c.s.push(14);
        c.s.push(18);
        c.s.push(-5);
        c.s.push(30);
        c.sortStackAsc();
        System.out.println(c.s);
    }
}
