class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void helper(int[] nums, List<Integer> arr, int ind) {
        
        ans.add(new ArrayList<>(arr));
        
        for(int i = ind; i < nums.length; i++) {
           
            if(i > ind && nums[i] == nums[i - 1]) continue; // Avoid duplicate
            
            arr.add(nums[i]);
            helper(nums, arr, i + 1);
            arr.remove(new Integer(nums[i]));  
            
        }        
        
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        Arrays.sort(nums);
        
        List<Integer> arr = new ArrayList<>();
        
        helper(nums, arr, 0);
        
        return ans;
    }
}