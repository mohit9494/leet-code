class Solution {
    
    public int helper(int[] cost, int n, int[] dp) {
        
        if (n == 0 || n == 1) return cost[n];
        
        if (dp[n] != -1) return dp[n];
        
        return dp[n] = cost[n] + Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
      int n = cost.length; 
      int[] dp = new int[n];
        
      dp[0] = cost[0];
      dp[1] = cost[1];
        
      for (int i = 2; i <= n - 1; i++) {
          dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
      }
       
      return Math.min(dp[n - 1], dp[n - 2]);  
    }
}