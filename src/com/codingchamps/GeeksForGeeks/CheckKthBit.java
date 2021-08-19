package com.codingchamps.GeeksForGeeks;

public class CheckKthBit {

    public static void main(String args[]){
        int num = 5;
        int k = 3;
        // Left Shift Approach
        System.out.print("Left Shifted Approach : ");
        int leftShifted = (1 <<(k-1));
        if((num & leftShifted)!=0){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
        // Right Shift Approach
        System.out.print("\nRight Shifted Approach : ");
        int rightShifted = (num >>(k-1));
        if((rightShifted & 1)==1){
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }
    }
}
