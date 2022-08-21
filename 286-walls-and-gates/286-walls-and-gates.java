class Solution {
    
    int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                if(rooms[i][j]==0)
                    q.add(new int[]{i,j});
            }
        }
        
        while(!q.isEmpty()){
            int cur[] = q.remove();
            int x = cur[0];
            int y = cur[1];
            for(int dir[] : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx >=0 && nx<rooms.length && ny>=0 && ny<rooms[0].length && rooms[nx][ny]!=-1 && rooms[x][y] +1 < rooms[nx][ny]){
                    rooms[nx][ny] = rooms[x][y] +1;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}