package com.codingchamps.GeeksForGeeks;

import java.util.Arrays;

public class ShuffleCheck {

	public static boolean checkLength(String a , String b, String result){

	    return ((a.length() + b.length()) == result.length()); 
	  }
	  public static boolean shuffleCheck(String a, String b, String result){

	    a = sortString(a);
	    b = sortString(b);
	    result = sortString(result);
	  
	    int i =0;
	    int j=0;
	    int k=0;

	    while(k< result.length()){

	      if(i < a.length() && a.charAt(i) == result.charAt(k))
	        i++;

	      else if(j < b.length() && b.charAt(j) == result.charAt(k))
	        j++;
	      else 
	        return false;

	      k++;
	    }

	    if(i< a.length() || j < b.length())
	      return false;

	    return true;  
	  }

	  public static String sortString(String s){

	    char ch[] = s.toCharArray();
	    Arrays.sort(ch);

	    s = String.valueOf(ch);

	    return s;
	  }

	  public static void processShulffleCheck(String first, String second, String[] results){

	    for(String result : results){

	      if(checkLength(first,second,result) == true && 
	        shuffleCheck(first,second,result)){
	            System.out.println(result + " is a valid shuffle of " + first + " and " + second);
	        }
	        else {
	           System.out.println(result + " is not a valid shuffle of " + first + " and " + second);
	      }
	    }
	  }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     String first = "XY";
	     String second = "12";
	     String[] results = {"1XY2", "Y1X2", "Y21XX"};

	     ShuffleCheck.processShulffleCheck(first, second, results);
	}

}
