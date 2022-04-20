class Solution {
    public boolean checkIfExist(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num*2) || num%2==0 && set.contains(num/2))
                return true;
            set.add(num);
        }
        return false;
    }
}