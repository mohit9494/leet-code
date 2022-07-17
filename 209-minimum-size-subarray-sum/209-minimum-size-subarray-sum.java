class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        
        // All positive both the target and the nums element 
        // we can use the sliding window -> we must we cant use map
        // as target can be == or greate than required
        
        
        while (j < nums.length) {
            
            // running sum
            sum += nums[j];
            
            while (sum >= target) {
                
                if (j - i + 1 < min) {
                    min = j - i + 1;     
                }
                
                // slide the window
                sum -= nums[i];
                i++;
                
            }
            
            j++;
            
        }
        
        
        return min == Integer.MAX_VALUE ? 0 : min;
        
    }
}