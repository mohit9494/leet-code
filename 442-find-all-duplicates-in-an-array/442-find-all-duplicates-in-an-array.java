class Solution {
    
    private void swap(int i, int j, int[] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public List<Integer> findDuplicates(int[] nums) {
        
        // Brute Force 
        // Sort the array and check
        // Use HashMap or HashSet
        
        // swapsort
        // elements are from 1 to N
        int i = 0;
        List<Integer> result = new ArrayList<>();
        
        while (i < nums.length) {
            
            // check if we need swapping
            if (i + 1 == nums[i]) {
                i++;
            } else {
               
                if (nums[nums[i] - 1] != nums[i]) {
                    //Just swap it
                    swap(i, nums[i] - 1, nums);
                } else {
                    // they are equal and skip it
                    i++;
                }
                
            }
                
        }
        
        // Array is sorted
        for (int k = 0; k < nums.length; k++) {
            if (nums[k] != k + 1) {
                result.add(nums[k]);
            }
        }
        
        return result;
    }
}