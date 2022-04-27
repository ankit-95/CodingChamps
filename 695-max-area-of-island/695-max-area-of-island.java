class Solution {
    
    public void dfs(int [][]grid,int i,int j,int m,int n,int[] localMax){
        if(i< 0 || i==m || j<0 || j==n || grid[i][j]==0)
            return;
        grid[i][j]=0;
        localMax[0]++;
        dfs(grid,i-1,j,m,n,localMax);
        dfs(grid,i,j+1,m,n,localMax);
        dfs(grid,i,j-1,m,n,localMax);
        dfs(grid,i+1,j,m,n,localMax);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    int[] local = new int[1];
                    dfs(grid,i,j,m,n,local);
                    max = Math.max(max,local[0]);
                }
            }
        }
        return max;
    }
}