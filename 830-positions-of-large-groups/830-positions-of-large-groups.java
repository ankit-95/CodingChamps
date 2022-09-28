class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                end++;
            } else {
                if(end-start+1>=3){
                    ans.add(Arrays.asList(start,end));
                }
                start = i+1;
                end = i+1;
            }
        }
        if(end-start+1>=3){
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }
}