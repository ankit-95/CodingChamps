class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
            int MAX_COST = 1000001;

            int[][][] dp = new int[m][n + 1][target + 1];

            for (int[][] matrix: dp)
                for (int[] row: matrix)
                    Arrays.fill(row, MAX_COST);

            for(int i = 1; i <= n; i++) {
                if (houses[0] == 0) dp[0][i][1] = cost[0][i - 1];
                else if (houses[0] == i) dp[0][i][1] = 0;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j <= n; j++) {
                    // if I only have two houses, I can't make 4 neighbour hoods so no point in looking at them hence the min in the next expression
                    for (int k = 1; k <= Math.min(target, i + 1); k++) {

                        if (houses[i] != 0 && houses[i] != j) continue;
                        int currCost = (houses[i] == j) ? 0 : cost[i][j - 1];

                        for (int l = 1; l <= n; l++) {
                            int newNeighour = (j == l) ? k : k - 1;
                            dp[i][j][k] = Math.min(dp[i][j][k],
                                                currCost + dp[i - 1][l][newNeighour]);
                        }
                    }
                }
            }

            int minCostRes = MAX_COST;
            for (int l = 1; l <= n; l++) {
                minCostRes = Math.min(minCostRes, dp[m - 1][l][target]);
            }

            // time - O(M * T * N * N) - T - target, match the rest to the parameters
            // space - O(M * T * N)

            // int minCostRes = minCost(houses, cost, m, n, target, 0, 0, new int[m][n + 1][target + 1]);
            return (minCostRes == MAX_COST) ? -1 : minCostRes;
        }

        private int minCost(int[] houses, int[][] cost, int m, int n, int target, int prevColorIdx, int index, int[][][] memo) {
            int MAX_COST = 1000001;
            if (index == m) {
                if (target != 1) return MAX_COST;
                return 0;
            }

            if (target == 0) return MAX_COST;

            if (memo[index][prevColorIdx][target] != 0) return memo[index][prevColorIdx][target]; 

            int minCost = MAX_COST;
            if (houses[index] == 0) {
                for (int i = 1; i <= n; i++) {
                    int newNeighour = (prevColorIdx == i || index == 0) ? target : target - 1;
                    minCost = Math.min(minCost,
                                      cost[index][i - 1] + minCost(houses, cost, m, n, newNeighour, i, index + 1, memo));
                }
            } else {
                int newNeighour = (prevColorIdx == houses[index] || index == 0) ? target : target - 1;
                minCost = Math.min(minCost, 0 + minCost(houses, cost, m, n, newNeighour, houses[index], index + 1, memo));
            }

            memo[index][prevColorIdx][target] = minCost;

            return memo[index][prevColorIdx][target];
        }
}
