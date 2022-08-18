class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }
        
         PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }
        
        int result = 0;
        int count= 0;
        while(!pq.isEmpty()){
            Map.Entry<Integer, Integer> entry = pq.poll();
            count+= entry.getValue();
            result++;
            if(count >= arr.length/2){
                break;
            }
        }
        return result;
    }
}