class Solution {
    
    public void dfs(int grid[][],int i,int j,int n,int m,int prev){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]!=prev){
            return;
        }
        grid[i][j] = -prev;
        dfs(grid,i-1,j,n,m,prev);
        dfs(grid,i+1,j,n,m,prev);
        dfs(grid,i,j+1,n,m,prev);
        dfs(grid,i,j-1,n,m,prev);
         if(i > 0 && j > 0 && i < grid.length-1 && j < grid[0].length-1
           && prev == Math.abs(grid[i+1][j])
           && prev == Math.abs(grid[i-1][j])
           && prev == Math.abs(grid[i][j+1])
           && prev == Math.abs(grid[i][j-1]))
            grid[i][j] = prev; 
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length;
        int m = grid[0].length;
        dfs(grid,row,col,n,m,grid[row][col]);
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] < 0)
                    grid[i][j] = color;
            }
        }
        return grid;
    }
}