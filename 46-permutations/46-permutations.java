class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void swap(int[] nums, int i, int j) {
        
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        
    }
    
    private void helper(int[] nums, int index) {
        
        if (index >= nums.length) {
            
            List<Integer> tmp = new ArrayList<>();
            
            for (int i : nums) tmp.add(i);
            ans.add(tmp);            
            return;
        }
        
       for (int i = index ; i< nums.length; i++) {
           
           swap(nums, index, i);
           
           helper(nums, index + 1);
           
           swap(nums, index, i);
           
       } 
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        helper(nums,0);
        
        return ans;
        
    }
}