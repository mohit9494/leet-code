class Solution {
    
    public int helper(int i, int b, int k, int[] arr, int[][][] dp) {
        
        if (k == 0) return 0;
        if (i == arr.length) return 0;
        
        if (dp[i][b][k] != -1) return dp[i][b][k];
        // either buy or not Buy
        int profit = 0;
        if (b == 1) {
            profit = Math.max(-arr[i] + helper(i + 1, 0, k, arr, dp), 0 + helper(i + 1, 1, k ,arr,dp));
        } else {
            profit = Math.max(arr[i] + helper(i + 1, 1, k - 1, arr,dp), 0 + helper(i + 1, 0, k ,arr,dp));
        }       
        return dp[i][b][k] = profit;
    }
    
    public int maxProfit(int k, int[] arr) {
        // u need => index, k, arr, and  buy flag
        int n = arr.length;
        int[][][] dp = new int[n][2][k + 1];
        for (int[][] a : dp) for (int[] b : a) Arrays.fill(b, -1);
        
        return helper(0, 1, k, arr, dp);
    }
}