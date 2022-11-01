class Solution {
    
    
//     public int helper(List<List<Integer>> arr, int i, int j, int[][] dp) {
        
//         if (i == arr.size()) return 0;
        
//         if (dp[i][j] != -1) return dp[i][j];
        
//         int d1 = arr.get(i).get(j) +  helper(arr, i + 1, j, dp);
//         int d2 = arr.get(i).get(j) + helper(arr, i + 1, j + 1, dp);
        
//         return dp[i][j] = Math.min(d1, d2);
//     }
    
    public int minimumTotal(List<List<Integer>> triangle) { 
        int m = triangle.size();
        int[][] dp = new int[m][m];
        // Initialization
        for (int i = 0; i <= m - 1; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        
        for (int i = m - 2; i >= 0; i--) {
           for (int j = 0; j <= i; j++) {
               dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j+ 1]);
           } 
        }
        
        return dp[0][0];
    }
}