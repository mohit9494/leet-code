class Solution {
    
    public int helper(int[][] costs, int house, int last, int[][] dp) {
        
        if (house == costs.length) return 0;
        
        if (dp[house][last] != -1) return dp[house][last];
        
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i <= 2 ; i++) {
          if (i == last) continue;
          min = Math.min(min, costs[house][i] + helper(costs, house + 1, i, dp));  
        }
        
        return dp[house][last] = min;
    }
    
    public int minCost(int[][] costs) { 
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n][m + 1]; // 4 values are there
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(costs, 0, 3, dp);
    }
    
}