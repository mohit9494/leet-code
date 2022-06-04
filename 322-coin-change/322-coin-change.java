class Solution {
    public int coinChange(int[] coins, int amount) {
      
        if(coins == null || coins.length == 0) return 0;
        
        int r = coins.length;
        int c = amount;
        
        // we are taking dummy 0th row
        int[][] dp = new int[r + 1][c + 1];
        
        // Initialize dummy row
        dp[0][0] = 0;
        for(int j = 1; j < dp[0].length; j++) {
            dp[0][j] = amount + 1; // Impossible value = Infinity 
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                // If amount < coin denomination -> Do not select -> Take previous
                if(j < coins[i - 1])// why i-1 ? -> as there is dummy row
                {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // Min between pick and non-pick
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
                
            }
        }
        
        return dp[r][c] >= amount + 1 ? -1 : dp[r][c];
    }
}