class Solution {
    public String getCom(Character c){
        switch(c){
            case '0' : return "";
            case '1' : return "";
            case '2' : return "abc";
            case '3' : return "def";    
            case '4' : return "ghi";    
            case '5' : return "jkl";
            case '6' : return "mno";
            case '7' : return "pqrs";
            case '8' : return "tuv";
            case '9' : return "wxyz";
        }
        return "";
    }
    
    public void helper(int index,String digits,List<String> ans,String help){
        if(index==digits.length()){
            ans.add(help);
            return;
        }
        String getComb = getCom(digits.charAt(index));
        for(int i=0;i<getComb.length();i++){
            helper(index+1,digits,ans,help+getComb.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.equals(""))
            return ans;
        helper(0,digits,ans,"");
        return ans;
    }
}