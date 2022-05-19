class Solution {
    
    public int searchHelper(int[] nums, int target, int left, int right) {
        
        while(left <= right) {
          
            int mid = left + (right - left)/2;
            
            if (nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1; 
            
        }
        
        return -1;
    }
    
    public int search(int[] nums, int target) {
        
        // Find the pivot element Index
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
            
            int mid = left + (right - left)/2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        // Got the pivot index
        int rot = left;
        
        int i = searchHelper(nums,target, 0, rot - 1);
        int j = searchHelper(nums, target, rot, nums.length - 1);
        
        if (i == -1 && j == -1) return -1;
        else if (i == -1) return j;
        else return i;
    }
}