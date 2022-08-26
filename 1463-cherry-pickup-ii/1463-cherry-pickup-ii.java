class Solution {
    
    public int helper(int i, int j1, int j2, int row, int col, int[][] grid, int[][][] dp){
        
        //  -> If invalid col return -1 :: Impossible value
        if (j1 < 0 || j1 > col || j2 < 0 || j2 > col) return -1;
        
        // base case
        if (i == row) {
            // both bob and alice reach the row at the same time
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];
        
        // for each movement of alice bob can take 3 position :: -1, 0 , +1
        // get the max each cell and return
        int maxi = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++){
            for (int dj2 = -1; dj2 <= 1; dj2++){
                if (j1 == j2) {
                    maxi = Math.max(maxi, grid[i][j1] + helper(i + 1, j1 + dj1, j2 + dj2, row, col, grid, dp));
                } else {
                    maxi = Math.max(maxi, grid[i][j1]+ grid[i][j2] + helper(i + 1, j1 + dj1, j2 + dj2, row,                                         col, grid, dp));
                }
                
            }
        }
        
       return dp[i][j1][j2] = maxi; 
    }
    
    public int cherryPickup(int[][] grid) {
        
        // This is 3d dp problem
        int m = grid.length;
        int n = grid[0].length;
        int j1 = 0;
        int j2 = n - 1;
        
        int[][][] dp = new int[m][n][n];
        
        for (int[][] a1 : dp) {
            for (int[] a2 : a1) Arrays.fill(a2, -1);
        }
        
        return helper(0, j1, j2, m - 1, n - 1, grid, dp);
    }
}