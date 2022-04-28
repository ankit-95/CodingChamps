class Solution {
    int dir[] = {0,1,0,-1,0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int efforts[][] = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(efforts[i],Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        while(!q.isEmpty()){
            int cur[] = q.remove();
            int cost = cur[0], r=cur[1], c=cur[2];
            for(int i =0;i<4;i++){
                int nr = r + dir[i];
                int nc = c + dir[i+1];
                if(nr >=0 && nr<m && nc>=0 && nc<n && efforts[nr][nc] > Math.max(cost,Math.abs(heights[r][c] - heights[nr][nc]))){
                    int effort = Math.max(cost,Math.abs(heights[r][c] - heights[nr][nc]));
                    efforts[nr][nc] = effort;
                    q.offer(new int[]{effort,nr,nc});
                }
            }
        }
        return efforts[m-1][n-1];
    }
}