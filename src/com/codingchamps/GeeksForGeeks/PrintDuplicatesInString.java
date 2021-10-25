package com.codingchamps.GeeksForGeeks;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicatesInString {

	public static void approach1(String s){
	    int count[] = new int[256];

	    for(int i=0;i<s.length();i++){
	      count[s.charAt(i)]++;
	    }

	    for(int i=0;i<255;i++){
	      if(count[i] > 1)
	        System.out.println((char)i +", count = "+ count[i]);
	    }
	  }

	  public static void approach2(String s){
	    HashMap<Character, Integer> count = new HashMap<>();

	    for(int i=0;i<s.length();i++){
	      if(count.containsKey(s.charAt(i))){
	        count.put(s.charAt(i), count.get(s.charAt(i))+1);
	      } else {
	        count.put(s.charAt(i), 1);  
	      }
	    }

	    for(Map.Entry e : count.entrySet()){
	      char key = (char)e.getKey();
	      int value = (Integer)e.getValue();

	      if(value > 1)
	        System.out.println(key +", count = "+ value);
	    }
	  }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "test string";
		System.out.println("Approach 1 :");
		approach1(s);
		System.out.println("Approach 2 :");
		approach2(s);
	}

}
