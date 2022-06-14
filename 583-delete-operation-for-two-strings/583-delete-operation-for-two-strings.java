class Solution {
    public int helper(int m,int n,String s1,String s2,int dp[][]){
        if(m== 0 || n==0)
            return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m-1) == s2.charAt(n-1)){
            return dp[m][n] = 1+ helper(m-1,n-1,s1,s2,dp);
        }
        return dp[m][n] = Math.max(helper(m,n-1,s1,s2,dp),helper(m-1,n,s1,s2,dp));
    }
    
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }   
        }
        int lcs = dp[m][n];
        return word1.length() + word2.length() - 2*lcs;
        
        
    }
}