class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        List<Integer> ans = new ArrayList<>();        
        if (nums == null || nums.length == 0) return ans;
        
        int n = nums.length;
        
        // Here the range is 1 - n
        // we will use negative marking        
        for (int i = 0; i < n; i++) {
            
            // we get the index to make negative
            int index = Math.abs(nums[i]) - 1; 
            
            if (nums[index] > 0 ) nums[index] = nums[index] * -1;           
            
        }
        
        // Find index with positive integer
        // Missing Number = Index + 1;        
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        
        return ans;
    }
}