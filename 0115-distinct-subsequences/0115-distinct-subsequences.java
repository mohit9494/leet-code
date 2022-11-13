class Solution {
    
    public int helper(int i, int j, String s, String t, int[][] dp) {
        
        // base case
        if (j == 0) return 1;
        if (i == 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        // if match -> either select or not select (not interested)
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          return dp[i][j]= helper(i - 1, j - 1, s, t, dp) + helper(i - 1, j, s, t, dp);
        } else {
          return dp[i][j]= helper(i - 1, j,s, t, dp);
        }             
    }
    
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(n, m, s, t, dp);
    }
}