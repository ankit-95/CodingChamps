class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            } else {
                map.put(nums[i],1);
            }
        }
        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>(){
           public int compare(Integer l1, Integer l2){
               return map.get(l1) - map.get(l2);
           } 
        });
        
        for(int k1 : map.keySet()){
            if(q.size()<k)
                q.add(k1);
            else {
                if(map.get(k1) > map.get(q.peek())){
                    q.remove();
                    q.add(k1);
                }
            }
        }
        int ans[] = new int[k];
        int i=0;
        while(!q.isEmpty()){
            ans[i] = q.remove();
            i++;
        }
        return ans;
    }
}