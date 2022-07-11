class Solution {
    
    private int tollPaid(int[] cost, int[] dp, int n) {
        
      // You can either start from the step with index 0, or the step with index 1.
      if (n < 0) return 0;
      if (n == 0 || n == 1) return cost[n];
        
      if (dp[n] != -1) return dp[n];
        
      return dp[n] = cost[n] + Math.min(tollPaid(cost, dp, n - 1), tollPaid(cost, dp, n - 2));
        
        
        
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        // here the n lies beyonfd the array length
        // we need to reach n
        int n = cost.length;
        
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        // we need to pay the toll till n - 1 or n-2 and Jump from either of them\
        return Math.min(tollPaid(cost, dp, n - 1), tollPaid(cost, dp, n - 2));
        
    }
}