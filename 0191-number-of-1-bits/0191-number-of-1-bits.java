public class Solution {
    
    public int count(int n,int len){
        if(n==0 || len==32)
            return 0;
        if((1&(n))==1){
            return 1 + count(n>>1,len+1);    
        }
        return count(n>>1,len+1);
    }
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return count(n,0);
    }
}