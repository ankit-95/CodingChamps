class Solution {
    public int helper(int index,int[] obstacles,int lane,int dp[][]){
        if(lane<1 || lane >3)
            return (int)1e9;
        if(index==obstacles.length-1){
            return 0;
        }
        if(dp[index][lane]!=-1) return dp[index][lane];
        if(obstacles[index+1]!=0 && obstacles[index+1]==lane){
            int l1 =  (obstacles[index]!=lane-1) ? 1 + helper(index,obstacles,lane-1,dp) : (int)1e9;
            int l2 =  (obstacles[index]!=lane-2) ? 1 + helper(index,obstacles,lane-2,dp) : (int)1e9;
            int l3 =  (obstacles[index]!=lane+1) ? 1 + helper(index,obstacles,lane+1,dp) : (int)1e9;
            int l4 =  (obstacles[index]!=lane+2) ? 1 + helper(index,obstacles,lane+2,dp) : (int)1e9;
            int min1 = Math.min(l1,l2);
            int min2 = Math.min(l3,l4);
            int min = Math.min(min1,min2);
            return dp[index][lane] = min;
        }
        else {
            return dp[index][lane] = helper(index+1,obstacles,lane,dp);
        }
    }
    public int minSideJumps(int[] obstacles) {
        int lane = 2;
        int n = obstacles.length;
        int dp[][] = new int[n+1][4];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return helper(0,obstacles,lane,dp);
    }
}