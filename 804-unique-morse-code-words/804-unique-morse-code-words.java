class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String map[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            String ans = "";
            for(char c: words[i].toCharArray()){
                ans+=map[c-'a'];
            }
            set.add(ans);
        }
        return set.size();
    }
}