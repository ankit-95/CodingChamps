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
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}// } Driver Code Ends




class Solution
{
    public void swap(int a,int b,int nums[]){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        Map<Integer,Integer> map = new HashMap<>();
        int temp[] = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=temp[i]){
                int old = nums[i];
                swap(map.get(temp[i]),i,nums);
                map.put(old,map.get(temp[i]));
                map.put(nums[i],i);
                count++;
            }
        }
        return count;
    }
}