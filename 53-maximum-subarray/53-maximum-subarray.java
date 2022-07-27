class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            // Get the effective running sum;
            sum = Math.max(sum + nums[i], nums[i]);
            maxi = Math.max(sum, maxi);
        }
        
        return maxi;
        
    }
}