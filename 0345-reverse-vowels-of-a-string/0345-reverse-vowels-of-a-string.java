class Solution {
    
    public boolean isVowel(char c){
        switch(c){
            case 'a' : return true;
            case 'e' : return true;
            case 'i' : return true;
            case 'o' : return true;
            case 'u' : return true;
            case 'A' : return true;
            case 'E' : return true;
            case 'I' : return true;
            case 'O' : return true;
            case 'U' : return true;
                
        }
        return false;
    }
    
    public String reverseVowels(String s) {
        char c[] = s.toCharArray();
        int start = 0;
        int last = c.length-1;
        while(start<last){
            if(isVowel(c[start]) && isVowel(c[last])){
                char temp = c[start];
                c[start] = c[last];
                c[last] = temp;
                start++;
                last--;
            } else if(isVowel(c[start]) && !isVowel(c[last])){
                last--;
            } else if(!isVowel(c[start]) && isVowel(c[last])){
                start++;
            } else {
                start++;
                last--;
            }
        }
        
        return String.valueOf(c);
    }
}