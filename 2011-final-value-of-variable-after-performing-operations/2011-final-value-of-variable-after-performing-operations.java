class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].matches("^[+X][+][+X]$"))
                ans++;
            else 
                ans--;
        }
        return ans;
    }
}