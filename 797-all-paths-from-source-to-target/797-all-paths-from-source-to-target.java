class Solution {
    
    public void helper(int src,int [][]graph,List<Integer> list, List<List<Integer>> ans){
        if(src==graph.length-1 || graph[src].length==0){
            if(src==graph.length-1)
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<graph[src].length;i++){
                list.add(graph[src][i]);
                helper(graph[src][i],graph,list, ans);
                list.remove(list.size()-1);    
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>>  ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        helper(0,graph,list, ans);
        return ans;
    }
}