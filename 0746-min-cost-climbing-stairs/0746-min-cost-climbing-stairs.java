class Solution {
    
    public int helper(int n, int[] cost, int[] dp) {
        if (n == 0 || n == 1) return cost[n];
        if (dp[n] != -1) return dp[n];
        return dp[n] = cost[n] + Math.min(helper(n - 1, cost, dp), helper(n - 2, cost, dp));
    }
    
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(helper(n - 1, cost, dp), helper(n - 2, cost, dp));
    }
}