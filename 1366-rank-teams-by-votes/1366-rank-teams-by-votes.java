class Solution {
    
    public class Node{
        char c;
        int count[] = new int[26];
        Node(char c ){
            this.c = c;
        }
    }
    
    
    public String rankTeams(String[] votes) {
        Node nodes[] = new Node[26];
        for(int i=0;i<26;i++){
            nodes[i] = new Node((char)(i+'A'));
        }
        
        for(String s : votes){
            for(int i=0;i<s.length();i++){
                nodes[(int)s.charAt(i)-'A'].count[i]++; 
            }
        }
        
        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                for (int i = 0; i < 26; i++) {
                    if (o1.count[i] != o2.count[i]) {
                        return o2.count[i] - o1.count[i];
                    }
                }
                return o1.c - o2.c;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<votes[0].length();i++){
            sb.append(nodes[i].c);
        }
        
        return sb.toString();
    }
}