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
      // right shifting by 1
      int[][] dp = new int[n + 1][m + 1];
      // Initialization
      for (int i = 0; i <= n; i++) dp[i][0] = i;
      for (int j = 0; j <= m; j++) dp[0][j] = j;
        
      for (int i = 1; i <= n; i++) {
          for (int j = 1; j <= m; j++) {
              
        // if match
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1]; 
        } else {
             // if no match - perform either insert, delete or replace and get min
            int in = 1 + dp[i][j - 1];
            int de = 1 + dp[i - 1][j];
            int re = 1 + dp[i - 1][j - 1];        
           dp[i][j] = Math.min(in, Math.min(de, re));  
        }
              
         }
      }
      return dp[n][m];
    }
}