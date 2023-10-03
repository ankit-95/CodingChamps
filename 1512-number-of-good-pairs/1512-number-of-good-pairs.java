class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i],++count);
            } else {
                map.put(nums[i],1);
            }
        }
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])>=2){
                int n = map.get(nums[i]);
                ans += n*(n-1)/2;
                map.put(nums[i],0); 
            }
        }
        return ans;
    }
}