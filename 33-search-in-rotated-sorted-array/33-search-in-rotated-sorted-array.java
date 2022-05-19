class Solution {
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
        
        int rot = left;
        
         left = 0;
         right = nums.length - 1;
        int n = nums.length;
            
        // Normal Binary Search
        while(left <= right){
            
            int mid = left + (right - left)/2;
            int realmid = (rot + mid) % n; // derivation
            
            if (nums[realmid] == target) return realmid;
            else if(nums[realmid] < target) left = mid + 1;
            else right = mid - 1;            
        }
        
        return -1;
    }
}