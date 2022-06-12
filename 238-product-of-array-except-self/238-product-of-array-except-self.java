class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        // Generate left array and use it to store ans
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) ans[i] = ans[i - 1] * nums[i - 1];
        
        // Generate Right product Dianamically
        int r = 1;
        
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * r;
            r = r * nums[i];
        }
      
        return ans;  
    }
}