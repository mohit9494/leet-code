class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
      int[] test = new int[nums.length + 1];
        
      List<Integer> ans = new ArrayList<>();
      
      for (int i : nums) {
          test[i]++;
      }
      
     for (int i = 1; i < test.length; i++) {
         if (test[i] == 0) ans.add(i);
     }
        
        return ans;
        
    }
}