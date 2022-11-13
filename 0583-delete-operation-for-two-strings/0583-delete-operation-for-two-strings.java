class Solution {
    
    public int helper(int i, int j, String s1, String s2, int[][] dp) {
        
        if (i < 0 || j < 0) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        
        // If match
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + helper(i - 1, j - 1, s1, s2, dp);
        }
        
        return dp[i][j] = Math.max(helper(i - 1, j, s1, s2, dp), helper(i, j - 1, s1, s2, dp));
    }
    
    public int minDistance(String word1, String word2) {
        // find lcs
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int lcs = helper(word1.length() - 1, word2.length() - 1, word1, word2, dp);
        return n + m - 2 * lcs;
    }
}