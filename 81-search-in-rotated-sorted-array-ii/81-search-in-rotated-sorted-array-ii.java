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
            
        // Now deal with duplicates
        while(left < nums.length - 1 && nums[left] == nums[left + 1]) {
            if(nums[left] == t) return left;
            left++;
        }
        while (right > 0 && nums[right] == nums[right - 1]) {
            if(nums[right] == t) return right;
            right--;
        }
        
        while (left <= right) {
            
            int mid = left + (right - left)/2;
            
            if(nums[mid] == t) return mid;
            else if (nums[mid]< t) left = mid + 1;
            else right = mid - 1;
            
        }
        
        return -1;
    }
    
    public boolean search(int[] nums, int target) {
        
        // get the pivot index;
      int pivot = getPivot(nums);
      if(nums[pivot] == target) return true; 
        
     int a = bs(nums, 0, pivot - 1, target);
     int b = bs(nums, pivot + 1, nums.length - 1, target);
     
    return Math.max(a, b) == -1 ? false : true;
        
    }
}