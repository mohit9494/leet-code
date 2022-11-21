class Solution {
    
    public int helper (int i, int b, int[] arr, int[][] dp) {
     
        if (i >= arr.length) return 0;
        
        if (dp[i][b] != -1) return dp[i][b];
        
        // either buy or not buy
        int profit = 0;
        if (b == 1) {
            profit = Math.max(-arr[i] + helper(i + 1, 0, arr, dp), 0 + helper(i + 1, 1, arr, dp));
        } else {
            // apply cooldown after sell
            profit = Math.max(arr[i] + helper(i + 2, 1, arr, dp), 0 + helper(i + 1, 0, arr,dp));
        }
     return dp[i][b] = profit;   
    }
    
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int[] a : dp) Arrays.fill(a, -1);
        return helper(0, 1, arr, dp);
    }
}