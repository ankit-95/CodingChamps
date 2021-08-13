package com.codingchamps.GeeksForGeeks;

public class isPrime {

    //Naive Approach with T.C  = O[n].
    public static boolean isPrimeNaiveApp(int num){
        for(int i=2;i< num;i++){
            if(num%i==0){
                return false;

            }
        }
        return true;
    }
    //isPrimeBetterApp Approach with T.C  = O[sqrt(n)].
    public static boolean isPrimeBetterApp(int num){
        for(int i=2;i< Math.sqrt(num);i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    // More Better approach for Large N
    public static boolean isPrimeMoreBetterApp(int num){
        if(num==1) return false;
        if(num==2 || num==3) return true;
        if(num%2==0 || num%3==0) return false;

        for(int i=5;i< Math.sqrt(num);i=i+6){
            if(num%i==0 ||num%(i+2)==0 ){
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        System.out.println(isPrimeBetterApp(97));
        System.out.println(isPrimeMoreBetterApp(1031));
    }
}
