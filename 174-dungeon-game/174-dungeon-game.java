class Solution {
    
    public int helper(int i,int j,int[][] dungeon,int dp[][]){
        if(i>=dungeon.length || j>=dungeon[0].length){
            return (int)1e9;
        }
        if(dp[i][j]>0)
            return dp[i][j];
        if(i==dungeon.length-1 && j==dungeon[0].length-1)
            return dp[i][j] = dungeon[i][j]<=0 ? -dungeon[i][j]+1 : 1;
        
        int right = helper(i,j+1,dungeon,dp);
        int down = helper(i+1,j,dungeon,dp);
        int minReq = Math.min(right,down) - dungeon[i][j];
        return dp[i][j] = minReq<=0 ? 1 : minReq;
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            Arrays.fill(dp[i],(int)1e9);
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int minReq = Math.min(dp[i+1][j],dp[i][j+1]) - dungeon[i][j];
                dp[i][j] = minReq<=0 ? 1 : minReq;
            }
        }
        return dp[0][0];
    }
}