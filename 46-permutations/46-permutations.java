class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(int[] nums, List<Integer> ds, Set<Integer> set) {
        
        if (ds.size() == nums.length) ans.add(new ArrayList<>(ds));
        
       for (int i = 0 ; i< nums.length; i++) {
           
           if(!set.contains(nums[i])) {
               
               set.add(nums[i]);
               ds.add(nums[i]);
               
               helper(nums, ds, set);
               
               set.remove(nums[i]);
               ds.remove(ds.size() - 1);
               
           }
           
           
       } 
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        helper(nums, new ArrayList<>(), new HashSet<>());
        
        return ans;
        
    }
}