class Solution {
    
    public int helper(int i, int j, int[][] dp){
        
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int left = helper(i - 1, j, dp);
        int right = helper(i, j - 1, dp);
        
        return dp[i][j] = left + right;
    }
    
    public int uniquePaths(int m, int n) {
    
     int[][] dp = new int[m][n];
        
     for (int i = 0; i <= m - 1; i++) {
         for (int j = 0; j <= n - 1; j++) {
             if (i == 0 && j == 0) dp[i][j] = 1;
             else {
               int up = i - 1 >= 0 ? dp[i - 1][j] : 0;
             int left = j - 1 >= 0 ? dp[i][ j - 1] : 0;
             dp[i][j] = up + left;   
             } 
         }
     }
        
     return dp[m - 1][n - 1];   
    }
}