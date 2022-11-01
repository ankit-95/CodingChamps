class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int result[] = new int[nums.length-k+1];
        int idx = 0;
        for(int i=0;i<nums.length;i++){
            if(!q.isEmpty() && q.peek()==i-k){
                q.poll();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i]){
                q.pollLast();
            }
            q.offer(i);
            if(i>= k-1)
                result[idx++] = nums[q.peek()];
            
        }
        return result;
    }
}