class Solution {
    
    // Recursion giving TLE
    // public void helper(int i,int j,int [][] grid, int n,int m, int count[]){
    //     if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==1)
    //         return;
    //     if(i==n-1 && j==m-1)
    //         count[0]++;
    //     helper(i+1,j,grid,n,m,count);
    //     helper(i,j+1,grid,n,m,count);
    // }
    // public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    //     int count[] = new int[1];
    //     helper(0,0,obstacleGrid,obstacleGrid.length,obstacleGrid[0].length,count);
    //     return count[0];
    // }
    
    
    //DP
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        
        int dp[][] = new int[n+1][m+1];
        dp[0][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(obstacleGrid[i-1][j-1]!=1){
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }    
        }
        return dp[n][m];
    }
}