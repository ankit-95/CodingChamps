class Solution {
    public int helper(int index,int ar[],int turn){
        if(index==ar.length-1){
            if(turn==1){
                if(ar[index-1] > ar[index])
                    return 1;
            }
            else{
                if(ar[index-1] < ar[index])
                    return 1;
            } 
            return 0;
        }
        int res = 0;
        if(turn==1){
            if(ar[index-1] > ar[index])
                res = Math.max(1 + helper(index+1,ar,1-turn), helper(index+1,ar,turn));
                return res;
        }
        if(ar[index-1] < ar[index])
            res = Math.max(1 + helper(index+1,ar,1-turn), helper(index+1,ar,turn)); 
        return res;
    }
    
    // public int maxTurbulenceSize(int[] arr) {
    //     if(arr.length==1){
    //         return arr.length;
    //     }
    //     int max1 = helper(1,arr,1);
    //     int max2 = helper(1,arr,0);
    //     return Math.max(max1,max2) + 1;
    // }
    
    public int maxTurbulenceSize(int[] arr) {
        if(arr.length < 2){
            return arr.length;
        }
        int max = 1;
        int s = 0;
        int e = 0;
        while(s<arr.length-1){
            if(arr[s]==arr[s+1]){
                s++;
                continue;
            }
            e = s+1;
            while(e+1<arr.length && isTurb(arr,e)){
                e++;
            }
            max = Math.max(max, e-s+1);
            s = e;
        }  
        return max;
    }
    
    public boolean isTurb(int arr[],int k){
        return (arr[k-1] < arr[k] && arr[k] > arr[k+1]) ||(arr[k-1] > arr[k] && arr[k] < arr[k+1]);
    }
}