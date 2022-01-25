package com.codingchamps.GeeksForGeeks;

import java.util.ArrayList;
import java.util.List;

public class RopCutProblem {


    public static int max = -1;
    public static void rop(int n, List<Integer> value, List<Integer> list){
        if(n<=0){
            if(n==0){
                System.out.println(list);
                max = Math.max(max,list.size());
            }
            return;
        }
        for(int i=0;i<value.size();i++){
            list.add(value.get(i));
            rop(n-value.get(i),value,list);
            list.remove(list.size()-1);
        }
    }
    public static void main(String args[]) {
//        int a=4,b=2,c=6;
//        int n=5;
        int a=2,b=5,c=1;
        int n=5;
        List<Integer> value = new ArrayList<>();
        value.add(a);
        value.add(b);
        value.add(c);
        rop(n,value,new ArrayList<>());
        System.out.print(max);
    }
}
