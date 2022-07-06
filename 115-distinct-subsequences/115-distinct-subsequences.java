class Solution {
    
    public int helper(int m,int n,String s,String t,int dp[][]){
        if(n==0){
            return 1;
        }
        if(m==0)
            return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s.charAt(m-1)==t.charAt(n-1)){
            return dp[m][n] = helper(m-1,n-1,s,t,dp) + helper(m-1,n,s,t,dp);
        }
            return dp[m][n] = helper(m-1,n,s,t,dp);
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp[][] = new int [n+1][m+1];
        
//         for(int i=0;i<s.length()+1;i++)
//             Arrays.fill(dp[i],-1);        
//         return helper(s.length(),t.length(),s,t,dp);
        
        for(int i=0;i<=n;i++) dp[i][0] = 1;
        for(int j=1;j<=m;j++) dp[0][j] = 0;
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}