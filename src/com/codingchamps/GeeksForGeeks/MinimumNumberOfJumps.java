package com.codingchamps.GeeksForGeeks;

public class MinimumNumberOfJumps {

    // O(n*n) , Using Tabulation method
    public static int minimumNunberOfJumpsApp1(int ar[], int n){

        int jumps[] = new int[n];
        jumps[0] = 0;
        for(int i =1;i<n;i++){
            jumps[i] = Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(ar[j] + j >= i && jumps[j]!=Integer.MAX_VALUE)
                    jumps[i] = Math.min(jumps[i],jumps[j]+1);
            }
        }
        return ((jumps[n-1])!=Integer.MAX_VALUE)? jumps[n-1]:-1;
    }

    // O(n)
    public static int jump(int ar[]){
        int n = ar.length;

        //base case
        if(n<=1)
          return 0;
        if(ar[0] == 0)
           return -1;
        // max place where we can reach
        int maxReach= ar[0];
        //current jump we did
        int jump =1;
        // steps we can take now, initially we can take steps equal maxReach
        int step = ar[0];
        // start to move from position 1

        for(int i =1;i<n;i++){
            //if we reach end
            if(i==n-1)
                return jump;
            // as we complete a step so reduce a step
            step--;

            //update maxReach
            maxReach = Math.max(maxReach,ar[i]+ i);

            //check if there is no step left
            if(step ==0){

                //if there is no step left then we have to make a jump
                jump++;

                //now update the steps
                //check if current index or previous index is the max reachable index
                //then it is impossible to move further
                if(maxReach <= i)
                   return -1;

                // if we can go further then update step like
                // now how many steps we can make
                step = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int ar [] = {1, 4, 3, 2, 6, 7};
       // System.out.println(minimumNunberOfJumpsApp1(ar,ar.length));
        System.out.println(jump(ar));
    }
}
