class Solution {
    
    public int helper(int[] nums, int index, int[] dp) {
        
        // if it choose the last element
        if (index == nums.length - 1) return nums[index];
        
        // If it skips last and go beyond
        if (index >= nums.length) return 0;
        
        if (dp[index] != -1) return dp[index];
        
        // pick the house
        int pick = nums[index] + helper(nums, index + 2, dp);
        // Not pick the house
        int notPick = 0 + helper(nums, index + 1, dp);
        
        return dp[index] = Math.max(pick, notPick);
        
    }
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        
        Arrays.fill(dp, -1);
       return helper(nums, 0, dp);
        
    }
}