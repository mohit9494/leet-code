class Solution {
    
    
    public int rob(int[] nums) {
        
        int n = nums.length;
        if (n == 1) return nums[0];
        
        int[] dp = new int[n];
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);
        int c = b;
        for (int i = 2; i <= n - 1; i++) {
            int pick = nums[i] + a;
            int notPick = b;
            
            c = Math.max(pick, notPick);
            a = b;
            b = c;
        }
        
       return c;
        
    }
}