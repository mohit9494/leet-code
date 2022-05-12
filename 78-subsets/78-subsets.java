class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void subsetFinder(int[] nums, List<Integer> ds, int index){
        
        if(index >= nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        // pickup
        ds.add(nums[index]);
        subsetFinder(nums, ds, index + 1);
        
        // NotPickup
        ds.remove(ds.size() - 1);
        subsetFinder(nums, ds, index + 1);
        
    }
    
    
    public List<List<Integer>> subsets(int[] nums) {
        
        subsetFinder(nums, new ArrayList<>(), 0);
        return ans;
        
    }
}