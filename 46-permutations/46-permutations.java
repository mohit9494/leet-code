class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void getPermute(int[] nums, int index){
        
       
        
        if(index >= nums.length) {
            
            List<Integer> ds = new ArrayList<>();
            
            for(int i : nums) ds.add(i);
            ans.add(ds);
            return;
        }
            
        for(int i = index; i < nums.length; i++) {
            
            // swap numbers for i to end with index;
            swap(nums, index, i);
            getPermute(nums, index + 1); // This is IMP
            swap(nums, index, i); // reswap it to cater backtracking
            
        }
 
         }
    
    public List<List<Integer>> permute(int[] nums) {
        
        getPermute(nums, 0);
        return ans;
    }
}