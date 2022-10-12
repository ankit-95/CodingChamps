class Solution {
    
//     public int helper(int i,int j,String s,String p,int dp[][]){
        
//         if(i<0 && j<0)
//             return 1;
        
//         if(j<0 && i>=0)
//             return 0;
        
//         if(i<0 && j>=0){
//             while(j-->0){
//                 if(p.charAt(j)!='*')
//                     return 0;
//             }
//             return 1;
//         }
        
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
//             return dp[i][j] = helper(i-1,j-1,s,p,dp);
//         }
        
//         else if(p.charAt(j)=='*'){
//             return dp[i][j] = helper(i-1,j,s,p,dp) | helper(i,j-1,s,p,dp);
//         }
        
//         return 0;
//     }
    
  static boolean isAllStars(String S1, int i) {

    // S1 is taken in 1-based indexing
    for (int j = 1; j <= i; j++) {
      if (S1.charAt(j - 1) != '*')
        return false;
    }
    return true;
  }

  static boolean wildcardMatching(String S1, String S2) {

    int n = S1.length();
    int m = S2.length();

    boolean dp[][] = new boolean[n + 1][m + 1];
    dp[0][0] = true;

    for (int j = 1; j <= m; j++) {
      dp[0][j] = false;
    }
    for (int i = 1; i <= n; i++) {
      dp[i][0] = isAllStars(S1, i);
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {

        if (S1.charAt(i - 1) == S2.charAt(j - 1) || S1.charAt(i - 1) == '?')
          dp[i][j] = dp[i - 1][j - 1];

        else {
          if (S1.charAt(i - 1) == '*')
            dp[i][j] = dp[i - 1][j] || dp[i][j - 1];

          else dp[i][j] = false;
        }
      }
    }

    return dp[n][m];

  }
    
    public boolean isMatch(String s, String p) {
        // int n = s.length();
        // int m = p.length();
        // int dp[][] = new int[n][m];
        // for(int d[] : dp)
        //     Arrays.fill(d,-1);
        // return helper(s.length()-1,p.length()-1,s,p,dp) ==1 ? true : false;
        return wildcardMatching(p,s);
    }
}