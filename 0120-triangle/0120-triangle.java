class Solution {
    
    
    public int helper(List<List<Integer>> arr, int i, int j, int[][] dp) {
        
        if (i == arr.size()) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        int d1 = arr.get(i).get(j) +  helper(arr, i + 1, j, dp);
        int d2 = arr.get(i).get(j) + helper(arr, i + 1, j + 1, dp);
        
        return dp[i][j] = Math.min(d1, d2);
    }
    
    public int minimumTotal(List<List<Integer>> triangle) { 
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(triangle, 0, 0, dp);
    }
}