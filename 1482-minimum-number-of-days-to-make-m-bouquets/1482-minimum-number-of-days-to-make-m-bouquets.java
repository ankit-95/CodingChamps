class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay == null || m == 0 || k == 0) return 0;
        if(m*k > bloomDay.length) return -1;
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for(int b : bloomDay){
            l = Math.min(l,b);
            r = Math.max(r,b);
        }
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(isValid(mid,bloomDay,m,k)){
                r = mid -1;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
    
    public boolean isValid(int target, int[] bloomDay, int m, int k){
        int count = 0;
        int curSize = 0;
        for(int val : bloomDay){
            if(val<= target) curSize++;
            else curSize = 0;
            if(curSize == k) {
                curSize =0;
                count++;
            }
            if(count==m) return true;
        }
        return false;
    }
}