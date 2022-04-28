class Solution {
    
    // flood-fill
    public void dfs(int[][] g,int i,int j){
        if(i<0 || i>=g.length || j<0 || j>=g[i].length || g[i][j]==0)
            return;
        g[i][j] = 0;
        dfs(g,i-1,j);
        dfs(g,i+1,j);
        dfs(g,i,j-1);
        dfs(g,i,j+1);
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        // first remove different components from grid2
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1 && grid1[i][j]==0)
                    dfs(grid2,i,j);
            }
        }   
        
        int c = 0;
        // count sun islands from grid2
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j]==1){
                    dfs(grid2,i,j);
                    c+=1;
                }
            }
        }
        return c;
    }
}