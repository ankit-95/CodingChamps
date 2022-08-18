class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals==null || intervals.length==0)
            return true;
        int start[] = new int[intervals.length];
        int end[] = new int[intervals.length];
        
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        
        Arrays.sort(start);
        Arrays.sort(end);
        int endstr = 0,total=0;
        for(int i=0;i<start.length;i++){
            if(start[i] < end[endstr]){
                total++;
            } else {
                endstr++;
            }
        }
        return total==1;
    }
}