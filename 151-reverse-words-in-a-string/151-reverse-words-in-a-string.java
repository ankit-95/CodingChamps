class Solution {
    
    public String reverse(char c[]){
        int start = 0;
        int last = c.length-1;
        while(start<last){
            char temp = c[start];
            c[start] = c[last];
            c[last] = temp;   
            start++;
            last--;
        }
        return String.valueOf(c);
    }
    
    public String reverseWords(String s) {
        s = s.trim();
        String rev = reverse(s.toCharArray());
        System.out.print(rev);
        String result = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rev.length();i++){
            if(Character.isLetterOrDigit(rev.charAt(i))){
                sb.append(rev.charAt(i));
            } else {
                if(sb.length()>0 && sb.charAt(sb.length()-1)!=' ')
                    result += sb.reverse().toString()+" ";
                sb = new StringBuilder();
            }
        }
        result += sb.reverse().toString();
        return result;
    }
}