class Solution {
    
    public int helper(int[] nums, int index, int[] dp) {
        
      if (index >= nums.length) {
            return 0;
      }
        if (dp[index] != -1) return dp[index];
        
        // pick
       int left =  nums[index] + helper(nums, index + 2, dp);
        
        // Not pick
       int right =  helper(nums, index + 1, dp);
        
       return dp[index] = Math.max(left, right);
    }
    
    public int rob(int[] nums) { 
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return helper(nums, 0, dp);
    }
}