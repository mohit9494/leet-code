class Solution {
    
    public int helper(int i, int j, int[][] arr, int[][] dp) {
     
        if ( i== 0 && j == 0) {
            return arr[i][j];
        }
        
        if (i < 0 || j < 0) return 400;
        
        if (dp[i][j] != -1) return dp[i][j];        
        int up = arr[i][j] + helper(i - 1, j, arr, dp);
        int left = arr[i][j] + helper(i, j - 1, arr, dp);
        
        return dp[i][j] = Math.min(up, left);
    }
    
    public int minPathSum(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][] dp = new int[m][n];
      
      for (int i = 0; i <= m - 1; i++) {
          for (int j = 0; j <= n - 1; j++) {
              if (i == 0 && j == 0) {
                  dp[i][j] = grid[i][j];
              } else {
                 int up = i - 1 >= 0 ? dp[i - 1][j] : 400;
                 int left = j - 1 >= 0 ? dp[i][j - 1] : 400;
                 dp[i][j] = grid[i][j] + Math.min(up, left);
              }
          }
      }
        
      return dp[m - 1][n - 1];
    }
}