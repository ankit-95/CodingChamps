class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(),intervals.end());
        int res=0,count=0;
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals[res][1]>=intervals[i][0])
            {
                intervals[res][0]=min(intervals[res][0],intervals[i][0]);
                intervals[res][1]=max(intervals[res][1],intervals[i][1]);
                count++;
            }
            else
            {
                res++;
                intervals[res][0]=intervals[i][0];
                intervals[res][1]=intervals[i][1];
            }
        }
        while(count>0)
        {
        intervals.pop_back();
            count--;
        }
        return intervals;
    }
};