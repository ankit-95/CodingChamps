class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int min = wordsDict.length;
        int first = -1;
        int second = -1;
        for(int i=0;i<wordsDict.length;i++){
            
            if(wordsDict[i].equals(word1)){
                first = i;
            }
            if(wordsDict[i].equals(word2)){
                second = i;
            }
            if(first!=-1 && second!=-1)
                min = Math.min(min, Math.abs(first-second));
        }
        return min;
    }
}