class Solution {
    int mod = (int)Math.pow(10,9) + 7;
    public int helper(int n,int k, int target,int dp[][]){
        if(n==0){
            if(target==0)
                return 1;
            return 0;    
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int res =0;
        for(int j=1;j<=k;j++){
            if(target-j>=0)
                res = (res+helper(n-1,k,target-j,dp))%mod;
        }   
        return dp[n][target] = res % mod;
    }
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        for(int d[] : dp)
            Arrays.fill(d,-1);
        return helper(n,k,target,dp);
    }
}