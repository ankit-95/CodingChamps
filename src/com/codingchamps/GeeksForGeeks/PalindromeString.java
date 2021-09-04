package com.codingchamps.GeeksForGeeks;

public class PalindromeString {


    public static boolean checkPalindrome(String s){
        int start=0;
        int last=s.length()-1;
        for(; start < s.length()/2;){
            if(Character.isLetter(s.charAt(start)) && Character.isLetter(s.charAt(last))){
                if(Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last))){
                    return false;
                }
                start++;
                last--;
            } if(!Character.isLetter(s.charAt(start))){
                start++;
            } if(!Character.isLetter(s.charAt(last))){
                last--;
            }
        }
        return true;
    }

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

        System.out.println(checkPalindrome("A man, a plan, a canal: Panama"));
    }
}
