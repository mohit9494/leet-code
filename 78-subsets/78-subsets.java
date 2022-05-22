class Solution {
    
    // Subset -> SubSequence
    List<List<Integer>> ans=  new ArrayList<>();
    
    private void helper(int[] arr, int i, List<Integer> ds) {
        
        // Base Condition
        if (i == arr.length) {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        
        // Pick the element
        ds.add(arr[i]);
        helper(arr, i + 1, ds);
        ds.remove(ds.size() - 1);
        
        // Not pick the element
        helper(arr, i + 1, ds);
        
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        helper(nums, 0, new ArrayList<Integer>());
        
        return ans;
    }
}