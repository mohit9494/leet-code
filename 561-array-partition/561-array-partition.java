class Solution {
    public int arrayPairSum(int[] nums) {
        int max = 0;
        if (nums == null || nums.length == 0) return max;
        
        Arrays.sort(nums);
        
        for (int i = 0; i <= nums.length - 2; i = i + 2) {
            max += nums[i];
        }
        
        return max;
    }
}