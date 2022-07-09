class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        
        // target might be greater than the right element
        if (target > nums[right]) return right + 1;
        
        while (left < right) {
            
            int mid = left + (right - left)/2;
            
            if (nums[mid] < target) left = mid + 1;
            else right = mid;
        }
        
        // single one left ==> 
       return left;
    }
}