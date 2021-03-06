class Solution {
    public int maxSubArray(int[] nums) {
        
        if (nums.length == 1) return nums[0];
        
        int sum = nums[0];
        int maxi = nums[0];
        int start = 0;
        int end = 0;
        
        for (int i = 1; i < nums.length; i++) {
            // Get the effective running sum;
            if (sum + nums[i] < nums[i]) {
                // everything before this was useless
                start = i;
                end = i;
                sum = nums[i];
                maxi = Math.max(maxi, sum);
            } else {
                sum = sum + nums[i];              
                if (sum > maxi) {
                    maxi = sum;
                    end = i;
                }
            }
        }
        
        System.out.println("Start = "+ start + "End ==" + end);
        return maxi;
        
    }
}