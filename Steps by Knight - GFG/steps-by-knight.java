// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] S1 = br.readLine().trim().split(" ");
            String[] S2 = br.readLine().trim().split(" ");
            int[] KnightPos = new int[2];
            int[] TargetPos = new int[2];
            for(int i = 0; i < 2; i++){
                KnightPos[i] = Integer.parseInt(S1[i]);
                TargetPos[i] = Integer.parseInt(S2[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minStepToReachTarget(KnightPos, TargetPos, N);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends


class Solution
{
    public class Pair{
        int x;
        int y; 
        int step;
        public Pair(int x,int y,int step){
            this.x = x;
            this.y = y;
            this.step = step;
        }
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        int sx= KnightPos[0]-1;
        int sy= KnightPos[1]-1;
        int tx= TargetPos[0]-1;
        int ty= TargetPos[1]-1;
        
        int dis[][] = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        dis[sx][sy] = 0;
        
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.step - b.step);
        q.add(new Pair(sx,sy,0));
        int[][] dirs = new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,2},{1,-2},{2,-1},{2,+1}};
        
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int dir[] : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];
                if(nx>=0 && nx<N && ny>=0 && ny<N && dis[nx][ny] > dis[x][y] + 1){
                    dis[nx][ny] = dis[x][y] + 1;
                    q.add(new Pair(nx,ny,dis[nx][ny]));
                }
            }
        }
        return dis[tx][ty];
    }
}