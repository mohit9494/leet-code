class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int[][] dp = new int[r][c];
        
        // Initialize the dp array
        for (int j = 0; j < c; j++) {
            dp[r -1][j] = matrix[r - 1][j];
        }
        
        for (int i = r - 2; i >= 0; i--) {
            for (int j = 0; j < c; j++) {
                
                int a = j == 0 ? Integer.MAX_VALUE : dp[i + 1][j - 1];
                int b = dp[i+ 1][j];
                int z = j == c - 1 ? Integer.MAX_VALUE : dp[i+ 1][j + 1];
                
                int min = Math.min(a, Math.min(b,z));
             
                dp[i][j] = min + matrix[i][j];
                
            }          
            
        }
        
        int ans = Integer.MAX_VALUE;
        
        // Get the min from the first row
        for (int j = 0; j < c; j++) {
            
            ans = Math.min(ans, dp[0][j]);
        }
        
        return ans;
    }
}