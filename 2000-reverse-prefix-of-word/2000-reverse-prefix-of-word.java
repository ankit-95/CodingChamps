class Solution {
    
    public void reverse(char ch[], int s,int l){
        while(s<=l){
            char temp = ch[s];
            ch[s] = ch[l];
            ch[l] = temp;
            s++;
            l--;
        }
    }
    public String reversePrefix(String word, char ch) {
        char c[] = word.toCharArray();
        int i=0;
        for(i=0;i<c.length;i++){
            if(c[i]==ch)
                break;
        }
        if(i<c.length){
            reverse(c,0,i);
        }
        return String.valueOf(c);
    }
}