class Solution {
    
    private boolean binary(int[] nums, int lo, int hi, int target) {
        
        while (lo <= hi) {
            
            int mid = lo + (hi - lo)/2;
            
            if (nums[mid] == target) return true;
            else if (nums[mid] < target) lo++;
            else hi--;           
            
        }
        
        return false;
        
    }
    
    public int findPairs(int[] nums, int k) {
        
        int count = 0;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            
            if (i == 0 || nums[i] != nums[i - 1]) {
                
               int target = nums[i] + k;
                
               boolean isPresent =  binary(nums, i + 1, nums.length - 1, target);
                
               if (isPresent) count++;                
            }
            
        }

        return count;
        
    }
}