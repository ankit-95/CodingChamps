// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]arr = new int[n][m];
            
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < m; ++j)
                    arr[i][j] = sc.nextInt ();

    		System.out.println (new Sol().maxOnes (arr, n, m));
        }
        
    }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int helper(int ar[],int start,int last){
        int ans = -1;
        while(start<=last){
            int mid = (start+last)/2;
            if(ar[mid]==1){
                ans = mid;
                last = mid-1;
            } else {
                start = mid+1;
            }
        }
        return ans!=-1 ? ar.length - ans + 1 : ans;
    }
    public static int maxOnes (int Mat[][], int N, int M)
    {
        int index = 0;
        int max = -1;
        for(int i=0;i<N;i++){
            int ar[] = Mat[i];
            int start = 0;
            int last = ar.length-1;
            int ans = helper(ar,start,last);
            if(ans > max){
                max = ans;
                index = i;
            }
        }
        return index;
    }
}