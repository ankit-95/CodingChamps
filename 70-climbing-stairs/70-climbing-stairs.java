class Solution {
    
    public int helper(int n,int dp[]){
        if(n==0){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int first = 0,second=0;
        if(n-1>=0) first = helper(n-1,dp);
        if(n-2>=0) second = helper(n-2,dp);
        return dp[n] = first + second;
    }
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(n,dp);
    }
    
    // public int climbStairs(int n) {
    //     if(n<=1)
    //         return 1;
    //     int prev1 = 1;
    //     int prev2 = 2;
    //     for(int i=3;i<=n;i++){
    //         int newVal = prev1 + prev2;
    //         prev1 = prev2;
    //         prev2 = newVal;
    //     }
    //     return prev2;
    // }
    
}