class Solution {
    
    public boolean dfs(int [][]g,int i,int j){
        if(i<0 || i>=g.length || j<0 || j>=g[i].length)
            return false;
        if(g[i][j]==1)
            return true;
        g[i][j] = 1;
        boolean d1 = dfs(g,i-1,j);
        boolean d2 = dfs(g,i+1,j);
        boolean d3 = dfs(g,i,j-1);
        boolean d4 = dfs(g,i,j+1);
        return d1 && d2 && d3 && d4;
    }
    public int closedIsland(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0){
                    res+= dfs(grid,i,j) ? 1 : 0;
                }
            }   
        }
        return res;
    }
}