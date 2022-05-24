// { Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
       int low = 0,high=n;
        while(low <= high){
            int cut1 = (low + high)>>1 ;
            int cut2 = n - cut1;
            int left1 =  (cut1==0) ? Integer.MIN_VALUE:ar1[cut1-1];
            int left2 =  (cut2==0) ? Integer.MIN_VALUE:ar2[cut2-1];
            int right1 = (cut1==n) ? Integer.MAX_VALUE:ar1[cut1];
            int right2 = (cut2==n) ? Integer.MAX_VALUE:ar2[cut2];
            if(left1<= right2 && left2 <=right1){
                return Math.max(left1,left2) + Math.min(right1,right2);
            }else if(left1 > right2){
                high = cut1-1;
            }else{
                low = cut1+1;
            }
        }
        return -1;
    }
}