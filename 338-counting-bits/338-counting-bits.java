class Solution {
    public int count(int n){
        int c =0;
        while(n>0){
            if((n&1)==1){
                c++;
            }
            n = n>>1;
        }
        return c;
    }
    public int[] countBits(int n) {
        int res[] = new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++){
            res[i] = count(i);
        }
        return res;
    }
}