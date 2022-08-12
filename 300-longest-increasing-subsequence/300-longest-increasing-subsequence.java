class Solution {
    public int lengthOfLIS(int[] nums) {
        
        // we will start from the smallest part and build on that
        // Initialization
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        // maintain two pointers i and j
        // j will be the slider to move from 0 to i - 1;
        int max = 1;
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                } 
            }
        }
        
        return max;
    }
}