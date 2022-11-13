class Solution {
    
    public int helper(int i, int j, String s, String t, int[][] dp) {
        
        // base case
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;
        if (dp[i][j] != -1) return dp[i][j];
        // if match
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = helper(i - 1, j - 1, s, t, dp); 
        }
        
        // if no match - perform either insert, delete or replace and get min
        int in = 1 + helper(i, j - 1, s, t, dp);
        int de = 1 + helper(i - 1, j, s, t, dp);
        int re = 1 + helper(i - 1, j - 1, s, t, dp);
        
        return dp[i][j] = Math.min(in, Math.min(de, re));
    }
    
    public int minDistance(String word1, String word2) {
       
      int n = word1.length();
      int m = word2.length();
      int[][] dp = new int[n][m];
      for (int[] arr : dp) Arrays.fill(arr, -1);
      return helper(n - 1, m - 1, word1, word2, dp);
    }
}