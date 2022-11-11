class Solution {
    
    String str1;
    String str2;
    
    public int helper(int i, int j, int[][] dp) {
        
        if (i == 0 || j == 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        // Match and No Match
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
          return  dp[i][j] = 1 + helper(i - 1, j - 1, dp);
        } 
       
        return dp[i][j] = Math.max(helper(i - 1, j, dp), helper(i, j - 1, dp));
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
      int n = text1.length();
      int m = text2.length();
      str1 = text1;
      str2 = text2;
      int[][] dp = new int[n + 1][m + 1];
      for (int[] arr : dp) Arrays.fill(arr, -1);
      return helper(n, m, dp);  
    }
}