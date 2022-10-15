class Solution {
    public List<String> cellsInRange(String s) {
        String[] str = s.split(":");
        char aplS = str[0].charAt(0);
        int start = Integer.valueOf(str[0].charAt(1)-'0');
        
        char aplE = str[1].charAt(0);
        int end = Integer.valueOf(str[1].charAt(1)-'0');
        
        List<String> ans = new ArrayList<>();
        for(char c =aplS;c<=aplE;c++){
            for(int i =start;i<=end;i++){
                ans.add(new String(c+""+i));
            }
        }
        return ans;
    }
}