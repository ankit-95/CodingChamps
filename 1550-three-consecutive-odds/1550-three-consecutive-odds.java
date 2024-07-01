class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int result[] = new int[arr.length];
        for(int i=0;i<arr.length; i++){
            if(arr[i]%2!=0){
                result[i] = 1;
            }
        }
        for(int i=1;i<arr.length; i++){ 
            if(result[i-1]!=0 && result[i]!=0)
                result[i] += result[i-1];
        }
        for(int i=0;i<arr.length; i++){            
            if(result[i]==3)
                return true;
        }
        return false;
    }
}