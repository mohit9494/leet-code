class Solution {
    
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private int partition(int[] a, int lo, int hi) {
        
        int i = lo;
        int j = hi + 1;
        
        while (true) {
        while (a[++i] < a[lo]) 
            if (i == hi) break;
        
        while (a[lo] < a[--j])
            if(j == lo) break;
        
        if (i >= j) break;
        
        swap(a, i, j);
            
        }
        
      swap(a, lo, j);
      
      return j;
        
    }
    
    public int findKthLargest(int[] nums, int k) {
        
    int lo = 0;
    int hi = nums.length - 1;
    
    k = nums.length - k;
        
    while (hi > lo) {
    
   int j = partition(nums, lo, hi);
                     
    if (j == k) return nums[k];
    else if (j < k) lo = j + 1;
    else hi = j - 1;
                     
    }
        
    return nums[k];
        
    }
}