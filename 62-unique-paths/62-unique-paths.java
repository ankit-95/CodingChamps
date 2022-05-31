class Solution {
    // Recursion solution
    
    // int count = 0;
    // public void helper(int i,int j,int m,int n){
    //     if(i< 0 || i>=m || j<0 || j>=n)
    //         return;
    //     if(i==m-1 && j==n-1){
    //         count++;
    //     }
    //     helper(i+1,j,m,n);
    //     helper(i,j+1,m,n);
    // }
    // public int uniquePaths(int m, int n) {
    //     helper(0,0,m,n);
    //     return count;
    // }
    
    // DP
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i>=1)
                    dp[i][j] += dp[i-1][j];
                if(j>=1)
                    dp[i][j] += dp[i][j-1];
            }    
        }
        return dp[m-1][n-1];
    }
}