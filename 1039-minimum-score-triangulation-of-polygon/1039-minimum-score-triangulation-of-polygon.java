class Solution {
    
    public int helper(int i, int j, int[] arr, int[][] dp) {
        
        // when its no longer a triangle
        if (j - i + 1 < 3) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int min = (int) 1e9;
        
        // move the k partition point between i and j
        for (int k = i + 1; k < j; k++) {
            int val = arr[i] * arr[k] * arr[j] + helper(i, k, arr, dp) + helper(k, j, arr, dp);
            min = Math.min(min, val);
        }
        
        return dp[i][j] = min;
    }
    
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(0, n - 1, values, dp);        
    }
}