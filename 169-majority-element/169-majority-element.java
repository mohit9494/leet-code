class Solution {
    public int majorityElement(int[] nums) {
        
        int count = 0;
        int i = 0;
        int element = 0;
        
        while (i < nums.length) {
          
            if (count == 0) {
                // Take the current element since everyone cancelled each other
                element = nums[i];
            }
            
            if (element == nums[i]) {
                // Increase the count if same element is present
                count++;
            } else {
                // decrease the count as other element is there
                count--;
            }
            i++;
        }
        
        return element;
    }
}