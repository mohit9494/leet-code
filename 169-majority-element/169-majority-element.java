class Solution {
    public int majorityElement(int[] nums) {
        
        // cancel each other algo
        int count = 0;
        int i = 0;
        int element = 0;
        
        while (i < nums.length) {
            
            if (count == 0) {
                // everything is cancelled // balance condition // no majority
                element = nums[i];                
            }
            
            if (element == nums[i]) {
                // same element // Increase the count
                count++;
            } else {
                count--;
            }
            
            i++;
        }
        return element;
    }
}