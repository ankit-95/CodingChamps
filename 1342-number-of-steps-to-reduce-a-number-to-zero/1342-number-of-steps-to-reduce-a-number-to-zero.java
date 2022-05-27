class Solution {
    
    public int numberOfSteps(int n) {
        if(n==0)
            return 0;
        if(n%2==0)
            return 1 + numberOfSteps(n/2);
        return 1 + numberOfSteps(n-1);
    }
}