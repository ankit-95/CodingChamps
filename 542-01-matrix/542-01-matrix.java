class Solution {
    

    int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }   
        }
        while(!q.isEmpty()){
            int[] top = q.poll();
            int r = top[0], c = top[1];
            for(int dir[] : dirs){
                int nr = r+dir[0], nc = c+dir[1];
                if(nr >=0 && nr<mat.length && nc >=0 && nc<mat[0].length && mat[nr][nc] >=mat[r][c]+1){
                        mat[nr][nc] =mat[r][c]+1;
                        q.offer(new int[]{nr,nc});
                    }        
                }
            }
        return mat;
        }
}