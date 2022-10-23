class Solution {
    public int[] findErrorNums(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int repeat = -1;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                repeat = nums[i];
            }
            set.add(nums[i]);
        }
        
        int ans = 1;
        for(int x : set){
            if(x==ans){
                ans++;
            } else {
                break;
            }
        }
        
        return new int[]{repeat,ans};
    }
}