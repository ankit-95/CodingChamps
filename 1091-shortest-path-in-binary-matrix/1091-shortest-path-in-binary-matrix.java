class Solution {
    
   // DFS will not work bcz every possible path will be checked.
    public void helper(int i,int j,int[][] grid,boolean [][] visited,int dist[],int len){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || visited[i][j] == true || grid[i][j]==1)
            return;
        if(i==grid.length-1 && j==grid[0].length-1){
            dist[0] = Math.min(dist[0],len);
            return;
        }
        visited[i][j] = true;
        grid[i][j] = -1;
        helper(i-1,j-1,grid,visited,dist,len+1);
        helper(i-1,j,grid,visited,dist,len+1);
        helper(i-1,j+1,grid,visited,dist,len+1);
        helper(i,j-1,grid,visited,dist,len+1);
        helper(i,j+1,grid,visited,dist,len+1);
        helper(i+1,j-1,grid,visited,dist,len+1);
        helper(i+1,j,grid,visited,dist,len+1);
        helper(i+1,j+1,grid,visited,dist,len+1); 
    }
    
   //BFS will work bcz... it will give shortest path. 
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) return -1;
        if (grid[0].length == 0 ) return -1;
        if (grid[0][0] != 0 | grid[grid.length-1][grid[0].length-1] != 0) return -1;
        int directions [][] = {{1,1}, {0,1},{1,0},{0,-1},{-1,0},{-1, -1},{1, -1},{-1, 1}};
        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(0,0));
        grid[0][0] = 1;
        while(!q.isEmpty()){
            List<Integer> cur = q.remove();
            int x = cur.get(0);
            int y = cur.get(1);
            if(x==grid.length-1 && y==grid[0].length-1) return grid[x][y];
            for(int dir[] : directions){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==0){
                    q.add(Arrays.asList(nx,ny));
                    grid[nx][ny] = grid[x][y] + 1;
                }
            }
        }
        return -1;
    }
}