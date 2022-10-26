class Solution {
    
//     public int helper(int[] nums, int index, int[] dp) {
        
//         if (index == nums.length - 1) {
//             return nums[index];
//         } else if (index >= nums.length) {
//             return 0;
//         }
//         if (dp[index] != -1) return dp[index];
        
//         // pick
//        int left =  nums[index] + helper(nums, index + 2, dp);
        
//         // Not pick
//        int right =  helper(nums, index + 1, dp);
        
//        return dp[index] = Math.max(left, right);
//     }
    
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
            
            dp[i] = Math.max(pick, notPick);
        }
       return dp[n - 1];
    }
}