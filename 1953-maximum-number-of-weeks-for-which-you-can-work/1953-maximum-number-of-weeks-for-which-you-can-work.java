class Solution {
    
    
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = Long.MIN_VALUE;
        for(int n : milestones){
            sum+=n;
            max = Math.max(max,n);
        }
        
        long rest = sum - max;
        return Math.min(2*rest+1,sum);
    }
}