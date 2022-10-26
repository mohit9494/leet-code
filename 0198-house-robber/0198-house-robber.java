class Solution {
    
    public int rob(int[] nums) { 
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for (int i = 2; i <= n - 1; i++) {
            // pick
            int pick = nums[i] + dp[i - 2];
            
            // not pick
            int notPick = dp[i - 1];
            
            dp[i] =  Math.max(pick, notPick);
        }
            
        return dp[n - 1];
    }
}