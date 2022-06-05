class Solution {
    
    public int maxSubArray(int[] nums) {
        
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int i : nums) {
          
            sum += i;
            
            maxi = Math.max(maxi, sum);
            
            // This is IMP ..REMOVIING EFFECTS of -ve numbers
            if (sum < 0 ) sum = 0;
            
        }
        
        return maxi;
    }
}