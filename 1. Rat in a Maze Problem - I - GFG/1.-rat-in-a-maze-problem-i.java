// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    public static boolean isSafe(int row, int col, int [][] m,int n){
        return (row>=0 && row< n && col>=0 && col <n && m[row][col]==1);
    }
    
    public static void helper(int row,int col,int [][] m,int n,ArrayList<String> ans, String help){
        if(row==n-1 && col==n-1 && m[row][col]==1){
            ans.add(help);
            return;
        }
        
        if(isSafe(row,col,m,n)){
            m[row][col]=0;
            helper(row+1,col,m,n,ans,help+"D");
            helper(row,col+1,m,n,ans,help+"R");
            helper(row-1,col,m,n,ans,help+"U");
            helper(row,col-1,m,n,ans,help+"L");
            m[row][col]=1;
        }
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<String>();
        helper(0,0,m,n,ans,"");
        if(ans.size()==0) {
            return ans;
        } 
        return ans;
    }
}