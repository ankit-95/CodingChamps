class Solution {
    
    public int lcs(String s1,String s2,int i,int j,int dp[][]){
        if(i==0 || j==0)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i-1)==s2.charAt(j-1))
            return dp[i][j] = 1 + lcs(s1,s2,i-1,j-1,dp);
        
        return dp[i][j] = Math.max(lcs(s1,s2,i,j-1,dp),lcs(s1,s2,i-1,j,dp));
    }
    public int minInsertions(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        int dp[][] = new int[s.length()+1][s.length()+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        int lcsLen = lcs(s,rev,s.length(),s.length(),dp);
        
        return s.length() - lcsLen;
    }
}