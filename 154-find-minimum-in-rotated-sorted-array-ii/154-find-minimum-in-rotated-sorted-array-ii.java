class Solution {
    
    private int getPivot(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < nums.length - 1 && nums[left] == nums[left + 1]) left++;
        
        while (right > 0 && nums[right] == nums[right - 1]) right--;
        
        while(left < right) {
            
            int mid=  left + (right - left)/2;
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
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