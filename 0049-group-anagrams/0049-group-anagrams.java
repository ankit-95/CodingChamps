class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>(); 
        for(String s : strs){
            char c [] = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(s);
        }
        for(Map.Entry<String,List<String>> key : map.entrySet()){
            ans.add(key.getValue());
        }
        return ans;
    }
}