class Solution {
    HashMap<String,ArrayList<Integer>> map;
    public void buildMap(String[] wordsDict) {
        map = new HashMap<>();
        for(int i=0;i<wordsDict.length;i++){
            map.putIfAbsent(wordsDict[i], new ArrayList<>());
            map.get(wordsDict[i]).add(i);
        }
    }
    
    public int shortestWordDistance(String[] wordsDict,String word1, String word2) {
        buildMap(wordsDict);
        ArrayList<Integer> loc1,loc2;
        loc1 = map.get(word1);
        loc2 = map.get(word2);
        
        int min = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;
        while(l1< loc1.size() && l2 < loc2.size()){
            int diff = Math.abs(loc1.get(l1) - loc2.get(l2));
            if(diff!=0)
                min = Math.min(min, diff);
            if(loc1.get(l1) < loc2.get(l2)){
                l1++;
            } else{
                l2++;
            }
        }
        return min;    
    }
}