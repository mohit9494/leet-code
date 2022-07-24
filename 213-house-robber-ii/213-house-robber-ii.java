class Solution {
    
    public int helper(int[] nums, int start, int end) {
       
        int[] dp = new int[end + 1];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        
        for (int i = start + 2; i <= end; i++) {
            
            int pick = nums[i] + dp[i - 2];
            int notPick = dp[i - 1];
            
            dp[i] = Math.max(pick, notPick);
        }
        
        return dp[end];
    }
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int t1 = helper(nums, 0, n - 2);
        int t2 = helper(nums, 1, n - 1);
        
        return Math.max(t1, t2);
    }
}