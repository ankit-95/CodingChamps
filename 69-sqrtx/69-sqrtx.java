class Solution {
    public int mySqrt(int x) {
        if(x==0)
            return x;
        int start =1;
        int end = x;
        int ans=0;
        while(start<=end){
            int mid = (start+end)/2;
            if(mid <= x/mid && ((mid+1) > x/(mid+1))){
                ans = mid;
                return mid;
            }
            else if(mid < x/mid){
                ans = mid;
                start = mid+1;
            } else 
                end = mid-1;
        }
        return ans;
    }
}