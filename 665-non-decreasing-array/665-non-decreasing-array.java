class Solution {
    public boolean checkPossibility(int[] ar) {
        int c =0;
        for(int i=1;i<ar.length && c<=1;i++){
            if(ar[i-1]>ar[i]){
                c++;
                if(i-2<0 || ar[i-2] <=ar[i]) ar[i-1] = ar[i];
                else ar[i] = ar[i-1];
            }
        }
        return c<=1;
    }
}