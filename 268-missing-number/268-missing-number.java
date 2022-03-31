class Solution {
    public int missingNumber(int[] nums) {
      
        // By using XOR -> 0 TO N-1 numbers ideally but 0 to N presernt 
        // which means N is replacing the Missing Number in our 
        
        int missing  = nums.length;
        
        for(int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        
        return missing;
        // Can use HashMap or HashSet as well
        // Fill the HashMap or HashSet and then move from 0 to n ..if absent then we get missing
        
        
//     // Sorting
//     Arrays.sort(nums);
    
//     // Ensure the first and last number
//     if (nums[0] != 0) return 0;
//     if(nums[nums.length - 1] != nums.length) return nums.length;
 
//     // Now the missing number is in the range (1, n-1)
//     for(int i = 0; i < nums.length; i++) {
//         if (nums[i] != i) {
//             return i;
//         }
//     }
//         return -1;
    }
}