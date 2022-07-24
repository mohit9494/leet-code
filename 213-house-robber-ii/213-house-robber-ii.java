class Solution {
    
    public int helper(int[] nums, int start, int end) {

        int a = nums[start];
        int b = Math.max(nums[start], nums[start + 1]);
        int c = b;
        
        for (int i = start + 2; i <= end; i++) {
            
            int pick = nums[i] + a;
            int notPick = b;
            
            c = Math.max(pick, notPick);
            a = b;
            b = c;
        }
        
        return c;
    }
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int t1 = helper(nums, 0, n - 2);
        int t2 = helper(nums, 1, n - 1);
        
        return Math.max(t1, t2);
    }
}