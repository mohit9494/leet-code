class Solution {
    
    private int findFirst(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int first = -1;
        
        while (left <= right) {
            
            mid = left + (right - left)/ 2 ;
            
            if (nums[mid] == target) {
                first = mid;
                right = mid - 1; //Imp step
            } else if (nums[mid] < target) {
               left = mid + 1; 
            } else {
                right = mid - 1;
            }
            
        } 
        
          return first;    
    }
    
    
    private int findLast(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length - 1;
        int mid;
        int last = -1;
        
        while (left <= right) {
            
            mid = left + (right - left)/ 2 ;
            
            if (nums[mid] == target) {
                last = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
               left = mid + 1; 
            } else {
                right = mid - 1;
            }
            
        } 
        return last;  
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        
        int[] result = new int[2];
        // Finding first 
        result[0] = findFirst(nums, target);
        
        // Finding Last
        result[1] = findLast(nums, target); 
        
        return result;  
    }
}