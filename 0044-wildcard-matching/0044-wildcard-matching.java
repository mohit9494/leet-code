class Solution {
    
    public boolean helper(int i, int j, String s, String p, int[][] dp) {
        
        // base case
        if (i < 0 && j < 0) return true;
        
        if (i < 0 && j >= 0) {
            // there is something in pattern
            while (j >= 0) {
                if (p.charAt(j--) != '*') return false;
            }
            return true;
        }
        
        if (i >= 0 && j < 0) return false;
        
        if (dp[i][j] != -1) return dp[i][j] == 1 ? true : false;
        
        // if match
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {

            boolean temp = helper(i - 1, j - 1, s, p, dp);
            dp[i][j] = temp == true ? 1 : 0;
            return temp;
            
        } else if (p.charAt(j) == '*' ) {
            // It can match for 0 to Infinity
            // consider it as 0 OR more
            boolean temp = helper(i - 1, j, s, p, dp) || helper(i, j - 1, s, p, dp);
            dp[i][j] = temp == true ? 1 : 0;
            return temp;
        } else {
            // no match at all
            return false;
        }
    }
    
    public boolean isMatch(String s, String p) {
       
        int n = s.length();
        int m = p.length();
        
        int[][] dp = new int[n][m];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        return helper(n - 1, m - 1, s, p, dp);
    }
}