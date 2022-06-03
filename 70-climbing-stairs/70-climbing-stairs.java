class Solution {
    
    // public void helper(int n, String s, List<String> ans){
    //     if(n==0){
    //         ans.add(s);
    //         return;
    //     }
    //     for(int i=1;i<=2;i++){
    //         if(n-i>=0)
    //             helper(n-i,s+i,ans);    
    //     } 
    // }
    // public int climbStairs(int n) {
    //     List<String> ans = new ArrayList<>();
    //     helper(n,"",ans);
    //     //System.out.print(ans);
    //     return ans.size();
    // }
    
    public int climbStairs(int n) {
        if(n<=1)
            return 1;
        int prev1 = 1;
        int prev2 = 2;
        for(int i=3;i<=n;i++){
            int newVal = prev1 + prev2;
            prev1 = prev2;
            prev2 = newVal;
        }
        return prev2;
    }
    
}