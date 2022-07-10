class Solution {
    public int findPeakElement(int[] nums) {
        
        // This is classis BS on answer problem
        if(nums.length == 1) return 0;
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right) {
            
            int mid = left + (right - left)/2;
            int gr = mid + 1 <= nums.length - 1 ? nums[mid + 1] : Integer.MIN_VALUE;
            int less = mid - 1 >= 0 ? nums[mid - 1] : Integer.MIN_VALUE;
            
            if (nums[mid] > gr && nums[mid] > less) return mid;
            
            if (nums[mid] < gr) left = mid + 1;
            else right = mid - 1;
            
        }
        
        return -1;
        
    }
}