class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null || coins.length == 0) return 0;
        
        int r = coins.length;
        int c = amount;
        
        int[][] dp = new int[r + 1][c + 1];
        
        // Initialize the dp
        // Keep in mind that you are counting total number of Ways not coins -> 
        // sum the ways at node junction
                
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
             
                // If the amount < than the coin denomination
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }               
                
            }
        }
        
        

        return dp[r][c];
 }
}