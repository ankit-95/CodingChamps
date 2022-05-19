class Solution {
    int memo[][] = new int[201][201];
    public int helper(int parent,int i,int j,int [][] mat,int m,int n){
        if(i<0 || i>=m || j<0 || j>=n || mat[i][j] <= parent)
            return 0;
        if(memo[i][j]!=0)
            return memo[i][j];
        int l1 = helper(mat[i][j],i,j-1,mat,m,n);
        int l2 = helper(mat[i][j],i,j+1,mat,m,n);
        int l3 = helper(mat[i][j],i-1,j,mat,m,n);
        int l4 = helper(mat[i][j],i+1,j,mat,m,n);
        memo[i][j] = Math.max(Math.max(l1 + 1,l2 + 1),Math.max(l3 + 1,l4 + 1));
        return memo[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int localMax[] = new int[1];
                max = Math.max(max,helper(-1,i,j,matrix,m,n));   
            }   
        }
        return max;
    }
}