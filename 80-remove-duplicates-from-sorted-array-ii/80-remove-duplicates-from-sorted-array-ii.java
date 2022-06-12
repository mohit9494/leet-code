class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 2;
        
        if (nums.length <= k) return nums.length;
        
        // Initialization
        int i = 1, j = 1, count = 1;
        
        while (j < nums.length) {
            
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                // Reset the count
                count = 1;
            }
            
            // check the count at present and move the i pointer which is slow with j
            if (count <= k) {
                nums[i++] = nums[j];
            }           
            
            j++;
        }
        return i;
    }
}