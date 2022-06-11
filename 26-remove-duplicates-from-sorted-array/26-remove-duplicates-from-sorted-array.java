class Solution {
    public int removeDuplicates(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        int i = 0, j = 0;
        
        while (j < nums.length) {
            
            
            if (nums[j] == nums[i]) {
                j++;
            } else {
                // i and j are not equal
                // move jth element to i + 1;
                i++;
                nums[i] = nums[j];
                j++;
            }        
            
        }
         return i + 1;   
    }
}