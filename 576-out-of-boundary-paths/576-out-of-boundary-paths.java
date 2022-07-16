class Solution {
    int modulo = (int)1e9 + 7;
    int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int dp[][][] = new int[m][n][maxMove+1];
        for(int [][] a :dp){
            for(int []b : a)
                Arrays.fill(b,-1);
        }
        return paths(m, n, startRow, startColumn, maxMove,dp);
    }
  
    public int paths(int m ,int n, int i, int j, int maxMove,int dp[][][]){
       if(maxMove<0)return 0;
       if(i>=m || i<0 | j>=n || j<0)return 1;
       if(dp[i][j][maxMove]!=-1) return dp[i][j][maxMove];
       int ans = 0;
       for(int[] dir : dirs){
          ans += paths(m, n, i+dir[0], j+dir[1], maxMove-1,dp);
          ans %= modulo;
       }
      return dp[i][j][maxMove] = ans;
    }
}