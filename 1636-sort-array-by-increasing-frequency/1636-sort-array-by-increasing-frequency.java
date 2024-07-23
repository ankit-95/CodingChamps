class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        
        Integer numsj[] = new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            numsj[i] = nums[i];
        }
        
        Arrays.sort(numsj, (a,b)->{
            if(map.get(a).equals(map.get(b))){
                return Integer.compare(b,a);
            }
            else{
                return Integer.compare(map.get(a),map.get(b));
            }
        });
        
        for(int i=0;i<nums.length;i++){
            nums[i] = numsj[i];
        }
        return nums;
    }
}