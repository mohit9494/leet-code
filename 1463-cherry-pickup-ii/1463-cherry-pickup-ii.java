class Solution {
    
    public int helper(int i, int j1, int j2, int[][] arr, int[][][] dp) {
        
        if (j1 < 0 || j1 > arr[0].length - 1 || j2 < 0 || j2 > arr[0].length - 1) return (int)-1e9;
        
        if (i == arr.length) return 0;
        
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        // for each movement of R1 -> R2 can move 3 times
        int maxi = (int) -1e9;
        for (int a = -1; a <= 1; a++) {
            for (int b = -1; b <= 1; b++) {
             
                // If both arrive in the same cell - take only one
                if (j1 == j2) {
                    maxi = Math.max(maxi, arr[i][j1] + helper(i+1, j1 + a, j2 + b, arr, dp));
                } else {
                    maxi = Math.max(maxi, arr[i][j1] + arr[i][j2] + helper(i+1, j1 + a, j2 + b,arr, dp));   
                }
                
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    
    
    public int cherryPickup(int[][] grid) {
      int m = grid.length;
      int n = grid[0].length;
      int[][][] dp = new int[m][n][n];
      for (int[][] dp1 : dp) {
          for (int[] dp2 : dp1) Arrays.fill(dp2, -1);
      }
      return helper(0, 0, n - 1, grid, dp);  
    }
}