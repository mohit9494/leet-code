class Solution {
    
    String[] dp;
    
    public boolean canJumpfrom(int position, int[] nums) {
        if (position == nums.length - 1) return true;
        
        if (!dp[position].equals("U")) return dp[position] == "G" ? true : false;
        
        int farJump = Math.min(position + nums[position], nums.length - 1);
        
        for (int i = farJump; i >= position + 1; i--) {
            if (canJumpfrom(i, nums)) {
                dp[position] = "G";
                return true;
            }
        }
        dp[position] = "B";
        return false;
    }
    
    public boolean canJump(int[] nums) {
        this.dp =  new String[nums.length];
        Arrays.fill(this.dp, "U");
       boolean result =  canJumpfrom(0, nums);
        System.out.println(Arrays.toString(this.dp));
        return result;
    }
}