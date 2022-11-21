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
        int n = arr.length;
        int[][][] dp = new int[n + 1][2][cap + 1];
        
        // Initialization
        // if cap == 0 
        // no need since default val is 0
        for (int i = 0; i <= n - 1; i++) {
            for (int buy = 0; buy <= 1; buy++) {
                dp[i][buy][0] = 0;
            }
        }
        
        for (int buy = 0; buy <= 1; buy++){
            for (int c = 0; c <= 2; c++){
                dp[n][buy][c] = 0;
            }
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int c = 1; c <= cap; c++) {
                    
                    int profit = 0;
                    if (buy == 1) {
                        profit = Math.max(-arr[i] + dp[i + 1][0][c], 0 + dp[i + 1][1][c]);
                    } else {
                        // once sell is complete 1 transaction is complete
                        profit = Math.max(arr[i] + dp[i + 1][1][c - 1], 0 + dp[i + 1][0][c]);
                    }        
                     dp[i][buy][c] = profit;
                    
                }
            }
        }
        
        return dp[0][1][cap];
    }
}