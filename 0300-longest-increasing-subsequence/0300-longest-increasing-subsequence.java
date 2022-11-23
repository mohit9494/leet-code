class Solution {
    
    public int lengthOfLIS(int[] arr) {
        
       int n = arr.length;   
       int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;
        
       for (int i = 0; i <= n - 1; i++) {
           for (int prev = i - 1; prev >= 0; prev--) {
               if (arr[i] > arr[prev]) {
                   dp[i] = Math.max(dp[i], 1 + dp[prev]);
               }
           }
           maxi = Math.max(maxi, dp[i]);
       }
    return maxi;
    }
}