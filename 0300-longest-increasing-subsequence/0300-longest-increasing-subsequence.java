class Solution {
    
    public int helper(int i, int prev, int[] arr, int[][] dp) {
        
        if (i >= arr.length) return 0;
        
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        // pick and non-pick
        int pick = 0;
        
        if (prev == -1 || arr[i] > arr[prev]) {
            pick = 1 + helper(i + 1, i, arr, dp);
        }
        
        int np = 0 + helper(i + 1, prev, arr, dp);
        
        return dp[i][prev + 1] = Math.max(pick, np);
    }
    
    public int lengthOfLIS(int[] arr) {
       // consider using previous index and current index 
       // use right shifting for prev index since you cannot store -1  
       int n = arr.length;
    // i -> n - 1 to 0
    // prev -> i - 1 to -1
       int[][] dp = new int[n + 1][n + 1];
      
       for (int i = n - 1; i >= 0 ; i--) {
           for (int prev = i - 1; prev >= -1; prev--) {
               
                // pick and non-pick
                int pick = 0;

                if (prev == -1 || arr[i] > arr[prev]) {
                    pick = 1 + dp[i + 1][i + 1];
                }

                int np = 0 + dp[i + 1][prev + 1];

                dp[i][prev + 1] = Math.max(pick, np);  
           }
       } 
        
       return dp[0][-1 + 1]; 
    }
}