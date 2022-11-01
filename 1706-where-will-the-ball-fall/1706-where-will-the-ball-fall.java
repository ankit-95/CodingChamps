class Solution {
    
    public int helper(int i,int j,int grid[][]){
        
        if(i==grid.length){
            return j;
        }
        
        int next = j + grid[i][j];
        
        if(next<0 || next> grid[0].length-1 || grid[i][j]!=grid[i][next])
            return -1;
        return helper(i+1,next,grid);
        
    }
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[] = new int[m];
        
        for(int i=0;i<m;i++){
            ans[i] = helper(0,i,grid);    
        }
        return ans;
    }
}