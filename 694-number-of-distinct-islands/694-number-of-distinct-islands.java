class Solution {
    Set<String> set = new HashSet<>();
    public void helper(int i,int j,int mat[][],StringBuilder s,String dir){
        if(i<0 || i>=mat.length || j<0 || j>=mat[0].length || mat[i][j]==0){
            return;
        }
        mat[i][j] = 0;
        s.append(dir);
        helper(i-1,j,mat,s,"u");
        helper(i+1,j,mat,s,"d");
        helper(i,j-1,mat,s,"l");
        helper(i,j+1,mat,s,"r");
        s.append("b");
    }
    public int numDistinctIslands(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    StringBuilder s = new StringBuilder();
                    helper(i,j,grid,s,"o");   
                    grid[i][j] = 0;
                    set.add(s.toString());
                }
            }   
        }
        return set.size();
    }
}