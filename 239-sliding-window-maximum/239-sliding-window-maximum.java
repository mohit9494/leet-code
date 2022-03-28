class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        // If k is greater than array then just return max of array
        
        int[] result = new int[nums.length - k + 1];
        
        int i = 0;
        int j = 0;
        int z = 0;
        
        Deque<Integer> q = new LinkedList();
        
        while(j < nums.length) {
            
                // clean up the queue                
                while(!q.isEmpty() && q.peekLast() < nums[j]){
                    q.pollLast();
                }
                    q.add(nums[j]);
 
            
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                
                // get the answer
                result[z++] = q.peek();
                
                //slide the window
                if(q.peek() == nums[i]) q.poll();
                
                i++;
                j++;
            }
            
        }
        
        
        return result;
    }
}