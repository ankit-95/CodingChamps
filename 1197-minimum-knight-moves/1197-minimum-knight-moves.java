class Solution {
    public int minKnightMoves(int x, int y) {
        int dirs[][] = {{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
        x = Math.abs(x);
        y = Math.abs(y);
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int count=0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] cur = q.poll();
                int u = cur[0];
                int v = cur[1];
                if(u==x && v==y){
                    return count;
                }
                
                for(int dir[] : dirs){
                    int nx = u + dir[0];
                    int ny = v + dir[1];
                    if(!visited.contains(nx+","+ny) && nx>=-1 && ny>=-1){
                        visited.add(nx+","+ny);
                        q.add(new int[]{nx,ny});
                    }
                }
            }
            count++;
        }
        
        return count;
    }
}