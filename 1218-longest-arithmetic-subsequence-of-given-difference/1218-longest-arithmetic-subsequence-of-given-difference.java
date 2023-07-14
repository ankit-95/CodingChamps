class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr){
            count.put(a, count.getOrDefault(a-difference,0)+1);
            ans = Math.max(ans,count.get(a));
        }
            
        return ans;
    }
}