class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum=0,result=0;
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        prefixSum.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(prefixSum.containsKey(sum-k)){
                result+=prefixSum.get(sum-k);
            }
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return result;
    }
}