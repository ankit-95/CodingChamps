package com.codingchamps.GeeksForGeeks;

/*
In th below code,

 1. Naive approach processes through the complete array therefore, Time Complexity is O(Total no. of bits)
 2. Brian Kerningam's Algo says, Time Complexity will be O(No. of set bits).
 3. Using Look Table Approach,Time Complexity will be O(1).
* */
public class NumberOfBits1 {

	public static int table[];
	static {
		table = new int[256];
		table[0]=0;
		for(int i=1;i<256;i++){
			table[i] = (i&1)+ table[i/2];
		}
	}
	public static int lookUpTableApproach(int num){
		int count= table[num & 0xff];
		num = num>>8;
		count += table[num & 0xff];
		num = num>>8;
		count += table[num & 0xff];
		num = num>>8;
		count += table[num & 0xff];
		return count;
	}

	public static int brianKeringamsApproach(int num){
		int count=0;
		while(num>0){
			num=(num&(num-1));
			count++;
		}
		return count;
	}
	public static int naiveApproach(int num){
		int count=0;
		while(num>0){
			count+=(num&1);
			num>>=1;
		}
		return count;
	}
	public static void main(String args[]) {
		int num = 15;

        System.out.print("\nNumber of bits (Naive Approach) : "+naiveApproach(num));
		System.out.print("\nNumber of bits (Brian Keringam's  Approach) : "+brianKeringamsApproach(num));
		System.out.print("\nNumber of bits (Look Up Table  Approach) : "+lookUpTableApproach(num));
	}

}
