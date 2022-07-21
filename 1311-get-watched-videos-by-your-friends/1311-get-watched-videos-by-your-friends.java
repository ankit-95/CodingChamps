class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        List<String> ans = new ArrayList<String>();
        boolean visited[] = new boolean[friends.length];
        Map<String,Integer> out = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        visited[id] = true;
        while(!q.isEmpty() && level>0){
            int size = q.size();
            while(size-->0) {
                int u = q.remove();
                for(int v : friends[u]){
                    if(!visited[v]){
                        visited[v] = true;
                        q.add(v);
                    }
                }
            }
            level--;
        }
        while(!q.isEmpty()){
            int u = q.remove();
            for(String s : watchedVideos.get(u)){
                out.put(s, out.getOrDefault(s,0)+1);
            }
        }
        return out.entrySet().stream().sorted((a,b)-> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : Integer.compare(a.getValue(),b.getValue())).map(e-> e.getKey()).collect(Collectors.toList());
    }
}