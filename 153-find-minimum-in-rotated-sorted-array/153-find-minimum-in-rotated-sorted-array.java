class Solution {
    public int findMin(int[] nums) {
        
        // keep it very simple
        // we need to find the min in rotated
        // Just shrink the lo to min
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            
            int mid = lo + (hi - lo)/2;
            
            if(nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
            
        }
     
        return nums[lo];
    }
}