class Solution {
    
    public int dfs(int i,int j,int grid[][],int n){
        if(i<0 || i>=n || j<0 || j>=n || grid[i][j]!=0)
            return 0;
        grid[i][j]=1;
        return 1 + dfs(i-1,j,grid,n) + dfs(i+1,j,grid,n) + dfs(i,j-1,grid,n) + dfs(i,j+1,grid,n);
    }
    public int regionsBySlashes(String[] str) {
        int n = str.length;
        int grid[][] = new int[n*3][n*3];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(str[i].charAt(j)=='/'){
                    grid[i*3][j*3+2] = grid[i*3+1][j*3+1] = grid[i*3+2][j*3] = 1;
                } 
                else if(str[i].charAt(j)=='\\'){
                    grid[i*3][j*3] = grid[i*3+1][j*3+1] = grid[i*3+2][j*3+2] = 1;
                } 
            }        
        }
        
        int region = 0;
        for(int i=0;i<n*3;i++){
            for(int j=0;j<n*3;j++){
                region += dfs(i,j,grid,n*3) >0 ? 1 : 0; 
            }        
        }
         
        return region;
    }
}