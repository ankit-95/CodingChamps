class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        for(int i=0;i<32;i++){
            int sum=0;
            for(int x : nums){
                if(((x>>i) & 1) == 1)
                    sum+=1;
            }
            sum=sum%3;
            ans |=sum<<i;
        }
        return ans;
    }
}