class Solution {
    
    public int findMin(int[] nums) {
        
        // if there is only one element in array
        if(nums.length == 1) return nums[0];
        
       // If the array is already sorted
       if(nums[0] < nums[nums.length - 1]) return nums[0];
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            // Always this should be first => [3,1]
            if(nums[mid + 1] < nums[mid]) return nums[mid + 1];
            
            if(nums[mid] < nums[mid - 1]) return nums[mid];
            
            // Deciding moving direction
            if(nums[mid] > nums[left]) {
                // left part is sorted
                left = mid + 1;
            } else {
                // right part is sorted ...min is in opposite part
                right = mid - 1;
            }            
            
        }        
        return -1;
    }
}