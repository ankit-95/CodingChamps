class Solution {
    
    public void swap(int nums[],int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    
    public void reverse(int nums[],int start){
        int last = nums.length-1;
        while(start<last){
            swap(nums,start,last);
            last--;
            start++;
        }
    }
    public void nextPermutation(int[] nums) {
        
        int i = nums.length-2;
        while(i>=0 && nums[i+1] <= nums[i]){
            i--;
        }
        if(i>=0){
            int j= nums.length-1;
            while(j>=0 && nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
        for(int t : nums)
            System.out.print(t+" ");
    }
}