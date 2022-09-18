class Solution {
    
    public int minCost(String colors, int[] neededTime) {
        int totalTime = 0;
        int i=0,j=0;
        while(i<neededTime.length && j<neededTime.length){
            int currTotal = 0;
            int curMax = 0;
            while(j<neededTime.length && colors.charAt(i)== colors.charAt(j)){
                currTotal+=neededTime[j];
                curMax = Math.max(curMax,neededTime[j]);
                j++;
            }
            totalTime += currTotal - curMax;
            i = j;
        }
        return totalTime;
    }
}