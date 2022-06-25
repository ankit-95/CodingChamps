class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<expression.length();i++){
            if(Character.isDigit(expression.charAt(i))) continue;
            List<Integer> l = diffWaysToCompute(expression.substring(0,i));
            List<Integer> r = diffWaysToCompute(expression.substring(i+1));
            for(int li : l){
                for(int ri : r){
                    switch(expression.charAt(i)){
                        case '+' : ans.add(li+ri);
                                    break;
                        case '*' : ans.add(li*ri);
                                    break;
                        case '-' : ans.add(li-ri);
                                    break;
                    }   
                }      
            }
        }
        if(ans.isEmpty()){
            ans.add(Integer.parseInt(expression));
        }
        return ans;
    }
}