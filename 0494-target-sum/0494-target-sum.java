class Solution {
    
    public int helper(int index, int target, int[] arr) {
        
       if (index < 0) {
           if (0 == target) return 1;
           else return 0;
       }
        
       int plus = helper(index - 1, target - arr[index], arr);
       int minus = helper(index - 1, target + arr[index], arr);
    
       return plus + minus;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
      
        int n = nums.length;
        return helper(n - 1, target, nums);
    }
}