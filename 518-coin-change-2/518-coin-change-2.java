class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null || coins.length == 0) return 0;
        
        // return total number of ways
        int r = coins.length;
        int c = amount;
        
        int[][] dp = new int[r + 1][c + 1];
                                                
        // Initialize first dummy row in dp
        dp[0][0] = 1;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                // If amount  < denomination in coins array
                if(j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
                
            }
        }
                                                
        return dp[r][c];                                        
 }
}