class Solution {
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        
        // we have to find the next permutation following lexographic order
        // we need to find the the disruptor here which is when nums[i] < nums[i + 1]:: Here we go in reverse dir
        //:: In that case all the nums before 
        // and nums[i] are placed properly. 
        // now next lexograpy is finding the num greater than nums[i] and swap it 
        
        // Find nums[i] where nums[i] < nums[i + 1]
        
        int i = nums.length - 2;        
        while (i >= 0) {
            if (nums[i] < nums[i + 1]) break;
            i--;
        }
        
        // we found i;
        // if  i < 0 // we need to reverse all and return
        if (i < 0) {
            i = 0;
            int j = nums.length - 1;
            while (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
            return;
        }
        
        int j = nums.length - 1;        
        while (j >= 0 && i >= 0) {
            if (nums[j] > nums[i]) break;
            j--;
        }
        
        // swap i and j
       if (i >= 0 && j >= 0) swap(nums, i, j);       
        
        // reverse from i + 1 to end
        i = i + 1;
        j = nums.length - 1;
        
        while (i <= j) {
        swap(nums, i, j);
        i++;
        j--;
        }
        
    }
}