package com.codingchamps.LeetCode;

public class MajorityElement {

    // Time Complexity : O(n) and Aux Space : O(1)

    public static int getMajorityElement(int ar[]){
        int count=0;
        Integer candidate = null;
        for(int num : ar){
            if(count==0)
                candidate = num;
            count += (num==candidate)?1:-1;
        }
        return candidate;
    }
    public static void main(String[] args) {
        int ar[] = {2,2,1,1,1,2,2};
        System.out.println(getMajorityElement(ar));
    }
}
