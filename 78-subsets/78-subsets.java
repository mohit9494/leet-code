class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    private void helper(int[] nums, int index, List<Integer> ds) {
        
        result.add(new ArrayList<>(ds));
        // for loop based recursion
        
        for (int i = index; i < nums.length; i++) {
            
            ds.add(nums[i]);
            helper(nums,i + 1, ds);
            ds.remove(ds.size() - 1);
            
        }
        
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if (nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
}