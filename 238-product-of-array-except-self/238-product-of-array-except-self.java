class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];        
        
        // calculate Left product
        int[] lp = new int[nums.length];
        
        // Calculate Right Product
        int[] rp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            if (i == 0) lp[i] = 1;
            else lp[i] = lp[i - 1] * nums[i - 1];
        }
        
        for(int i = nums.length - 1; i >= 0 ; i--) {
            if (i == nums.length - 1) rp[i] = 1;
            else rp[i] = rp[i + 1] * nums[i + 1];
        }
     
        // System.out.println(Arrays.toString(lp));
        // System.out.println(Arrays.toString(rp));
        
        for (int i = 0; i < nums.length; i++) {
            ans[i] = lp[i] * rp[i];
        }
        
        return ans;
        
    }
}