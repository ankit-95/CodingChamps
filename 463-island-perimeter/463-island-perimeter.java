class Solution {
    
    public int helper(int i,int j,int grid[][],int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0)
            return 1;
        
        if(grid[i][j]==-1) return 0;
        grid[i][j] = -1;
        
        int l1 = helper(i-1,j,grid,n,m);
        int l2 = helper(i+1,j,grid,n,m);
        int l3 = helper(i,j-1,grid,n,m);
        int l4 = helper(i,j+1,grid,n,m);
        
        return l1 + l2 + l3 + l4;
    }
    
    public int islandPerimeter(int[][] grid) {
        
        int ans = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    ans +=helper(i,j,grid,grid.length, grid[0].length);     
                }
            }    
        }
        return ans;
    }
}