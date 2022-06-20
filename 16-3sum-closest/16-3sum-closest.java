class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return 0;
        Arrays.sort(nums);
        int minDis = Integer.MAX_VALUE;
        int res =0;
        for(int i=0;i<nums.length-2;i++){
            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                
                int l = i+1, r = nums.length-1;
                while(l<r){
                    int sum = nums[i]+nums[l]+nums[r];
                    if(target==sum){
                        return target;
                    } else if(sum> target){
                          if(sum - target < minDis){
                              minDis = sum - target;
                              res = sum;
                          }
                          r--;
                    } else {
                          if(target - sum < minDis){
                              minDis = target - sum;
                              res = sum;
                          }
                          l++;
                    }
                }
            }
        }
        return res;
    }
}