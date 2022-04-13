class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        int start = 1;
        int end = num;
        while(start<=end){
            int mid = (start+end)/2;
            int res = num/mid;
            int tail = num%mid;
            if(res==mid && tail==0)
                return true;
            if(res > mid){
                start = mid+1;
            } else {
                end = mid -1;
            } 
        }        
        return false;
    }
}