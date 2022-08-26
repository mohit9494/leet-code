class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        prev = matrix[n - 1];
        
        if (n == 1) return matrix[0][0];
        
        // Initialization
        // for (int k = 0; k < n; k++) dp[n - 1][k] = matrix[n - 1][k];
                                                 
        for (int i = n - 2; i >=0 ; i--) {
            curr = new int[n];
            for (int j = 0; j < n; j++) {
                int val = matrix[i][j];
                int l = Integer.MAX_VALUE;
                int r = Integer.MAX_VALUE;
                if (j - 1 >= 0) l = val + prev[j - 1];
                if (j + 1 <= n - 1) r = val + prev[j + 1];
                int c = val + prev[j];
                
                curr[j] = Math.min(l, Math.min(c, r));
            }
            prev = curr;
            System.out.println(Arrays.toString(curr));
        }
        
        //System.out.println(Arrays.deepToString(dp));
         
         int min = Integer.MAX_VALUE;
         for (int z = 0; z < n ; z++) {
             min = Math.min(min, curr[z]);
         }
         return min;                                                                                                   
    }
}