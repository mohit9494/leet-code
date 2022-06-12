class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Generate left array and use it to store ans
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) ans[i] = ans[i - 1] * nums[i - 1];
        
        // Generate Right product Dianamically
        int r = 1;
        
        for (int k = nums.length - 1; k >= 0; k--) {
            ans[k] = ans[k] * r;
            r = r * nums[k];
        }
      
        return ans;  
    }
}