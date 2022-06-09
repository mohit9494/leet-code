class Solution {
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
                
        int i = 0;
        int j = 0;
        
        // No second array
        if (n == 0) return;
        
        if (m == 0) {
            //copy all from second to first;
            for (int element : nums2) {
                nums1[i++] = element;
            }
            return;
        }
        
        while (i < m) {
            
            if (nums1[i] <= nums2[j]) {
                i++;
            } else {
                //swap i and j;
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                
                // Reposition jth element in nums2;
                while (j < n-1 && nums2[j] > nums2[j + 1]) {
                    swap(nums2, j, j+1);
                    j++;
                }
                
                j = 0;
                
            }
    
        }
        
        // copy all from nums2 to nums1

        for (int k = i; k < nums1.length; k++) {
            nums1[k] = nums2[k - i];
        }
            
   
    }
}