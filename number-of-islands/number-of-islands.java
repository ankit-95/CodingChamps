class Solution {
    public void helper(int i,int j,char[][] grid,int n,int m){
        if(i<0 || i==n || j<0 || j==m || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        helper(i-1,j,grid,n,m);    
        helper(i,j-1,grid,n,m);    
        helper(i,j+1,grid,n,m);    
        helper(i+1,j,grid,n,m);     
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    count+=1;
                    helper(i,j,grid,n,m);
                }
            }
        }
       return count;
    }
}