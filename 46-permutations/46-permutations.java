class Solution {
    
    List<List<Integer>> result = new ArrayList<>();
    
    private void swap(int[] arr, int i, int j) {
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private void helper(int[] nums, int index) {
        
        // base
        if (index == nums.length) {
            
            List<Integer> temp = new ArrayList<>();
            
            for (int i : nums) temp.add(i);
           
            result.add(temp);
            return;
        }
        
        
       for (int i = index; i < nums.length; i++) {
           
           swap(nums, index, i);
           helper(nums, index + 1);
           swap(nums, index, i);
           
       } 
        
        
    }
    
    public List<List<Integer>> permute(int[] nums) {
        
        if (nums == null || nums.length == 0) return result;
        
        helper(nums, 0);
        
        return result;
    }
}