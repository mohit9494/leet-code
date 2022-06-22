class Solution {
    
    private int helper(int[] cost, int n, int[] dp) {
        
    if (n < 0) return 0;
      // we can start from either index 0 or 1
    if (n == 0 || n == 1) return cost[n];
     
    if (dp[n] != -1) return dp[n];    
        
    return dp[n] = cost[n] + Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));
        
    }
    
    public int minCostClimbingStairs(int[] cost) {
        
        // top of floor is beyond array
        // u only pay till step i then from i jump 1 or 2
        int n = cost.length;
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
        // here we need to reach n
        // to get there we need to pay toll till either n - 1 or n - 2 :: from there we can jump 1 or 2 steps for free
        // and we will reach n
        //now get the mimimum to reach n - 1 or n-2;
        
        return Math.min(helper(cost, n - 1, dp), helper(cost, n - 2, dp));
        
    }
}