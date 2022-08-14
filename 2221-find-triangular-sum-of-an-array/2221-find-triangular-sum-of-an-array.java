class Solution {
    public int triangularSum(int[] nums) {
        ArrayList<Integer> cur = new ArrayList<>();
        for(int x : nums)
            cur.add(x);
        while(cur.size()>1){
            ArrayList<Integer> next = new ArrayList<>();
            for(int i=0;i<cur.size()-1;i++){
                next.add((cur.get(i) + cur.get(i+1))%10);
            }
            cur = next;
        }
        return cur.get(0);
    }
}