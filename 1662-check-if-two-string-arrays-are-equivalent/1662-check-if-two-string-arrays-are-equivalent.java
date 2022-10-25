class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int idx1=0,idx2=0,arr1=0,arr2=0;
        while(arr1 < word1.length && arr2 < word2.length){
            if(word1[arr1].charAt(idx1) != word2[arr2].charAt(idx2)) return false;
            if(idx1==word1[arr1].length()-1){
                idx1=0;
                arr1++;
            } else idx1++;
            if(idx2==word2[arr2].length()-1){
                idx2=0;
                arr2++;
            } else idx2++;
        }
        return arr1==word1.length && arr2==word2.length;
    }
}