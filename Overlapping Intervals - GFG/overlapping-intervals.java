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
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    public class Pair{
        int start;
        int end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public String toString(){
            return "["+start + " , "+ end+"]";
        }
    }
    public int[][] overlappedInterval(int[][] Intervals)
    {
        List<Pair> list = new ArrayList<>();
        for(int i=0;i<Intervals.length;i++){
            list.add(new Pair(Intervals[i][0],Intervals[i][1]));
        }
        Collections.sort(list, new Comparator<Pair>(){
           public int compare(Pair p1,Pair p2){
               if(p1.start == p2.start){
                   return p1.end - p2.end;
               }
               return p1.start - p2.start;
           }
        });
        List<Pair> ans = new ArrayList<>();
      //  System.out.println(list);
        //ans.add(list.get(0));
        int start = list.get(0).start;
        int end = list.get(0).end;
        for(int i=1;i<list.size();i++){
            if(list.get(i).start>=start && list.get(i).start<=end){
                start = Math.min(start,list.get(i).start); //1
                end = Math.max(end,list.get(i).end); //4
            } else {
                ans.add(new Pair(start,end));
                start = list.get(i).start;
                end = list.get(i).end;
            }
        }
        ans.add(new Pair(start,end));
       // System.out.println(ans);
        
        int result[][] = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            int res[] = new int[2];
            res[0] =ans.get(i).start;
            res[1] =ans.get(i).end;
            result[i] = res;
        }
        return result;
    }
}