class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;       
        int dp[][] = new int[r+1][c];
        for(int i=1;i<=r;i++){
            for(int j=0;j<c;j++){
                dp[i][j] = matrix[i-1][j]=='1' ? 1 : 0;
            }
        }
        
        for(int i=1;i<=r;i++){
            for(int j=0;j<c;j++){
                if(i>1) dp[i][j] += dp[i][j]==1 ? dp[i-1][j] : 0;
           //     System.out.print(dp[i][j]+" ");
            }
           // System.out.print("\n");
        }
        
        int maxi = 0;
        for(int i=1;i<=r;i++){
            Stack<Integer> s = new Stack<>();
            for(int j=0;j<=c;j++){
                int val = j==c ? -1 : dp[i][j];
                while(!s.isEmpty() && val <= dp[i][s.peek()]){
                    int h = dp[i][s.pop()];
                    int w = s.isEmpty() ? j : j - s.peek() -1;
                    maxi = Math.max(maxi, h*w);
                }
                s.push(j);
            }
        }
        return maxi;
    }
}