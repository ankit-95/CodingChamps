class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int val : hand){
            q.add(val);
        }
        
        while(!q.isEmpty()){
            int start = q.remove();
            for(int j=1;j<groupSize;j++){
                if(q.remove(start+j)){
                    continue;
                } else {
                    return false;
                }   
            }
        }
        return true;
    }
}