class Solution {
    
    
    public boolean isMajorityElement(int[] nums, int target) {
        
       // Array is sorted
       int major = nums.length/2;
        
       for (int i = 0; i < nums.length - major; i++) {
           
           if (nums[i] == target && nums[i + major] == target) return true;
           
       }
        
        return false;
        
    }
}