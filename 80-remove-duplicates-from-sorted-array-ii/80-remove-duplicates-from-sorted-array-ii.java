class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 2;
        
        if (nums.length < k) return nums.length;
        
        int i = 1, j = 1, count = 1;
        
        while (j < nums.length) {
            
          if (nums[j] == nums[j - 1]) {
              count++;
          } else {
              count = 1;
          }
            
            // Check count
            if (count <= k ) {
                // move i with j
                nums[i++] = nums[j];
            }
            
            j++;
        }
        
        return i;
    }
}