class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack();
        Stack<Character> s2 = new Stack();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#' && !s1.isEmpty())
                s1.pop();
            else if(s.charAt(i)!='#')
                s1.push(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#' && !s2.isEmpty())
                s2.pop();
            else if(t.charAt(i)!='#')
                s2.push(t.charAt(i));
        }
        
        String r1="";
        Iterator itr = s1.iterator();
        while(itr.hasNext()){
            r1+=itr.next();
        }
        
        String r2="";
        itr = s2.iterator();
        while(itr.hasNext()){
            r2+=itr.next();
        }
        return r1.equals(r2);
    }
}