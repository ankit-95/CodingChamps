class Solution {
    
//     public boolean helper(String s,Set<String> copy,HashMap<String,Boolean> map){
        
//         if(s.equals(""))
//             return true;
//         if(map.containsKey(s)) return map.get(s);
//         for(String word : copy){
//             if(s.indexOf(word)==0){
//                 String suffix = s.substring(word.length());
//                 boolean flag = helper(suffix,copy,map);
//                 map.put(suffix,flag);
//                 if(flag==true)
//                     return true;
//             }
//         }
//         map.put(s,false);
//         return false;
//     }
//     public List<String> findAllConcatenatedWordsInADict(String[] words) {
//         Set<String> set = new HashSet<>();
//         List<String> res = new ArrayList<String>();
//         for(String s : words){
//             set.add(s);
//         }
        
//         for(int i=0;i<words.length;i++){
//             Set<String> copy = new HashSet<>();
//             copy.addAll(set);
//             copy.remove(words[i]);
//             HashMap<String,Boolean> map = new HashMap<>();
//             boolean flag = helper(words[i],copy,map);
//             if(flag) res.add(words[i]);
//         }
        
//         return res;
//     }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
     //sort the array in asc order of word length, since longer words are formed by shorter words.
     Arrays.sort(words, (a,b) -> a.length() - b.length());

      List<String> result = new ArrayList<>();

      //list of shorter words 
      HashSet<String> preWords = new HashSet<>();

      for(int i=0; i< words.length; i++){
          //Word Break-I problem.
          if(topDown(words[i], preWords, 0, new Boolean[words[i].length()])) {
              result.add(words[i]);
          }
          preWords.add(words[i]);
      }
      return result;
     }

    private boolean topDown(String s, HashSet<String> wordDict, int startIndex, Boolean[] memo) {
         if(wordDict.isEmpty()) {
             return false;
         }
         // if we reach the beyond the string, then return true
         // s = "leetcode" when "code" is being checked in the IF() of the loop, we reach endIndex == s.length(), 
         // and wordDict.contains("code") => true and topDown(s, wordDict, endIndex, memo) needs to return true. 
         if(startIndex == s.length()) {
             return true;
         }

         // memo[i] = true means => that the substring from index i can be segmented. 
         // memo[startIndex] means => wordDict contains substring from startIndex and it can be segemented.
         if(memo[startIndex] != null) { //Boolean[] array's default value is "null"
             return memo[startIndex];
         }

         for(int endIndex = startIndex + 1; endIndex <= s.length(); endIndex++) {
             if(wordDict.contains(s.substring(startIndex, endIndex)) && topDown(s, wordDict, endIndex, memo)) {
                 memo[startIndex] = true;
                 return true;
             }
         }
         memo[startIndex] = false;
         return false;
    }
}