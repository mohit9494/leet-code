class Solution {
    
    public int helper(int i, int buy, int cap, int[] arr, int[][][] dp) {
        
        if (cap == 0) return 0;
        if (i == arr.length) return 0;
        
        if (dp[i][buy][cap] != -1) return dp[i][buy][cap];
        
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-arr[i] + helper(i + 1, 0, cap, arr, dp), 0 + helper(i + 1, 1, cap, arr, dp));
        } else {
            // once sell is complete 1 transaction is complete
            profit = Math.max(arr[i] + helper(i + 1, 1, cap - 1, arr, dp), 0 + helper(i + 1, 0, cap, arr, dp));
        }        
        return dp[i][buy][cap] = profit;
    }
    
    public int maxProfit(int[] arr) {
        int cap = 2;
        int[][][] dp = new int[arr.length][2][cap + 1];
        for (int[][] x : dp) for (int[] y : x) Arrays.fill(y, -1);
        return helper(0, 1, cap, arr, dp);
    }
}