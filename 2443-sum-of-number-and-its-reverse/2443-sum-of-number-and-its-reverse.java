class Solution {
    public int rev(int n){
        int rev = 0;
        while(n>0){
            rev = rev*10 + n%10;
            n = n/10;
        }
        return rev;
    }
    
    public boolean sumOfNumberAndReverse(int num) {
        int left = 0;
        int right = num;
        while(left<= right){
            if(left + rev(left) == num)
                return true;
            left++;
        }
        return false;
    }
}