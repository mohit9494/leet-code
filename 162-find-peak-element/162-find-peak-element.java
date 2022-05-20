class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 1) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            
            int val = nums[mid];            
            int le = mid == 0 ? Integer.MIN_VALUE: nums[mid - 1];
            int re = mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1];
            
            if (val > le && val > re) return mid;
            else if (val > re) {
                // I am on the downword slope
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
        
    }
}