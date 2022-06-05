class Solution {
    public int findMaxLength(int[] nums) {
        
        int ans = 0;
        
        if (nums == null || nums.length == 0) return ans;
        
        int sum = 0;
        int k = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
        
            int element = nums[i];
            
            if (element == 0) {
                sum += -1;
            } else {
                sum += 1;
            }
            
            // Now process
            if(sum == k) {
                ans = i + 1;
            } else {
            
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            
            // put the first instance only
            map.putIfAbsent(sum, i);
                
            }
        }
        
        return ans;
        
    }
}