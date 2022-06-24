class Solution {
    public int maxProduct(int[] ar) {
        if (ar.length == 0) {
        return 0;
        }
        int max_here_pre = ar[0];
        int min_here_pre = ar[0];
        int max_here;
        int min_here;
        int max = ar[0];
        for(int i=1;i<ar.length;i++){
            max_here = Math.max(ar[i], Math.max(max_here_pre*ar[i],min_here_pre * ar[i]));
            min_here = Math.min(ar[i], Math.min(max_here_pre*ar[i],min_here_pre * ar[i]));
            max = Math.max(max,max_here);
            max_here_pre = max_here;
            min_here_pre = min_here;
        }
        return max;
    }
}