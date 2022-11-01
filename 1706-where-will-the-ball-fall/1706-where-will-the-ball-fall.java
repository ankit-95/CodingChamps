class Solution {
    
    public int helper(int i,int j,int grid[][],int dp[][]){
        
        if(i==grid.length){
            return j;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        int next = j + grid[i][j];
        
        if(next<0 || next> grid[0].length-1 || grid[i][j]!=grid[i][next])
            return -1;
        return dp[i][j] = helper(i+1,next,grid,dp);
        
    }
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[] = new int[m];
        
        int dp[][] = new int[n+1][m];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        
        for(int i=0;i<m;i++){
            ans[i] = helper(0,i,grid,dp);    
        }
        return ans;
    }
}