class Solution {
    
    int[][] costs;
    
    public int helper(int house, int lastColor, int[][] dp) {
        
        if (house == 0) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i<= 2; i++) {
                if (i != lastColor) {
                 min = Math.min(min, costs[house][i]) ;
                }
            }
            return min;
        }
        
        if (dp[house][lastColor] != -1) return dp[house][lastColor];
        
        // U start from last house
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i <= 2; i++) {
            if (i != lastColor) {
                int cost = costs[house][i] + helper(house - 1, i, dp);
                min = Math.min(min, cost);
            }
        }
        
        return dp[house][lastColor] = min;
    }
    
    public int minCost(int[][] costs) {
        this.costs = costs;
        int n = this.costs.length;
        int m = this.costs[0].length;
        
        int[][] dp = new int[n][m + 1] ;// m + 1 for impossible color
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        // Start with house number -> n - 1 and prev color = 3 -> Impossible value
        return helper(n - 1, m, dp);
    }
}