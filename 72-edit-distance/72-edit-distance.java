class Solution {
    
    public int helper(String s1,String s2,int m,int n,int dp[][]){
        if(m==0)
            return n;
        if(n==0)
            return m;
        if(dp[m][n]!=-1) return dp[m][n];
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return dp[m][n] = helper(s1,s2,m-1,n-1,dp);
        }
        return dp[m][n] =  1 + Math.min(Math.min(helper(s1,s2,m-1,n-1,dp),helper(s1,s2,m-1,n,dp)), helper(s1,s2,m,n-1,dp));
    }
    public int minDistance(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return helper(s1,s2,s1.length(),s2.length(),dp);
    }
}