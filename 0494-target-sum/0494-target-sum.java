class Solution {
    // used as an offset
    int total;
    public int helper(int index, int target, int[] arr, int[][] dp, int sum) {
        
       if (index < 0) {
           if (sum == target) return 1;
           else return 0;
       }
       
       if (dp[index][sum + total] != Integer.MIN_VALUE) return dp[index][sum + total]; 
        
       int plus = helper(index - 1, target, arr, dp, sum + arr[index]);
       int minus = helper(index - 1, target, arr, dp, sum - arr[index]);
    
       return dp[index][sum + total] = plus + minus;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
      
        int n = nums.length;
        total = Arrays.stream(nums).sum();
        int[][] dp = new int[n + 1][2 * total + 1];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MIN_VALUE);
        return helper(n - 1, target, nums, dp, 0);
    }
}