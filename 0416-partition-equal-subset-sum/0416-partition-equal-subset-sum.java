class Solution {
    
    public boolean helper(int index, int target, int[] arr, int[][] dp) {
        
        if (target == 0) return true;
        
        if (index < 0 || target < 0) return false;
        
        if (dp[index][target] != -1) return dp[index][target] == 1 ? true : false;
        
        boolean take = helper(index - 1, target - arr[index], arr, dp);
        boolean notTake = helper(index - 1, target, arr, dp);
        dp[index][target] = (take || notTake) == true ? 1 : 0;
        return take || notTake;
    }
    
    public boolean canPartition(int[] nums) {
       
        // Get the total
        int total = Arrays.stream(nums).sum();
        
        // odd can't be divided into two equal sum subsets
        if (total % 2 == 1) return false;
        
        int target = total / 2;
        
        int[][] dp = new int[nums.length][target + 1];
        for (int[] arr : dp ) Arrays.fill(arr, -1);
        
        return helper(nums.length - 1, target, nums, dp);
    }
}