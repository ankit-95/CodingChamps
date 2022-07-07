class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1) return 0; // base case
        
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.computeIfAbsent(arr[i], v-> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            while(size-->0){
                int top = q.remove();
                if(top-1 >0 && map.containsKey(arr[top-1]))
                    q.add(top-1);
                if(top+1 < arr.length && map.containsKey(arr[top+1])){
                    if(top+1 == arr.length-1) return steps;
                    q.add(top+1);
                }
                if(map.containsKey(arr[top])){
                    for(int k : map.get(arr[top])){
                        if(k!=top){
                            if(k==arr.length-1) return steps;
                            q.add(k);
                        }
                    }
                }
                map.remove(arr[top]);    
            }
        }
        //System.out.print(map);
        return steps;
    }
}