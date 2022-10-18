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
        int right = num/2;
        while(right <= num){
            if(right + rev(right) == num)
                return true;
            right++;
        }
        return false;
    }
}