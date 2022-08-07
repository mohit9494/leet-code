class Solution {
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        String[] dp =  new String[n];
        Arrays.fill(dp, "U");
        
        // fill the last element with Good
        dp[n - 1] = "G";
        
        for (int i = n - 2; i >= 0; i--) {
           int farJump = Math.min(n - 1, i + nums[i]);
           
            for (int j = farJump; j >= i + 1; j--) {
                if(dp[j] == "G") {
                    dp[i] = "G";
                    break;
                }
            }
            dp[i] = dp[i] == "U" ? "B" : "G";
        }
        
        System.out.println(Arrays.toString(dp));
        
     return dp[0] == "G";   
    }
}