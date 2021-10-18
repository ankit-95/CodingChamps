package com.codingchamps.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

public class StringRotation {

	 public static boolean stringRotationApp1(String s1,String s2){

		    return (s1.length() == s2.length()) &&
		               ((s1 + s1).indexOf(s2) != -1);
		  }

		  public static boolean stringRotationApp2(String s1, String s2){

		    Queue<Character> q1 = new LinkedList<>();
		    for(int i=0;i<s1.length();i++){
		      q1.add(s1.charAt(i));
		    }

		    Queue<Character> q2 = new LinkedList<>();
		    for(int i=0;i<s2.length();i++){
		      q2.add(s2.charAt(i));
		    }

		    int k = s2.length();
		    while( k > 0){
		      k--;
		      char ch = q2.remove();
		      q2.add(ch);
		      if(q2.equals(q1))
		        return true;
		    }

		    return false;
		  }
	public static void main(String[] args) {
		
		String s1= "ABCD";
        String s2= "ACBD";
        System.out.print(stringRotationApp2(s1,s2));

	}

}
