class Solution {
    public char nextGreatestLetter(char[] ar, char target) {
        int start = 0;
        int end = ar.length-1;
        char ans = '0';
        while(start<=end){
            int mid = (start+end)/2;
            if(ar[mid] > target){
                ans = ar[mid];
                end--;
            } else if(ar[mid] < target){
                start++;
            } else if(ar[mid] == target){
                start++;
            }      
        }
        return ans=='0'? ar[0] : ans;
    }
}