class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(start);
        while(!q.isEmpty()){
            int top = q.remove();
            if(arr[top]==0){
                return true;
            }
            if(visited.contains(top)) continue;
            visited.add(top);
            if(top + arr[top] < arr.length){
                q.add(top + arr[top]);
            }
            if(top - arr[top] >= 0){
                q.add(top - arr[top]);
            }
        }
        return false;
    }
}