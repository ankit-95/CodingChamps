class Solution {
    
    // Memo
    // public int helper(String s1,String s2,int m,int n,int dp[][]){
    //     if(m==0)
    //         return n;
    //     if(n==0)
    //         return m;
    //     if(dp[m][n]!=-1) return dp[m][n];
    //     if(s1.charAt(m-1)==s2.charAt(n-1)){
    //         return dp[m][n] = helper(s1,s2,m-1,n-1,dp);
    //     }
    //     return dp[m][n] =  1 + Math.min(Math.min(helper(s1,s2,m-1,n-1,dp),helper(s1,s2,m-1,n,dp)), helper(s1,s2,m,n-1,dp));
    // }
    // public int minDistance(String s1, String s2) {
    //     int dp[][] = new int[s1.length()+1][s2.length()+1];
    //     for(int d[] : dp)
    //         Arrays.fill(d,-1);
    //     return helper(s1,s2,s1.length(),s2.length(),dp);
    // }
    
    
    public int minDistance(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int m = s1.length();
        int n = s2.length();
        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        for(int i=0;i<=n;i++)
            dp[0][i] = i;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]), dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}