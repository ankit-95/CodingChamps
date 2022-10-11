class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        // for(int i=1;i<arr.length;i++){
        //     int diff = Math.abs(arr[i-1] - arr[i]);
        //     if(diff< min){
        //         min = diff;
        //     }
        // }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<arr.length;i++){
            int diff = Math.abs(arr[i-1] - arr[i]);
            if(diff==min){
                ans.add(Arrays.asList(arr[i-1],arr[i]));
            } else if(diff<min){
                ans.clear();
                ans.add(Arrays.asList(arr[i-1],arr[i]));
                min = diff;
            }
        }
        
        return ans;
    }
}