class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i<tasks.length;i++){
            map.put(tasks[i], map.getOrDefault(tasks[i],0)+1);
        }
        
        System.out.println(map);
        int ans = 0;
        for(Map.Entry<Integer,Integer> pair : map.entrySet()){
            int val = pair.getValue();
            if(val==1)
                return -1;
            if(val%3==0){
                ans+=(val/3);
            } else{
                ans+=(val/3)+1;
            } 
        }
        return ans;   
    }
}