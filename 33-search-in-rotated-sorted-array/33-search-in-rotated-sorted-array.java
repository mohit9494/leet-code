class Solution {
    
    private int getPivot(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            
            int mid=  left + (right - left)/2;
            
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
            
        }
        
        return left;
        
    }
    
    public int bs(int[] nums, int left, int right, int t){
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            
            if(nums[mid] == t) return mid;
            else if (nums[mid]< t) left = mid + 1;
            else right = mid - 1;
            
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        
      // get the pivot index;
      int pivot = getPivot(nums);
      if(nums[pivot] == target) return pivot; 
        
     int a = bs(nums, 0, pivot - 1, target);
     int b = bs(nums, pivot + 1, nums.length - 1, target);
     
    return Math.max(a, b);
    
    }
}