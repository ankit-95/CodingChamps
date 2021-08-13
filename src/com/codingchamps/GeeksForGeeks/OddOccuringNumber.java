package com.codingchamps.GeeksForGeeks;

public class OddOccuringNumber {

    public static void oddOneOccuringNumber() {
        int ar[] = {4,3,4,4,4,5,5};
        int xor=0;
        for(int i=0;i<ar.length;i++){
            xor = xor ^ ar[i];
        }
        System.out.println(xor);
    }
    public static void oddTwoOccuringNumber() {
        int ar[] = {4, 3, 3, 4, 4, 4, 5, 5, 8, 4};
        int xor = 0;
        for (int i = 0; i < ar.length; i++) {
            xor = xor ^ ar[i];
        }
        int sn = xor & ~(xor - 1);  // Rightmost bit   ; xor = 8^4 = 12 i.e 1100 ^ (1011-1 = 0011) = 0100
        int res1=0,res2=0;
        for (int i = 0; i < ar.length; i++) {
            if((ar[i] & sn) !=0)
              res1 = res1 ^ ar[i];
            else
                res2 = res2 ^ ar[i];
        }
        System.out.println("Two Numbers are : "+ res1 + " and "+ res2);
    }
        public static void findMissingNumber() {
        int ar[] = {1,2,3,5};
        int limit = 5;
        int xor=0;
        for(int i=0;i<ar.length;i++){
            xor = xor ^ ar[i];
        }
        for(int i=1;i<=limit;i++){
            xor = xor ^ i;
        }
        System.out.println(xor);
    }
    public static void main(String args[]){
        oddOneOccuringNumber();
        findMissingNumber();
        oddTwoOccuringNumber();
    }
}
