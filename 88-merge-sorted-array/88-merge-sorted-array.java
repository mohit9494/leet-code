class Solution {
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void merge(int[] nums1, int m, int[] nums2, int n) {        
                
        int i = 0;
        int j = m + n - 1;
        
        // No second array
        if (n == 0) return;
        
        if (m == 0) {
            //copy all from second to first;
            for (int element : nums2) {
                nums1[i++] = element;
            }
            return;
        }
        
        int n1 = m - 1;
        int n2 = n - 1;
        
        // compare n1 and n2
        while ( n1 >= 0 && n2 >= 0) {
        if (nums1[n1] > nums2[n2]) {
            nums1[j--] = nums1[n1--];
        } else {
            nums1[j--] = nums2[n2--];
        }
        }
        
        if(n1 < 0) {
            while (j >= 0) nums1[j--] = nums2[n2--];
        }
        
            
   
    }
}