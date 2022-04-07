class Solution {
    public int lastStoneWeight(int[] nums) {
        PriorityQueue<Integer> q = new PriorityQueue(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        while(!q.isEmpty() && q.size()>1){
            int f = q.remove();
            int s = q.remove();
            int diff = Math.abs(f-s);
            if(diff!=0){
                q.add(diff);
            }
        }
        return q.isEmpty()?0:q.peek();
    }
}