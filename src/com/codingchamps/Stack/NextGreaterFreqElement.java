package com.codingchamps.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterFreqElement {

    HashMap<Integer,Integer> map;

    public NextGreaterFreqElement(){
        map = new HashMap<>();
    }

    public void calFreq(int ar[]){

        for(int i=0;i<ar.length;i++){
            if(map.containsKey(ar[i])){
                int count = map.get(ar[i]);
                count++;
                map.put(ar[i],count);
            } else {
                map.put(ar[i],1);
            }
        }
    }

    public void ngefref(int ar[], int s[]){
        Stack<Integer> stack = new Stack<>();

        for(int i=ar.length-1;i>=0;i--){

            while(!stack.empty() && map.get(stack.peek()) <= map.get(ar[i])){
                stack.pop();
            }

            s[i] = stack.empty()?-1:stack.peek();
            stack.push(ar[i]);
        }
    }

    public static void main(String args[]){

        int ar[] = {1, 1, 2, 3, 4, 2, 1};

        NextGreaterFreqElement nge = new NextGreaterFreqElement();
        nge.calFreq(ar);

       // System.out.println(nge.map);

        int s[] =  new int[ar.length];
        nge.ngefref(ar,s);

        System.out.print("{");
        for (int i=0;i<s.length-1;i++){
            System.out.print(s[i]+",");
        }
        System.out.print(s[s.length-1]);
        System.out.print("}");
    }
}
