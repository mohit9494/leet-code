class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
      int[] test = new int[nums.length + 1];
        
      List<Integer> ans = new ArrayList<>();
      Set<Integer> set = new HashSet<>();
      
      for (int i : nums) set.add(i);
        
      for (int i = 1; i <= nums.length; i++) {
          if (!set.contains(i)) ans.add(i); 
      }
      
        
        return ans;
        
    }
}