package com.company;

public class RemoveCharacters {

    public static String removeCharacters(String s){
        if(s.equals(""))
            return "";
        if(s.substring(0,1).equals("x"))
            return ""+removeCharacters(s.substring(1));
        else
            return s.substring(0,1)+ removeCharacters(s.substring(1));
    }
    public static void main (String args[]){
        String s = "xxxxxxxxxabxcxxzxxxxxxxx";
        System.out.println(removeCharacters(s));
    }
}
