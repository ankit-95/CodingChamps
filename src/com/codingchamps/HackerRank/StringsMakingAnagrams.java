package com.codingchamps.HackerRank;

public class StringsMakingAnagrams {

    public static void main(String args[]){
        String a = "cde";
        String b = "abc";
        int count=0;
        int xor=0;
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                /*if((a.charAt(i) ^ b.charAt(j)) == 0){
                    xor =  xor ^ (a.charAt(i) ^ b.charAt(j));
                    continue;
                }
                else count++;*/
                xor =  xor ^ (a.charAt(i) ^ b.charAt(j));
            }
        }
        System.out.println(count+" "+xor);
    }
}
