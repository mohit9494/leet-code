class Solution {
    
    List<List<Integer>> ans = new ArrayList<>();
    
//     private void helper(int[] nums, List<Integer> ds, Set<Integer> set) {
        
//         if (ds.size() == nums.length) {
//             ans.add(new ArrayList<>(ds));
//             return ;
//         }
        
//         for(int i = 0; i < nums.length; i++) {
         
//             if (!set.contains(nums[i])){
                
//             set.add(nums[i]);
//             ds.add(nums[i]);
                
//             helper(nums, ds, set);
                
//             set.remove(nums[i]);
//             ds.remove(ds.size() - 1);
                
//             }
           
//         }        
        
//     }  
    
    private void swap(int[] arr, int i, int j) {
        
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        
    }
    
    private void helper(int[] nums, int index) {
        
        if(index >= nums.length) {
            List temp = new ArrayList<>();
            
            for(int i : nums) temp.add(i);
            
            ans.add(temp);
            
            return;
        }
        
        // swapping
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            helper(nums, index + 1);
            swap(nums, index, i);
            
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        
        helper(nums, 0);
        
        return ans;
        
    }
}