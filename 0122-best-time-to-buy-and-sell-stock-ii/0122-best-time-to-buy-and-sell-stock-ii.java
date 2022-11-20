class Solution {
    
    public int helper(int i, int buy, int[] arr, int[][] dp) {
        if (i == arr.length) return 0;
        
        if (dp[i][buy] != -1) return dp[i][buy];
        
        int profit = 0;
        // either buy / not buy
        if (buy == 1) {
            profit = Math.max(-arr[i] + helper(i +  1, 0, arr, dp), 0 + helper(i + 1, 1, arr, dp));
        } else {
            profit = Math.max(arr[i] + helper(i +  1, 1, arr, dp), 0 + helper(i + 1, 0, arr, dp));
        }        
        return dp[i][buy] = profit;
    }
    
    public int maxProfit(int[] arr) {        
        int[][] dp = new int[arr.length][2];
        for (int[] k : dp) Arrays.fill(k, -1);
        return helper(0, 1, arr, dp);
    }
}