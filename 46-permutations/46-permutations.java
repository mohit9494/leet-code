class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    private void helper(int[] nums, int index, List<Integer> ds, Set<Integer> set) {
       
       // Base case is imp
       if (ds.size() == nums.length) {
            
            result.add(new ArrayList<>(ds));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            
            if (!set.contains(nums[i])) {
                
            ds.add(nums[i]);
            set.add(nums[i]);
                
            helper(nums, i + 1, ds, set);
                
            ds.remove(ds.size() - 1);
            set.remove(nums[i]);
                
            }
        }        
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        if (nums == null || nums.length == 0) return result;
        
        Set<Integer> set = new HashSet<>();
        
        helper(nums, 0, new ArrayList<>(), set);
        
        return result;
    }
}