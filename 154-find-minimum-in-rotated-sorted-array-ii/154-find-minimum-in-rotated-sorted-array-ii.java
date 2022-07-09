class Solution {
    
    private int getPivot(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            
            int mid =  left + (right - left)/2;
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            else if (nums[mid] == nums[right]) {
                right--;
            }
            else {
                right = mid;
            }
            
            
        }
        
        return nums[left];
        
    }
    
    public int findMin(int[] nums) {
        
        if(nums.length == 1) return nums[0];
        
        return getPivot(nums);
        
    }
}