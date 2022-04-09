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
        PriorityQueue<List<Integer>> q = new PriorityQueue<>(new Comparator<List<Integer>>(){
           public int compare(List<Integer> l1, List<Integer> l2){
               return l1.get(1) - l2.get(1);
           } 
        });
        
        for(Map.Entry<Integer,Integer> k1 : map.entrySet()){
            if(q.size()<k)
                q.add(Arrays.asList(k1.getKey(),k1.getValue()));
            else {
                if(k1.getValue() > q.peek().get(1)){
                    q.remove();
                    q.add(Arrays.asList(k1.getKey(),k1.getValue()));
                }
            }
        }
        int ans[] = new int[k];
        int i=0;
        while(!q.isEmpty()){
            ans[i] = q.remove().get(0);
            i++;
        }
        return ans;
    }
}