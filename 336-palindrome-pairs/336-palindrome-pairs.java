class Solution {
    
    public List<String> allValidSuffex(String s){
        List<String> suffixes = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,0,i)){
                suffixes.add(s.substring(i+1));
            }
        }
        return suffixes;
    }
    
    public List<String> allValidPrefixes(String s){
        List<String> prefixes = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            if(isPalindrome(s,i,s.length()-1)){
                prefixes.add(s.substring(0,i));
            }
        }
        return prefixes;
    }
    
    public boolean isPalindrome(String s,int f,int l){
        while(f<l){
            if(s.charAt(f)!=s.charAt(l)) return false;
            f++;
            l--;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++)
            map.put(words[i],i);
        
        for(String str : words){
            int currentIndex = map.get(str);
            String reverseString = new StringBuffer(str).reverse().toString();
            if(map.containsKey(reverseString) && currentIndex!= map.get(reverseString))
                ans.add(Arrays.asList(currentIndex,map.get(reverseString)));
            
            // valid suffixes
            for(String s : allValidSuffex(str)){
                String reverse = new StringBuffer(s).reverse().toString();
                if(map.containsKey(reverse)){
                     ans.add(Arrays.asList(map.get(reverse),currentIndex));
                }
            }
                
                
            // valid prefixes
            for(String s : allValidPrefixes(str)){
                String reverse = new StringBuffer(s).reverse().toString();
                if(map.containsKey(reverse)){
                     ans.add(Arrays.asList(currentIndex,map.get(reverse)));
                }
            }
        }
        
        return ans;
    }
}