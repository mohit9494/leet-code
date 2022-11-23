class Solution {
    
    public int helper(int prev, int i, int[] arr, int[][] dp) {
        
        if (i >= arr.length) return 0;
        
        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        // pick and non-pick
        int pick = 0;
        
        if (prev == -1 || arr[i] > arr[prev]) {
            pick = 1 + helper(i, i + 1, arr, dp);
        }
        
        int np = 0 + helper(prev, i + 1, arr, dp);
        
        return dp[i][prev + 1] = Math.max(pick, np);
    }
    
    public int lengthOfLIS(int[] nums) {
       // consider using previous index and current index 
       // use right shifting for prev index since you cannot store -1
       int n = nums.length;
       int[][] dp = new int[n][n + 1];
       for (int[] k : dp) Arrays.fill(k , -1);
       return helper(-1, 0, nums, dp); 
    }
}