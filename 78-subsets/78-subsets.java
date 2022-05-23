class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(int[] nums, int i, List<Integer> ds) {
        
        if (i >= nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        // Pick the num
        ds.add(nums[i]);
        helper(nums, i + 1, ds);
        ds.remove(ds.size() - 1);
        
        helper(nums, i + 1, ds);
        
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, 0, new ArrayList<>());
        return ans;
    }
}