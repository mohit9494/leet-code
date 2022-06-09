class Solution {
    public int maxSubArray(int[] nums) {
        
        
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            
            sum = sum + nums[i];
            
            maxi = Math.max(maxi, sum);
            
            // Kadane's
            if (sum < 0) sum = 0;                  
        }
        
        return maxi;        
    }
}