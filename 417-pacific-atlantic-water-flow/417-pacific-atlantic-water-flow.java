// class Solution {
//     public List<List<Integer>> pacificAtlantic(int[][] heights) {
//         int n = heights.length;
//         int m = heights[0].length;
//         boolean pacific[][] = new boolean[n][m];
//         boolean atlantic[][] = new boolean[n][m];
        
//         Queue<int[]> pacificBuf = new LinkedList<>();
//         Queue<int[]> atlanticBuf = new LinkedList<>();
//         for(int i=0;i<n;i++){
//            pacificBuf.offer(new int[]{i,0}); 
//            atlanticBuf.offer(new int[]{i,m-1});
//            pacific[i][0]  = true;
//            atlantic[i][m-1]  = true;
//         }
        
//         for(int i=0;i<m;i++){
//            pacificBuf.offer(new int[]{0,i}); 
//            atlanticBuf.offer(new int[]{n-1,i});
//            pacific[0][i]  = true;
//            atlantic[n-1][i]  = true;
//         }
        
//         bfs(heights,pacificBuf,pacific);
//         bfs(heights,atlanticBuf,atlantic);
//         List<List<Integer>>  ans = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 List<Integer> list = new ArrayList<>();
//                 if(pacific[i][j] && atlantic[i][j]){
//                     list.add(i);
//                     list.add(j);
//                 }
//                 ans.add(new ArrayList<>(list));
//             }
//         }
//         return ans;
//     }
    
//     int dirs[][] = {{1,0},{-1,0},{0,1},{0,-1}};
//     public void bfs(int[][] heights,Queue<int[]> q,boolean visited[][]){
        
//         while(!q.isEmpty()){
//             int cur[] = q.poll();
//             for(int [] dir : dirs){
//                 int x = cur[0] + dir[0];
//                 int y = cur[1] + dir[1];
//                 if(x<0 || y<0 || x>= heights.length || y>= heights[0].length || heights[x][y] < heights[cur[0]][cur[1]]){
//                     continue;
//                 }
//                 visited[x][y] = true;
//                 q.add(new int[]{x,y});
//             }
//         }
//     }
// }
public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length, m = matrix[0].length;
        boolean[][]pacific = new boolean[n][m];
        boolean[][]atlantic = new boolean[n][m];
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, m-1);
        }
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, n-1, i);
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                List<Integer> list = new ArrayList<>();
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(i);
                    list.add(j);
                    res.add(new ArrayList<>(list));
                }
            }
        } 
                    
        return res;
    }
    
    int[][]dir = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        for(int[]d:dir){
            dfs(matrix, visited, matrix[x][y], x+d[0], y+d[1]);
        }
    }
}