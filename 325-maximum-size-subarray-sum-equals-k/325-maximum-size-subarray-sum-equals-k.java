class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
    int maxi = 0;
    int sum = 0;
        
    Map<Integer, Integer> map = new HashMap<>();
        
    for(int i = 0; i < nums.length; i++) {
        
        sum += nums[i];

        if (sum == k) {
            
            maxi = i + 1;
            
        } else  {
            
            if (map.containsKey(sum - k)) {
                maxi = Math.max(maxi, i - map.get(sum - k));
            } 
    
        }
        
        map.putIfAbsent(sum, i);
    }
    return maxi;

    }
}