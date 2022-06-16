class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(int[] nums, int index, List<Integer> ds) {
        
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        // pick and non-pick
        ds.add(nums[index]);
        helper(nums, index + 1, ds);
        ds.remove(ds.size() - 1);
        
        // Non Pick
        helper(nums, index + 1, ds);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, 0, new ArrayList<>());
        
        return ans;
    }
}