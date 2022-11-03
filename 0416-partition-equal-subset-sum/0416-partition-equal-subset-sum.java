class Solution {
    
    public boolean canPartition(int[] nums) {
       
        // Get the total
        int total = Arrays.stream(nums).sum();
        // odd can't be divided into two equal sum subsets
        if (total % 2 == 1) return false; 
        
        int target = total / 2; 
        int n = nums.length;
        boolean[][] dp = new boolean[n][total + 1];
        
        // Initialization
        for (int i = 0; i <= n - 1; i++) dp[i][0] = true;
        // at index == 0 return nums[0] == target
        dp[0][nums[0]] = true;
        
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= target; j++) {
               boolean take = false;
                if (j - nums[i] >= 0) {
                 take = dp[i - 1][j - nums[i]];   
                }   
               boolean notTake = dp[i - 1][j]; 
               dp[i][j] = take || notTake;
            }
        }
        return dp[n - 1][target];
    }
}