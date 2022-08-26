class Solution {
    public boolean reorderedPowerOf2(int n) {
        int arr[] = count(n);
        
        for(int i=0;i<31;i++){
            if(Arrays.equals(arr,count(1<<i))){
                return true;
            }
        }
        return false;
    }
    
    public int[] count(int n){
        int arr[] = new int[10];
        while(n>0){
            arr[n%10]++;
            n=n/10;
        }
        return arr;
    }
}