class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Generate left array
        int[] lp = new int[nums.length];
        lp[0] = 1;        
        for (int i = 1; i < nums.length; i++) lp[i] = lp[i - 1] * nums[i - 1];
        
        // Generate right array
        int[] rp = new int[nums.length];
        rp[nums.length - 1] = 1;
        
        for (int i = nums.length - 2; i >= 0; i--) rp[i] = rp[i + 1] * nums[i + 1];
        
        int[] ans = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) ans[i] = lp[i] * rp[i];
        
        return ans;
        
    }
}