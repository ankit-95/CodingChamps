class Solution {
    
    public int helper(int i,int j,int mat[][],int dp[][]){
        if(j<0 || j>=mat[0].length)
            return (int)1e9;
        if(i==mat.length-1){
            return mat[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int left = helper(i+1,j-1,mat,dp);
        int down = helper(i+1,j,mat,dp);
        int right = helper(i+1,j+1,mat,dp);
        return dp[i][j] = Math.min(Math.min(left,down),right) + mat[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<matrix[0].length;i++){
            for(int d[] : dp)
                Arrays.fill(d,-1);
            int cur_min = helper(0,i,matrix,dp);
            min = Math.min(min,cur_min);
        } 
        return min;
    }
}