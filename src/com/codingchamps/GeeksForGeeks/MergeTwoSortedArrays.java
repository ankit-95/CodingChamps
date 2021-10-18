package com.codingchamps.GeeksForGeeks;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	// Time Complexity : ((n+m) log(n+m)) and Aux Space Complexity : O(1)

	public static void mergeArrays(int ar1[] , int ar2[], int n ,int m){
		int gap = n+m;
		int i=0,j=0;
		
		for( gap = nextGap(gap) ; gap > 0 ; gap = nextGap(gap)){
			
			for(i =0;i+gap<n;i++){
				if(ar1[i] > ar1[i+gap])
					ar1[i] += ar1[i+gap] - (ar1[i+gap] = ar1[i]);
			}
			
			for(j = (gap>n)? gap-n : 0;i<n && j<m; i++,j++){
				if(ar1[i] > ar2[j]){
					ar1[i]+= ar2[j] - (ar2[j] = ar1[i]);
				}
			}
			
			if(j<m){
				for(j=0;j+gap<m;j++){
					if(ar2[j] > ar2[j+gap]){
						ar2[j] += ar2[j+gap] - (ar2[j+gap] = ar2[j]);
					}
				}
			}
		}
	}
	
	public static int nextGap(int gap){
		if(gap <= 1)
			return 0;
		return (gap/2 + gap %2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Merge two sorted Arrays
		
		int ar1[] = {1,4,6,8,9};
		int ar2[] = {2,3,5,7};
		
		mergeArrays(ar1,ar2,ar1.length,ar2.length);
		
		Arrays.stream(ar1).forEach(e-> System.out.print(e+" "));
		System.out.println();
		Arrays.stream(ar2).forEach(e-> System.out.print(e+" "));
	}

}
