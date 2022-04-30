class Solution {
    
    Map<String, Map<String,Double>> map;
    
    public double dfs(String s,String e,Set<String> visited){
        if(!map.containsKey(s))
            return -1.0;
        if(map.get(s).containsKey(e))
            return map.get(s).get(e);
        visited.add(s);
        for(Map.Entry<String,Double> pair : map.get(s).entrySet()){
            if(!visited.contains(pair.getKey())){
                double product = dfs(pair.getKey(),e,visited);
                if(product!=-1.0)
                    return Double.parseDouble(String.valueOf(pair.getValue())) * product;    
            }
        }
        return -1.0;    
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        map = new HashMap<>();
        for(int i=0;i<equations.size();i++){
            map.putIfAbsent(equations.get(i).get(0), new HashMap<>());
            map.get(equations.get(i).get(0)).put(equations.get(i).get(1),values[i]);
            map.putIfAbsent(equations.get(i).get(1), new HashMap<>());
            map.get(equations.get(i).get(1)).put(equations.get(i).get(0),1/values[i]);
        }
        
        System.out.print(map);
        double[] result = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            Set<String> visited = new HashSet();
            result[i] = dfs(queries.get(i).get(0),queries.get(i).get(1),visited);
        }
        
        return result;
    }
}