class Solution {
    public int rob(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        
        if (n == 1) return nums[0];
        
        // Initialize the dp array
        // we need (i - 2) amount so we need to initialize first 2 places
        int prev = nums[0];
        int curr = Math.max(nums[0], nums[1]);
        
        // start from 2
        for (int i = 2; i < n; i++) {
            
            int temp = curr;
            // Take max from not choose and choose
            curr = Math.max(curr, nums[i] + prev);
            
            prev = temp;
        }
        
        return curr;
    }
}