class Solution {
    public int findNumberOfLIS(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int maxi = 1;
        
        for (int i = 0; i <= n - 1; i++) {
            for (int prev = i - 1; prev >= 0; prev--) {
                if (arr[i] > arr[prev] && dp[i] < 1 + dp[prev]) {
                    dp[i] = 1 + dp[prev];
                    count[i] = count[prev];
                    // still the same number of subseq - Inherit
                } else if (arr[i] > arr[prev] && dp[i] == 1 + dp[prev]) {
                    // it has got this combination again
                    // someone else is giving the same combination
                    count[i] = count[i] + count[prev];
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }
        int ans = 0;
        for (int k = 0; k <= n - 1; k++) {
            // calculate for each maxi value
            if (dp[k] == maxi) ans += count[k];
        }
        
       return ans;
    }
}