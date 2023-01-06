class Solution {
    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int x : costs){
            q.add(x);
        }
        
        int ans = 0;
        while(!q.isEmpty() && q.peek() <= coins){
            ans++;
            coins-= q.remove();
        }
        
        return ans;
    }
}