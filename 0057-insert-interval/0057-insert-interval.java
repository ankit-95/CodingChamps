class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int []> result = new ArrayList<>();
        if(intervals == null || intervals.length==0){
            int response[][] = new int[1][2];
            response[0] = newInterval;
            return response;
        }
        int i=0;
        for(;i<intervals.length;i++){
            if(newInterval[1] < intervals[i][0]){
                result.add(newInterval);
                break;
            } else if(newInterval[0] > intervals[i][1]){
                result.add(intervals[i]);
            }
            else {
                newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            }
        }
        if(i==intervals.length) result.add(newInterval);
        while(i<intervals.length) result.add(intervals[i++]);
        
        int response[][] = new int[result.size()][2];
        for(int k=0;k<result.size();k++)
            response[k] = result.get(k);
        return response;
    }
}