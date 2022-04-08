class Solution {
    
    public void swap(int a, int b, char ch[]){
        char temp = ch[a];
        ch[a] = ch[b];
        ch[b] = temp;
    }
    
    public void reverse(char ch[], int start){
        int last = ch.length-1;
        while(start<=last){
            swap(start,last,ch);
            start++;
            last--;
        }
    }
    
    
    public int nextPerm(char ch[]){
        int i = ch.length-2;
        while(i>=0 && ch[i+1]<=ch[i]){
            i--;
        }
        int count=0;
        if(i>=0){
            int j = ch.length-1;
            while(j>=0 && ch[j] <= ch[i]){
                j--;
            }
            count++;
            swap(i,j,ch);
        }
        reverse(ch,i+1);
        // System.out.println(String.valueOf(ch) +"  "+count);
        return count;
    }
    public int getMinSwaps(String num, int k) {
        int ans = 0;
        char ch[] = num.toCharArray();
        for(int i=0;i<k;i++){
            nextPerm(ch);
        }
        char original[] = num.toCharArray();
        char perm[] = ch;
        int i=0;
        while(i<original.length){
            int j=i;
            while(perm[j]!=original[i]) j++;
            while(i<j){
                ans++;
                swap(j,j-1,perm);
                j--;
            }
            i++;
        }
        return ans;
    }
}