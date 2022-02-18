class Solution {
    
    public void swap (int[] arr, int i, int j) {
       int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public int findDuplicate(int[] nums) {
        
        // floyd detection
        int fast = nums[0];
        int slow = nums[0];
        
        do {            
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);
            
            // Find cycle entrance
            slow = nums[0];
            
        while (slow != fast) {
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
        
//         // array count
//         int ans = -1;
//         int[] test = new int[nums.length];
        
//         for (int i : nums) test[nums[i]]++;
        
//         for (int j = 0; j < test.length; j++) {
//             if(test[j] > 1) {
//                 ans = j;
//                 break;
//             } 
//         }
        
//         return ans;
//        Array as a HashMap
        
//         int ans = -1;
        
//        while(true) {
//          if(nums[0] != nums[nums[0]]) {
//              swap(nums , 0 , nums[0]);
//          } else {
//              ans = nums[0];
//              break;
//          } 
//        }
        
        
//         return ans;
        
    }
}