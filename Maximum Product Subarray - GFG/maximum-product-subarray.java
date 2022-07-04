// { Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long max_here_pre = arr[0];
        long min_here_pre = arr[0];
        long max = arr[0];
        for(int i=1;i<n;i++){
            long max_here = Math.max(arr[i], Math.max(max_here_pre*arr[i],min_here_pre*arr[i]));
            long min_here = Math.min(arr[i], Math.min(max_here_pre*arr[i],min_here_pre*arr[i]));
            max = Math.max(max,max_here);
            max_here_pre = max_here;
            min_here_pre = min_here;
        }
        return max;
    }
}