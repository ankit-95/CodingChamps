class Solution {
    public int sq(int x){
        return x * x;
    }
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];
        int index = 0;
        for(int q[] : queries){
            int cnt = 0;
            for(int p[] : points){
                int dsq = sq(p[0] - q[0])  + sq(p[1]-q[1]);
                if(dsq<= sq(q[2])){
                    cnt++;
                }
            }
            ans[index++] = cnt;
        }
        return ans;
    }
}