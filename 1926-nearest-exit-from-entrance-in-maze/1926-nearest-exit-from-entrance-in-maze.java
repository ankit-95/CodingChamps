class Solution {
    
    int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0],entrance[1],0});
        boolean vis[][] = new boolean[n][m];
        vis[entrance[0]][entrance[1]] = true;
        int startx = entrance[0];
        int starty = entrance[1];
        while(!q.isEmpty()){
            int top[] = q.remove();
            int x = top[0];
            int y = top[1];
            int dist = top[2];
            if((x!= startx || y!=starty) && (x==0 || x==n-1 || y==m-1 || y==0)){
                return dist;
            }

            for(int dir[] : dirs){
                int nx = x + dir[0];                              
                int ny = y + dir[1];
                if(nx>=0 && nx < n && ny>=0 && ny < m && maze[nx][ny]=='.' && !vis[nx][ny]){
                    q.add(new int[]{nx,ny,dist+1});
                    vis[nx][ny] = true;
                }
            }
        }
        return -1;
    }
}