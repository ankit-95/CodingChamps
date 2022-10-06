class Solution {
    
    public void dfs(int[][]grid,int i,int j){
        if(i<0|| i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1)
            return;
        grid[i][j]=0;    
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
    public int numEnclaves(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(i==0 || j==0 || i==grid.length-1 || j==grid[i].length-1){
                    dfs(grid,i,j);
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                res+=grid[i][j];   
            }
        }
        return res;
    }
}