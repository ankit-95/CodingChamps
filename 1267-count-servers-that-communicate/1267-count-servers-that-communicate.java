class Solution {
    
    public void helper(int i,int j,int grid[][],int n,int m,int count[]){
        if(grid[i][j]==1){
            count[0]++;
            grid[i][j] = 0;    
            for(int k=0;k<n;k++){
                  if(grid[k][j]==1)  
                      helper(k,j,grid,n,m,count);
            }
             for(int k=0;k<m;k++){
                  if(grid[i][k]==1)
                      helper(i,k,grid,n,m,count);
            }
        }
    }
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int len = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                   int count[] = new int[1];
                   helper(i,j,grid,n,m,count);
                   if(count[0]>1)
                        len+=count[0];
                }
            }    
        }
        return len;
    }
}