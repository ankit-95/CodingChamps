package com.codingchamps.GeeksForGeeks;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static String removeDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        String result="";
        for(int i=0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                result+=s.charAt(i);
                set.add(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String args[]){
        System.out.println(removeDuplicates("HappyNewYear"));
    }
}
