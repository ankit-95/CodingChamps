package com.codingchamps.GeeksForGeeks;

public class PalindromeString {

    public static int isPlaindrome(String s) {

        for(int i=0, j = s.length()-1;i<s.length()/2;i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String args[]){

        System.out.println(isPlaindrome("abba"));
        System.out.println(isPlaindrome("abc"));
    }
}
