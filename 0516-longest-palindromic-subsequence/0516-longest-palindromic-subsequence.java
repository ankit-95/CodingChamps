class Solution {
    
    //Memo
    public int lps(int i,int j,String s,String rev,int dp[][]){
        if(i==0 || j==0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i-1)==rev.charAt(j-1))
            return dp[i][j] = 1 + lps(i-1,j-1,s,rev,dp);
        return dp[i][j] = Math.max(lps(i,j-1,s,rev,dp),lps(i-1,j,s,rev,dp));
    }
    
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        StringBuilder sb = new StringBuilder(s);
        
        String rev = sb.reverse().toString();
        
        return lps(s.length(),rev.length(),s,rev,dp);
    }
}