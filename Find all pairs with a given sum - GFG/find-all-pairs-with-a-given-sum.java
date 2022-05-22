// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            long N = Long.parseLong(stt.nextToken());
            long M = Long.parseLong(stt.nextToken());
            long X = Long.parseLong(stt.nextToken());
            long A[] = new long[(int)(N)];
            long B[] = new long[(int)(M)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < N; i++) {
                A[i] = Long.parseLong(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < M; i++) {
                B[i] = Long.parseLong(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            pair [] answer = obj.allPairs(A, B, N, M, X);
            int sz = answer.length;
            
            if(sz==0)
            System.out.println(-1);
            else{
                StringBuilder output = new StringBuilder();
                for(int i=0;i<sz;i++){
                    if(i<sz-1)
                    output.append(answer[i].first +" "+ answer[i].second + ", ");
                    else
                    output.append(answer[i].first +" "+ answer[i].second);
                    
                }
                System.out.println(output);
            }
            
        }
	}
}
// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/
class Solution {
        
    
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        HashSet<Long> set = new HashSet<>();
        Arrays.sort(A);
        for(int i=0;i<N;i++){
            set.add(A[i]);
        } 
        Arrays.sort(B);
        List<ArrayList<Long>> ans = new ArrayList<>();
        for(int i=0;i<M;i++){
            List<Long> list = new ArrayList<>();
            long diff = X - B[i];
            if(set.contains(diff)){
                list.add(diff);
                list.add(B[i]);
                ans.add(new ArrayList<>(list));
            }
        }
        Collections.sort(ans, new Comparator<ArrayList<Long>>(){
            public int compare(ArrayList<Long> l1, ArrayList<Long> l2){
                return (int)(l1.get(0) - l2.get(0));
            }
        });
        pair p[] = new pair[ans.size()];
        for(int i=0;i<ans.size();i++){
            List<Long> list = ans.get(i);
            p[i] = new pair(list.get(0),list.get(1));
        }
        return p;
    }
}