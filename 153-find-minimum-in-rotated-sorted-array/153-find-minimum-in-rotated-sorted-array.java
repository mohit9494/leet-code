class Solution {
    // Need to find the minimum so focus on getting 
    // the left element in optimal condition
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
           
            int mid = left + (right - left)/2;
            
            // min is in right part -> nums[mid] is certainly not min as it is > nums[right] 
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right] ) {
                // mid can be minimum
                right = mid;
            }            
            
        }
        
        return nums[left];
    }
}