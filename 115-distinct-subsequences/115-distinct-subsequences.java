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
        int dp[][] = new int [s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++)
            Arrays.fill(dp[i],-1);
        return helper(s.length(),t.length(),s,t,dp);
    }
}