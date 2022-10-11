class Solution {
    public int hardestWorker(int n, int[][] logs) {
        PriorityQueue<int[]> q = new PriorityQueue((a, b) -> {
            if(((int[])b)[1] == ((int[])a)[1])
                return ((int[])a)[0] - ((int[])b)[0];
            return ((int[])b)[1] - ((int[])a)[1];
        });
        
        q.add(new int[]{logs[0][0],logs[0][1]});
        for(int i= 1;i<logs.length;i++){
            int diff = logs[i][1] - logs[i-1][1];
            q.add(new int[]{logs[i][0],diff});
        }
        
        return q.peek()[0];
    }
}