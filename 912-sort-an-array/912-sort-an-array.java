class Solution {
    
    public void mergeSort(int ar[],int p,int r){
        if(p<r){
            int mid = (p+r)/2;
            mergeSort(ar,p,mid);
            mergeSort(ar,mid+1,r);
            merge(ar,p,mid,r);
        }
    }
    
    public void merge(int ar[],int p,int mid,int r){
        int n1 = mid-p+1;
        int n2 = r-mid;
        int left[] = new int[n1];
        int right[] = new int[n2];
        for(int i=0;i<n1;i++)
            left[i] = ar[i+p];
        for(int i=0;i<n2;i++)
            right[i] = ar[i+mid+1];
        int i=0,j=0,k=p;
        while(i<n1 && j<n2){
            if(left[i] <= right[j]){
                ar[k++] = left[i++];
            } else 
                ar[k++] = right[j++];  
        }
        while(i<n1){
            ar[k++] = left[i++];
        }
        while(j<n2){
             ar[k++] = right[j++];  
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}