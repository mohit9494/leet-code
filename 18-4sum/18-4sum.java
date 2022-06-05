class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums.length == 0) return ans;
        
        // Sort the array
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 3 ; i++) {
            
            if (i == 0 || nums[i] != nums[i - 1]) {
                
             for (int j = i + 1; j < nums.length - 2 ; j++) {
    
                 if (j == i + 1 || nums[j] != nums[j - 1]) {
                     
                     int sum = target - nums[i] - nums[j]; 
                     int lo = j + 1;
                     int hi = nums.length - 1;
                     
                     while (lo < hi) {
                         
                         if (nums[lo] + nums[hi] < sum) lo++;
                         else if (nums[lo] + nums[hi] > sum) hi--;
                         else {
                             // we got the ans
                             ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                             
                             // avoid duplicates
                             while(lo < hi && nums[lo] == nums[lo + 1]) lo++;
                             while(lo < hi && nums[hi] == nums[hi - 1]) hi--;
                             
                             lo++;
                             hi--;
                             
                         }
                         
                         
                         
                     }
                     
                     
                 }
                 
             }
    }    
        } 
        return ans;
    }
}