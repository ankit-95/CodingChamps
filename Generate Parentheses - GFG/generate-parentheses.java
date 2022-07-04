// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void helper(int left,int right,List<String> list,String s){
        if(left==0 && right==0){
            list.add(s);
            return;
        }
        if(left>0) helper(left-1,right,list,s+"(");
        if(right>left) helper(left,right-1,list,s+")");
    }
    public List<String> AllParenthesis(int n) 
    {
        List<String> list = new ArrayList<>();
        helper(n,n,list,"");
        return list;
    }
}