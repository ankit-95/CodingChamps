class Solution {
    public static int gameOnIntTD(int[] piles, int si, int ei, boolean turn, int[][] strg){
		if(si > ei){
			return 0;
		}
		
		// If the Recursion has Calculated the Answer  
		if(strg[si][ei] > 0){
			return strg[si][ei]; // return that Stored Answer
		}

		if(turn){ // If it is Alex's Turn
			int rr1 = gameOnIntTD(piles, si + 1,ei,false, strg) + piles[si]; // Same as Above
			int rr2 = gameOnIntTD(piles, si,ei - 1,false, strg) + piles[ei]; // Same as Above
			strg[si][ei] = Math.max(rr1, rr2); // Storing the max ans at particular indices
			return strg[si][ei];
		}
		// If it is Lee's Turn
		int rr1 = gameOnIntTD(piles, si + 1, ei, true, strg) - piles[si]; //Same logic as above
		int rr2 = gameOnIntTD(piles, si, ei - 1, true, strg) - piles[ei];//Same logic as above
		strg[si][ei] = Math.min(rr1, rr2); //Storing the answer at particular indices
		return strg[si][ei];
	}
    public boolean stoneGame(int[] piles) {
        return gameOnIntTD(piles,0,0,true,new int[piles.length][piles.length]) > 0 ? true : false;
    }
}