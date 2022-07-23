class Solution {
    
    public int helper(int[] cost, int[] dp, int n) {
        
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        
        if (dp[n] != -1) return dp[n];
        
        return dp[n] = cost[n] + Math.min(helper(cost, dp, n - 1), helper(cost, dp, n - 2));
    }
    public int minCostClimbingStairs(int[] cost) {
        
        // This is classic problem
        int n = cost.length;
        
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        
        return Math.min(helper(cost, dp, n - 1), helper(cost, dp, n - 2));
         
    }
}