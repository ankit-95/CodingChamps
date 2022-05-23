// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int Arr[] = new int[m];
            for (int i = 0; i < m; i++) Arr[i] = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.count(Arr, m, n));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution {

    public long count(int S[], int m, int n) {
        long dp[][] = new long[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = 1l;
        }
        for(int i=1;i<=n;i++){
            dp[i][0] = 0l;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = dp[i][j-1];
                if(S[j-1]<=i){
                    dp[i][j] += dp[i-S[j-1]][j];
                }
            }    
        }
        return dp[n][m];
    }
}