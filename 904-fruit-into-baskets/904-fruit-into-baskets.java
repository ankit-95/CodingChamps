class Solution {
    public int totalFruit(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int end = 0;
        int first = 0;
        int ans =0;
        while(end<nums.length){
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            while(map.size()>2){
                map.put(nums[first],map.getOrDefault(nums[first],0)-1);
                if(map.get(nums[first])==0)
                    map.remove(nums[first]);
                first++;
            }
            ans = Math.max(ans, end - first +1);   
            end++;
        }
        return ans;
    }
}