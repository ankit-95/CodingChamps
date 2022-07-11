class TrieNode {
    TrieNode list[] = new TrieNode[26];
    String word;
    TrieNode(){}
    
    public boolean containsKey(char c){
        return list[c-'a']!=null;
    }
    
    public TrieNode get(char c){
        return list[c-'a'];
    }
    
    public void put(char c,TrieNode n){
        list[c-'a'] = n;
    }
    
    public void setWord(String s){
        word = s;
    }
}

class Solution {
    TrieNode root;
    Solution(){
        root = new TrieNode();   
    }
    
    public void buildTrie(String[] words){
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(!node.containsKey(c)){
                    node.put(c,new TrieNode());
                }
                node = node.get(c);
            }
            node.setWord(word);
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || !p.containsKey(c)) return;
        p = p.get(c);
        if (p.word != null) {   // found one
            res.add(p.word);
            p.setWord(null);     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res); 
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res); 
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res); 
        board[i][j] = c;
    }
}