// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static boolean helper(int index,String A,int end,HashSet<String> set){
        if(index==end)
            return true;
        for(int i=index+1;i<=end;i++){
            if(set.contains(A.substring(index,i)))  
                if(helper(i,A,end,set))
                    return true;
        }
        return false;
    }
    public static int wordBreak(String A, ArrayList<String> B )
    {
        HashSet<String> set = new HashSet<String>();
        for(String s : B){
            set.add(s);
        }
        
        return helper(0,A,A.length(),set)?1:0;
    }
}