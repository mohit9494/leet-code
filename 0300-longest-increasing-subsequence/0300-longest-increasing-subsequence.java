class Solution {
    
    public int lengthOfLIS(int[] arr) {
       // consider using previous index and current index 
       // use right shifting for prev index since you cannot store -1  
       int n = arr.length;
    // i -> n - 1 to 0
    // prev -> i - 1 to -1 // right shift prev by +1
       int[] next = new int[n + 1];
       int[] curr = new int[n + 1];
      
       for (int i = n - 1; i >= 0 ; i--) {
           for (int prev = i - 1; prev >= -1; prev--) {
               
                // pick and non-pick
                int pick = 0;

                if (prev == -1 || arr[i] > arr[prev]) {
                    pick = 1 + next[i + 1];
                }

                int np = 0 + next[prev + 1];

               curr[prev + 1] = Math.max(pick, np);  
           }
           next = curr;
       } 
        
       return curr[-1 + 1]; 
    }
}