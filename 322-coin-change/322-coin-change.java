class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if (coins.length == 0 || amount == 0) return 0;
        
        // dp array
        // row - coin denomination
        // cols - amount
        
        int r = coins.length;
        int c = amount;
        
        // +1 to handle the 0 values
        int[][] dp = new int[r + 1][c + 1];
        
        // first row initialization
        for(int j = 1; j < dp[0].length; j++) {
            // Just put any impossible value
            dp[0][j] = amount + 1; 
        }
        
        for (int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++) {
                
                // here coins[i - 1] => why -1 ?
                // because we added 1 dummy row as 0 first
                // j => amount
                if (j < coins[i - 1]) {
                 dp[i][j] = dp[i - 1][j];   
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
                
                
            }
        }
          
         int ans = dp[r][c]; 
        
        return ans >= amount + 1 ? -1 : ans;
    }
}