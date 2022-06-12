class Solution {
    public int removeDuplicates(int[] nums) {
        
        int k = 1;
        
        if (nums.length <= k) return nums.length;
        
        int i = 1;
        int j = 1;
        int count = 1;
        
        while (j < nums.length) {
            
            if (nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }
            
            if (count <= k) {
                nums[i++] = nums[j];
            }
            
            j++;
        }
        
        return i;
    }
}