class Solution {
     
    int count = 0;
    
    public void calculate1(int[] nums, int target, int idx, int sum) {
        
        // reached end of array
        if(idx == nums.length) {
            if (sum == target) count++;
        } else {
            
          calculate1(nums, target, idx + 1, sum + nums[idx]);  
          calculate1(nums, target, idx + 1, sum - nums[idx]);
        }
    }
    
    
    public int findTargetSumWays(int[] nums, int target) {
       

         calculate1(nums, target, 0, 0);
            
        return count;
        
    }
}