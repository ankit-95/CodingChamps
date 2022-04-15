// { Driver Code Starts
import java.util.*;

class MaxLenZeroSumSub
{

    // Returns length of the maximum length subarray with 0 sum

    // Drive method
    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            GfG g = new GfG();
            System.out.println(g.maxLen(arr, n));
            T--;
        }
    }
}// } Driver Code Ends


class GfG
{
    int maxLen(int ar[], int n)
    {
        Map<Integer, Integer> map = new HashMap<>();
        int ans=0;
        int curSum=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            curSum+=ar[i];
            if(!map.containsKey(curSum)){
                map.put(curSum,i);
            }
            else {
                int a1 = map.get(curSum);
                ans = Math.max(ans, i - a1);
            }
        }
        return ans;
    }
}