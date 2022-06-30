class Solution {
    public int minMoves(int[] nums) {
       TreeMap<Integer,Integer> map = new TreeMap<>();
       for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       }
       Map.Entry<Integer, Integer> lastEntry = map.pollLastEntry();
       int lastElement = lastEntry.getKey();
       int keyCount = lastEntry.getValue();
       int step =0;
       while(!map.isEmpty()){
           Map.Entry<Integer, Integer> secondLastEntry = map.pollLastEntry();
           step += (lastElement - secondLastEntry.getKey()) * keyCount;
           keyCount+=secondLastEntry.getValue();
           lastElement = secondLastEntry.getKey();
       }
       return step;
    }
}