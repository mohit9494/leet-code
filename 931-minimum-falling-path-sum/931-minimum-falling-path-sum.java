class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        // Initialization
        for (int k = 0; k < n; k++) dp[n - 1][k] = matrix[n - 1][k];
                                                 
        for (int i = n - 2; i >=0 ; i--) {
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int l = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                if (j - 1 >= 0) l = val + dp[i + 1][j - 1];
                if (j + 1 <= n - 1) r = val + dp[i + 1][j + 1];
                int c = val + dp[i + 1][j];
                
                dp[i][j] = Math.min(l, Math.min(c, r));
            }
        }
        
        System.out.println(Arrays.deepToString(dp));
         
         int min = Integer.MAX_VALUE;
         for (int z = 0; z < n ; z++) {
             min = Math.min(min, dp[0][z]);
         }
         return min;                                                  
                                                  
    }
}