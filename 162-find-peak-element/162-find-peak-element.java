class Solution {
    public int findPeakElement(int[] nums) {
        
        if (nums.length == 1) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            int leftElement = mid == 0 ? Integer.MIN_VALUE : nums[mid - 1];
            int rightElement = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];           
            
            if (nums[mid] > leftElement && nums[mid] > rightElement) {
                return mid;
            } else if (leftElement > nums[mid]) {
                // move to left
                right = mid - 1;
            } else {
                //move to right
                left = mid + 1;
            }    
    
        }
       return -1;
    }
}