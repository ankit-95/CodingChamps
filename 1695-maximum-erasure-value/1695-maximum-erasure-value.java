class Solution {
    
    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int i=0,j=0,n= nums.length;
        int sum=0;
        int max =0;
        while(i<n && j<n){
            if(!set.contains(nums[j])){
                sum+=nums[j];
                max = Math.max(max,sum);
                set.add(nums[j]);
                j++;
            } else {
                sum-=nums[i];
                set.remove(nums[i]);
                i++;
            }
        }
        return max;
    }
}