class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        
        // find LCS String by building the DP Table
        // right shifting the index by 1;
        
        int n = str1.length();
        int m = str2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        // use the dp array;
        int a = n;
        int b = m;
        
        String ans = "";
        
        while (a > 0 && b > 0 ) {
            if (str1.charAt(a - 1) == str2.charAt(b - 1)) {
                ans = str1.charAt(a - 1) + ans;
                a--;
                b--;
            } else if (dp[a - 1][b] > dp[a][b - 1]) {
                ans = str1.charAt(a - 1) + ans;
                a--;
            } else {
                ans = str2.charAt(b - 1) + ans;
                b--;
            }
        }
        
        // Take care of the last chars
        while (a > 0) {
            ans = str1.charAt(a - 1) + ans;
            a--;
        }
        
        while (b > 0) {
            ans = str2.charAt(b - 1) + ans;
            b--;
        }
        
        return ans;
    }
}