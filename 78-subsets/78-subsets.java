class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    private void helper(int[] nums, int index, List<Integer> ds) {
        
        if (index == nums.length) {
            result.add(new ArrayList<>(ds));
            return;
        }
        
        // choose
        ds.add(nums[index]);
        helper(nums, index + 1, ds);
        ds.remove(ds.size() - 1);
        
        // Not choose
        helper(nums, index + 1, ds);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        if (nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());
        
        return result;
    }
}