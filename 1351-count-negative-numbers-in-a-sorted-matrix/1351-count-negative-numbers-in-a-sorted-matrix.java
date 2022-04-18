class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length-1;
        int col = 0;
        int ans = 0;
        while(row>=0 && col<grid[0].length){
            if(grid[row][col]<0){
                ans+= grid[0].length - col;
                row--;
            } else if (grid[row][col] >=0){
                col++;
            }
        }
        return ans;
    }
}