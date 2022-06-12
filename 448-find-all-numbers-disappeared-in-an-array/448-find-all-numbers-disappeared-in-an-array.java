class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
      List<Integer> ans = new ArrayList<>();
   
      // Negative Marking
      for (int i = 0; i < nums.length; i++) {
          
          int index = Math.abs(nums[i]) - 1;
          
          if (nums[index] > 0) nums[index] = nums[index] * -1;
          
      }
        
    // Filter
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] > 0) ans.add(i + 1);
    }
        
        return ans;
        
    }
}