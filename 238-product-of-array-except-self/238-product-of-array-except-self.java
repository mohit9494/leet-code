class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        if(nums == null || nums.length == 0) return ans;
        
        // Calculate the Left Side product using ans array
        ans[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        // Getting right side product on the fly
        int r = 1;
        
        for(int i = nums.length - 1; i >= 0; i--) { 
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
        
        return ans;
        
    }
}