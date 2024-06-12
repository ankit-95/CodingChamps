class Solution {
    public void sortColors(int[] nums) {
        int zero=0,one=0,two=0;
        for(int i: nums){
            if(i==0)
                zero++;
            else if(i==1)
                one++;
            else
                two++;
        }
        int index=0;
        while(zero-->0){
            nums[index++] = 0;
        }
        while(one-->0){
            nums[index++] = 1;
        }
        while(two-->0){
            nums[index++] = 2;
        }
        
    }
}