class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> seen = new HashSet<>(Arrays.asList(bank));
        Queue<String> q = new LinkedList<>();
        int step = 0;
        q.add(start);
        
        char ch[] = {'A','C','G','T'};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String node = q.remove();
                if(node.equals(end)){
                    return step;
                }
                
                for(char c :  ch){
                    for(int i=0;i<node.length();i++){
                        String neighbor = node.substring(0,i) + c + node.substring(i+1);
                        if(seen.contains(neighbor)){
                            seen.remove(neighbor);
                            q.add(neighbor);
                        }
                    }    
                }
            }
            step++;
        }
        return -1;
    }
}