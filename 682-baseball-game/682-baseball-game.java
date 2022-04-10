class Solution {
    public int calPoints(String[] ops) {
        List<String> ans = new ArrayList<>();
        ans.add(ops[0]);
        for(int i=1;i<ops.length;i++){
            if(ans.size()>=1 && ops[i].equals("C")){
                ans.remove(ans.size()-1);
            }
            else if(ans.size()>=1 && ops[i].equals("D")){
                ans.add(String.valueOf(Integer.parseInt(ans.get(ans.size()-1))*2));
            }
            else if(ans.size()>=2 && ops[i].equals("+")){
                ans.add(String.valueOf(Integer.parseInt(ans.get(ans.size()-1)) + Integer.parseInt(ans.get(ans.size()-2))));
            }
            else {
                ans.add(ops[i]);
            }
        }
        
        int out = 0;
        Iterator itr = ans.iterator();
        while(itr.hasNext()){
            out += Integer.parseInt(String.valueOf(itr.next()));
        }
        return out;
    }
}