class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        // This is Mnontonic Stack problem
        // Since the list is circular we need to use % and move 2 times throught the array
        // to complete the circle
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < 2 * n; i++) {
          
            int index = i % n;
            
            // break condition
            // if (i >= n && !st.isEmpty() && nums[index] == st.peek()) break;
            
            while (!st.isEmpty() && nums[index] > nums[st.peek()]) {
                
                // nums[index] is the ans
                ans[st.pop()] = nums[index];
            }
            
            if (i < n) {
                st.push(i);
            }
            
        }
        
        return ans;
        
    }
}