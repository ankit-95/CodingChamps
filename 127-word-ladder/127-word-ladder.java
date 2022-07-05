class Solution {
    public int ladderLength(String startWord, String targetWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        boolean isPresent = false;
        for(String s : wordList){
            if(s.equals(targetWord)){
                isPresent=true;
            }
            set.add(s);
        }
        if(!isPresent)
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-->0){
                String curr = q.remove();
                for(int i=0;i<curr.length();i++){
                    char c[] = curr.toCharArray();
                    for(char ch='a';ch<='z';ch++){
                        c[i] = ch;
                        if(String.valueOf(c).equals(curr))
                            continue;
                        if(String.valueOf(c).equals(targetWord))
                            return level+1;
                        if(set.contains(String.valueOf(c))){
                            q.add(String.valueOf(c));
                            set.remove(String.valueOf(c));
                        }    
                    }
                }
            }
        }
        return 0;
    }
}