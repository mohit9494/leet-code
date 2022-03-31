class Solution {
    public int missingNumber(int[] nums) {
        
    // Sorting
    Arrays.sort(nums);
    
    // Ensure the first and last number
    if (nums[0] != 0) return 0;
    if(nums[nums.length - 1] != nums.length) return nums.length;
 
    // Now the missing number is in the range (1, n-1)
    for(int i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
            return i;
        }
    }
        return -1;
    }
}